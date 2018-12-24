package com.power.demo.util;

import com.power.demo.common.GoodsType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;


/**
 * Created by JeffWong.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonTests {


    @Test
    public void testGoodsTypeEnum() throws Exception {

        GoodsType goodsType = GoodsType.Discount;

        System.out.println(GoodsType.Normal.ordinal());//0
        System.out.println(GoodsType.Discount.ordinal());//1

        System.out.println(goodsType.getCode());
        System.out.println(goodsType.getDescription());

        Assert.isTrue(goodsType.getCode() == 1024, "折扣商品Code为1024");


    }
}