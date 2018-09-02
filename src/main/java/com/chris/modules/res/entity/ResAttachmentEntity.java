package com.chris.modules.res.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 资源附件
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public class ResAttachmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//附件ID
	private Long id;
	//附件名称
	private String name;
	//附件URL
	private String url;
	//资源ID
	private Long resId;
	//附件大小，KB为单位
	private String size;
	//附件类型，如：jpg、png、pdf、xls、word、mp4等
	private Integer type;
	//上传时间
	private Date uploadTime;
	//创建时间
	private Date createTime;
	//创建人
	private Integer createUserId;
	//修改时间
	private Date updateTime;
	//修改人
	private Integer updateUserId;
	//顺序
	private Integer sortOrder;

	/**
	 * 设置：附件ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：附件ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：附件名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：附件名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：附件URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：附件URL
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：资源ID
	 */
	public void setResId(Long resId) {
		this.resId = resId;
	}
	/**
	 * 获取：资源ID
	 */
	public Long getResId() {
		return resId;
	}
	/**
	 * 设置：附件大小，KB为单位
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * 获取：附件大小，KB为单位
	 */
	public String getSize() {
		return size;
	}
	/**
	 * 设置：附件类型，如：jpg、png、pdf、xls、word、mp4等
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：附件类型，如：jpg、png、pdf、xls、word、mp4等
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：上传时间
	 */
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	/**
	 * 获取：上传时间
	 */
	public Date getUploadTime() {
		return uploadTime;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * 获取：创建人
	 */
	public Integer getCreateUserId() {
		return createUserId;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
	/**
	 * 获取：修改人
	 */
	public Integer getUpdateUserId() {
		return updateUserId;
	}
	/**
	 * 设置：顺序
	 */
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	/**
	 * 获取：顺序
	 */
	public Integer getSortOrder() {
		return sortOrder;
	}
}
