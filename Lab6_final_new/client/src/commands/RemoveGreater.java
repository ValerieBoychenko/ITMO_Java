package commands;

import parameters.CommandValidator;
import parameters.TypeParameter;

import java.io.Serial;
import java.io.Serializable;

public class RemoveGreater extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 11L;

    public void executeReadParameters(){parameter = CommandValidator.Validation(TypeParameter.KEY);}
}
