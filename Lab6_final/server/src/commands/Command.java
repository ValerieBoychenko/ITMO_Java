package commands;

import exceptions.ConsoleOutputErrorException;
import handlers.MusicBandCollection;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public abstract class Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

    static public MusicBandCollection musicBands;
    abstract public void execute(DatagramSocket serverSocket, DatagramPacket receivePacket) throws ConsoleOutputErrorException, IOException;
}
