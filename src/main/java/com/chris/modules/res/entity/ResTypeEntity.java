package com.chris.modules.res.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 资源类别
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public class ResTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//资源类别ID
	private Integer id;
	//资源类别名称
	private String name;
	//资源类别编码
	private String code;
	//父级资源类别
	private Integer parentTypeId;
	//是否目录，1、是，0、否
	private String isFolder;
	//创建时间
	private Date createTime;
	//创建人
	private Integer createUserId;
	//修改时间
	private Date updateTime;
	//修改人
	private Integer updateUserId;
	//部门ID
	private Integer deptId;
	//资源类别层次结构
	private String hierarchy;
	//资源类别描述
	private String remark;

	/**
	 * 设置：资源类别ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：资源类别ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：资源类别名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：资源类别名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：资源类别编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：资源类别编码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：父级资源类别
	 */
	public void setParentTypeId(Integer parentTypeId) {
		this.parentTypeId = parentTypeId;
	}
	/**
	 * 获取：父级资源类别
	 */
	public Integer getParentTypeId() {
		return parentTypeId;
	}
	/**
	 * 设置：是否目录，1、是，0、否
	 */
	public void setIsFolder(String isFolder) {
		this.isFolder = isFolder;
	}
	/**
	 * 获取：是否目录，1、是，0、否
	 */
	public String getIsFolder() {
		return isFolder;
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
	/**
	 * 设置：部门ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：部门ID
	 */
	public Integer getDeptId() {
		return deptId;
	}
	/**
	 * 设置：资源类别层次结构
	 */
	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
	}
	/**
	 * 获取：资源类别层次结构
	 */
	public String getHierarchy() {
		return hierarchy;
	}
	/**
	 * 设置：资源类别描述
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：资源类别描述
	 */
	public String getRemark() {
		return remark;
	}
}
