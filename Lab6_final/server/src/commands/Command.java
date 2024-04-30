package commands;

import commands.commandParameters.Parameter;
import exceptions.ConsoleOutputErrorException;
import handlers.MusicBandCollection;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;

public abstract class Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

    static public MusicBandCollection musicBands;
    protected Parameter parameter;
    abstract public String execute() throws ConsoleOutputErrorException, IOException;
}
