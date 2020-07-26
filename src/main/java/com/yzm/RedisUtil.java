package com.yzm;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.Function;
/**
 * @ClassName RedisUtil
 * @Description: TODO
 * @Author zhiMing.yue
 * @Date 2020/06/26 0:30
 **/
@Slf4j
public class RedisUtil {
    public static void redisLock( String redisKey, Consumer<Void> consumer) {
        Function<Consumer<Void>, Void> function = (Consumer<Void> call) -> {
            try {
                call.accept((Void) null);
            } catch (Exception e) {
                log.error("redisValueLocks redisKey error", e);
            }
            return (Void) null;
        };
    }
}

