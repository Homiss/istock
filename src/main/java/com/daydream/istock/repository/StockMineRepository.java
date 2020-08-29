package com.daydream.istock.repository;

import com.daydream.istock.domain.StockMine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Homiss
 * @date 2020/8/28 下午9:22
 */
public interface StockMineRepository extends JpaRepository<StockMine, String> {

    @Query("select s from StockMine s where s.symbol = ?1")
    StockMine findBySymbol(String symbol);
}
