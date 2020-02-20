package com.drcnet.mc.bigdata.bmap.enums;

public enum RoleTypeEnum {

        MANAGER(0,"管理员"),
        USER(1,"用户");


        private int code;
        private String name;


     RoleTypeEnum(int code, String name) {
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
