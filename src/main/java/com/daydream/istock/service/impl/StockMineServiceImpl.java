package com.daydream.istock.service.impl;

import com.daydream.istock.domain.StockMine;
import com.daydream.istock.repository.StockMineRepository;
import com.daydream.istock.service.StockMineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Homiss
 * @date 2020/8/28 下午9:24
 */
@Service
public class StockMineServiceImpl implements StockMineService {

    @Autowired
    private StockMineRepository stockMineRepository;

    @Override
    public List<StockMine> list() {
        return stockMineRepository.findAll();
    }

    @Override
    @Transactional
    public void add(String name, String symbol, BigDecimal cost) {
        StockMine stockMine = stockMineRepository.findBySymbol(symbol);
        if(stockMine == null){
            stockMine = StockMine.builder()
                    .name(name)
                    .symbol(symbol)
                    .cost(cost)
                    .build();
        } else {
            stockMine.setCost(cost);
        }
        stockMineRepository.save(stockMine);
    }
}
