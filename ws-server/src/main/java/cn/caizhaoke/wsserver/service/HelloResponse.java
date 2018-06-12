package cn.caizhaoke.wsserver.service;

import cn.caizhaoke.wsserver.domain.HelloResult;
import cn.caizhaoke.wsserver.domain.PayloadParam;
import cn.caizhaoke.wsserver.framework.utils.RandomUtils;
import org.springframework.stereotype.Service;

/**
 * @author zhaoke_cai@163.com
 * @date 2018/6/12
 * @description
 */
@Service
public class HelloResponse implements ResponseI {
    @Override
    public PayloadParam reply(PayloadParam param) {
        HelloResult result = new HelloResult("This is a text result FROM HelloResponse!", "This is b text result FROM HelloResponse!");

        param.setResResult(result);
        param.setUpdate(new RandomUtils().getRandomBoolean());

        return param;
    }
}
