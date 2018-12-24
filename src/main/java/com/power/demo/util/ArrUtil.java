package com.power.demo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JeffWong.
 */
public class ArrUtil {

    /**
     * 拆分列表
     *
     * @param datas
     * @param recordCount
     * @return
     */
    public static <T> List<List<T>> spliceArrays(List<T> datas, int recordCount) {
        if (datas == null || recordCount < 1) {
            return null;
        }
        int totalCount = datas.size();
        //获取要拆分子数组个数
        int count = totalCount / recordCount;
        int groupCnt = totalCount % recordCount;
        if (groupCnt != 0) {
            count = totalCount / recordCount + 1;
        }

        System.out.println("split total group count = " + count);

        List<List<T>> rows = new ArrayList<List<T>>();
        for (int i = 0; i < count; i++) {

            int index = i * recordCount;
            List<T> cols = new ArrayList<T>();
            int j = 0;
            while (j < recordCount && index < totalCount) {
                cols.add(datas.get(index++));
                j++;
            }
            rows.add(cols);
        }
        return rows;
    }
}
