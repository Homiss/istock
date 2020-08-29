package com.daydream.istock.repository;

import com.daydream.istock.domain.StockCodeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Homiss
 * @date 2020/8/28 下午10:32
 */
public interface StockCodeInfoRepository extends JpaRepository<StockCodeInfo, String> {

    @Query("select s.name from StockCodeInfo s where s.symbol = ?1")
    String findNameBySymbol(String symbol);
}
