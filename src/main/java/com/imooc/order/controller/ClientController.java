package com.imooc.order.controller;

/**
 * @Author 章鑫
 * @Date 2018/8/28 16:19
 */

import com.imooc.order.client.ProductClient;
import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CarDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: 章鑫
 * @Project_name：order
 * @Name: TestController
 * @Create: 2018-08-28 16:19
 * @Description:
 **/
@RestController
@Slf4j
public class ClientController {

//    //3.第三种方式
//    @Autowired
//    private RestTemplate restTemplate;

//    //2.第二种方式
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    //4.第四种方式（Feign）
    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {

//        //3.第三种方式(利用@loadBalanced，可在restTemplate里使用应用名字)
//        String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);
//        log.info("response={}",response);
//        return response;

//        //1.第一种方式（直接使用restTemplate,url写死）
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8090/msg",String.class);
//        log.info("response={}",response);
//        return response;

//        //2.第二种方式（利用loadBalancerClient通过应用名获取url,然后再使用restTemplate）
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort() + "/msg");
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(url,String.class);
//        log.info("response={}",response);
//        return response;

        //4.第四种方式（Feign）
        String reponse = productClient.productMsg();
        log.info("reponse={}",reponse);
        return reponse;
    }

    @PostMapping("/getProductListForOrder")
    public List<ProductInfo> getProductListForOrder() {
        List<ProductInfo> listForOrder = productClient.listForOrder(Arrays.asList("157875196366190022","157875196366190023"));
        log.info("listForOrder={}",listForOrder);
        return listForOrder;
    }

    @PostMapping("/decreaseStock")
    public String decreaseStock() {
        CarDTO carDTO = new CarDTO();
        carDTO.setProductId("157875196366190022");
        carDTO.setProductQuantity(2);
        productClient.decreaseStock(Arrays.asList(carDTO));
        return "库存扣除成功！";
    }
}
