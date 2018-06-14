package cn.caizhaoke.wsserver.framework.utils;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhaoke_cai@163.com
 * @date 2018/6/14
 * @description
 */
public class TCPSocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        while (true) {
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutput dos = new DataOutputStream(s.getOutputStream());

            System.out.print(dis.readUTF());
            System.out.println(dis.readUTF());

            dos.writeUTF("bye");
            s.close();
        }
    }

}
