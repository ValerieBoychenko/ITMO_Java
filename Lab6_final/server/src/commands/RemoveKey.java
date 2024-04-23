package commands;

import commands.auxiliaryCommands.CheckCorrectKey;
import serverModules.ResponseClient;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;
import java.util.InputMismatchException;

public class RemoveKey extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 12L;
    private String key;

    public void execute(DatagramSocket serverSocket, DatagramPacket receivePacket) {
        try {
            int correctKey = CheckCorrectKey.checking(Integer.parseInt(key), serverSocket, receivePacket);
            if (correctKey != -1){
                musicBands.remove(correctKey);
                new ResponseClient().response("The operation was completed successfully", serverSocket, receivePacket);
            }
        } catch (ClassCastException e) {
            System.out.println("Key not exist");
        } catch (InputMismatchException e) {
            System.out.println("The key was entered incorrectly!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String toString(){
        return "Class name: RemoveKey" + " - / " + new Date().toString() + " /";
    }
}
