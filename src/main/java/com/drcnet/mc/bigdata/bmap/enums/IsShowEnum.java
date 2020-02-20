package com.drcnet.mc.bigdata.bmap.enums;

public enum IsShowEnum {

        HIDE(0,"不展示"),
        SHOW(1,"展示");


        private int code;
        private String name;


     IsShowEnum(int code, String name) {
        this.code = code;
        this.name = name();
    }
    public int getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public void setName(String name) {
        this.name = name;
    }



}
