package commands;

import serverModules.ResponseClient;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PrintFieldDescendingGenre extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 10L;

    public void execute(DatagramSocket serverSocket, DatagramPacket receivePacket) {
        String result = musicBands.getMusicBands().values().stream()
                .map(band -> {
                    if (band.getGenre() == null) {
                        throw new NullPointerException("Genre is null for music band. \n" + this.toString());
                    }
                    return band.getGenre().toString();
                })
                .sorted()
                .collect(Collectors.joining("\n"));
        musicBands.updateCollection(musicBands.getMusicBands());
        try {
            new ResponseClient().response(result, serverSocket, receivePacket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString(){
        return "Class name: PrintFieldDescendingGenre" + " - / " + new Date().toString() + " /";
    }

}
