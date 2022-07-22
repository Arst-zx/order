package com.imooc.order.utils;

import java.util.Random;

/**
 * @Author: 章鑫
 * @Project_name：order
 * @Name: KeyUtil
 * @Create: 2018-08-28 15:52
 * @Description:
 **/
public class KeyUtil {

    /**
     * 生产唯一主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey() {

        Random random = new Random();
        Integer integer = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(integer);
    }
}
