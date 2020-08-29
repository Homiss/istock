package com.daydream.istock.domain;

import com.alibaba.fastjson.JSONArray;
import com.daydream.istock.domain.enums.StockType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 股票信息
 * @author homiss
 **/
@Entity
@Table(name = "stock_code_info")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockCodeInfo implements Serializable {

    /**
     * 股票代码
     */
    @Id
    @Column(name = "symbol", nullable = false, length = 16)
    private String symbol;

    /**
     * 深市  沪市
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 4)
    private StockType type;

    /**
     * 股票名称
     */
    @Column(name = "name", nullable = false, length = 32)
    private String name;

    /**
     * 所在地域
     */
    @Column(name = "area", nullable = false, length = 32)
    private String area;

    /**
     * 所属行业
     */
    @Column(name = "industry", nullable = false, length = 32)
    private String industry;

    /**
     * 股票全称
     */
    @Column(name = "full_name", nullable = false, length = 32)
    private String fullName;

    /**
     * 市场类型（主板/中小板/创业板）
     */
    @Column(name = "market", nullable = false, length = 32)
    private String market;

    /**
     * 上市状态L上市 D退市 P暂停上市
     */
    @Column(name = "listing_status", nullable = false, length = 4)
    private String listingStatus;

    /**
     * 上市日期
     */
    @Column(name = "listing_date", nullable = false, length = 32)
    private String listingDate;

    /**
     * data 来源于 tushareSpilder
     */
    public static StockCodeInfo of(JSONArray data){
        if(data == null){
            return null;
        }
        return StockCodeInfo.builder()
            .symbol(data.getString(1))
            .type(StockType.byName(data.getString(0).replaceAll("\\d+\\.","")))
            .name(data.getString(2))
            .area(data.getString(3))
            .industry(data.getString(4))
            .fullName(data.getString(5))
            .market(data.getString(6))
            .listingStatus(data.getString(7))
            .listingDate(data.getString(8))
            .build();
        
    }

}
