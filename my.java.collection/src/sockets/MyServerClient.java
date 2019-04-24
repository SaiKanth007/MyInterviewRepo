/*
 **
 */

package src.sockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 */
public class MyServerClient {

    static Socket socket;

    static DataInputStream in;

    public static void main(String[] args) throws IOException {
        socket = new Socket("localhost", 7777);
        in = new DataInputStream(socket.getInputStream());
        System.out.println("Received Information");
        System.out.println(in.readUTF());

    }

}
