package com.daydream.istock.service;

import com.daydream.istock.domain.StockCodeInfo;

import java.util.List;

/**
 * @author Homiss
 * @date 2020/8/28 下午10:32
 */
public interface StockCodeInfoService {
    void saveAll(List<StockCodeInfo> stockCodeInfos);

    String findNameBySymbol(String symbol);
}
