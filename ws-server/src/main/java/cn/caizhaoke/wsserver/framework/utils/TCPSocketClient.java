package cn.caizhaoke.wsserver.framework.utils;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author zhaoke_cai@163.com
 * @date 2018/6/14
 * @description
 */
public class TCPSocketClient {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 6666);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutput dos = new DataOutputStream(s.getOutputStream());

        dos.writeUTF("hello ");
        dos.writeUTF("server");
        System.out.println(dis.readUTF());
        s.close();
    }

}
