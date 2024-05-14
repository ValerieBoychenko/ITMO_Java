package commands;


import parameters.CommandValidator;
import parameters.TypeParameter;

import java.io.Serial;
import java.io.Serializable;


public class CountLessThanGenre extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 3L;

    public CountLessThanGenre() {
        super(TypeParameter.GENRE);
    }

    public void executeReadParameters() {
        parameter = CommandValidator.Validation(getTypeParameter());
    }
}

