package com.zglu.jpa;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author zglu
 */
@RestController
@AllArgsConstructor
public class TestController {

    private final RoleRepo roleRepo;

    @PostMapping("/role")
    @ApiOperation("增")
    public Role add(@RequestBody Role role) {
        return roleRepo.save(role);
    }

    @GetMapping("/role/{id}")
    @ApiOperation("查")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "id", required = true),
    })
    public Role get(@PathVariable long id) {
        return roleRepo.findById(id).orElse(null);
    }

    @GetMapping("/role")
    @ApiOperation("查分页")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "orderBy", value = "排序：[字段,升降序;...]", defaultValue = "name,asc;id,desc"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "page", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "size", value = "行数", defaultValue = "3"),
    })
    public Page<Role> get(String orderBy, Integer page, Integer size) {
        Sort sort = Sort.unsorted();
        if (StringUtils.hasText(orderBy)) {
            List<Sort.Order> orderList = new ArrayList<>();
            Stream.of(orderBy.split(";")).forEach(m -> {
                if (StringUtils.hasText(m)) {
                    Sort.Order order = new Sort.Order(Sort.Direction.fromString(m.split(",")[1]), m.split(",")[0]);
                    orderList.add(order);
                }
            });
            sort = Sort.by(orderList);
        }
        PageRequest pageable = PageRequest.of(page, size, sort);
        return roleRepo.findAll(pageable);
    }

    @PutMapping("/role")
    @ApiOperation("覆盖改")
    public Role put(@RequestBody Role role) {
        return roleRepo.save(role);
    }

    @PatchMapping("/role")
    @ApiOperation("改")
    public Role set(@RequestBody RoleVo roleVo) {
        Role role = new Role();
        BeanUtils.copyProperties();
        BeanUtils.copyProperties(roleVo, role);
        return roleRepo.save(role);
    }

    @DeleteMapping("/role/{id}")
    @ApiOperation("删")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "id", required = true),
    })
    public void del(@PathVariable long id) {
        roleRepo.deleteById(id);
    }

}
