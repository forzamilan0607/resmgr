package com.chris.modules.oss.entity;

import com.chris.common.model.SysUpdateInfo;

import java.io.Serializable;

public class SysAttachmentEntity extends SysUpdateInfo implements Serializable{
    private static final long serialVersionUID = 1L;

    //附件ID
    private Long id;
    //附件名称
    private String name;
    //附件URL
    private String url;
    //对象ID
    private Long objId;
    //对象来源
    private String objSource;
    //文件后缀名
    private String suffixName;
    //附件大小，KB为单位
    private String size;
    //附件类型，如：图片、文档、视频
    private String type;
    //顺序
    private Integer sortOrder;

    private String tempUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getObjId() {
        return objId;
    }

    public void setObjId(Long objId) {
        this.objId = objId;
    }

    public String getObjSource() {
        return objSource;
    }

    public void setObjSource(String objSource) {
        this.objSource = objSource;
    }

    public String getSuffixName() {
        return suffixName;
    }

    public void setSuffixName(String suffixName) {
        this.suffixName = suffixName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String  getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getTempUrl() {
        return tempUrl;
    }

    public void setTempUrl(String tempUrl) {
        this.tempUrl = tempUrl;
    }

    public SysAttachmentEntity() {
    }

    public SysAttachmentEntity(Long objId) {
        this.objId = objId;
    }

    public SysAttachmentEntity(Long objId, String objSource) {
        this.objId = objId;
        this.objSource = objSource;
    }
}
