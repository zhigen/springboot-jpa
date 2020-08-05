package com.zglu.jpa.db0.user.service;

import com.zglu.jpa.db0.user.dao.User;
import com.zglu.jpa.db0.user.dao.UserDao;
import com.zglu.jpa.db0.user.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zglu
 */
@Service
@AllArgsConstructor
public class UserService {
    private final UserDao dao;

    public User add(User t) {
        return dao.add(t);
    }

    public User set(User t) {
        return dao.set(t);
    }

    public void remove(long id) {
        dao.remove(id);
    }

    public List<User> get() {
        return dao.get();
    }

    public User get(long id) {
        return dao.get(id);
    }

    public Page<User> page(Integer page, Integer size) {
        return dao.page(page, size);
    }

    public Object hql() {
        return dao.hql();
    }

    public Object sql() {
        return dao.sql();
    }

    public List<User> repo() {
        return dao.repo();
    }

    public List<User> repoHql() {
        return dao.repoHql();
    }

    public List<User> repoSql() {
        return dao.repoSql();
    }

    public List<UserDto> hqlTo() {
        return dao.hqlTo();
    }

    public List<UserDto> hqlJoinTo() {
        return dao.hqlJoinTo();
    }

    public List<Map<String, Object>> sqlTo() {
        return dao.sqlTo();
    }

    public List<Map<String, Object>> sqlJoinTo(Integer page, Integer size) {
        return dao.sqlJoinTo(page, size);
    }

}
