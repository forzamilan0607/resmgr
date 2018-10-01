package com.chris.modules.oss.cloud;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.utils.IOUtils;
import com.aliyun.oss.model.OSSObject;
import com.chris.common.exception.CommonException;
import com.chris.common.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 阿里云存储
 *
 * @author chris
 * @email 258321511@qq.com
 * @date 2017-03-26 16:22
 */
@Slf4j
public class AliyunCloudStorageService extends CloudStorageService {
    private OSSClient client;

    public AliyunCloudStorageService(CloudStorageConfig config) {
        this.config = config;
        //初始化
        init();
    }

    private void init() {
        client = new OSSClient(config.getAliyunEndPoint(), config.getAliyunAccessKeyId(),
                config.getAliyunAccessKeySecret());
    }

    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            client.putObject(config.getAliyunBucketName(), path, inputStream);
        } catch (Exception e) {
            throw new CommonException("上传文件失败，请检查配置信息", e);
        }

        return config.getAliyunDomain() + "/" + path;
    }

    @Override
    public String uploadSuffix(byte[] data, String suffix) {
        return upload(data, getPath(config.getAliyunPrefix(), suffix));
    }

    @Override
    public String uploadSuffix(InputStream inputStream, String suffix) {
        return upload(inputStream, getPath(config.getAliyunPrefix(), suffix));
    }

    @Override
    public void download(String path, HttpServletResponse response) {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            OSSObject ossObject = client.getObject(config.getAliyunBucketName(), this.getKey(path));
            out = new BufferedOutputStream(response.getOutputStream());
            in = new BufferedInputStream(ossObject.getObjectContent());
            byte[] car = new byte[1024];
            int _byte = 0;
            while ((_byte = in.read(car)) != -1) {
                out.write(car, 0, _byte);
            }
        } catch (OSSException e) {
            log.error("下载文件[" + path + "]异常，原因：", e);
            throw new CommonException("下载文件失败");
        } catch (IOException e) {
            log.error("文件读取[" + path + "]异常，原因：", e);
            throw new CommonException("文件读取");
        } finally {
            IOUtils.safeClose(in);
            IOUtils.safeClose(out);
            client.shutdown();
        }
    }

    private String getKey(String path) {
        return path.replace(this.config.getAliyunDomain() + Constant.Symbol.SLASH, "");
    }
}
