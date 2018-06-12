package cn.caizhaoke.wsserver.framework.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

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

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

//        log.info("handle the websocket session");

        TimeUnit.MILLISECONDS.sleep(2000);

        System.out.println(message.toString());

        session.sendMessage(new TextMessage("This is server reply message content!"));

    }
}
