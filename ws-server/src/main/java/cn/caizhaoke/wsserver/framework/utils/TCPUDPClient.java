package cn.caizhaoke.wsserver.framework.utils;

import cn.caizhaoke.wsserver.domain.SomeRequest;
import cn.caizhaoke.wsserver.domain.SomeResponse;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoke_cai@163.com
 * @date 2018/6/25
 * @description
 */
public class TCPUDPClient {


    public static void main(String[] args) throws IOException, InterruptedException {
        InetAddress addr = InetAddress.getLocalHost();
        String localIP = addr.getHostAddress();

        Client client = new Client();
        client.start();
        client.connect(5000, localIP, 54555, 54777);
//        client.connect(5000, "47.96.252.235", 19999);

        Kryo kryo = client.getKryo();
        kryo.register(SomeRequest.class);
        kryo.register(SomeResponse.class);

        SomeRequest request = new SomeRequest();
        request.text = "Here is the request";
        client.sendTCP(request);

        client.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                if (object instanceof SomeResponse) {
                    SomeResponse response = (SomeResponse) object;
                    System.out.println(response.text);
                }
            }
        });

        TimeUnit.SECONDS.sleep(10); //for receive
    }

}
