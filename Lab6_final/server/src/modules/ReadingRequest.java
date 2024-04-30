package modules;

import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReadingRequest implements Serializable {
    public byte[] reading(DatagramSocket serverSocket, DatagramPacket receivePacket) throws IOException {
        serverSocket.receive(receivePacket);
        return receivePacket.getData();
    }
}
