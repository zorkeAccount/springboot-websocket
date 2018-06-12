package cn.caizhaoke.wsserver.framework.components;

import cn.caizhaoke.wsserver.domain.PayloadParam;
import cn.caizhaoke.wsserver.service.ResponseI;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoke_cai@163.com
 * @date 2018/6/12
 * @description Handler类，继承AbstractWebSocketHandler类，实现WebSocketHandler接口，
 * 通过Spring底层的WebSocket API处理连接请求，如handleTextMessage处理消息文本
 */
@Component
@Slf4j
public class WebSocketHandlerCpt extends AbstractWebSocketHandler {
    public static final String ResponseI_Package = ResponseI.class.getPackage().getName() + ".";

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        TimeUnit.MILLISECONDS.sleep(2000); //返回推送内容机制，预期应该是消息推送内容存在变化时才进行推送,如result.getIsUpdate()

        PayloadParam result = getPayloadParamResult(message);
        if (result.getUpdate()) {
            TextMessage textMessage = new TextMessage(result.toString());//最好是改成转换成json字符串格式返回交互
            session.sendMessage(textMessage);
        }

    }

    private PayloadParam getPayloadParamResult(TextMessage message) {
        PayloadParam param = getPayloadParamObject(message);
        String reqService = ResponseI_Package + param.getReqKey() + "Response";

        try {
            Class c = Class.forName(reqService);
            ResponseI res = (ResponseI) c.newInstance();
            param = res.reply(param);
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            param.setResResult("根据payload字符串中的reqKey - " + param.getReqKey() + "调用服务出现异常：" + e.getMessage());
            log.info("根据payload字符串中的reqKey - " + param.getReqKey() + "调用服务出现异常：" + e.getMessage());
        }

        return param;
    }

    private PayloadParam getPayloadParamObject(TextMessage message) {
        String payload = message.getPayload();
        System.out.println(payload);
        String messageString = message.toString();
        System.out.println(messageString);

        PayloadParam param = new PayloadParam();
        try {
            ObjectMapper mapper = new ObjectMapper();
            param = mapper.readValue(payload, PayloadParam.class);
        } catch (IOException e) {
            param.setResResult("payload字符串转换成java对象异常:" + e.getMessage());
            log.info("payload字符串转换成java对象异常:" + e.getMessage());
        }

        return param;

    }

}
