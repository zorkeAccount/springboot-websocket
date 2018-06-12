package cn.caizhaoke.wsserver.framework.configs;

import cn.caizhaoke.wsserver.framework.components.WebSocketHandlerCpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author zhaoke_cai@163.com
 * @date 2018/6/12
 * @description 实现WebSocketConfigurer，接收浏览器的请求并分配到MarcoHandler中的handleTextMessage方法
 */
@Configuration
@EnableWebSocket
public class WebSocketCfg implements WebSocketConfigurer {

    @Autowired
    WebSocketHandlerCpt webSocketHandlerCpt;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {

        webSocketHandlerRegistry.addHandler(webSocketHandlerCpt, "/wsserver").setAllowedOrigins("*").withSockJS();
//        webSocketHandlerRegistry.addHandler(webSocketHandlerCpt,"/wsserver").setAllowedOrigins("https://localhost:8443").withSockJS();

    }
}
