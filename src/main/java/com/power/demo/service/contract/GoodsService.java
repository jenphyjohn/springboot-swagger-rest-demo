package com.power.demo.service.contract;

import com.power.demo.common.BizResult;
import com.power.demo.entity.vo.GoodsVO;

import java.util.List;
import java.util.Map;

/**
 * 货品服务接口
 * <p>
 * Created by JeffWong.
 */
public interface GoodsService {

    /**
     * 根据商品Id查询商品信息
     *
     * @param goodsId 商品Id
     */
    GoodsVO getGoodsByGoodsId(String goodsId);

    /**
     * 根据商品编码查询商品信息
     *
     * @param goodsCode 商品编码
     */
    GoodsVO getGoodsByGoodsCode(String goodsCode);

    /**
     * 根据商品类型查询商品信息列表
     *
     * @param goodsType 商品类型
     */
    List<GoodsVO> getGoodsByGoodsType(int goodsType);

    /**
     * 根据商品类型查询商品信息字典
     *
     * @param goodsType 商品类型
     */
    Map<String, GoodsVO> getGoodsMapByGoodsType(int goodsType);

    /**
     * 根据商品类型查询商品信息列表
     */
    List<GoodsVO> getAllGoods();

    /**
     * 根据商品名称查询商品信息
     */
    GoodsVO getGoodsByGoodsName(String goodsName);

    /**
     * 插入
     *
     * @param ent 商品
     */
    BizResult<Integer> addGoods(GoodsVO ent);

    /**
     * 更新
     *
     * @param ent 商品
     */
    BizResult<Integer> modifyGoods(GoodsVO ent);

    /**
     * 删除
     */
    BizResult<Integer> removeGoods(String goodsId);
}
