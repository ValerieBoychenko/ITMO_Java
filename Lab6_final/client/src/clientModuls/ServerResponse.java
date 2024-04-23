package clientModuls;

import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerResponse implements Serializable {
    public void response(DatagramSocket clientSocket) throws IOException, ClassNotFoundException {
        byte[] receiveData = new byte[4096];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("SERVER: " + "\n" + receivedMessage);
    }
}
