package com.zglu.jpa.user.dao;

import com.zglu.jpa.ReplaceUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zglu
 */
@Component
@AllArgsConstructor
public class UserDao {
    private final UserRepository userRepository;
    @PersistenceContext
    private final EntityManager entityManager;

    public User save(User user) {
        boolean flag = user.getId() == null || user.getId() == 0L || !userRepository.existsById(user.getId());
        Assert.isTrue(flag, "Duplicate key!");
        user.setCreatedDate(LocalDateTime.now());
        user.setLastModifiedDate(LocalDateTime.now());
        user.setEnable(true);
        return userRepository.save(user);
    }

    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
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

    public User put(User user) {
        Assert.notNull(user.getId(), "id must not be null!");
        Assert.isTrue(user.getId() != 0L, "id must not be zero!");
        return userRepository.save(user);
    }

    public User update(User user) {
        user.setLastModifiedDate(LocalDateTime.now());
        userRepository.update(user);
        return user;
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

}
