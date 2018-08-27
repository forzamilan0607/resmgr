package com.chris.modules.generator.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 属性值表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public class SysAttrValueEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//属性值ID
	private Integer id;
	//属性ID
	private Integer attrId;
	//属性值
	private String value;
	//顺序
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
	 * 设置：属性值ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：属性值ID
	 */
	public Integer getId() {
		return id;
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
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：属性值
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 设置：顺序
	 */
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	/**
	 * 获取：顺序
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
