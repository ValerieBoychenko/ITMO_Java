import commands.CountLessThanGenre;
import commands.Save;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        var parser = new handlers.Parser(env.get("FILE_PATH"));
        parser.start();
    }
}
