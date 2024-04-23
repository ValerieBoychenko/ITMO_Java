package commands;

import java.io.Serial;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import static java.lang.System.exit;

public class Exit extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 5L;

    public void execute(DatagramSocket serverSocket, DatagramPacket receivePacket){
        new Save().execute(serverSocket, receivePacket);
        exit(1);
    }
}
