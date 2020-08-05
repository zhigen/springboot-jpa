package com.zglu.jpa.db0.user.controller;

import com.zglu.jpa.db0.user.dto.UserDto;
import com.zglu.jpa.db0.user.service.UserService;
import com.zglu.jpa.db0.user.dao.User;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zglu
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    @ApiOperation("增")
    public User add(@RequestBody UserDto dto) {
        return service.add(dto.toEntity());
    }

    @PatchMapping
    @ApiOperation("改，忽略空属性")
    public User set(@RequestBody UserDto dto) {
        return service.set(dto.toEntity());
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删")
    public void remove(@PathVariable long id) {
        service.remove(id);
    }

    @GetMapping
    @ApiOperation("查")
    public List<User> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    @ApiOperation("查")
    public User get(@PathVariable long id) {
        return service.get(id);
    }

    @GetMapping("/page")
    @ApiOperation("查分页")
    public Page<User> page(@RequestParam Integer page, @RequestParam Integer size) {
        return service.page(page, size);
    }

    @GetMapping("/hql")
    @ApiOperation("hql")
    public Object time() {
        return service.hql();
    }

    @GetMapping("/sql")
    @ApiOperation("sql")
    public Object sql() {
        return service.sql();
    }

    @GetMapping("/repo")
    @ApiOperation("repo")
    public List<User> repo() {
        return service.repo();
    }

    @GetMapping("/repo-hql")
    @ApiOperation("repoHql")
    public List<User> repoHql() {
        return service.repoHql();
    }

    @GetMapping("/repo-sql")
    @ApiOperation("repoSql")
    public List<User> repoSql() {
        return service.repoSql();
    }

    @GetMapping("/hql-to")
    @ApiOperation("hqlTo")
    public List<UserDto> hqlTo() {
        return service.hqlTo();
    }

    @GetMapping("/hql-join-to")
    @ApiOperation("hqlJoinTo")
    public List<UserDto> hqlJoinTo() {
        return service.hqlJoinTo();
    }

    @GetMapping("/sql-to")
    @ApiOperation("sqlTo")
    public List<Map<String, Object>> sqlTo() {
        return service.sqlTo();
    }

    @GetMapping("/sql-join-to")
    @ApiOperation("sqlJoinTo")
    public List<Map<String, Object>> sqlJoinTo(@RequestParam Integer page, @RequestParam Integer size) {
        return service.sqlJoinTo(page, size);
    }

}
