package commands;

import parameters.Parameters;
import parameters.TypeParameter;

import java.io.Serial;
import java.io.Serializable;

public abstract class Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

    protected Parameters parameter;
    private final TypeParameter typeParameter;

    public Command(TypeParameter typeParameter) {
        this.typeParameter = typeParameter;
    }

    abstract public void executeReadParameters();

    public void setParameter(Parameters parameter) {
        this.parameter = parameter;
    }

    public TypeParameter getTypeParameter() {
        return typeParameter;
    }
}
