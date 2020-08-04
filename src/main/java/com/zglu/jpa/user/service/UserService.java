package com.zglu.jpa.user.service;

import com.zglu.jpa.user.dao.User;
import com.zglu.jpa.user.dao.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zglu
 */
@Service
@AllArgsConstructor
public class UserService {
    private final UserDao userDao;

    public User add(User user) {
        return userDao.add(user);
    }

    public User set(User user) {
        return userDao.set(user);
    }

    public void remove(long id) {
        userDao.remove(id);
    }

    public List<User> get() {
        return userDao.get();
    }

    public User get(long id) {
        return userDao.get(id);
    }

    public List<User> list(String q, String order, Integer offset, Integer limit) {
        return userDao.findAll(q, order, offset, limit);
    }

    public Page<User> page(String q, String order, Integer number, Integer size) {
        List<User> content = userDao.findAll(q, order, number * size, size);
        Pageable pageable = PageRequest.of(number, size);
        long total = userDao.count(q);
        return new PageImpl<>(content, pageable, total);
    }

}
