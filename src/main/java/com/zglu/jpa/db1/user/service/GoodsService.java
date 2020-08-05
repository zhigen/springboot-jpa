package com.zglu.jpa.db1.user.service;

import com.zglu.jpa.db1.user.dao.Goods;
import com.zglu.jpa.db1.user.dao.GoodsDao;
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
