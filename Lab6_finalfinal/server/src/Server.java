import commands.Command;
import commands.Save;
import exceptions.ConsoleOutputErrorException;
import collectionHandler.MusicBandCollection;
import fileHandler.FileReader;
import network.*;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Map;

public class Server {

    public static void main(String[] args) {
//        try {
//            Command.musicBands = new MusicBandCollection();
//            Map<String, String> env = System.getenv();
//            new FileReader().read(env.get("FILE_PATH"));
//            DatagramSocket serverSocket = new Connection().connecting();
//            System.out.println("Server started...");
//            while (true) {
//                serverSocket.setSoTimeout(60000);
//                byte[] receiveData = new byte[2048];
//                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
//                try {
//                new ResponseClient(serverSocket, receivePacket);
//                byte[] receivedBytes = new ReadingRequest().reading(serverSocket, receivePacket);
//                Command command = new CommandProcessing().processing(receivedBytes);
//                System.out.println("Received command: " + command.toString());
//                ResponseClient.response(new Response(command.execute()));
//                } catch (SocketTimeoutException e) {
//                    System.out.println("Нет запросов от пользователей. Завершение работы сервера...");
//                    new Save().execute();
//                    break;
//                }
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (ConsoleOutputErrorException e) {
//            throw new RuntimeException(e);
//        }
        try {
            Command.musicBands = new MusicBandCollection();
            Map<String, String> env = System.getenv();
            new FileReader().read(env.get("FILE_PATH"));
            DatagramSocket serverSocket = new Connection().connecting();
            System.out.println("Server started...");

            Thread consoleInputThread = new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    while (true) {
                        String input = reader.readLine();
                        if (input.equalsIgnoreCase("stop")) {
                            System.out.println("Logging out of the server...");
                            new Save().execute();
                            serverSocket.close();
                            break;
                        }
                        if ( input.equalsIgnoreCase("save")){
                            new Save().execute();
                        } else {
                            System.out.println("The wrong command. Type 'stop' to stop the server or 'save' to save everything to a file. ");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            consoleInputThread.start();
            try {
                while (!serverSocket.isClosed()) {
                    byte[] receiveData = new byte[2048];
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    new ResponseClient(serverSocket, receivePacket);
                    byte[] receivedBytes = new ReadingRequest().reading(serverSocket, receivePacket);
                    Command command = new CommandProcessing().processing(receivedBytes);
                    System.out.println("Received command: " + command.toString());
                    ResponseClient.response(new Response(command.execute()));
                }
            }catch (SocketException e){
                System.out.println("The execution was aborted! The server has shut down.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ConsoleOutputErrorException e) {
            throw new RuntimeException(e);
        }
    }
}