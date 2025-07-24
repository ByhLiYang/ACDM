package com.hq.acdm.vo.coordinatedOprt;


public class FlowControlInfoTControlInfoVo {

    private String id;
    private String controlId;
    private String publisher;
    private String pubtime;
    private String controlContent;
    private String controlRealStarttm;
    private String controlAlteratEndtm;
    private String originalsource;
    private String isavailable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getControlId() {
        return controlId;
    }

    public void setControlId(String controlId) {
        this.controlId = controlId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }

    public String getControlContent() {
        return controlContent;
    }

    public void setControlContent(String controlContent) {
        this.controlContent = controlContent;
    }

    public String getControlRealStarttm() {
        return controlRealStarttm;
    }

    public void setControlRealStarttm(String controlRealStarttm) {
        this.controlRealStarttm = controlRealStarttm;
    }

    public String getControlAlteratEndtm() {
        return controlAlteratEndtm;
    }

    public void setControlAlteratEndtm(String controlAlteratEndtm) {
        this.controlAlteratEndtm = controlAlteratEndtm;
    }

    public String getOriginalsource() {
        return originalsource;
    }

    public void setOriginalsource(String originalsource) {
        this.originalsource = originalsource;
    }

    public String getIsavailable() {
        return isavailable;
    }

    public void setIsavailable(String isavailable) {
        this.isavailable = isavailable;
    }
}
