package network;

import network.connectionWithServer.ServerConnect;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerResponse implements Serializable {
    public void response() throws IOException, ClassNotFoundException {
        byte[] receiveData = new byte[16384];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        ServerConnect.getDatagramSocket().receive(receivePacket);
        ByteArrayInputStream byteStream = new ByteArrayInputStream(receivePacket.getData());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteStream);
        Response receivedResponse = (Response) objectInputStream.readObject();
        System.out.println(receivedResponse.getMessage());
        ServerConnect.disconnect();
    }
}
