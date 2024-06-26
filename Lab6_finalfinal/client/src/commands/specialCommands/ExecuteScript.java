package commands.specialCommands;


import commands.Command;
import parameters.TypeParameter;

import java.io.*;


public class ExecuteScript extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 4L;

    private final String fileName;

    public ExecuteScript(String fileName){
        super(TypeParameter.NONE);
        this.fileName = fileName;
    }

    public void executeReadParameters(){}

    public String getFileName() {
        return fileName;
    }
}
