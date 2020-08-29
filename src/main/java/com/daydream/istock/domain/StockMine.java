package com.daydream.istock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author housizhou
 */
@Entity
@Table(name = "stock_mine")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockMine implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, length = 32)
    private String id;

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Column(name = "symbol", nullable = false, length = 16)
    private String symbol;

    @Column(name = "cost", nullable = false, precision = 15, scale = 2)
    private BigDecimal cost;

}