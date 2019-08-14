package com.imooc.order.controller;

/**
 * @Author 章鑫
 * @Date 2018/9/11 16:29
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 章鑫
 * @Project_name：order
 * @Name: EnvController
 * @Create: 2018-09-11 16:29
 * @Description:
 **/
@RestController
@RequestMapping("/env")
@RefreshScope
public class EnvController {

    @Value("${env}")
    private String env;

    @GetMapping("/print")
    public String print() {
        return env;
    }
}
