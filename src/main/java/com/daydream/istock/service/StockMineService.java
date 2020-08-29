package com.daydream.istock.service;

import com.daydream.istock.domain.StockMine;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Homiss
 * @date 2020/8/28 下午9:24
 */
public interface StockMineService {
    List<StockMine> list();

    void add(String name, String symbol, BigDecimal cost);
}
