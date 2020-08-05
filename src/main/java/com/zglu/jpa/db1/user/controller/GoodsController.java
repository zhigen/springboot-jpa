package com.zglu.jpa.db1.user.controller;

import com.zglu.jpa.db1.user.dao.Goods;
import com.zglu.jpa.db1.user.dto.GoodsDto;
import com.zglu.jpa.db1.user.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zglu
 */
@RestController
@RequestMapping("/goods")
@AllArgsConstructor
public class GoodsController {
    private final GoodsService service;

    @PostMapping
    @ApiOperation("增")
    public Goods add(@RequestBody GoodsDto dto) {
        return service.add(dto.toEntity());
    }

    @GetMapping
    @ApiOperation("查")
    public List<Goods> get() {
        return service.get();
    }

}
