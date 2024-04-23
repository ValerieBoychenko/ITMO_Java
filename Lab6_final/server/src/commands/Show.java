package commands;

import base_class.MusicBand;
import serverModules.ResponseClient;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

public class Show extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 16L;

    public void execute(DatagramSocket serverSocket, DatagramPacket receivePacket) {

        var bands = musicBands.getMusicBands();
        if (bands == null) {
            throw new NullPointerException("Bands is not initialized.\n" + this.toString());
        }
        if (musicBands.getMusicBands().isEmpty()){
            try {
                new ResponseClient().response("The collection is empty!", serverSocket, receivePacket);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String result = bands.values().stream()
                .sorted(Comparator.comparing(MusicBand::getName))
                .map(MusicBand::toString)
                .collect(Collectors.joining("\n"));
        try {
            new ResponseClient().response(result, serverSocket, receivePacket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString(){
        return "Class name: Show" + " - / " + new Date().toString() + " /";
    }

}
