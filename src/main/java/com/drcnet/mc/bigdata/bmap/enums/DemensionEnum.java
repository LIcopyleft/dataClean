package com.drcnet.mc.bigdata.bmap.enums;

public enum DemensionEnum {
    /**
     * 分类
     */
    CATEGORY("M", "category"),
    /**
     * 商品分类
     */
    COMMODITY("G", "commodity"),
    /**
     * 公司
     */
    COMPANY("G", "company"),
    /**
     * 设备
     */
    EQUIPMENT("E", "equipment"),
    /**
     * 海关代码
     */
    HS("H", "hs"),
    /**
     * 指标
     */
    INDICATOR("I", "indicator"),
    /**
     * 行业
     */
    INDUSTRY("V", "industry"),
    /**
     * 时间
     */
    TIME("T", "time"),
    /**
     * 地区
     */
    REGION("R", "region"),

    /**
     * 地区
     */
    TO_REGION("R", "to_region"),
    /**
     * 地区
     */
    FROM_REGION("R", "from_region");


    private String code;
    private String name;


    DemensionEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static boolean isValue(String code) {
        DemensionEnum[] values = values();
        for (DemensionEnum codeEnum : values){
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
