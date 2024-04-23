package clientModuls;

import commands.Command;
import commands.Exit;
import parser.Parser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendCommand {
    public void sending(Command command, InetAddress serverAddress, DatagramSocket clientSocket, int serverPort) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteStream);
        out.writeObject(command);
        byte[] sendData = byteStream.toByteArray();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
        clientSocket.send(sendPacket);
    }
}
