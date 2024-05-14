package network;

import commands.Command;
import parameters.ParametersRequest;

import java.io.Serial;
import java.io.Serializable;

public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = 88L;
    private Command command;
    public Request(Command command) {
        this.command = command;
    }
    public Command getCommand() {
        return command;
    }
}
