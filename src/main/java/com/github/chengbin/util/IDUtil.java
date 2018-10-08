package com.github.chengbin.util;

import java.util.UUID;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/7.
 */
public class IDUtil {

    public static String randomId() {
        return UUID.randomUUID().toString().split("-")[0];
    }
}
