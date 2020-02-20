package com.drc.dataClean.model;

import java.util.Date;

public class DataContent {
    private Integer urlId;

    private String classify;

    private String title;

    private Date timeshow;

    private String stagename;

    private String platformnam;

    private String classifysho;

    private String tradeshow;

    private String districtsho;

    private String url;

    private String stageshow;

    private String titleshow;

    private String hashcode;

    private String content;

    public Integer getUrlId() {
        return urlId;
    }

    public void setUrlId(Integer urlId) {
        this.urlId = urlId;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getTimeshow() {
        return timeshow;
    }

    public void setTimeshow(Date timeshow) {
        this.timeshow = timeshow;
    }

    public String getStagename() {
        return stagename;
    }

    public void setStagename(String stagename) {
        this.stagename = stagename == null ? null : stagename.trim();
    }

    public String getPlatformnam() {
        return platformnam;
    }

    public void setPlatformnam(String platformnam) {
        this.platformnam = platformnam == null ? null : platformnam.trim();
    }

    public String getClassifysho() {
        return classifysho;
    }

    public void setClassifysho(String classifysho) {
        this.classifysho = classifysho == null ? null : classifysho.trim();
    }

    public String getTradeshow() {
        return tradeshow;
    }

    public void setTradeshow(String tradeshow) {
        this.tradeshow = tradeshow == null ? null : tradeshow.trim();
    }

    public String getDistrictsho() {
        return districtsho;
    }

    public void setDistrictsho(String districtsho) {
        this.districtsho = districtsho == null ? null : districtsho.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getStageshow() {
        return stageshow;
    }

    public void setStageshow(String stageshow) {
        this.stageshow = stageshow == null ? null : stageshow.trim();
    }

    public String getTitleshow() {
        return titleshow;
    }

    public void setTitleshow(String titleshow) {
        this.titleshow = titleshow == null ? null : titleshow.trim();
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode == null ? null : hashcode.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}