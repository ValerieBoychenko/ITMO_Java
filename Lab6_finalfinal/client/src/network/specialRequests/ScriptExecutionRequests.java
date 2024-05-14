package network.specialRequests;

import commands.Command;
import commands.specialCommands.ExecuteScript;
import exceptions.ConsoleOutputErrorException;
import network.ClientManager;
import network.Request;
import network.SendRequest;
import network.ServerResponse;
import parser.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ScriptExecutionRequests {
    public static void executeScript(InetAddress serverAddress, int serverPort, Command command) {
        String fileName = ((ExecuteScript) command).getFileName();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String newCommand;
            while ((newCommand = br.readLine()) != null) {
                Command finalCommand = new ClientManager(new Parser().parsing(newCommand)).handler(serverAddress, serverPort);
                new SendRequest().sending(new Request(finalCommand), serverAddress, serverPort);
                new ServerResponse().response();
            }
        } catch (IOException | ConsoleOutputErrorException | NullPointerException | ClassNotFoundException e) {
            e.getMessage();
        }
    }
}
