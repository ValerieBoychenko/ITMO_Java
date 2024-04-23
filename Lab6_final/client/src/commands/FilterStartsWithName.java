package commands;



import parser.ManualInput;

import java.io.Serial;


public class FilterStartsWithName extends Command {
    String name;
    @Serial
    private static final long serialVersionUID = 6L;
    public void executeReadParameters(){
        System.out.println("Enter name: ");
        this.name = new ManualInput().nextLine();
    }
}

