package serverModules;

import commands.Help;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ResponseClient implements Serializable {
    private static final long serialVersionUID = 5L;
    private final String HOST = "localhost";
    private final int PORT = 9876;
    public void response(String message, DatagramSocket serverSocket, DatagramPacket receivePacket) throws IOException {
        byte[] sendData = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
        serverSocket.send(sendPacket);
    }
}
