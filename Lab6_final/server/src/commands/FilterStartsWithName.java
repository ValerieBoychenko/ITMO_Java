package commands;

import base_class.MusicBand;
import serverModules.ResponseClient;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.*;
import java.util.stream.Collectors;

public class FilterStartsWithName extends Command implements Serializable {

    String name;
    @Serial
    private static final long serialVersionUID = 6L;

    public void execute(DatagramSocket serverSocket, DatagramPacket receivePacket) throws NullPointerException {
        try {
            String result = "";
            if (musicBands == null) {
                throw new NullPointerException("MusicBands is not initialized.\n" + this);
            }
            List<MusicBand> filteredBands = musicBands.getMusicBands().values().stream()
                    .filter(band -> band.getName().startsWith(name))
                    .toList();
                if (filteredBands.isEmpty()) {
                    new ResponseClient().response("There are no such groups.", serverSocket, receivePacket);

                }else {
                    result = filteredBands.stream()
                            .map(MusicBand::toString)
                            .collect(Collectors.joining("\n"));
                }
                new ResponseClient().response(result, serverSocket, receivePacket);
            } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch(InputMismatchException e){
                System.out.println("The name was entered incorrectly!");
            }
    }

    @Override
    public String toString() {
        return "Class name: FilterStartsWithName" + " - / " + new Date().toString() + " /";
    }

}

