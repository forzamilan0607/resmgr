package com.chris.modules.res.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 资源基本信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
public class ResBaseInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//资源ID
	private Long resId;
	//资源类别
	private Integer resType;
	//品牌
	private Integer brand;
	//系列
	private Integer series;
	//型号
	private Integer model;
	//出厂时间
	private Date factoryTime;
	//整机序列号
	private String serialNo;
	//主要部件信息
	private Long componentInfo;
	//资源铭牌，用于上传照片或其他附件，多个附件ID以逗号分隔
	private String resNameplate;
	//描述性位置，如：调度大楼/中栋/3层/310房/东头/上方；附属楼/主楼/2层/走廊/西头/地面
	private Integer positionDesc;
	//坐标位置，如：F8、H13
	private String positionCoordinate;
	//三维图形对象ID
	private String objId;
	//创建时间
	private Date createTime;
	//创建人
	private Integer createUserId;
	//修改时间
	private Date modifyTime;
	//修改人
	private Integer modifyUserId;
	//部门ID
	private Integer deptId;
	//责任人
	private Integer personResponsible;
	//是否同步，1、是，0、否
	private String isSync;

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
	 * 设置：资源类别
	 */
	public void setResType(Integer resType) {
		this.resType = resType;
	}
	/**
	 * 获取：资源类别
	 */
	public Integer getResType() {
		return resType;
	}
	/**
	 * 设置：品牌
	 */
	public void setBrand(Integer brand) {
		this.brand = brand;
	}
	/**
	 * 获取：品牌
	 */
	public Integer getBrand() {
		return brand;
	}
	/**
	 * 设置：系列
	 */
	public void setSeries(Integer series) {
		this.series = series;
	}
	/**
	 * 获取：系列
	 */
	public Integer getSeries() {
		return series;
	}
	/**
	 * 设置：型号
	 */
	public void setModel(Integer model) {
		this.model = model;
	}
	/**
	 * 获取：型号
	 */
	public Integer getModel() {
		return model;
	}
	/**
	 * 设置：出厂时间
	 */
	public void setFactoryTime(Date factoryTime) {
		this.factoryTime = factoryTime;
	}
	/**
	 * 获取：出厂时间
	 */
	public Date getFactoryTime() {
		return factoryTime;
	}
	/**
	 * 设置：整机序列号
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	/**
	 * 获取：整机序列号
	 */
	public String getSerialNo() {
		return serialNo;
	}
	/**
	 * 设置：主要部件信息
	 */
	public void setComponentInfo(Long componentInfo) {
		this.componentInfo = componentInfo;
	}
	/**
	 * 获取：主要部件信息
	 */
	public Long getComponentInfo() {
		return componentInfo;
	}
	/**
	 * 设置：资源铭牌，用于上传照片或其他附件，多个附件ID以逗号分隔
	 */
	public void setResNameplate(String resNameplate) {
		this.resNameplate = resNameplate;
	}
	/**
	 * 获取：资源铭牌，用于上传照片或其他附件，多个附件ID以逗号分隔
	 */
	public String getResNameplate() {
		return resNameplate;
	}
	/**
	 * 设置：描述性位置，如：调度大楼/中栋/3层/310房/东头/上方；附属楼/主楼/2层/走廊/西头/地面
	 */
	public void setPositionDesc(Integer positionDesc) {
		this.positionDesc = positionDesc;
	}
	/**
	 * 获取：描述性位置，如：调度大楼/中栋/3层/310房/东头/上方；附属楼/主楼/2层/走廊/西头/地面
	 */
	public Integer getPositionDesc() {
		return positionDesc;
	}
	/**
	 * 设置：坐标位置，如：F8、H13
	 */
	public void setPositionCoordinate(String positionCoordinate) {
		this.positionCoordinate = positionCoordinate;
	}
	/**
	 * 获取：坐标位置，如：F8、H13
	 */
	public String getPositionCoordinate() {
		return positionCoordinate;
	}
	/**
	 * 设置：三维图形对象ID
	 */
	public void setObjId(String objId) {
		this.objId = objId;
	}
	/**
	 * 获取：三维图形对象ID
	 */
	public String getObjId() {
		return objId;
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
	 * 设置：责任人
	 */
	public void setPersonResponsible(Integer personResponsible) {
		this.personResponsible = personResponsible;
	}
	/**
	 * 获取：责任人
	 */
	public Integer getPersonResponsible() {
		return personResponsible;
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
