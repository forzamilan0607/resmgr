package com.chris.modules.res.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import java.util.List;


/**
 * 资源采购信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public class ResPurchaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//采购ID
	private Long id;
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
	private BigDecimal price;
	//创建时间
	private Date createTime;
	//创建人
	private Integer createUserId;
	//修改时间
	private Date updateTime;
	//修改人
	private Integer updateUserId;

	private List<ResAttachmentEntity> attachmentList;

	/**
	 * 设置：采购ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：采购ID
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
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：采购价格
	 */
	public BigDecimal getPrice() {
		return price;
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

	public List<ResAttachmentEntity> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<ResAttachmentEntity> attachmentList) {
		this.attachmentList = attachmentList;
	}
}
