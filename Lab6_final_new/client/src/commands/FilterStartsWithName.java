package commands;

import parameters.CommandValidator;
import parameters.TypeParameter;

import java.io.Serial;
import java.io.Serializable;


public class FilterStartsWithName extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 6L;

    public void executeReadParameters(){parameter = CommandValidator.Validation(TypeParameter.NAME);}
}
