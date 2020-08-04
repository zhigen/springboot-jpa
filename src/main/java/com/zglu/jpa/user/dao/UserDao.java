package com.zglu.jpa.user.dao;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.zglu.jpa.utils.ReplaceUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

/**
 * @author zglu
 */
@Component
@AllArgsConstructor
public class UserDao {
    private final UserRepository repository;
    @PersistenceContext
    private final EntityManager entityManager;

    public User add(User user) {
        user.setId(null);
        return repository.save(user);
    }

    public User set(User user) {
        User old = repository.getOne(user.getId());
        old.setName(user.getName());
        return repository.save(old);
    }

    public void remove(long id) {
        repository.deleteById(id);
    }

    public List<User> get() {
        return repository.findAll();
    }

    public User get(long id) {
        return repository.getOne(id);
    }

    public Page<User> page(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    public List<User> findAll(String q, String order, Integer offset, Integer limit) {
        String searchSql = "SELECT * FROM zglu.user ";
        if (StringUtils.hasText(q)) {
            searchSql += "WHERE " + ReplaceUtils.getColumnName(q);
        }
        if (StringUtils.hasText(order)) {
            searchSql += " ORDER BY " + ReplaceUtils.getColumnName(order);
        }
        if (offset != null && limit != null) {
            searchSql += " LIMIT " + limit + " OFFSET " + offset;
        }
        Query query = entityManager.createNativeQuery(searchSql, User.class);
        return query.getResultList();
    }

    public long count(String q) {
        String searchSql = "SELECT COUNT(id) FROM zglu.user ";
        if (StringUtils.hasText(q)) {
            searchSql += "WHERE " + ReplaceUtils.getColumnName(q);
        }
        Query query = entityManager.createNativeQuery(searchSql);
        BigInteger count = (BigInteger) query.getSingleResult();
        return count.longValue();
    }

}
