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
	private Integer sortOrder;
	//是否同步，1、是，0、否
	private String isSync;

	public Integer getAttrValueId() {
		return attrValueId;
	}

	public void setAttrValueId(Integer attrValueId) {
		this.attrValueId = attrValueId;
	}

	public Integer getAttrId() {
		return attrId;
	}

	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getIsSync() {
		return isSync;
	}

	public void setIsSync(String isSync) {
		this.isSync = isSync;
	}
}
