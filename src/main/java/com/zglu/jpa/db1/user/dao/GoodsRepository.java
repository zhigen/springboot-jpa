package com.zglu.jpa.db1.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zglu
 */
@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {

}
