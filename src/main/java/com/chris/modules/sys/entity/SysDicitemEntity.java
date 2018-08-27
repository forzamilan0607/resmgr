package com.chris.modules.generator.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 字典项表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public class SysDicitemEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//字典项ID
	private Integer id;
	//字典ID
	private Integer dictId;
	//字典项值
	private String name;
	//字典项值
	private String value;
	//扩展值1
	private String extValue1;
	//扩展值2
	private String extValue2;
	//排序
	private Integer sortOrder;
	//创建时间
	private Date createTime;
	//创建人
	private Integer createUserId;
	//修改时间
	private Date updateTime;
	//修改人
	private Integer updateUserId;

	/**
	 * 设置：字典项ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：字典项ID
	 */
	public Integer getId() {
		return id;
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
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：字典项值
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：字典项值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：字典项值
	 */
	public String getValue() {
		return value;
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
	/**
	 * 设置：排序
	 */
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSortOrder() {
		return sortOrder;
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
}
