package com.chris.modules.res.entity;

import com.chris.common.model.SysUpdateInfo;
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
public class ResInstallConfigEntity extends SysUpdateInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//安装配置ID
	private Long id;
	//资源ID
	private Long resId;
	//图纸附件列表
	private List<SysAttachmentEntity> drawingAttachments;
	//操作规范说明
	private String operationSpecificationText;
	//操作规范说明附件列表
	private List<SysAttachmentEntity> operSpecAttachments;

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

	public String getOperationSpecificationText() {
		return operationSpecificationText;
	}

	public void setOperationSpecificationText(String operationSpecificationText) {
		this.operationSpecificationText = operationSpecificationText;
	}

	public List<SysAttachmentEntity> getOperSpecAttachments() {
		return operSpecAttachments;
	}

	public void setOperSpecAttachments(List<SysAttachmentEntity> operSpecAttachments) {
		this.operSpecAttachments = operSpecAttachments;
	}
}
