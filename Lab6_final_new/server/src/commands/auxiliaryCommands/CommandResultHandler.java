package commands.auxiliaryCommands;

import modules.Response;
import modules.ResponseClient;

import java.io.IOException;
import java.io.Serializable;

public class CommandResultHandler implements Serializable {
    public static void sendUser(Response message){
        try {
            ResponseClient.response(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
