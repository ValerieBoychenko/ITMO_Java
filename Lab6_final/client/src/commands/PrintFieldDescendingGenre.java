package commands;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Команда для печати жанров музыкальных групп в порядке убывания.
 */
public class PrintFieldDescendingGenre extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 10L;
    public void executeReadParameters(){}
}
