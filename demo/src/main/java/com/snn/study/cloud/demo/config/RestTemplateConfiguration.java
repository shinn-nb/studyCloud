package com.snn.study.cloud.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shinn
 * @Date: 2021/11/10 下午6:09 （日期和时间）
 */
@Configuration
public class RestTemplateConfiguration {
    @Bean
    public RestTemplate initHttpRestTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(HttpConst.TIME_OUT);
        requestFactory.setReadTimeout(HttpConst.TIME_OUT);
        List<HttpMessageConverter<?>> converterList = new ArrayList<>();
        converterList.add(new FormHttpMessageConverter());
        converterList.add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        converterList.add(new MappingJackson2HttpMessageConverter());
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        restTemplate.setMessageConverters(converterList);
        return restTemplate;
    }
}
