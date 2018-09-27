package com.chris.modules.app.controller;


import com.chris.common.utils.DateUtils;
import com.chris.common.utils.R;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public R upload(@RequestParam("file" ) MultipartFile file) throws Exception {
        log.info("开始上传文件");

        if(file .isEmpty()) {
            return R.error("文件为空！");
        }

        String fileName = file.getOriginalFilename();
        String path = "E:/files/" + DateUtils.currentDateStr("yyyyMMdd") + "/";
        log.info("接收文件保存路径-{}，文件大小为-{}" , path , file .getSize());
        File localFile = new File(path);

        if(!localFile .exists()) {
            localFile.mkdirs();
        }
        try {
            String url = path + fileName;
            file.transferTo(new File(url));
            //downloadUrl为包的下载目录
            log.info("文件{}上传成功");
            return R.ok("上传文件成功").put("url", url);
        } catch (Exception e ) {
            log.error("上传文件发生异常，异常信息:" , e );
            return R.error(e.getMessage());
        }
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
