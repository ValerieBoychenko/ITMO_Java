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
import java.util.TreeMap;

public class RemoveGreater extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 11L;
    private String key;

    public void execute(DatagramSocket serverSocket, DatagramPacket receivePacket) throws NullPointerException {
        String result = "";
        try {
            for (Integer key : musicBands.getMusicBands().keySet()){
                System.out.println("Name: " + musicBands.getMusicBands().get(key).getName() + " -> "  + key);
            }
            TreeMap<Integer, MusicBand> newMusicBands = musicBands.getMusicBands();
            newMusicBands.keySet().removeIf(k -> {
                if (k == null) {
                    throw new NullPointerException("Key in the map cannot be null");
                }
                return k > Integer.parseInt(key);
            });
            musicBands.updateCollection(newMusicBands);
            System.out.println("Collection after deleting items: ");
            for (Integer newKey : musicBands.getMusicBands().keySet()){
               result += "Name: " + musicBands.getMusicBands().get(newKey).getName() + " -> "  + newKey + "\n";
            }
            new ResponseClient().response(result, serverSocket, receivePacket);
        } catch (InputMismatchException | IOException e) {
            System.out.println("The key was entered incorrectly!");
        }
    }

    @Override
    public String toString(){
        return "Class name: RemoveGreater" + " - / " + new Date().toString() + " /";
    }

}
