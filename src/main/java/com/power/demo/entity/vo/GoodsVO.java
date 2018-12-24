package com.power.demo.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * 货品信息
 * <p>
 * Created by JeffWong.
 */
@ApiModel
public class GoodsVO {

    @ApiModelProperty("商品Id")
    private String goodsId;

    @ApiModelProperty("商品编码")
    private String goodsCode;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品类型")
    private Integer goodsType;

    @ApiModelProperty("是否删除")
    private Integer disabled;

    @ApiModelProperty("创建时间(Date类型)")
    private Date createTime;

    @ApiModelProperty("创建时间(JodaTime)")
    private DateTime createDate;

    @ApiModelProperty("创建时间(String类型)")
    private String strCreateTime;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public DateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(DateTime createDate) {
        this.createDate = createDate;
    }

    public String getStrCreateTime() {
        return strCreateTime;
    }

    public void setStrCreateTime(String strCreateTime) {
        this.strCreateTime = strCreateTime;
    }
}