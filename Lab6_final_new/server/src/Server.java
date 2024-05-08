import commands.Command;
import exceptions.ConsoleOutputErrorException;
import collectionHandler.MusicBandCollection;
import modules.*;
import fileHandler.FileReader;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Map;

public class Server {

    public static void main(String[] args) {
        try {
            Command.musicBands = new MusicBandCollection();
            Map<String, String> env = System.getenv();
            new FileReader().read(env.get("FILE_PATH"));
            DatagramSocket serverSocket = new Connection().connecting();
            System.out.println("Server started...");
            while (true) {
                byte[] receiveData = new byte[2048];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                new ResponseClient(serverSocket, receivePacket);
                byte[] receivedBytes = new ReadingRequest().reading(serverSocket, receivePacket);
                Command command = new CommandProcessing().processing(receivedBytes);
                System.out.println("Received command: " + command.toString());
                ResponseClient.response(new Response(command.execute()));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ConsoleOutputErrorException e) {
            throw new RuntimeException(e);
        }
    }
}