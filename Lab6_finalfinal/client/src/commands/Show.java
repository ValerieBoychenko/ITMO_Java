package commands;


import parameters.CommandValidator;
import parameters.TypeParameter;

import java.io.Serial;
import java.io.Serializable;


public class Show extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 16L;

    public Show() {
        super(TypeParameter.NONE);
    }

    public void executeReadParameters() {
        parameter = CommandValidator.Validation(getTypeParameter());
    }
}
