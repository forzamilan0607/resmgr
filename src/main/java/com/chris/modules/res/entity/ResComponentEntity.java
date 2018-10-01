package com.chris.modules.res.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 设备部件信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 22.18
 */
public class ResComponentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//部件ID
	private Long id;
	//资源ID
	private Long resId;
	//部件名称
	private String name;
	//序列号
	private String serialNo;
	//字典ID
	private Integer dictId;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;

	/**
	 * 设置：部件ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：部件ID
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
	 * 设置：部件名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：部件名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：序列号
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	/**
	 * 获取：序列号
	 */
	public String getSerialNo() {
		return serialNo;
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
