package com.drcnet.mc.bigdata.bmap.enums;

public enum LabelTypeEnum {

    NATION(1,"国家"),
    AREA(2,"地区");


        private int code;
        private String name;


     LabelTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
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
