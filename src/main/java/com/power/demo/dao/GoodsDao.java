package com.power.demo.dao;

import org.apache.ibatis.annotations.Param;
import com.power.demo.domain.GoodsDO;

import java.util.List;

/**
 * 商品DAO接口
 * <p>
 * Created by JeffWong.
 */
public interface GoodsDao {

    /**
     * 根据商品Id查询商品信息
     *
     * @param goodsId 商品Id
     */
    GoodsDO findGoodsByGoodsId(@Param("goodsId") String goodsId);

    /**
     * 根据商品编码查询商品信息
     *
     * @param goodsCode 商品编码
     */
    GoodsDO findGoodsByGoodsCode(@Param("goodsCode") String goodsCode);

    /**
     * 根据商品类型查询商品信息列表
     *
     * @param goodsType 商品类型
     */
    List<GoodsDO> findGoodsByGoodsType(@Param("goodsType") int goodsType);

    /**
     * 根据商品类型查询商品信息列表
     */
    List<GoodsDO> findAllGoods();

    /**
     * 插入
     *
     * @param ent 商品
     */
    int insertGoods(GoodsDO ent);

    /**
     * 更新
     *
     * @param ent 商品
     */
    int updateGoods(GoodsDO ent);

    /**
     * 删除
     */
    int deleteGoods(String goodsId);
}
