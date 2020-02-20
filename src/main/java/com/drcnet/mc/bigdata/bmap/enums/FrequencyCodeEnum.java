package com.drcnet.mc.bigdata.bmap.enums;

public enum FrequencyCodeEnum {

    YEAR("Y", "年"),
    MONTH("M", "月"),
    SEASON("Q", "季"),
    TEN_DAY("X", "旬"),
    WEEK("W", "周"),
    DAY("D", "日");


    private String code;
    private String name;


    FrequencyCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static boolean isValue(String code) {
        FrequencyCodeEnum[] values = values();
        for (FrequencyCodeEnum codeEnum : values){
            if(codeEnum.code.equalsIgnoreCase(code)){
                return true;
            }
        }
        return false;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }


}
