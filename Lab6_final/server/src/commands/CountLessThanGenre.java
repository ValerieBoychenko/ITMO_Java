package commands;

import base_class.MusicBand;
import base_class.MusicGenre;
import serverModules.ResponseClient;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;


public class CountLessThanGenre extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 3L;

    private String genre;

    public void execute(DatagramSocket serverSocket, DatagramPacket receivePacket) throws NullPointerException {
        if (musicBands == null) {
            throw new NullPointerException("MusicBands is not initialized.\n" + this.toString());
        }

        long count = musicBands.getMusicBands().values().stream()
                .filter(band -> band.getGenre().compareTo(Objects.requireNonNull(MusicGenre.convert(genre))) < 0)
                .count();
        try {
            new ResponseClient().response(String.valueOf(count), serverSocket, receivePacket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString(){
        return "Class name: CountLessThanGenre" + " - / " + new Date().toString() + " /";
    }

}

