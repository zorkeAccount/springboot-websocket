package cn.caizhaoke.wsserver.service;

import cn.caizhaoke.wsserver.domain.HelloResult;
import cn.caizhaoke.wsserver.domain.PayloadParam;
import org.springframework.stereotype.Service;

/**
 * @author zhaoke_cai@163.com
 * @date 2018/6/12
 * @description
 */
@Service
public class HelloSecondResponse implements ResponseI {
    @Override
    public PayloadParam reply(PayloadParam param) {
        HelloResult result = new HelloResult("This is a text result FROM HelloSecondResponse!", "This is b text result FROM HelloSecondResponse!");

        param.setResResult(result);

        return param;
    }
}
