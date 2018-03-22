package com.chris.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 属性值表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
public class SysAttrValueEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//属性值ID
	private Integer attrValueId;
	//属性ID
	private Integer attrId;
	//属性值
	private String attrValue;
	//顺序
	private Integer order;
	//是否同步，1、是，0、否
	private String isSync;

	/**
	 * 设置：属性值ID
	 */
	public void setAttrValueId(Integer attrValueId) {
		this.attrValueId = attrValueId;
	}
	/**
	 * 获取：属性值ID
	 */
	public Integer getAttrValueId() {
		return attrValueId;
	}
	/**
	 * 设置：属性ID
	 */
	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}
	/**
	 * 获取：属性ID
	 */
	public Integer getAttrId() {
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
	 * 设置：顺序
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
	/**
	 * 获取：顺序
	 */
	public Integer getOrder() {
		return order;
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
