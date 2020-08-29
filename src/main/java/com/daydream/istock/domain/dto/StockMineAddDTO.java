package com.daydream.istock.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Homiss
 * @date 2020/8/28 下午9:36
 */
@Data
@Builder
public class StockMineAddDTO {

    private String symbol;

    private BigDecimal cost;
}
