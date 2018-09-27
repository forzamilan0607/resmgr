package com.chris.modules.oss.servlet;

import com.chris.common.utils.SpringContextUtils;
import com.chris.modules.oss.cloud.OSSFactory;
import com.chris.modules.oss.entity.SysAttachmentEntity;
import com.chris.modules.oss.service.SysAttachmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "downloadServlet",urlPatterns = "*.fileDownload")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SysAttachmentEntity attachmentEntity = this.getSysAttachmentService().queryObject(Long.valueOf(request.getParameter("id")));
        String name = new String(attachmentEntity.getName().getBytes("gbk"),"iso-8859-1");
        response.setHeader("content-disposition", "attachment; filename=" + name);
        response.setCharacterEncoding("gbk");
        OSSFactory.build().download(attachmentEntity.getUrl(), response);
        super.doGet(request, response);
    }

    private SysAttachmentService getSysAttachmentService() {
        return (SysAttachmentService) SpringContextUtils.getBean("sysAttachmentService");
    }
}
