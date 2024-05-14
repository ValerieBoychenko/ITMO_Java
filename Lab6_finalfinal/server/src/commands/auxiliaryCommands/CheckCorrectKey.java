package commands.auxiliaryCommands;

import network.Response;
import network.ResponseClient;

import java.io.IOException;
import java.io.Serializable;
import java.util.InputMismatchException;

import static commands.Command.musicBands;

public class CheckCorrectKey implements Serializable {
    static public Integer checking(int key) {
        while (true) {
            try {
                if (musicBands.getMusicBands().get(key) != null) {
                    break;
                } else {
                    System.out.println("Key does not exist.");
                    ResponseClient.response(new Response("Key does not exist."));
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
