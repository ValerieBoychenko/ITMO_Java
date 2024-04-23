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
public class InsertNewElement extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 9L;
    private String key;

    private MusicBand musicBand;

    public void execute(DatagramSocket serverSocket, DatagramPacket receivePacket) throws NullPointerException {
        try {
            if (musicBands == null) {
                throw new NullPointerException("MusicBands is not initialized.\n" + this.toString());
            }
            musicBands.put(Integer.parseInt(key), musicBand);
            new ResponseClient().response("The item was added successfully", serverSocket, receivePacket);
        } catch (InputMismatchException | IOException e) {
            System.out.println("Ключ введен неверно!" + "\n" + new InsertNewElement().toString());
        }
    }

    @Override
    public String toString(){
        return "Имя класса: InsertNewElement" + " - / " + new Date().toString() + " /";
    }
}

