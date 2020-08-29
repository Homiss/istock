package com.daydream.istock.domain.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Homiss
 * @date 2020/8/8 下午3:30
 */

public enum StockType {
    SH,SZ;


    private static final Map<String, StockType> KEY_MAP = new HashMap<>();

    static {
        for (StockType t : StockType.values()) {
            KEY_MAP.put(t.name(), t);
        }
    }

    public static StockType byName(String key) {
        return KEY_MAP.get(key.toUpperCase());
    }
}
