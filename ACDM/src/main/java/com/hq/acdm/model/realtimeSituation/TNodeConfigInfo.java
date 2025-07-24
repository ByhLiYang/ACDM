package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;
import java.util.Date;

public class TNodeConfigInfo implements Serializable {
    private String id;

    private String nodeCode;

    private Integer nodeSeq;

    private String nodeName;

    private String nodeColumn;

    private String nodeEstimateColumn;

    private String nodeSubexp;

    private Integer isavailabl;

    private Integer isnecessary;

    private String rmk;

    private Date createTm;

    private Date updateTm;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode == null ? null : nodeCode.trim();
    }

    public Integer getNodeSeq() {
        return nodeSeq;
    }

    public void setNodeSeq(Integer nodeSeq) {
        this.nodeSeq = nodeSeq;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    public String getNodeColumn() {
        return nodeColumn;
    }

    public void setNodeColumn(String nodeColumn) {
        this.nodeColumn = nodeColumn == null ? null : nodeColumn.trim();
    }

    public String getNodeEstimateColumn() {
        return nodeEstimateColumn;
    }

    public void setNodeEstimateColumn(String nodeEstimateColumn) {
        this.nodeEstimateColumn = nodeEstimateColumn == null ? null : nodeEstimateColumn.trim();
    }

    public String getNodeSubexp() {
        return nodeSubexp;
    }

    public void setNodeSubexp(String nodeSubexp) {
        this.nodeSubexp = nodeSubexp == null ? null : nodeSubexp.trim();
    }

    public Integer getIsavailabl() {
        return isavailabl;
    }

    public void setIsavailabl(Integer isavailabl) {
        this.isavailabl = isavailabl;
    }

    public Integer getIsnecessary() {
        return isnecessary;
    }

    public void setIsnecessary(Integer isnecessary) {
        this.isnecessary = isnecessary;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk == null ? null : rmk.trim();
    }

    public Date getCreateTm() {
        return createTm;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    public Date getUpdateTm() {
        return updateTm;
    }

    public void setUpdateTm(Date updateTm) {
        this.updateTm = updateTm;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TNodeConfigInfo other = (TNodeConfigInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNodeCode() == null ? other.getNodeCode() == null : this.getNodeCode().equals(other.getNodeCode()))
            && (this.getNodeSeq() == null ? other.getNodeSeq() == null : this.getNodeSeq().equals(other.getNodeSeq()))
            && (this.getNodeName() == null ? other.getNodeName() == null : this.getNodeName().equals(other.getNodeName()))
            && (this.getNodeColumn() == null ? other.getNodeColumn() == null : this.getNodeColumn().equals(other.getNodeColumn()))
            && (this.getNodeEstimateColumn() == null ? other.getNodeEstimateColumn() == null : this.getNodeEstimateColumn().equals(other.getNodeEstimateColumn()))
            && (this.getNodeSubexp() == null ? other.getNodeSubexp() == null : this.getNodeSubexp().equals(other.getNodeSubexp()))
            && (this.getIsavailabl() == null ? other.getIsavailabl() == null : this.getIsavailabl().equals(other.getIsavailabl()))
            && (this.getIsnecessary() == null ? other.getIsnecessary() == null : this.getIsnecessary().equals(other.getIsnecessary()))
            && (this.getRmk() == null ? other.getRmk() == null : this.getRmk().equals(other.getRmk()))
            && (this.getCreateTm() == null ? other.getCreateTm() == null : this.getCreateTm().equals(other.getCreateTm()))
            && (this.getUpdateTm() == null ? other.getUpdateTm() == null : this.getUpdateTm().equals(other.getUpdateTm()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNodeCode() == null) ? 0 : getNodeCode().hashCode());
        result = prime * result + ((getNodeSeq() == null) ? 0 : getNodeSeq().hashCode());
        result = prime * result + ((getNodeName() == null) ? 0 : getNodeName().hashCode());
        result = prime * result + ((getNodeColumn() == null) ? 0 : getNodeColumn().hashCode());
        result = prime * result + ((getNodeEstimateColumn() == null) ? 0 : getNodeEstimateColumn().hashCode());
        result = prime * result + ((getNodeSubexp() == null) ? 0 : getNodeSubexp().hashCode());
        result = prime * result + ((getIsavailabl() == null) ? 0 : getIsavailabl().hashCode());
        result = prime * result + ((getIsnecessary() == null) ? 0 : getIsnecessary().hashCode());
        result = prime * result + ((getRmk() == null) ? 0 : getRmk().hashCode());
        result = prime * result + ((getCreateTm() == null) ? 0 : getCreateTm().hashCode());
        result = prime * result + ((getUpdateTm() == null) ? 0 : getUpdateTm().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nodeCode=").append(nodeCode);
        sb.append(", nodeSeq=").append(nodeSeq);
        sb.append(", nodeName=").append(nodeName);
        sb.append(", nodeColumn=").append(nodeColumn);
        sb.append(", nodeEstimateColumn=").append(nodeEstimateColumn);
        sb.append(", nodeSubexp=").append(nodeSubexp);
        sb.append(", isavailabl=").append(isavailabl);
        sb.append(", isnecessary=").append(isnecessary);
        sb.append(", rmk=").append(rmk);
        sb.append(", createTm=").append(createTm);
        sb.append(", updateTm=").append(updateTm);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}