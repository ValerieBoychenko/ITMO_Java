package commands;

import commands.commandParameters.Parameter;

import java.io.Serial;
import java.io.Serializable;

public abstract class Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

    protected Parameter parameter;

    abstract public void executeReadParameters();

}
