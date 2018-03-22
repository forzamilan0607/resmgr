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
public class SysDepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//部门ID
	private Integer deptId;
	//部门名称
	private String deptName;
	//公司ID
	private Integer companyId;
	//状态，1、有效，0、无效
	private String status;
	//创建时间
	private Date createTime;
	//创建人
	private Integer createUserId;
	//修改时间
	private Date modifyTime;
	//修改人
	private Integer modifyUserId;
	//是否同步，1、是，0、否
	private String isSync;

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
	 * 设置：部门名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 获取：部门名称
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * 设置：公司ID
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	/**
	 * 获取：公司ID
	 */
	public Integer getCompanyId() {
		return companyId;
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
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * 设置：修改人
	 */
	public void setModifyUserId(Integer modifyUserId) {
		this.modifyUserId = modifyUserId;
	}
	/**
	 * 获取：修改人
	 */
	public Integer getModifyUserId() {
		return modifyUserId;
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
