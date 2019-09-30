package com.imooc.order.controller;

import com.imooc.order.config.GirlConfig;
import com.netflix.discovery.provider.Serializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 章鑫
 * @Project_name：order
 * @Name: GirlController
 * @Create: 2018-09-29 15:26
 * @Description:
 **/
@RestController
public class GirlController {

    Serializer serializer;

    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("/girl/print")
    public String print() {
        return "name:" + girlConfig.getName() + ",age:" + girlConfig.getAge();
    }
}
