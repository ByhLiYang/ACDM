package com.hq.acdm.model.supervision.managermonitor;

import java.math.BigDecimal;

public class VFreestandSum {
    private String terminal;

    private String description;

    private BigDecimal stands;

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal == null ? null : terminal.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public BigDecimal getStands() {
        return stands;
    }

    public void setStands(BigDecimal stands) {
        this.stands = stands;
    }
}