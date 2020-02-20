package com.drcnet.mc.bigdata.bmap.enums;

public enum ChangePassStatusEnum {

    SUCCESS(0,"密码修改成功"),
    OLD_PASS_ERR(1,"旧密码错误,请重试"),
    PASS_LENTH_ERR(2,"密码长度应为6-16个数字和字母组合"),
    PASS_REG_ERR(3,"密码过于简单，请尝试“字母+数字”组合");
    private int code;
    private String name;

    ChangePassStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    public static String getName(Integer value) {
        ChangePassStatusEnum[] enums = values();
        for (ChangePassStatusEnum businessModeEnum : enums) {
            if (businessModeEnum.code == (value)) {
                return businessModeEnum.name;
            }
        }
        return null;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public void setName(String name) {
        this.name = name;
    }



}
