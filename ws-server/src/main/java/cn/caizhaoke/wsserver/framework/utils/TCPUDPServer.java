package cn.caizhaoke.wsserver.framework.utils;

import cn.caizhaoke.wsserver.domain.SomeRequest;
import cn.caizhaoke.wsserver.domain.SomeResponse;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoke_cai@163.com
 * @date 2018/6/25
 * @description
 */
public class TCPUDPServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server();
        server.start();
        server.bind(54555, 54777);

        Kryo kryo = server.getKryo();
        kryo.register(SomeRequest.class);
        kryo.register(SomeResponse.class);

        server.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                if (object instanceof SomeRequest) {
                    SomeRequest request = (SomeRequest) object;
                    System.out.println(request.text);

                    SomeResponse response = new SomeResponse();
                    response.text = "Thanks";
                    connection.sendTCP(response);
                }
            }
        });

        TimeUnit.SECONDS.sleep(10); //for receive

    }

}
