package com.chris.common.model;

import java.io.Serializable;
import java.util.Map;

public class CommonCheckParam implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, String> condition;
    private String daoName;

    public Map<String, String> getCondition() {
        return condition;
    }

    public void setCondition(Map<String, String> condition) {
        this.condition = condition;
    }

    public String getDaoName() {
        return daoName;
    }

    public void setDaoName(String daoName) {
        this.daoName = daoName;
    }

}
