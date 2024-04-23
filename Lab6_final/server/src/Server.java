import base_class.MusicBand;
import commands.Command;
import commands.Help;
import exceptions.ConsoleOutputErrorException;
import handlers.MusicBandCollection;
import serverModules.CommandProcessing;
import serverModules.Connection;
import serverModules.ReadingRequest;
import workingWithFile.FileReader;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Map;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        try {
            Command.musicBands = new MusicBandCollection();
            Map<String, String> env = System.getenv();
            new FileReader().read(env.get("FILE_PATH"));
            DatagramSocket serverSocket = new Connection().connecting();
            System.out.println("Server started...");
            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                byte[] receivedBytes = new ReadingRequest().reading(serverSocket, receivePacket);
                Command command = new CommandProcessing().processing(receivedBytes);
                System.out.println("Received command: " + command.toString());
                command.execute(serverSocket, receivePacket);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ConsoleOutputErrorException e) {
            throw new RuntimeException(e);
        }
    }
}