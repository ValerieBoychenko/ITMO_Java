package commands.auxiliaryCommands.parameters;

import java.io.Serializable;

public record StringParameters(String parameter) implements Parameter, Serializable {
    public void getParameters(){
        System.out.println("parameter: " + parameter);
    }
}
