package exception;

import commands.Command;
/**
 * Исключение, возникающее при выполнении команды.
 */
public class CommandException extends Exception {
    /**
     * Конструктор класса.
     *
     * @param command команда, вызвавшая исключение
     */
    public CommandException(Command command) {
        super(command.toString());
    }
}
