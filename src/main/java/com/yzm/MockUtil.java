package com.yzm;

import java.util.Random;

/**
 * @ClassName MockUtil
 * @Description: TODO
 * @Author zhiMing.yue
 * @Date 2020/06/25 23:44
 **/
public class MockUtil {
    private static final Random random = new Random();

    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }
    public static void redisLock(String str){
        System.out.println("123456");
    }
}
