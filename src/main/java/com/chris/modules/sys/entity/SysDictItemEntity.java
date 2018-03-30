package com.chris.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 部门
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
public class SysDictItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//字典项ID
	private Integer dictItemId;
	//字典ID
	private Integer dictId;
	//字典项值
	private String dictItemValue;
	//扩展值1
	private String extValue1;
	//扩展值2
	private String extValue2;
	//排序
	private Integer sortOrder;
	//是否同步，1、是，0、否
	private String isSync;

	/**
	 * 设置：字典项ID
	 */
	public void setDictItemId(Integer dictItemId) {
		this.dictItemId = dictItemId;
	}
	/**
	 * 获取：字典项ID
	 */
	public Integer getDictItemId() {
		return dictItemId;
	}
	/**
	 * 设置：字典ID
	 */
	public void setDictId(Integer dictId) {
		this.dictId = dictId;
	}
	/**
	 * 获取：字典ID
	 */
	public Integer getDictId() {
		return dictId;
	}
	/**
	 * 设置：字典项值
	 */
	public void setDictItemValue(String dictItemValue) {
		this.dictItemValue = dictItemValue;
	}
	/**
	 * 获取：字典项值
	 */
	public String getDictItemValue() {
		return dictItemValue;
	}
	/**
	 * 设置：扩展值1
	 */
	public void setExtValue1(String extValue1) {
		this.extValue1 = extValue1;
	}
	/**
	 * 获取：扩展值1
	 */
	public String getExtValue1() {
		return extValue1;
	}
	/**
	 * 设置：扩展值2
	 */
	public void setExtValue2(String extValue2) {
		this.extValue2 = extValue2;
	}
	/**
	 * 获取：扩展值2
	 */
	public String getExtValue2() {
		return extValue2;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
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
