package com.chris.modules.res.entity;

import com.chris.modules.oss.entity.SysAttachmentEntity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import java.util.List;


/**
 * 资源运维信息
 *
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public class ResMaintenanceEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //运维ID
    private Long id;
    //资源ID
    private Long resId;
    //维护单位
    private Integer maintainDeptId;
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
    //维保合同附件列表
    private List<SysAttachmentEntity> maintainContractAttachments;

    //设备资源说明书附件列表
    private List<SysAttachmentEntity> resInstructionsAttachments;

    //运维或保养特别提示、注意事项（文字）
    private String precautionsText;

    //运维或保养特别提示、注意事项附件列表
    private List<SysAttachmentEntity> precautionsAttachments;

    //设备状态,入库/在用/送修/注销
    private Integer resStatus;
    //创建时间
    private Date createTime;
    //创建人
    private Integer createUserId;
    //修改时间
    private Date updateTime;
    //修改人
    private Integer updateUserId;

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

    public Integer getMaintainDeptId() {
        return maintainDeptId;
    }

    public void setMaintainDeptId(Integer maintainDeptId) {
        this.maintainDeptId = maintainDeptId;
    }

    public Integer getPersonResponsible() {
        return personResponsible;
    }

    public void setPersonResponsible(Integer personResponsible) {
        this.personResponsible = personResponsible;
    }

    public Date getWarrantyStartDate() {
        return warrantyStartDate;
    }

    public void setWarrantyStartDate(Date warrantyStartDate) {
        this.warrantyStartDate = warrantyStartDate;
    }

    public Date getWarrantyEndDate() {
        return warrantyEndDate;
    }

    public void setWarrantyEndDate(Date warrantyEndDate) {
        this.warrantyEndDate = warrantyEndDate;
    }

    public String getMaintainCompany() {
        return maintainCompany;
    }

    public void setMaintainCompany(String maintainCompany) {
        this.maintainCompany = maintainCompany;
    }

    public Date getMaintainPeriod() {
        return maintainPeriod;
    }

    public void setMaintainPeriod(Date maintainPeriod) {
        this.maintainPeriod = maintainPeriod;
    }

    public BigDecimal getMaintainPrice() {
        return maintainPrice;
    }

    public void setMaintainPrice(BigDecimal maintainPrice) {
        this.maintainPrice = maintainPrice;
    }

    public List<SysAttachmentEntity> getMaintainContractAttachments() {
        return maintainContractAttachments;
    }

    public void setMaintainContractAttachments(List<SysAttachmentEntity> maintainContractAttachments) {
        this.maintainContractAttachments = maintainContractAttachments;
    }

    public List<SysAttachmentEntity> getResInstructionsAttachments() {
        return resInstructionsAttachments;
    }

    public void setResInstructionsAttachments(List<SysAttachmentEntity> resInstructionsAttachments) {
        this.resInstructionsAttachments = resInstructionsAttachments;
    }

    public String getPrecautionsText() {
        return precautionsText;
    }

    public void setPrecautionsText(String precautionsText) {
        this.precautionsText = precautionsText;
    }

    public List<SysAttachmentEntity> getPrecautionsAttachments() {
        return precautionsAttachments;
    }

    public void setPrecautionsAttachments(List<SysAttachmentEntity> precautionsAttachments) {
        this.precautionsAttachments = precautionsAttachments;
    }

    public Integer getResStatus() {
        return resStatus;
    }

    public void setResStatus(Integer resStatus) {
        this.resStatus = resStatus;
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
}
