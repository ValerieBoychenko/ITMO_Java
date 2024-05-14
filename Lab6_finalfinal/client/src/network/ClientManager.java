package network;

import commands.*;
import commands.specialCommands.ExecuteScript;
import network.specialRequests.RequestingKeys;
import network.specialRequests.ScriptExecutionRequests;
import parameters.TypeParameter;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientManager {
    private Command command;

    public ClientManager(Command command) {
        this.command = command;
    }

    public Command handler(InetAddress serverAddress, int serverPort) {
        if (command.getTypeParameter() == TypeParameter.KEY || command.getTypeParameter() == TypeParameter.KEY_AND_MUSIC_BAND) {
            return commandWithKey(serverAddress, serverPort);
        }
        if (command instanceof ExecuteScript) {
            commandExecuteScript(serverAddress, serverPort);
        } else {
            return defoultCommand();
        }
        return null;
    }

    private Command commandWithKey(InetAddress serverAddress, int serverPort) {
        RequestingKeys.request(serverAddress, serverPort);
        command.executeReadParameters();
        return command;
    }

    private Command defoultCommand() {
        command.executeReadParameters();
        return command;
    }

    private void commandExecuteScript(InetAddress serverAddress, int serverPort) {
        ScriptExecutionRequests.executeScript(serverAddress, serverPort, command);
    }


}
