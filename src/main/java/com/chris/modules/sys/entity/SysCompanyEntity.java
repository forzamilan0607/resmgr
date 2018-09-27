package com.chris.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 公司
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 24.18
 */
public class SysCompanyEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//公司ID
	private Integer id;
	//公司名称
	private String name;
	//园区ID
	private Integer parkId;
	//上级公司ID
	private Integer parentCompanyId;
	//状态，1、有效，0、无效
	private String status;
	//公司地址
	private String address;
	//创建时间
	private Date createTime;
	//创建人
	private Integer createUserId;
	//修改时间
	private Date updateTime;
	//修改人
	private Integer updateUserId;

	/**
	 * 设置：公司ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：公司ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：公司名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：公司名称
	 */
	public String getName() {
		return name;
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
	 * 设置：上级公司ID
	 */
	public void setParentCompanyId(Integer parentCompanyId) {
		this.parentCompanyId = parentCompanyId;
	}
	/**
	 * 获取：上级公司ID
	 */
	public Integer getParentCompanyId() {
		return parentCompanyId;
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
	 * 设置：公司地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：公司地址
	 */
	public String getAddress() {
		return address;
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
