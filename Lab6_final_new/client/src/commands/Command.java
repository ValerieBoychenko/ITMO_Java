package commands;

import parameters.ParametersRequest;

import java.io.Serial;
import java.io.Serializable;

public abstract class Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

    protected ParametersRequest parameter;

    abstract public void executeReadParameters();

}
