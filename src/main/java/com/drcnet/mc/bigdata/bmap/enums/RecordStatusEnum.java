package com.drcnet.mc.bigdata.bmap.enums;

public enum  RecordStatusEnum {

        NORMAL(0,"正常"),
        DISABLE(1,"禁用");


        private int code;
        private String name;


     RecordStatusEnum(int code,String name) {
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
