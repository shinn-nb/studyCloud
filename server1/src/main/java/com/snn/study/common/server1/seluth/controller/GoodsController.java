package com.snn.study.common.server1.seluth.controller;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: shinn
 * @Date: 2022/2/24 下午6:08 （日期和时间）
 */
@RestController
@RequestMapping("/goods")
@Logger
public class GoodsController {
    private final RestTemplate restTemplate;

    public GoodsController(final RestTemplate restTemplate) {this.restTemplate = restTemplate;}

    @GetMapping
    public ResponseEntity<String> read(){
        String stock = restTemplate.getForEntity("http://localhost:8082/stock", String.class).getBody();

        return ResponseEntity.ok("好看："+stock);
    }
}
