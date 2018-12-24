package com.power.demo.common;

/**
 * Created by JeffWong.
 */
public enum GoodsType {

    Normal(0, "普通商品"),

    Discount(1024, "折扣商品");

    GoodsType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    private int code;

    private String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
