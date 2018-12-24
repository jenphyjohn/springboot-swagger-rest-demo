package com.power.demo.controller;

import com.power.demo.common.BizResult;
import com.power.demo.entity.vo.GoodsVO;
import com.power.demo.service.contract.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品接口REST服务
 * <p>
 * Created by JeffWong.
 */
@RestController
@RequestMapping("/api/goods")
@Api("商品相关api")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
    @ApiOperation("根据商品Id查询商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "goodsId", required = true, value = "商品ID", dataType = "String")
    })
    public GoodsVO getGoodsByGoodsId(String goodsId) {
        return goodsService.getGoodsByGoodsId(goodsId);
    }

    @RequestMapping(value = "/getbycode", method = RequestMethod.GET)
    @ApiOperation("根据商品编码查询商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "goodsCode", required = false, value = "商品编码", dataType = "String")
    })
    public GoodsVO getGoodsByGoodsCode(String goodsCode) {
        return goodsService.getGoodsByGoodsCode(goodsCode);
    }

    @RequestMapping(value = "/getbytype", method = RequestMethod.GET)
    @ApiOperation("根据商品类型查询商品信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "goodsType", required = true, value = "商品类型", dataType = "Integer")
    })
    public List<GoodsVO> getGoodsByGoodsCode(Integer goodsType) {
        return goodsService.getGoodsByGoodsType(goodsType);
    }

    @RequestMapping(value = "/addgoods", method = RequestMethod.POST)
    @ApiOperation("新增商品信息")
    public BizResult<Integer> addGoods(@RequestBody GoodsVO goodsInfo) {
        return goodsService.addGoods(goodsInfo);
    }

}
