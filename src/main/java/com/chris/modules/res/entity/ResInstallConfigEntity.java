package com.chris.modules.res.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 资源安装/配置信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
public class ResInstallConfigEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//安装配置ID
	private Long configId;
	//资源ID
	private Long resId;
	//图纸，多个附件ID以逗号分隔
	private String drawing;
	//操作规范说明
	private String operationSpecificationText;
	//操作规范说明（附件），多个附件ID以逗号分隔
	private String operationSpecificationAttach;
	//是否同步，1、是，0、否
	private String isSync;

	/**
	 * 设置：安装配置ID
	 */
	public void setConfigId(Long configId) {
		this.configId = configId;
	}
	/**
	 * 获取：安装配置ID
	 */
	public Long getConfigId() {
		return configId;
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
}
