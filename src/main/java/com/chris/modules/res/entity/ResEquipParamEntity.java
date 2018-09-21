package com.chris.modules.res.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 资源设备参数信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 22.18
 */
public class ResEquipParamEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//参数ID
	private Long id;
	//资源ID
	private Long resId;
	//属性ID
	private Long attrId;
	//参数名称
	private String name;
	//参数值
	private String value;
	//字典ID
	private Integer dictId;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;

	/**
	 * 设置：参数ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：参数ID
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
	 * 设置：参数名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：参数名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：参数值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：参数值
	 */
	public String getValue() {
		return value;
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
}
