package commands.auxiliaryCommands;

import commands.Command;
import serverModules.ResponseClient;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class InfoAboutKeyCollection extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 17L;
    public void execute(DatagramSocket serverSocket, DatagramPacket receivePacket){
        String info = "";
        if (musicBands.getMusicBands().isEmpty()){
            try {
                new ResponseClient().response("The collection is empty!", serverSocket, receivePacket);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        for (Integer key : musicBands.getMusicBands().keySet()){
            info += "Name: " + musicBands.getMusicBands().get(key).getName() + " -> "  + key + "\n";
        }
        try {
            new ResponseClient().response(info, serverSocket, receivePacket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
