package network;

import commands.Command;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class CommandProcessing implements Serializable {
    public Command processing(byte[] receivedBytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(receivedBytes);
        ObjectInputStream in = new ObjectInputStream(byteInputStream);
        return ((Request) in.readObject()).getCommand();
    }
}
