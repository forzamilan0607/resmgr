package com.chris.modules.res.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 资源附件
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
public class ResAttachmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//附件ID
	private Long attachId;
	//附件名称
	private String attachName;
	//资源ID
	private Long resId;
	//附件大小，KB为单位
	private Integer attachSize;
	//附件类型，如：jpg、png、pdf、xls、word、mp4等
	private Integer attachType;
	//上传时间
	private Date uploadTime;
	//是否同步，1、是，0、否
	private String isSync;
	//顺序
	private Integer sortOrder;

	/**
	 * 设置：附件ID
	 */
	public void setAttachId(Long attachId) {
		this.attachId = attachId;
	}
	/**
	 * 获取：附件ID
	 */
	public Long getAttachId() {
		return attachId;
	}
	/**
	 * 设置：附件名称
	 */
	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}
	/**
	 * 获取：附件名称
	 */
	public String getAttachName() {
		return attachName;
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
	public void setAttachSize(Integer attachSize) {
		this.attachSize = attachSize;
	}
	/**
	 * 获取：附件大小，KB为单位
	 */
	public Integer getAttachSize() {
		return attachSize;
	}
	/**
	 * 设置：附件类型，如：jpg、png、pdf、xls、word、mp4等
	 */
	public void setAttachType(Integer attachType) {
		this.attachType = attachType;
	}
	/**
	 * 获取：附件类型，如：jpg、png、pdf、xls、word、mp4等
	 */
	public Integer getAttachType() {
		return attachType;
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
	 * 设置：是否同步，1、是，0、否
	 */
	public void setIsSync(String isSync) {
		this.isSync = isSync;
	}
	/**
	 * 获取：是否同步，1、是，0、否
	 */
	public String getIsSync() {
		return isSync;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
}
