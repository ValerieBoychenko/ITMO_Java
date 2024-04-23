package commands.auxiliaryCommands;

import serverModules.ResponseClient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.InputMismatchException;
import java.util.Scanner;

import static commands.Command.musicBands;

public class CheckCorrectKey {
     static public Integer checking(int key, DatagramSocket serverSocket, DatagramPacket receivePacket){
        while (true){
            try {
                if (musicBands.getMusicBands().get(key) != null){
                    break;
                } else {
                    System.out.println("Key does not exist.");
                    new ResponseClient().response("Key does not exist.", serverSocket, receivePacket);
                    return -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("The input error must be of type Integer (< 2147483647).");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return key;
    }
}
