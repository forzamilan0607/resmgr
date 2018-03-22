package com.chris.modules.res.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 资源参数配置信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
public class ResParamConfigEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//资源ID
	private Long resId;
	//属性ID
	private Long attrId;
	//属性值
	private String attrValue;
	//是否同步，1、是，0、否
	private String isSync;

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
	 * 设置：属性ID
	 */
	public void setAttrId(Long attrId) {
		this.attrId = attrId;
	}
	/**
	 * 获取：属性ID
	 */
	public Long getAttrId() {
		return attrId;
	}
	/**
	 * 设置：属性值
	 */
	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}
	/**
	 * 获取：属性值
	 */
	public String getAttrValue() {
		return attrValue;
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
