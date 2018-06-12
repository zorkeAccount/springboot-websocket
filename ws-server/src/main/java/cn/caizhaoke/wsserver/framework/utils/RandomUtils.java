package cn.caizhaoke.wsserver.framework.utils;

import java.util.Random;

/**
 * @author zhaoke_cai@163.com
 * @date 2018/6/12
 * @description 随机工具类：获取随机的boolean值
 */
public class RandomUtils {
    private Random random;

    public RandomUtils() {
        random = new Random();
    }

    public Boolean getRandomBoolean() {
        return random.nextBoolean();
    }
}
