package com.power.demo.service.impl;

import com.power.demo.entity.vo.GoodsVO;
import com.power.demo.service.contract.GoodsService;
import com.power.demo.util.DateTimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.*;

/**
 * Created by JeffWong.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsServiceImplTest {

    @Autowired
    private GoodsService goodsService;

    @Test
    public void testGetGoodsByGoodsId() throws Exception {

        String goodsId = "61AEF3E4-0FE2-446C-B01D-931B5C2E5D2B";

        GoodsVO ent = goodsService.getGoodsByGoodsId(goodsId);

        Assert.notNull(ent, "商品不为空");

    }

    @Test
    public void testGetGoodsByGoodsCode() throws Exception {
        String goodsCode = "1002469";

        GoodsVO ent = goodsService.getGoodsByGoodsCode(goodsCode);

        Assert.notNull(ent, "商品不为空");
    }

    @Test
    public void testGetGoodsByGoodsType() throws Exception {

        Integer goodsType = 3;

        List<GoodsVO> entList = goodsService.getGoodsByGoodsType(goodsType);

        Assert.notEmpty(entList, "商品列表不为空");
    }

    @Test
    public void testGetGoodsMapByGoodsType() throws Exception {

        Integer goodsType = 3;

        Map<String, GoodsVO> map = goodsService.getGoodsMapByGoodsType(goodsType);

        Assert.notEmpty(map, "商品字典不为空");
    }

    @Test
    public void testGetAllGoods() throws Exception {

        List<GoodsVO> entList = goodsService.getAllGoods();

        Assert.notEmpty(entList, "商品列表不为空");

        System.out.println(entList);
    }

    @Test
    public void testGetGoodsByGoodsName() throws Exception {

        String goodsName = "澳洲和牛厚切眼肉牛排（M6-M8）250g";
        GoodsVO ent = goodsService.getGoodsByGoodsName(goodsName);

        Assert.notNull(ent, "商品列表不为空");
    }

    @Test
    public void testGoodsCUD() throws Exception {

        GoodsVO ent = new GoodsVO();

        int affectNum = -1;

        for (int i = 0; i < 10; i++) {

            Thread.sleep(50);

            Random rdm = new Random();

            ent.setGoodsId(UUID.randomUUID().toString());
            ent.setGoodsType(1024);
            ent.setGoodsName("测试商品_" + DateTimeUtil.fmtDate(new Date()));
            ent.setCreateTime(new Date());
            ent.setGoodsCode("g_" + DateTimeUtil.fmtDate(new Date()) + String.valueOf(rdm.nextInt(3)));
            ent.setDisabled(0);

            affectNum = goodsService.addGoods(ent).getReturnObject();
            Assert.isTrue(affectNum == 1, "新增成功");

        }

        ent.setDisabled(1);
        affectNum = goodsService.modifyGoods(ent).getReturnObject();
        Assert.isTrue(affectNum == 1, "修改成功");

        affectNum = goodsService.removeGoods(ent.getGoodsId()).getReturnObject();
        Assert.isTrue(affectNum == 1, "删除成功");
    }

}