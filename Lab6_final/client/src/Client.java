import clientModuls.SendCommand;
import clientModuls.ServerResponse;
import commands.*;
import commands.auxiliaryCommands.InfoAboutKeyCollection;
import exceptions.ConsoleOutputErrorException;
import parser.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

    public static void main(String[] args) {
        try {
            System.out.println("Client start!");
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9876;
            while (true) {
                int statusCommand = 0;
                Command command = null;
                do {
                    command = new Parser().start();
                    if (command instanceof RemoveKey || command instanceof RemoveGreater || command instanceof RemoveLowerKey ||
                            command instanceof ReplaceIfGreater || command instanceof Update) {
                        Command commandTwo = new InfoAboutKeyCollection();
                        new SendCommand().sending(commandTwo, serverAddress, clientSocket, serverPort);
                        new ServerResponse().response(clientSocket);
                        command.executeReadParameters();
                        statusCommand = 2;
                    }
                    if (command instanceof ExecuteScript){
                        String fileName = ((ExecuteScript) command).getFileName();
                        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                            String newCommand;
                            Parser parser = new Parser();
                            while ((newCommand = br.readLine()) != null) {
                                Command finalCommand = parser.parsing(newCommand);
                                finalCommand.executeReadParameters();
                                new SendCommand().sending(finalCommand, serverAddress, clientSocket, serverPort);
                                new ServerResponse().response(clientSocket);
                            }
                        } catch (IOException | ConsoleOutputErrorException | NullPointerException e) {
                            e.getMessage();
                        }
                        statusCommand = 1;
                    }
                } while (command == null);

                if (command instanceof Exit) {
                    new SendCommand().sending(new Exit(), serverAddress, clientSocket, serverPort);
                    break;
                }
                if (statusCommand == 0) {
                    command.executeReadParameters();
                    new SendCommand().sending(command, serverAddress, clientSocket, serverPort);
                    new ServerResponse().response(clientSocket);
                }
                if (statusCommand == 2) {
                    new SendCommand().sending(command, serverAddress, clientSocket, serverPort);
                    new ServerResponse().response(clientSocket);
                }
            }
            clientSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}