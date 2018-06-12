package cn.caizhaoke.wsserver.service;

import cn.caizhaoke.wsserver.domain.PayloadParam;

/**
 * @author zhaoke_cai@163.com
 * @date 2018/6/12
 * @description 响应websocket服务接口
 */
public interface ResponseI {

    PayloadParam reply(PayloadParam param);

}
