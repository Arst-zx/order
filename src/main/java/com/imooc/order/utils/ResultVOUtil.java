package com.imooc.order.utils;

import com.imooc.order.VO.ResultVO;

/**
 * 2017-12-10 18:03
 * @author 章鑫
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
