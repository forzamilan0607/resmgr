package com.chris.modules.res.entity;

import com.chris.common.model.SysUpdateInfo;
import com.chris.modules.oss.entity.SysAttachmentEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

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
public class ResBaseInfoEntity extends SysUpdateInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//资源ID
	private Long id;
	//资源设备名称
	private String name;
	//设备ID
	private Integer equipId;
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
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	private Date factoryTime;
	//整机序列号
	private String serialNo;
	//位置ID，如：调度大楼/中栋/3层/310房/东头/上方；附属楼/主楼/2层/走廊/西头/地面
	private Integer locationId;
	//描述性位置
	private String locationDesc;
	//坐标位置，如：F8、H13
	private String locationCoordinate;
	//三维图形对象ID
	private String objId;
	//部门ID
	private Integer deptId;
	//部门名称
	private String deptName;
	//资源描述
	private String remark;
	//责任人ID
	private Integer personResponsible;
	//责任人名称
	private String responsibleName;

	private List<SysAttachmentEntity> resNameplateAttachments;

	private List<ResComponentEntity> resComponentList;

	private List<ResEquipParamEntity> resEquipParamList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEquipId() {
		return equipId;
	}

	public void setEquipId(Integer equipId) {
		this.equipId = equipId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getResTypeId() {
		return resTypeId;
	}

	public void setResTypeId(Integer resTypeId) {
		this.resTypeId = resTypeId;
	}

	public Integer getBrand() {
		return brand;
	}

	public void setBrand(Integer brand) {
		this.brand = brand;
	}

	public Integer getSeries() {
		return series;
	}

	public void setSeries(Integer series) {
		this.series = series;
	}

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}

	public Date getFactoryTime() {
		return factoryTime;
	}

	public void setFactoryTime(Date factoryTime) {
		this.factoryTime = factoryTime;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getLocationDesc() {
		return locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	public String getLocationCoordinate() {
		return locationCoordinate;
	}

	public void setLocationCoordinate(String locationCoordinate) {
		this.locationCoordinate = locationCoordinate;
	}

	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getPersonResponsible() {
		return personResponsible;
	}

	public void setPersonResponsible(Integer personResponsible) {
		this.personResponsible = personResponsible;
	}

	public List<SysAttachmentEntity> getResNameplateAttachments() {
		return resNameplateAttachments;
	}

	public void setResNameplateAttachments(List<SysAttachmentEntity> resNameplateAttachments) {
		this.resNameplateAttachments = resNameplateAttachments;
	}

	public List<ResComponentEntity> getResComponentList() {
		return resComponentList;
	}

	public void setResComponentList(List<ResComponentEntity> resComponentList) {
		this.resComponentList = resComponentList;
	}

	public List<ResEquipParamEntity> getResEquipParamList() {
		return resEquipParamList;
	}

	public void setResEquipParamList(List<ResEquipParamEntity> resEquipParamList) {
		this.resEquipParamList = resEquipParamList;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

	public ResBaseInfoEntity() {
    }

    public ResBaseInfoEntity(Long id) {
        this.id = id;
    }
}
