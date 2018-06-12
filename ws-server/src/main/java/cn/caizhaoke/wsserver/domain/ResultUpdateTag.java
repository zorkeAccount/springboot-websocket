package cn.caizhaoke.wsserver.domain;

import java.io.Serializable;

/**
 * @author zhaoke_cai@163.com
 * @date 2018/6/12
 * @description
 */
public class ResultUpdateTag implements Serializable {
    private Boolean isUpdate;

    public Boolean getUpdate() {
        return null == isUpdate ? Boolean.TRUE : isUpdate;
    }

    public void setUpdate(Boolean update) {
        isUpdate = update;
    }
}
