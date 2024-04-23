package commands;


import serverModules.ResponseClient;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;
import java.util.TreeMap;

public class Clear extends Command implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public void execute(DatagramSocket serverSocket, DatagramPacket receivePacket) throws NullPointerException {
        if (musicBands == null) {
            throw new NullPointerException("MusicBands is not initialized.\n" + this.toString());
        }
        musicBands.updateCollection(new TreeMap<>());
        try {
            new ResponseClient().response("The collection has been successfully cleared.", serverSocket, receivePacket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString(){
        return "Class name: Clear" + " - / " + new Date().toString() + " /";
    }

}
