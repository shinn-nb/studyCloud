package com.snn.study.common.server2.seluth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @Author: shinn
 * @Date: 2022/2/24 下午6:08 （日期和时间）
 */
@RestController
@RequestMapping("/stock")
public class StockController {
    @GetMapping
    public ResponseEntity<String> read(){
//        throw new RuntimeException("aaa");
        return ResponseEntity.ok("库存为："+(new Random()).nextInt(4));
    }
}
