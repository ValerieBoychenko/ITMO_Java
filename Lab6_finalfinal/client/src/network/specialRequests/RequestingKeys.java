package network.specialRequests;

import commands.auxiliaryCommands.InfoAboutKeyCollection;
import network.Request;
import network.SendRequest;
import network.ServerResponse;
import network.connectionWithServer.ServerConnect;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class RequestingKeys {
    public static void request(InetAddress serverAddress, int serverPort) {
        try {
            new SendRequest().sending(new Request(new InfoAboutKeyCollection()), serverAddress, serverPort);
            new ServerResponse().response();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
