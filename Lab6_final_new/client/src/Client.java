import commands.commandStatus.CommandStatus;
import modules.ClientManager;
import modules.SendCommand;
import modules.ServerResponse;
import commands.*;
import parser.Parser;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

    public static void main(String[] args) {
        try {
            System.out.println("Client start!");
            DatagramSocket clientSocket = new DatagramSocket();
            final InetAddress serverAddress = InetAddress.getByName("localhost");
            final int serverPort = 9876;
            while (true) {
                CommandStatus statusCommand = CommandStatus.NO_PARAMETERS;
                Command command = null;
                do {
                    command = new Parser().start();
                    statusCommand = new ClientManager(command).handler(clientSocket, serverAddress, serverPort);
                } while (command == null);

                if (command instanceof Exit) {
                    try {
                        new SendCommand().sending(new Exit(), serverAddress, clientSocket, serverPort);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                }
                if (statusCommand == CommandStatus.NO_PARAMETERS) {
                    command.executeReadParameters();
                    try {
                        new SendCommand().sending(command, serverAddress, clientSocket, serverPort);
                        new ServerResponse().response(clientSocket);
                    } catch (IOException | ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}