package cn.caizhaoke.wsserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhaoke_cai@163.com
 * @date 2018/6/12
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloResult implements Serializable {
    private String a;
    private String b;
}
