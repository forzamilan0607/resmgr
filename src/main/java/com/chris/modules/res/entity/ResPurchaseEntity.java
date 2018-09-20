package com.chris.modules.res.entity;

import com.chris.modules.oss.entity.SysAttachmentEntity;

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

	//合同附件
	private List<SysAttachmentEntity> contractAtachments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getResId() {
		return resId;
	}

	public void setResId(Long resId) {
		this.resId = resId;
	}

	public String getContractCompany() {
		return contractCompany;
	}

	public void setContractCompany(String contractCompany) {
		this.contractCompany = contractCompany;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getContractDesc() {
		return contractDesc;
	}

	public void setContractDesc(String contractDesc) {
		this.contractDesc = contractDesc;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public List<SysAttachmentEntity> getContractAtachments() {
		return contractAtachments;
	}

	public void setContractAtachments(List<SysAttachmentEntity> contractAtachments) {
		this.contractAtachments = contractAtachments;
	}
}
