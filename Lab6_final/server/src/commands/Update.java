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

public class Update extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 17L;
    String key;

    MusicBand musicBand;

    public void execute(DatagramSocket serverSocket, DatagramPacket receivePacket) {
        try {
            if (musicBand == null) {
                throw new NullPointerException("newMusicBand is not initialized.\n" + this.toString());
            }
            if (musicBands.getMusicBands().containsKey(Integer.parseInt(key))) {
                musicBands.put(Integer.parseInt(key), musicBand);
                new ResponseClient().response("An element with a key " + key + " successfully updated.", serverSocket, receivePacket);
            } else {
                new ResponseClient().response("An element with a key " + key + " not found in the collection.", serverSocket, receivePacket);
            }
        } catch (InputMismatchException | IOException e) {
            System.out.println("The key was entered incorrectly!");
        }
    }

    @Override
    public String toString(){
        return "Class name: Update" + " - / " + new Date().toString() + " /";
    }

}
