package commands;

import exceptions.ConsoleOutputErrorException;
import collectionHandler.MusicBandCollection;
import parameters.ParametersRequest;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;

public abstract class Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

    static public MusicBandCollection musicBands;
    protected ParametersRequest parameter;
    abstract public String execute() throws ConsoleOutputErrorException, IOException;
}
