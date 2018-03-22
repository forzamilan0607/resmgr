package com.chris.modules.res.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 资源采购信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
public class ResPurchaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//采购ID
	private Long purchaseId;
	//资源ID
	private Long resId;
	//合同单位
	private String contractCompany;
	//合同编号
	private String contractNo;
	//合同附件，多个附件ID以逗号分隔
	private String contractAttach;
	//合同描述
	private String contractDesc;
	//采购价格
	private BigDecimal purchasePrice;
	//采购时间
	private Date purchaseDate;
	//是否同步，1、是，0、否
	private String isSync;

	/**
	 * 设置：采购ID
	 */
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
	/**
	 * 获取：采购ID
	 */
	public Long getPurchaseId() {
		return purchaseId;
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
	 * 设置：合同单位
	 */
	public void setContractCompany(String contractCompany) {
		this.contractCompany = contractCompany;
	}
	/**
	 * 获取：合同单位
	 */
	public String getContractCompany() {
		return contractCompany;
	}
	/**
	 * 设置：合同编号
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	/**
	 * 获取：合同编号
	 */
	public String getContractNo() {
		return contractNo;
	}
	/**
	 * 设置：合同附件，多个附件ID以逗号分隔
	 */
	public void setContractAttach(String contractAttach) {
		this.contractAttach = contractAttach;
	}
	/**
	 * 获取：合同附件，多个附件ID以逗号分隔
	 */
	public String getContractAttach() {
		return contractAttach;
	}
	/**
	 * 设置：合同描述
	 */
	public void setContractDesc(String contractDesc) {
		this.contractDesc = contractDesc;
	}
	/**
	 * 获取：合同描述
	 */
	public String getContractDesc() {
		return contractDesc;
	}
	/**
	 * 设置：采购价格
	 */
	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	/**
	 * 获取：采购价格
	 */
	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}
	/**
	 * 设置：采购时间
	 */
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	/**
	 * 获取：采购时间
	 */
	public Date getPurchaseDate() {
		return purchaseDate;
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
