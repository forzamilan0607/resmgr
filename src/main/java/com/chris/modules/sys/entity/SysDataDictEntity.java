package com.chris.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 数据字典表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 18.18
 */
public class SysDataDictEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//字典ID
	private Integer id;
	//字典名称
	private String name;
	//字典类型
	private String type;
	//字典项值
	private String value;
	//扩展值
	private String extValue;
	//排序
	private Integer sortOrder;
	//父级字典
	private Integer parentId;
	//字典描述
	private String dictDesc;
	//状态，1、有效，0、无效
	private String status;
	//创建时间
	private Date createTime;
	//创建人
	private Integer createUserId;
	//修改时间
	private Date updateTime;
	//修改人
	private Integer updateUserId;

	/**
	 * 设置：字典ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：字典ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：字典名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：字典名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：字典类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：字典类型
	 */
	public String getType() {
		return type;
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
	 * 设置：扩展值
	 */
	public void setExtValue(String extValue) {
		this.extValue = extValue;
	}
	/**
	 * 获取：扩展值
	 */
	public String getExtValue() {
		return extValue;
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
	 * 设置：父级字典
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父级字典
	 */
	public Integer getParentId() {
		return parentId;
	}
	/**
	 * 设置：字典描述
	 */
	public void setDictDesc(String dictDesc) {
		this.dictDesc = dictDesc;
	}
	/**
	 * 获取：字典描述
	 */
	public String getDictDesc() {
		return dictDesc;
	}
	/**
	 * 设置：状态，1、有效，0、无效
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态，1、有效，0、无效
	 */
	public String getStatus() {
		return status;
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
