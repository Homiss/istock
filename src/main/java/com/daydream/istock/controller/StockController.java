package com.daydream.istock.controller;

import com.alibaba.fastjson.JSONArray;
import com.daydream.istock.domain.StockCodeInfo;
import com.daydream.istock.service.StockCodeInfoService;
import com.daydream.istock.spider.openapi.TushareApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Homiss
 * @date 2020/8/28 下午10:15
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private TushareApi tushareApi;
    @Autowired
    private StockCodeInfoService stockCodeInfoService;

    @GetMapping("/refreshCode")
    public void refreshCode(){
        List<StockCodeInfo> stockCodeInfos = new ArrayList<StockCodeInfo>();
        JSONArray rows = tushareApi.getStockCodeList();
        for (int i = 0; i < rows.size(); i++) {
            stockCodeInfos.add(StockCodeInfo.of(rows.getJSONArray(i)));
        }
        stockCodeInfoService.saveAll(stockCodeInfos);
    }
}


