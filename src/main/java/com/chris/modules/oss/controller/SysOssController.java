package com.chris.modules.oss.controller;

import com.alibaba.fastjson.JSONObject;
import com.chris.modules.oss.cloud.FileSizeConfig;
import com.chris.modules.oss.entity.SysAttachmentEntity;
import com.chris.modules.oss.service.SysAttachmentService;
import com.chris.modules.sys.entity.SysConfigEntity;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.chris.common.exception.CommonException;
import com.chris.common.utils.*;
import com.chris.common.validator.ValidatorUtils;
import com.chris.common.validator.group.AliyunGroup;
import com.chris.common.validator.group.QcloudGroup;
import com.chris.common.validator.group.QiniuGroup;
import com.chris.modules.oss.cloud.CloudStorageConfig;
import com.chris.modules.oss.cloud.OSSFactory;
import com.chris.modules.oss.entity.SysOssEntity;
import com.chris.modules.oss.service.SysOssService;
import com.chris.modules.sys.service.SysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 文件上传
 * 
 * @author chris
 * @email 258321511@qq.com
 * @date 2017-03-25 12:13:26
 */
@RestController
@RequestMapping("sys/oss")
public class SysOssController {
	@Autowired
	private SysAttachmentService sysAttachmentService;
    @Autowired
    private SysConfigService sysConfigService;

    private final static String KEY = ConfigConstant.CLOUD_STORAGE_CONFIG_KEY;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:oss:all")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<SysAttachmentEntity> attachmentList = this.sysAttachmentService.queryList(query);
		int total = this.sysAttachmentService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(attachmentList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}


    /**
     * 云存储配置信息
     */
    @RequestMapping("/config")
    @RequiresPermissions("sys:oss:all")
    public R config(){
        CloudStorageConfig config = sysConfigService.getConfigObject(KEY, CloudStorageConfig.class);

        return R.ok().put("config", config);
    }


	/**
	 * 保存云存储配置信息
	 */
	@RequestMapping("/saveConfig")
	@RequiresPermissions("sys:oss:all")
	public R saveConfig(@RequestBody CloudStorageConfig config){
		//校验类型
		ValidatorUtils.validateEntity(config);

		if(config.getType() == Constant.CloudService.QINIU.getValue()){
			//校验七牛数据
			ValidatorUtils.validateEntity(config, QiniuGroup.class);
		}else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
			//校验阿里云数据
			ValidatorUtils.validateEntity(config, AliyunGroup.class);
		}else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
			//校验腾讯云数据
			ValidatorUtils.validateEntity(config, QcloudGroup.class);
		}
		

        sysConfigService.updateValueByKey(KEY, new Gson().toJson(config));

		return R.ok();
	}
	

	/**
	 * 上传文件
	 */
	@RequestMapping("/upload")
	@RequiresPermissions("sys:oss:all")
	public R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
		if (file.isEmpty()) {
			throw new CommonException("上传文件不能为空");
		}
		//上传文件
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String fileType = this.getFileType(suffix.substring(1));
		//校验文件大小
		this.verifyFileSize(file.getSize() / 1024, fileType);
		String url = OSSFactory.build().uploadSuffix(file.getBytes(), suffix);

		//保存文件信息
		SysAttachmentEntity attachmentEntity = new SysAttachmentEntity();
		attachmentEntity.setUrl(url);
		attachmentEntity.setName(file.getOriginalFilename());
		attachmentEntity.setSuffixName(suffix.substring(1).toLowerCase());
		attachmentEntity.setType(fileType);
		attachmentEntity.generateTempURL();
		attachmentEntity.setSize(file.getSize() + "");
		this.sysAttachmentService.save(attachmentEntity);

		return R.ok().put("url", url).put("attachmentObj", attachmentEntity);
	}

	private void verifyFileSize(long fileSize, String fileType) {
		SysConfigEntity config = GlobalDataUtils.getConfigList().stream().filter(item -> ValidateUtils.equals(item.getKey(), "FILE_UPLOAD_SIZE_LIMIT")).findFirst().get();
		if (ValidateUtils.isNotEmpty(config)) {
			FileSizeConfig fileSizeConfig = new Gson().fromJson(config.getValue(), FileSizeConfig.class);
			if (!fileSizeConfig.isFileSizeOK(fileSize, fileType)) {
				throw new CommonException(fileType + "文件大小不能超过" + fileSizeConfig.getMaxSize() + "KB");
			}
		}
	}

	@RequestMapping("/downLoad")
	public R downLoad(HttpServletRequest request, HttpServletResponse response) throws Exception{
		SysAttachmentEntity attachmentEntity = this.sysAttachmentService.queryObject(Long.valueOf(request.getParameter("id")));
		String name = new String(attachmentEntity.getName().getBytes("gbk"),"iso-8859-1");
		response.setHeader("content-disposition", "attachment; filename=" + name);
		response.setCharacterEncoding("gbk");
		OSSFactory.build().download(attachmentEntity.getUrl(), response);
		return R.ok();
	}

	private String getFileType(String suffix) {
		ImmutableList<String> docTypes = ImmutableList.of("doc", "docx", "xls", "xlsx", "csv", "pdf");
		if (docTypes.contains(suffix.toLowerCase())) {
			return Constant.FileType.DOCUMENT.getValue();
		}
		ImmutableList<String> imgTypes = ImmutableList.of("png", "jpg", "jpeg", "gif");
		if (imgTypes.contains(suffix.toLowerCase())) {
			return Constant.FileType.IMAGE.getValue();
		}
		ImmutableList<String> videoTypes = ImmutableList.of("mp4", "avi");
		if (videoTypes.contains(suffix.toLowerCase())) {
			return Constant.FileType.VIDEO.getValue();
		}
		throw new CommonException("不支持的文件类型[" + suffix + "]");
	}


	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:oss:all")
	public R delete(Long id){
		this.sysAttachmentService.delete(id);
		return R.ok();
	}

}
