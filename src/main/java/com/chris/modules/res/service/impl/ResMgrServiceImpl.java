package com.chris.modules.res.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chris.common.utils.Constant;
import com.chris.common.utils.ValidateUtils;
import com.chris.modules.oss.entity.SysAttachmentEntity;
import com.chris.modules.oss.service.SysAttachmentService;
import com.chris.modules.res.dto.ResInfoDTO;
import com.chris.modules.res.entity.ResBaseInfoEntity;
import com.chris.modules.res.entity.ResInstallConfigEntity;
import com.chris.modules.res.entity.ResMaintenanceEntity;
import com.chris.modules.res.entity.ResPurchaseEntity;
import com.chris.modules.res.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("resMgrService")
public class ResMgrServiceImpl implements ResMgrService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ResBaseInfoService resBaseInfoService;

    @Autowired
    private ResPurchaseService resPurchaseService;

    @Autowired
    private ResMaintenanceService resMaintenanceService;

    @Autowired
    private ResInstallConfigService resInstallConfigService;

    @Autowired
    private SysAttachmentService sysAttachmentService;

    @Override
    public List<ResBaseInfoEntity> queryList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void saveResInfo(ResInfoDTO resInfoDTO) {
        logger.debug("saveResInfo start......");
        this.resBaseInfoService.save(resInfoDTO.getResBaseInfo());
        this.fillResMgrDTOAttrValue(resInfoDTO);
        logger.debug("request JSON = " + JSONObject.toJSONString(resInfoDTO));
        this.resBaseInfoService.saveOtherObj(resInfoDTO.getResBaseInfo());
        //保存资源购置信息
        this.resPurchaseService.save(resInfoDTO.getResPurchase());
        //保存资源维保信息
        this.resMaintenanceService.save(resInfoDTO.getResMaintenance());
        //保存资源安装配置信息
        this.resInstallConfigService.save(resInfoDTO.getResInstallConfig());
        logger.debug("saveResInfo end......");
    }

    private void fillResMgrDTOAttrValue(ResInfoDTO resInfoDTO) {
        this.fillResBaseInfoAttrValue(resInfoDTO.getResBaseInfo());
        this.fillResPurchaseAttrValue(resInfoDTO.getResPurchase(), resInfoDTO.getResBaseInfo().getId());
        this.fillResMaintenanceAttrValue(resInfoDTO.getResMaintenance(), resInfoDTO.getResBaseInfo().getId());
        this.fillResInstallConfigAttrValue(resInfoDTO.getResInstallConfig(), resInfoDTO.getResBaseInfo().getId());
    }

    private void fillResBaseInfoAttrValue(ResBaseInfoEntity resBaseInfo) {
        final Long resId = resBaseInfo.getId();
        if (ValidateUtils.isNotEmptyCollection(resBaseInfo.getResComponentList())) {
            resBaseInfo.getResComponentList().forEach(item -> {
                item.setResId(resId);
            });
        }
        if (ValidateUtils.isNotEmptyCollection(resBaseInfo.getResEquipParamList())) {
            resBaseInfo.getResEquipParamList().forEach(item -> {
                item.setResId(resId);
            });
        }
        this.fillAttachmentsAttrValue(resBaseInfo.getResNameplateAttachments(), resId, Constant.AttachmentSource.RES_NAMEPLATE__ATTACHMENTS);
    }

    private void fillResPurchaseAttrValue(ResPurchaseEntity resPurchase, final Long resId) {
        resPurchase.setResId(resId);
        this.fillAttachmentsAttrValue(resPurchase.getContractAttachments(), resId, Constant.AttachmentSource.CONTRACT_ATTACHMENTS);
    }

    private void fillResMaintenanceAttrValue(ResMaintenanceEntity resMaintenance, final Long resId) {
        resMaintenance.setResId(resId);
        this.fillAttachmentsAttrValue(resMaintenance.getMaintainContractAttachments(), resId, Constant.AttachmentSource.MAINTAIN_CONTRACT_ATTACHMENTS);
        this.fillAttachmentsAttrValue(resMaintenance.getResInstructionsAttachments(), resId, Constant.AttachmentSource.RES_INSTRUCTIONS_ATTACHMENTS);
        this.fillAttachmentsAttrValue(resMaintenance.getPrecautionsAttachments(), resId, Constant.AttachmentSource.PRECAUTIONS_ATTACHMENTS);
    }

    private void fillResInstallConfigAttrValue(ResInstallConfigEntity resInstallConfig, Long resId) {
        resInstallConfig.setResId(resId);
        this.fillAttachmentsAttrValue(resInstallConfig.getDrawingAttachments(), resId, Constant.AttachmentSource.DRAWING_ATTACHMENTS);
        this.fillAttachmentsAttrValue(resInstallConfig.getOperSpecAttachments(), resId, Constant.AttachmentSource.OPERSPEC_ATTACHMENTS);
    }

    private void fillAttachmentsAttrValue(List<SysAttachmentEntity> attachments, Long objId, String objSource) {
        if (ValidateUtils.isNotEmptyCollection(attachments)) {
            attachments.forEach(item -> {
                item.setObjId(objId);
                item.setObjSource(objSource);
            });
        }
    }

    @Override
    public void updateResInfo(ResInfoDTO resInfoDTO) {
        this.fillResMgrDTOAttrValue(resInfoDTO);
        logger.debug("updateResInfo start, request JSON = " + JSONObject.toJSONString(resInfoDTO));
        this.resBaseInfoService.update(resInfoDTO.getResBaseInfo());
        this.resPurchaseService.update(resInfoDTO.getResPurchase());
        this.resMaintenanceService.update(resInfoDTO.getResMaintenance());
        this.resInstallConfigService.update(resInfoDTO.getResInstallConfig());
        logger.debug("updateResInfo end.");
    }

    @Override
    public void deleteResInfoById(Long resId) {

    }

    @Override
    public void deleteBatchResInfo(Long[] resIds) {

    }

    @Override
    public ResInfoDTO queryResInfoById(Long id) {
        ResBaseInfoEntity resBaseInfo = this.resBaseInfoService.queryResBaseInfoById(id);
        ResPurchaseEntity resPurchase = this.resPurchaseService.queryResPurchaseByResId(id);
        ResMaintenanceEntity resMaintenance = this.resMaintenanceService.queryResMaintenceByResId(id);
        ResInstallConfigEntity resInstallConfig = this.resInstallConfigService.queryResInstallConfigByResId(id);
        List<SysAttachmentEntity> attachments = this.sysAttachmentService.queryAttachmentsByCondition(new SysAttachmentEntity(id));
        ResInfoDTO resInfoDTO = ResInfoDTO.builder().resBaseInfo(resBaseInfo).resPurchase(resPurchase).
                resMaintenance(resMaintenance).resInstallConfig(resInstallConfig).build();
        this.bindAttachments4ResInfo(attachments, resInfoDTO);
        return resInfoDTO;
    }

    private void bindAttachments4ResInfo(List<SysAttachmentEntity> attachments, ResInfoDTO resInfoDTO) {
        if (ValidateUtils.isNotEmptyCollection(attachments)) {
            if (ValidateUtils.isNotEmpty(resInfoDTO.getResBaseInfo())) {
                resInfoDTO.getResBaseInfo().setResNameplateAttachments(attachments.stream().filter(item -> ValidateUtils.equals(item.getObjSource(), Constant.AttachmentSource.RES_NAMEPLATE__ATTACHMENTS)).collect(Collectors.toList()));
            }
            if (ValidateUtils.isNotEmpty(resInfoDTO.getResPurchase())) {
                resInfoDTO.getResPurchase().setContractAttachments(attachments.stream().filter(item -> ValidateUtils.equals(item.getObjSource(), Constant.AttachmentSource.CONTRACT_ATTACHMENTS)).collect(Collectors.toList()));
            }
            if (ValidateUtils.isNotEmpty(resInfoDTO.getResMaintenance())) {
                resInfoDTO.getResMaintenance().setMaintainContractAttachments(attachments.stream().filter(item -> ValidateUtils.equals(item.getObjSource(), Constant.AttachmentSource.MAINTAIN_CONTRACT_ATTACHMENTS)).collect(Collectors.toList()));
                resInfoDTO.getResMaintenance().setResInstructionsAttachments(attachments.stream().filter(item -> ValidateUtils.equals(item.getObjSource(), Constant.AttachmentSource.RES_INSTRUCTIONS_ATTACHMENTS)).collect(Collectors.toList()));
                resInfoDTO.getResMaintenance().setPrecautionsAttachments(attachments.stream().filter(item -> ValidateUtils.equals(item.getObjSource(), Constant.AttachmentSource.PRECAUTIONS_ATTACHMENTS)).collect(Collectors.toList()));
            }
            if (ValidateUtils.isNotEmpty(resInfoDTO.getResInstallConfig())) {
                resInfoDTO.getResInstallConfig().setDrawingAttachments(attachments.stream().filter(item -> ValidateUtils.equals(item.getObjSource(), Constant.AttachmentSource.DRAWING_ATTACHMENTS)).collect(Collectors.toList()));
                resInfoDTO.getResInstallConfig().setOperSpecAttachments(attachments.stream().filter(item -> ValidateUtils.equals(item.getObjSource(), Constant.AttachmentSource.OPERSPEC_ATTACHMENTS)).collect(Collectors.toList()));
            }
        }
    }
}
