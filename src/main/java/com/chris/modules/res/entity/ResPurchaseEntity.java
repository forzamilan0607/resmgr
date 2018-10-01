package com.chris.modules.res.entity;

import com.chris.common.model.SysUpdateInfo;
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
public class ResPurchaseEntity extends SysUpdateInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//采购ID
	private Long id;
	//资源ID
	private Long resId;
	//合同单位ID
	private Integer contractCompanyId;
	//合同单位
	private String contractCompanyName;
	//合同编号
	private String contractNo;
	//合同描述
	private String contractDesc;
	//采购价格
	private BigDecimal price;
	//合同附件
	private List<SysAttachmentEntity> contractAttachments;

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

	public Integer getContractCompanyId() {
		return contractCompanyId;
	}

	public void setContractCompanyId(Integer contractCompanyId) {
		this.contractCompanyId = contractCompanyId;
	}

	public String getContractCompanyName() {
		return contractCompanyName;
	}

	public void setContractCompanyName(String contractCompanyName) {
		this.contractCompanyName = contractCompanyName;
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

	public List<SysAttachmentEntity> getContractAttachments() {
		return contractAttachments;
	}

	public void setContractAttachments(List<SysAttachmentEntity> contractAttachments) {
		this.contractAttachments = contractAttachments;
	}
}
