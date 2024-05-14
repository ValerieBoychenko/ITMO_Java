import network.ClientManager;
import network.Request;
import network.SendRequest;
import network.ServerResponse;
import commands.*;
import network.connectionWithServer.ServerConnect;
import parser.Parser;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

import static java.lang.System.exit;

public class Client {

    public static void main(String[] args) {
        try {
            System.out.println("Client start!");
            final InetAddress serverAddress = InetAddress.getByName("localhost");
            final int serverPort = 9877;
            while (true) {
                Command commandWithParameters = null;
                do {
                    Command command = new Parser().start();
                    if (command instanceof Exit) {
                        ServerConnect.disconnect();
                        exit(1);
                    }
                    if (command != null) {
                        commandWithParameters = new ClientManager(command).handler(serverAddress, serverPort);
                    }
                } while (commandWithParameters == null);

                try {
                    new SendRequest().sending(new Request(commandWithParameters), serverAddress, serverPort);
                    new ServerResponse().response();
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}