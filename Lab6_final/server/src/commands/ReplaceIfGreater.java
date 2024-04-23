package commands;

import base_class.MusicBand;
import serverModules.ResponseClient;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReplaceIfGreater extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 14L;
    private String key;

    private MusicBand musicBand;

    public void execute(DatagramSocket serverSocket, DatagramPacket receivePacket) {
        try {
            if (musicBand == null) {
                throw new NullPointerException("musicBand is not initialized.\n" + this.toString());
            }
            MusicBand oldValue = musicBands.getMusicBands().get(Integer.parseInt(key));
            if (oldValue != null){
                if (musicBand.compareTo(oldValue) > 0) {
                    musicBands.put(Integer.parseInt(key), musicBand);
                }else{
                    new ResponseClient().response("oldValue greater then newValue.", serverSocket, receivePacket);
                }
            }else {
                throw new NullPointerException("oldValue is not initialized.\n" + this.toString());
            }
            String result = "";
            for (Integer newKey : musicBands.getMusicBands().keySet()){
                result += "Name: " + musicBands.getMusicBands().get(newKey).getName() + " -> "  + newKey + "\n";
            }
            new ResponseClient().response(result,serverSocket, receivePacket);
        } catch (InputMismatchException | IOException e) {
            System.out.println("The key was entered incorrectly!");
        }
    }
    @Override
    public String toString(){
        return "Class name: ReplaceIfGreater"  + " - / " + new Date().toString() + " /";
    }

}
