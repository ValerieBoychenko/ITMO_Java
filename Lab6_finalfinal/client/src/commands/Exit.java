package commands;

import parameters.CommandValidator;
import parameters.TypeParameter;

import java.io.Serial;
import java.io.Serializable;

public class Exit extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 5L;

    public Exit() {
        super(TypeParameter.NONE);
    }

    public void executeReadParameters() {
        parameter = CommandValidator.Validation(getTypeParameter());
    }
}
