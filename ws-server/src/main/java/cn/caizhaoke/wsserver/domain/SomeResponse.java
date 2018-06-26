package cn.caizhaoke.wsserver.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaoke_cai@163.com
 * @date 2018/6/25
 * @description
 */
@Data
public class SomeResponse implements Serializable {
    public String text;
}
