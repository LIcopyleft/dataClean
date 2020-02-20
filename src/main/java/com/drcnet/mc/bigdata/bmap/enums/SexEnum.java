package com.drcnet.mc.bigdata.bmap.enums;

public enum SexEnum {

        MAN(0,"男"),
        WOMEN(1,"女");


        private int code;
        private String name;


     SexEnum(int code, String name) {
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
