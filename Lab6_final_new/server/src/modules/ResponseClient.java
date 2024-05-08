package modules;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ResponseClient implements Serializable {
    private static final long serialVersionUID = 5L;
    private static DatagramSocket serverSocket;
    private static DatagramPacket receivePacket;
    public ResponseClient(DatagramSocket serverSocket, DatagramPacket receivePacket){
        ResponseClient.serverSocket = serverSocket;
        ResponseClient.receivePacket = receivePacket;
    }
    public static void response(Response response) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteStream);
        out.writeObject(response);
        byte[] sendData = byteStream.toByteArray();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
        serverSocket.send(sendPacket);
    }
}
