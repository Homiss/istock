package com.daydream.istock.controller;

import com.daydream.istock.domain.StockMine;
import com.daydream.istock.domain.base.Result;
import com.daydream.istock.domain.base.ResultResponse;
import com.daydream.istock.domain.dto.StockMineAddDTO;
import com.daydream.istock.service.StockCodeInfoService;
import com.daydream.istock.service.StockMineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Homiss
 * @date 2020/8/28 下午9:26
 */
@RequestMapping("/stockMine")
@RestController
public class StockMineController {

    @Autowired
    private StockMineService stockMineService;
    @Autowired
    private StockCodeInfoService stockCodeInfoService;

    @GetMapping(value = "/list")
    @ResponseBody
    public Result getAllUser () {
        List<StockMine> allStocks = stockMineService.list();
        return ResultResponse.getSuccessResult(allStocks);
    }

    @PostMapping("/add")
    public Result add(@RequestBody StockMineAddDTO addDTO){
        String name = stockCodeInfoService.findNameBySymbol(addDTO.getSymbol());
        stockMineService.add(name, addDTO.getSymbol(), addDTO.getCost());
        return ResultResponse.getSuccessResult();
    }



}
