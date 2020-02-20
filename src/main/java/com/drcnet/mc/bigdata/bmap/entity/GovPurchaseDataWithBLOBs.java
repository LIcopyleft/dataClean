package com.drcnet.mc.bigdata.bmap.entity;

public class GovPurchaseDataWithBLOBs extends GovPurchaseData {
    private String content;

    private String expertname;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getExpertname() {
        return expertname;
    }

    public void setExpertname(String expertname) {
        this.expertname = expertname == null ? null : expertname.trim();
    }
}