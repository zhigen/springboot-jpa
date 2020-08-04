package com.zglu.jpa.user.controller;

import com.zglu.jpa.user.dao.User;
import com.zglu.jpa.user.dto.UserDto;
import com.zglu.jpa.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zglu
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    @ApiOperation("增")
    public User add(@RequestBody UserDto userDto) {
        return userService.add(User.valueOf(userDto));
    }

    @PatchMapping
    @ApiOperation("改，忽略空属性")
    public User set(@RequestBody UserDto userDto) {
        return userService.set(User.valueOf(userDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删")
    public void remove(@PathVariable long id) {
        userService.remove(id);
    }

    @GetMapping("/{id}")
    @ApiOperation("查")
    public User get(@PathVariable long id) {
        return userService.get(id);
    }

    @GetMapping("/user")
    @ApiOperation("查")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "q", value = "搜索，语法与SQL一致，除属性驼峰外全小写", defaultValue = "id >= 2 and id<=10"),
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "order", value = "排序，语法与SQL一致，除属性驼峰外全小写", defaultValue = "name asc, id desc"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "offset", value = "偏移量", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "limit", value = "行数", defaultValue = "10"),
    })
    public List<User> list(String q, String order, Integer offset, Integer limit) {
        return userService.list(q, order, offset, limit);
    }

    @GetMapping("/user/page")
    @ApiOperation("查分页")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "q", value = "搜索，语法与SQL一致，除属性驼峰外全小写", defaultValue = "id >= 2 and id<=10"),
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "order", value = "排序，语法与SQL一致，除属性驼峰外全小写", defaultValue = "name asc, id desc"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "number", value = "页号", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "size", value = "行数", defaultValue = "10"),
    })
    public Page<User> page(String q, String order, Integer number, Integer size) {
        return userService.page(q, order, number, size);
    }
}
