/*
 */

package src.sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 */
public class MyServer {

    static ServerSocket serverSocket;

    static Socket socket;

    static DataOutputStream out;

    public static void main(String[] args) throws IOException {
        System.out.println("Starting server:");
        serverSocket = new ServerSocket(7777);
        System.out.println("Starting started:");
        socket = serverSocket.accept();
        System.out.println("Connection address:" + socket.getInetAddress());
        out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF("This is the Message from the server");
        System.out.println("Data has been sent");

    }

}
