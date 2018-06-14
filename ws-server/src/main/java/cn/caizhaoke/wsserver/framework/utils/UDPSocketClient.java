package cn.caizhaoke.wsserver.framework.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author zhaoke_cai@163.com
 * @date 2018/6/14
 * @description
 */
public class UDPSocketClient {

    public static void main(String[] args) throws IOException {
        long n = 10000L;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeLong(n);

        byte[] buf = baos.toByteArray();
        System.out.println(buf.length);

        DatagramPacket dp = new DatagramPacket(buf,
                buf.length,
                new InetSocketAddress("127.0.0.1", 5678)
        );
        DatagramSocket ds = new DatagramSocket(9999);
        ds.send(dp);
        ds.close();
    }

}
