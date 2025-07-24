package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;

public class TMultiDatasourceSetting implements Serializable {
    private String id;

    private String table;

    private String field;

    private String datasource;

    private Integer priority;

    private String remk;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table == null ? null : table.trim();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field == null ? null : field.trim();
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource == null ? null : datasource.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getRemk() {
        return remk;
    }

    public void setRemk(String remk) {
        this.remk = remk == null ? null : remk.trim();
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
        TMultiDatasourceSetting other = (TMultiDatasourceSetting) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTable() == null ? other.getTable() == null : this.getTable().equals(other.getTable()))
            && (this.getField() == null ? other.getField() == null : this.getField().equals(other.getField()))
            && (this.getDatasource() == null ? other.getDatasource() == null : this.getDatasource().equals(other.getDatasource()))
            && (this.getPriority() == null ? other.getPriority() == null : this.getPriority().equals(other.getPriority()))
            && (this.getRemk() == null ? other.getRemk() == null : this.getRemk().equals(other.getRemk()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTable() == null) ? 0 : getTable().hashCode());
        result = prime * result + ((getField() == null) ? 0 : getField().hashCode());
        result = prime * result + ((getDatasource() == null) ? 0 : getDatasource().hashCode());
        result = prime * result + ((getPriority() == null) ? 0 : getPriority().hashCode());
        result = prime * result + ((getRemk() == null) ? 0 : getRemk().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", table=").append(table);
        sb.append(", field=").append(field);
        sb.append(", datasource=").append(datasource);
        sb.append(", priority=").append(priority);
        sb.append(", remk=").append(remk);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}