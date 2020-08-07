package com.zglu.jpa.db1.goods.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zglu
 */
@Component
public class GoodsDao {
    @Autowired
    private GoodsRepository repository;

    public Goods add(Goods t) {
        t.setId(null);
        return repository.save(t);
    }

    public List<Goods> get() {
        return repository.findAll();
    }

}
