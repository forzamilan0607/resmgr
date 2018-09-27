package com.chris.modules.res.dto;

import java.io.Serializable;

public class LocationParamDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer deptId;
    private Integer createUserId;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }
}
