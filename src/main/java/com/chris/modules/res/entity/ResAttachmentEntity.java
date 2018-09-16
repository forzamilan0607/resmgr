package com.chris.modules.res.entity;

import com.chris.common.model.SysUpdateInfo;

import java.io.Serializable;


/**
 * 资源附件
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public class ResAttachmentEntity extends SysUpdateInfo implements Serializable{
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
	private Integer type;
	//顺序
	private Integer sortOrder;

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
}
