package com.zglu.jpa.db1.goods.dto;

import com.zglu.jpa.db1.goods.dao.Goods;
import lombok.Data;

/**
 * @author zglu
 */
@Data
public class GoodsDto {
    private Long id;
    private String name;

    public Goods toEntity() {
        Goods t = new Goods();
        t.setId(id);
        t.setName(name);
        return t;
    }

}
