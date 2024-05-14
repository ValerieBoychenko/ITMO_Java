package commands;

import parameters.CommandValidator;
import parameters.TypeParameter;

import java.io.Serial;
import java.io.Serializable;


public class Update extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 17L;

    public Update() {
        super(TypeParameter.KEY_AND_MUSIC_BAND);
    }

    public void executeReadParameters() {
        parameter = CommandValidator.Validation(getTypeParameter());
    }
}
