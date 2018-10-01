package com.chris.common.tree;

import java.io.Serializable;

public class TreeNode implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer nodeId;
    private String nodeName;
    private Integer parentNodeId;
    private String extValue;

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Integer getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(Integer parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    public String getExtValue() {
        return extValue;
    }

    public void setExtValue(String extValue) {
        this.extValue = extValue;
    }

    public TreeNode() {
    }

}
