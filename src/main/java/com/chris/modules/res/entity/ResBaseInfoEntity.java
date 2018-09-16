package com.chris.modules.res.entity;

import com.chris.modules.oss.entity.SysAttachmentEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 资源基本信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public class ResBaseInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//资源ID
	private Long id;
	//资源名称
	private String name;
	//资源编码
	private String code;
	//资源类别
	private Integer resTypeId;
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
	private String nameplate;
	//位置ID，如：调度大楼/中栋/3层/310房/东头/上方；附属楼/主楼/2层/走廊/西头/地面
	private Integer locationId;
	//描述性位置
	private String locationDesc;
	//坐标位置，如：F8、H13
	private String locationCoordinate;
	//三维图形对象ID
	private String objId;
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
	//资源描述
	private String remark;
	//责任人
	private Integer personResponsible;

	private List<SysAttachmentEntity> attachmentList;

	/**
	 * 设置：资源ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：资源ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：资源名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：资源名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：资源编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：资源编码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：资源类别
	 */
	public void setResTypeId(Integer resTypeId) {
		this.resTypeId = resTypeId;
	}
	/**
	 * 获取：资源类别
	 */
	public Integer getResTypeId() {
		return resTypeId;
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
	public void setNameplate(String nameplate) {
		this.nameplate = nameplate;
	}
	/**
	 * 获取：资源铭牌，用于上传照片或其他附件，多个附件ID以逗号分隔
	 */
	public String getNameplate() {
		return nameplate;
	}
	/**
	 * 设置：位置ID，如：调度大楼/中栋/3层/310房/东头/上方；附属楼/主楼/2层/走廊/西头/地面
	 */
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	/**
	 * 获取：位置ID，如：调度大楼/中栋/3层/310房/东头/上方；附属楼/主楼/2层/走廊/西头/地面
	 */
	public Integer getLocationId() {
		return locationId;
	}
	/**
	 * 设置：描述性位置
	 */
	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}
	/**
	 * 获取：描述性位置
	 */
	public String getLocationDesc() {
		return locationDesc;
	}
	/**
	 * 设置：坐标位置，如：F8、H13
	 */
	public void setLocationCoordinate(String locationCoordinate) {
		this.locationCoordinate = locationCoordinate;
	}
	/**
	 * 获取：坐标位置，如：F8、H13
	 */
	public String getLocationCoordinate() {
		return locationCoordinate;
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
	 * 设置：资源描述
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：资源描述
	 */
	public String getRemark() {
		return remark;
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

	public List<SysAttachmentEntity> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<SysAttachmentEntity> attachmentList) {
		this.attachmentList = attachmentList;
	}
}
