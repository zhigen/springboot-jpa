package com.zglu.jpa.db1.goods.service;

import com.zglu.jpa.db1.goods.dao.Goods;
import com.zglu.jpa.db1.goods.dao.GoodsDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zglu
 */
@Service
@AllArgsConstructor
public class GoodsService {
    private final GoodsDao dao;

    public Goods add(Goods t) {
        return dao.add(t);
    }

    public List<Goods> get() {
        return dao.get();
    }

}
