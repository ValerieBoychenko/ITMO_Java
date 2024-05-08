package modules;

import commands.*;
import commands.auxiliaryCommands.InfoAboutKeyCollection;
import commands.commandStatus.CommandStatus;
import commands.specialCommands.ExecuteScript;
import exceptions.ConsoleOutputErrorException;
import parser.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientManager {
    private Command command;
    public ClientManager(Command command){
        this.command = command;
    }

    public CommandStatus handler(DatagramSocket clientSocket, InetAddress serverAddress, int serverPort){
        if (command instanceof RemoveKey || command instanceof RemoveGreater || command instanceof RemoveLowerKey ||
                command instanceof ReplaceIfGreater || command instanceof Update) {
            commandWithKey(clientSocket, serverAddress, serverPort);
            return CommandStatus.PARAMETERS_ARE_RECEIVED;
        }
        if (command instanceof ExecuteScript){
            commandExecuteScript(clientSocket, serverAddress, serverPort);
            return CommandStatus.PARAMETERS_ARE_RECEIVED;
        }
        return CommandStatus.NO_PARAMETERS;
    }

    private void commandWithKey(DatagramSocket clientSocket, InetAddress serverAddress, int serverPort) {
        Command commandTwo = new InfoAboutKeyCollection();
        try {
            new SendCommand().sending(commandTwo, serverAddress, clientSocket, serverPort);
            new ServerResponse().response(clientSocket);
            command.executeReadParameters();
            new SendCommand().sending(command, serverAddress, clientSocket, serverPort);
            new ServerResponse().response(clientSocket);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void commandExecuteScript(DatagramSocket clientSocket, InetAddress serverAddress, int serverPort){
        String fileName = ((ExecuteScript) command).getFileName();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String newCommand;
            Parser parser = new Parser();
            while ((newCommand = br.readLine()) != null) {
                Command finalCommand = parser.parsing(newCommand);
                finalCommand.executeReadParameters();
                new SendCommand().sending(finalCommand, serverAddress, clientSocket, serverPort);
                new ServerResponse().response(clientSocket);
            }
        } catch (IOException | ConsoleOutputErrorException | NullPointerException | ClassNotFoundException e) {
            e.getMessage();
        }
    }


}
