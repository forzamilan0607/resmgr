package com.chris.modules.res.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 资源安装/配置信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public class ResInstallConfigEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//安装配置ID
	private Long id;
	//资源ID
	private Long resId;
	//图纸，多个附件ID以逗号分隔
	private String drawing;
	private List<ResAttachmentEntity> attachmentList1;
	//操作规范说明
	private String operationSpecificationText;
	//操作规范说明（附件），多个附件ID以逗号分隔
	private String operationSpecificationAttach;
	private List<ResAttachmentEntity> attachmentList2;
	//创建时间
	private Date createTime;
	//创建人
	private Integer createUserId;
	//修改时间
	private Date updateTime;
	//修改人
	private Integer updateUserId;

	/**
	 * 设置：安装配置ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：安装配置ID
	 */
	public Long getId() {
		return id;
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
	 * 设置：图纸，多个附件ID以逗号分隔
	 */
	public void setDrawing(String drawing) {
		this.drawing = drawing;
	}
	/**
	 * 获取：图纸，多个附件ID以逗号分隔
	 */
	public String getDrawing() {
		return drawing;
	}
	/**
	 * 设置：操作规范说明
	 */
	public void setOperationSpecificationText(String operationSpecificationText) {
		this.operationSpecificationText = operationSpecificationText;
	}
	/**
	 * 获取：操作规范说明
	 */
	public String getOperationSpecificationText() {
		return operationSpecificationText;
	}
	/**
	 * 设置：操作规范说明（附件），多个附件ID以逗号分隔
	 */
	public void setOperationSpecificationAttach(String operationSpecificationAttach) {
		this.operationSpecificationAttach = operationSpecificationAttach;
	}
	/**
	 * 获取：操作规范说明（附件），多个附件ID以逗号分隔
	 */
	public String getOperationSpecificationAttach() {
		return operationSpecificationAttach;
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

	public List<ResAttachmentEntity> getAttachmentList1() {
		return attachmentList1;
	}

	public void setAttachmentList1(List<ResAttachmentEntity> attachmentList1) {
		this.attachmentList1 = attachmentList1;
	}

	public List<ResAttachmentEntity> getAttachmentList2() {
		return attachmentList2;
	}

	public void setAttachmentList2(List<ResAttachmentEntity> attachmentList2) {
		this.attachmentList2 = attachmentList2;
	}
}
