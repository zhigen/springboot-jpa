package com.zglu.jpa.db0.user.dao;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.zglu.jpa.db0.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * @author zglu
 */
@Component
public class UserDao {
    @Autowired
    private UserRepository repository;
    @PersistenceContext
    private EntityManager entityManager;

    public User add(User t) {
        t.setId(null);
        return repository.save(t);
    }

    public User set(User n) {
        User o = repository.findById(n.getId()).orElse(null);
        if (o != null) {
            BeanUtil.copyProperties(n, o, CopyOptions.create().setIgnoreNullValue(true));
            return repository.save(o);
        }
        return null;
    }

    public void remove(long id) {
        User t = new User();
        t.setId(id);
        repository.delete(t);
    }

    public List<User> get() {
        return repository.findAll();
    }

    public User get(long id) {
        return repository.findById(id).orElse(null);
    }

    public Page<User> page(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    public Object hql() {
        String hql = "select u from User u";
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    public Object sql() {
        String sql = "select * from zglu0.user";
        Query query = entityManager.createNativeQuery(sql, User.class);
        return query.getResultList();
    }

    public List<User> repo() {
        return repository.findBy();
    }

    public List<User> repoHql() {
        return repository.hql();
    }

    public List<User> repoSql() {
        return repository.sql();
    }

    public List<UserDto> hqlTo() {
        return repository.hqlTo();
    }

    public List<UserDto> hqlJoinTo() {
        return repository.hqlJoinTo();
    }

    public List<Map<String, Object>> sqlTo() {
        return repository.sqlTo();
    }

    public List<Map<String, Object>> sqlJoinTo(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.sqlJoinTo(pageable);
    }

}
