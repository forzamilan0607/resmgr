package com.chris.modules.app.controller;


import com.chris.common.utils.R;
import com.chris.common.validator.Assert;
import com.chris.modules.app.service.UserService;
import com.chris.modules.app.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 文件传输controller
 *
 * @author chris
 * @email 258321511@qq.com
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/fileTransfer")
@Api("文件传输接口")
public class FileTransferController {
    private static final Logger log = LoggerFactory.getLogger(FileTransferController.class);

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public R upload(@RequestParam("file" ) MultipartFile file, HttpServletRequest request , HttpServletResponse response ) throws Exception {
        String innerCode = request.getParameter("innerCode" );
        log.info("开始接收机器innerCode-{}的文件" , innerCode);

        if(file .isEmpty()) {
            return R.error("文件为空！");
        }

        String fileName = file.getOriginalFilename();
        String path = "E://";
        log.info("接收文件保存路径-{}，文件大小为-{}" , path , file .getSize());
        File localFile = new File(path);

        if(!localFile .exists()) {
            localFile.mkdirs();
        }
        try {

            file.transferTo(new File(path+fileName));
            //downloadUrl为包的下载目录
            log.info("文件{}上传成功");
            return R.ok("上传文件成功");
        } catch (Exception e ) {
            log.error("上传文件发生异常，异常信息:" , e );
        }
//        writeJSON( json, response );
        return R.ok();
    }

    @RequestMapping(value = "/upload2", method = RequestMethod.POST)
    public String upload2(MultipartFile file, HttpServletRequest request) throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String rootPath = request.getRealPath("/");
        String prefix = "abc";
        String datePath = format.format(new Date());
        String appPath = prefix+"/"+datePath;
        //FileUtils.createFilePath(request.getRealPath("/"), appPath);
        String fileName = UUID.randomUUID() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        /*
         * /upload/other/2015-04-15/cea78319e0ea4756b29de05b2cc431ab.pdf
         * */
        FileCopyUtils.copy(file.getBytes(), new File(request.getRealPath("/") + appPath+"/"+fileName));
        return "/" + appPath+"/"+fileName;
    }

}
