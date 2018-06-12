package cn.caizhaoke.wsserver.domain;

import lombok.Data;

/**
 * @author zhaoke_cai@163.com
 * @date 2018/6/12
 * @description
 */
@Data
public class PayloadParam extends ResultUpdateTag {
    private String reqKey;
    private Object resResult;
}
