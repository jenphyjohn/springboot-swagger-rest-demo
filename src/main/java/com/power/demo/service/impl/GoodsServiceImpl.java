package com.power.demo.service.impl;

import com.power.demo.common.AppConst;
import com.power.demo.common.BizResult;
import com.power.demo.common.GoodsType;
import com.power.demo.dao.GoodsDao;
import com.power.demo.domain.GoodsDO;
import com.power.demo.entity.vo.GoodsVO;
import com.power.demo.service.contract.GoodsService;
import com.power.demo.util.FastMapperUtil;
import com.power.demo.util.PowerLogger;
import com.power.demo.util.ValidateUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 商品服务业务逻辑实现类
 * <p>
 * Created by JeffWong.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    /**
     * 根据商品Id查询商品信息
     *
     * @param goodsId 商品Id
     */
    public GoodsVO getGoodsByGoodsId(String goodsId) {

        if (StringUtils.isEmpty(goodsId)) {
            return null;
        }

//        if (ValidateUtil.isGuid(goodsId) == false) {
//            //throw new Exception("非法的商品ID");
//            return null;
//        }


        GoodsDO dbEnt = goodsDao.findGoodsByGoodsId(goodsId);

        GoodsVO ent = SetEntity(dbEnt);

        return ent;
    }

    /**
     * 根据商品编码查询商品信息
     *
     * @param goodsCode 商品编码
     */
    public GoodsVO getGoodsByGoodsCode(String goodsCode) {
        if (StringUtils.isEmpty(goodsCode)) {
            return null;
        }

        GoodsDO dbEnt = goodsDao.findGoodsByGoodsCode(goodsCode);

        GoodsVO ent = SetEntity(dbEnt);

        return ent;
    }

    /**
     * 根据商品类型查询商品信息列表
     *
     * @param goodsType 商品类型
     */
    public List<GoodsVO> getGoodsByGoodsType(int goodsType) {

        List<GoodsVO> list = new ArrayList<GoodsVO>();
        if (goodsType < 0) {
            return list;
        }

        List<GoodsDO> dbEntList = goodsDao.findGoodsByGoodsType(goodsType);

//        for (GoodsDO dbEnt : dbEntList) {
//            if (StringUtils.isEmpty(dbEnt.getGoodsCode()) == true) {
//                continue;
//            }
//            GoodsVO ent = SetEntity(dbEnt);
//            list.add(ent);
//        }

        dbEntList.stream().filter(x -> StringUtils.isEmpty(x.getGoodsCode()) == false)
                .forEach(x -> {
                    GoodsVO ent = SetEntity(x);
                    list.add(ent);
                });

        //按照Code逆序排列
        Collections.sort(list, (x, y) -> y.getGoodsCode().compareTo(x.getGoodsCode()));

        return list;
    }

    /**
     * 根据商品类型查询商品信息字典
     *
     * @param goodsType 商品类型
     */
    public Map<String, GoodsVO> getGoodsMapByGoodsType(int goodsType) {

        Map<String, GoodsVO> map = new HashMap<>();
        if (goodsType < 0) {
            return map;
        }

        List<GoodsVO> list = getGoodsByGoodsType(goodsType);

        map = list.stream()
                .distinct()
                .collect(Collectors.toMap(GoodsVO::getGoodsId, x -> x));

        return map;
    }

    public List<GoodsVO> getAllGoods() {

        List<GoodsVO> list = new ArrayList<GoodsVO>();
        List<GoodsDO> dbEntList = goodsDao.findAllGoods();

        dbEntList.stream().filter(x -> StringUtils.isEmpty(x.getGoodsCode()) == false)
                .forEach(x -> {
                    GoodsVO ent = SetEntity(x);
                    list.add(ent);
                });

        //按照Code顺序排列
        Collections.sort(list, (x, y) -> x.getGoodsCode().compareTo(y.getGoodsCode()));

        return list;
    }

    /**
     * 根据商品名称查询商品信息
     */
    public GoodsVO getGoodsByGoodsName(String goodsName) {
        GoodsVO ent = null;
        if (StringUtils.isEmpty(goodsName) == true) {
            return ent;
        }
        List<GoodsVO> goodsVOs = getAllGoods();
        Optional<GoodsVO> objEnt = goodsVOs.stream()
                .filter(x -> x.getDisabled() == 0)
                .filter(x -> goodsName.equals(x.getGoodsName()))
                .findFirst();

        if (objEnt.isPresent() == true) {
            ent = objEnt.get();
        }

        return ent;
    }

    /**
     * 插入
     *
     * @param ent 商品
     */
    public BizResult<Integer> addGoods(GoodsVO ent) {

        BizResult<Integer> resultInfo = new BizResult<Integer>(true, AppConst.Success);
        if (ent == null) {
            resultInfo.setFail("请求实体为空");
            return resultInfo;
        }

        GoodsVO existEnt = getGoodsByGoodsId(ent.getGoodsId());
        if (existEnt != null) {
            resultInfo.setFail("已存在相同编号的商品");
            return resultInfo;
        }

        //验证商品类型
        boolean isGoodsTypeOK = false;
        for (GoodsType item : GoodsType.values()) {
            if (item.getCode() == ent.getGoodsType()) {
                isGoodsTypeOK = true;
                break;
            }
        }
        if (isGoodsTypeOK == false) {
            resultInfo.setFail("商品类型不合法");
            return resultInfo;
        }

        //其他判重及参数验证 略

        GoodsDO dbEnt = new GoodsDO();
        FastMapperUtil.setFieldValue(dbEnt, ent);

        int affectNum = goodsDao.insertGoods(dbEnt);
        resultInfo.setReturnObject(affectNum);
        resultInfo.setSuccess("新增商品成功");

        PowerLogger.info(resultInfo.getMessage());

        return resultInfo;
    }

    /**
     * 更新
     *
     * @param ent 商品
     */
    public BizResult<Integer> modifyGoods(GoodsVO ent) {
        BizResult<Integer> resultInfo = new BizResult<Integer>(true, AppConst.Success);

        if (ent == null) {
            resultInfo.setFail("请求实体为空");
            return resultInfo;
        }

        //判重及参数验证 略

        GoodsDO dbEnt = new GoodsDO();
        FastMapperUtil.setFieldValue(dbEnt, ent);

        int affectNum = goodsDao.updateGoods(dbEnt);
        resultInfo.setReturnObject(affectNum);
        resultInfo.setSuccess("修改商品成功");

        return resultInfo;
    }

    /**
     * 删除
     */
    public BizResult<Integer> removeGoods(String goodsId) {
        BizResult<Integer> resultInfo = new BizResult<Integer>(true, AppConst.Success);

        if (StringUtils.isEmpty(goodsId) == true) {
            resultInfo.setFail("商品编号为空");
            return resultInfo;
        }

        int affectNum = goodsDao.deleteGoods(goodsId);
        resultInfo.setReturnObject(affectNum);
        resultInfo.setSuccess("删除商品成功");

        return resultInfo;
    }

    /**
     * 构造返回商品信息实体
     *
     * @param dbEnt 商品信息
     */
    private GoodsVO SetEntity(GoodsDO dbEnt) {
        if (dbEnt == null) {
            return null;
        }
        GoodsVO ent = new GoodsVO();
        FastMapperUtil.setFieldValue(ent, dbEnt);

        DateTime time = new DateTime(dbEnt.getCreateTime());
        ent.setCreateDate(time);

        ent.setStrCreateTime(time.toString("yyyy-MM-dd HH:mm:ss"));
        return ent;
    }

}
