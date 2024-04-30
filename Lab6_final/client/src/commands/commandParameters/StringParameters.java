package commands.commandParameters;

import java.io.Serializable;

public record StringParameters(String parameter) implements Parameter, Serializable {
    public void getParameters(){
        System.out.println("parameter: " + parameter);
    }
}
