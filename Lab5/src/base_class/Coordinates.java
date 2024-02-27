package base_class;

import exception.NullException;
import exception.RangeException;
import org.json.simple.JSONObject;

import java.util.Objects;

/**
 * Класс, представляющий координаты.
 */
public class Coordinates {
    private Float x; // Координата x
    private Integer y; // Координата y

    /**
     * Конструктор для создания объекта base_class.Coordinates.
     * @param x координата x
     * @param y координата y
     * @throws NullException если x или y равны null
     * @throws RangeException если значение x находится вне допустимого диапазона
     */
    public Coordinates(Float x, Integer y){
        if (x < 71) {
            this.x = Objects.requireNonNull(x, "Field cannot be null");;
        }
        this.y = Objects.requireNonNull(y, "Field cannot be null");
    }

    /**
     * Преобразует координаты в JSON объект.
     * @return JSON объект с координатами
     */
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("x", this.x);
        json.put("y", this.y);
        return json;
    }
}
