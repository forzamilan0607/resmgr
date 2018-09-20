package com.chris.modules.res.entity;

import com.chris.modules.oss.entity.SysAttachmentEntity;

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
	//图纸附件列表
	private List<SysAttachmentEntity> drawingAttachments;
	//操作规范说明
	private String operationSpecification;
	//操作规范说明附件列表
	private List<SysAttachmentEntity> operSpecAttachments;
	//创建时间
	private Date createTime;
	//创建人
	private Integer createUserId;
	//修改时间
	private Date updateTime;
	//修改人
	private Integer updateUserId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getResId() {
		return resId;
	}

	public void setResId(Long resId) {
		this.resId = resId;
	}

	public List<SysAttachmentEntity> getDrawingAttachments() {
		return drawingAttachments;
	}

	public void setDrawingAttachments(List<SysAttachmentEntity> drawingAttachments) {
		this.drawingAttachments = drawingAttachments;
	}

	public String getOperationSpecification() {
		return operationSpecification;
	}

	public void setOperationSpecification(String operationSpecification) {
		this.operationSpecification = operationSpecification;
	}

	public List<SysAttachmentEntity> getOperSpecAttachments() {
		return operSpecAttachments;
	}

	public void setOperSpecAttachments(List<SysAttachmentEntity> operSpecAttachments) {
		this.operSpecAttachments = operSpecAttachments;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
}
