package com.power.demo.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BooksVO {
    @ApiModelProperty("图书ID")
    private String id;
    @ApiModelProperty("图书名称")
    private String name;
    @ApiModelProperty("图书价钱")
    private Integer price;
    @ApiModelProperty("图书类别")
    private String category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
