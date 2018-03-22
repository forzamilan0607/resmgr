package com.chris.modules.res.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 资源运维信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
public class ResMaintenanceEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//运维ID
	private Long id;
	//资源ID
	private Long resId;
	//维护单位
	private Integer maintainDept;
	//责任人
	private Integer personResponsible;
	//保修开始日期
	private Date warrantyStartDate;
	//保修结束日期
	private Date warrantyEndDate;
	//维保单位
	private String maintainCompany;
	//维保周期
	private Date maintainPeriod;
	//维保价格
	private BigDecimal maintainPrice;
	//维保合同，多个附件ID以逗号分隔
	private String maintainContract;
	//设备资源说明书，多个附件ID以逗号分隔
	private String resInstructions;
	//运维或保养特别提示、注意事项（文字）
	private String precautionsText;
	//运维或保养特别提示、注意事项（附件）
	private String precautionsAttach;
	//设备状态,入库/在用/送修/注销
	private Integer resStatus;
	//是否同步，1、是，0、否
	private String isSync;

	/**
	 * 设置：运维ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：运维ID
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
	 * 设置：维护单位
	 */
	public void setMaintainDept(Integer maintainDept) {
		this.maintainDept = maintainDept;
	}
	/**
	 * 获取：维护单位
	 */
	public Integer getMaintainDept() {
		return maintainDept;
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
	 * 设置：保修开始日期
	 */
	public void setWarrantyStartDate(Date warrantyStartDate) {
		this.warrantyStartDate = warrantyStartDate;
	}
	/**
	 * 获取：保修开始日期
	 */
	public Date getWarrantyStartDate() {
		return warrantyStartDate;
	}
	/**
	 * 设置：保修结束日期
	 */
	public void setWarrantyEndDate(Date warrantyEndDate) {
		this.warrantyEndDate = warrantyEndDate;
	}
	/**
	 * 获取：保修结束日期
	 */
	public Date getWarrantyEndDate() {
		return warrantyEndDate;
	}
	/**
	 * 设置：维保单位
	 */
	public void setMaintainCompany(String maintainCompany) {
		this.maintainCompany = maintainCompany;
	}
	/**
	 * 获取：维保单位
	 */
	public String getMaintainCompany() {
		return maintainCompany;
	}
	/**
	 * 设置：维保周期
	 */
	public void setMaintainPeriod(Date maintainPeriod) {
		this.maintainPeriod = maintainPeriod;
	}
	/**
	 * 获取：维保周期
	 */
	public Date getMaintainPeriod() {
		return maintainPeriod;
	}
	/**
	 * 设置：维保价格
	 */
	public void setMaintainPrice(BigDecimal maintainPrice) {
		this.maintainPrice = maintainPrice;
	}
	/**
	 * 获取：维保价格
	 */
	public BigDecimal getMaintainPrice() {
		return maintainPrice;
	}
	/**
	 * 设置：维保合同，多个附件ID以逗号分隔
	 */
	public void setMaintainContract(String maintainContract) {
		this.maintainContract = maintainContract;
	}
	/**
	 * 获取：维保合同，多个附件ID以逗号分隔
	 */
	public String getMaintainContract() {
		return maintainContract;
	}
	/**
	 * 设置：设备资源说明书，多个附件ID以逗号分隔
	 */
	public void setResInstructions(String resInstructions) {
		this.resInstructions = resInstructions;
	}
	/**
	 * 获取：设备资源说明书，多个附件ID以逗号分隔
	 */
	public String getResInstructions() {
		return resInstructions;
	}
	/**
	 * 设置：运维或保养特别提示、注意事项（文字）
	 */
	public void setPrecautionsText(String precautionsText) {
		this.precautionsText = precautionsText;
	}
	/**
	 * 获取：运维或保养特别提示、注意事项（文字）
	 */
	public String getPrecautionsText() {
		return precautionsText;
	}
	/**
	 * 设置：运维或保养特别提示、注意事项（附件）
	 */
	public void setPrecautionsAttach(String precautionsAttach) {
		this.precautionsAttach = precautionsAttach;
	}
	/**
	 * 获取：运维或保养特别提示、注意事项（附件）
	 */
	public String getPrecautionsAttach() {
		return precautionsAttach;
	}
	/**
	 * 设置：设备状态,入库/在用/送修/注销
	 */
	public void setResStatus(Integer resStatus) {
		this.resStatus = resStatus;
	}
	/**
	 * 获取：设备状态,入库/在用/送修/注销
	 */
	public Integer getResStatus() {
		return resStatus;
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
