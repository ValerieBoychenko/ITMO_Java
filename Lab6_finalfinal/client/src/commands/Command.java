package commands;

import parameters.ParametersRequest;
import parameters.TypeParameter;

import java.io.Serial;
import java.io.Serializable;

public abstract class Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

    protected ParametersRequest parameter;
    private final TypeParameter typeParameter;

    public Command(TypeParameter typeParameter) {
        this.typeParameter = typeParameter;
    }

    abstract public void executeReadParameters();

    public void setParameter(ParametersRequest parameter) {
        this.parameter = parameter;
    }

    public TypeParameter getTypeParameter() {
        return typeParameter;
    }
}
