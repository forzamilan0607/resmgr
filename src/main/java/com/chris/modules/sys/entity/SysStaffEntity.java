package com.chris.modules.sys.entity;

import com.chris.common.model.SysUpdateInfo;

import java.io.Serializable;
import java.util.Date;


/**
 * 员工信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 26.18
 */
public class SysStaffEntity extends SysUpdateInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//员工ID
	private Integer id;
	//员工姓名
	private String name;
	//员工工号
	private String workNo;
	//部门ID
	private Integer deptId;
	//公司ID
	private Integer companyId;
	//园区ID
	private Integer parkId;
	//身份证
	private String idCard;
	//职务
	private String position;
	//性别
	private String gender;
	//出生日期
	private Date bornDate;
	//状态
	private String status;
	/**
	 * 设置：员工ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：员工ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：员工姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：员工姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：员工工号
	 */
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	/**
	 * 获取：员工工号
	 */
	public String getWorkNo() {
		return workNo;
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
	 * 设置：园区ID
	 */
	public void setParkId(Integer parkId) {
		this.parkId = parkId;
	}
	/**
	 * 获取：园区ID
	 */
	public Integer getParkId() {
		return parkId;
	}
	/**
	 * 设置：身份证
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	/**
	 * 获取：身份证
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * 设置：职务
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * 获取：职务
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * 设置：性别
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 获取：性别
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * 设置：出生日期
	 */
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	/**
	 * 获取：出生日期
	 */
	public Date getBornDate() {
		return bornDate;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}

}
