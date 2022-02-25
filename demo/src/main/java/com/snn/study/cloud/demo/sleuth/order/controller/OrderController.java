package com.snn.study.cloud.demo.sleuth.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: shinn
 * @Date: 2022/2/24 下午5:56 （日期和时间）
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    private final RestTemplate restTemplate;

    public OrderController(final RestTemplate restTemplate) {this.restTemplate = restTemplate;}

    @GetMapping
    public ResponseEntity<String> read() {
        log.warn("error");
        String goods = restTemplate.getForEntity("http://localhost:8081/goods", String.class).getBody();

        return ResponseEntity.ok("success:" + goods + ":" );
    }
}
