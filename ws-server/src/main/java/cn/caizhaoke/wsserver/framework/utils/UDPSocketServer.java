package cn.caizhaoke.wsserver.framework.utils;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author zhaoke_cai@163.com
 * @date 2018/6/14
 * @description
 */
public class UDPSocketServer {

    public static void main(String[] args) throws IOException {
        byte buf[] = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        DatagramSocket ds = new DatagramSocket(5678);
        while (true) {
            ds.receive(dp);
            ByteArrayInputStream bais = new ByteArrayInputStream(buf);
            DataInputStream dis = new DataInputStream(bais);
            System.out.println(dis.readLong());
        }
    }

}
