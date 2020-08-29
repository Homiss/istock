package com.daydream.istock.service.impl;

import com.daydream.istock.domain.StockCodeInfo;
import com.daydream.istock.repository.StockCodeInfoRepository;
import com.daydream.istock.service.StockCodeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Homiss
 * @date 2020/8/28 下午10:32
 */
@Service
public class StockCodeInfoServiceImpl implements StockCodeInfoService {

    @Autowired
    private StockCodeInfoRepository stockCodeInfoRepository;


    @Override
    @Transactional
    public void saveAll(List<StockCodeInfo> stockCodeInfos) {
        stockCodeInfoRepository.saveAll(stockCodeInfos);
    }

    @Override
    public String findNameBySymbol(String symbol) {
        return stockCodeInfoRepository.findNameBySymbol(symbol);
    }


}
