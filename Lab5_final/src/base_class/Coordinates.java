package base_class;

import org.json.simple.JSONObject;

import java.util.Objects;

/**
 * Класс, представляющий координаты.
 */
public class Coordinates {
    private Float x;
    private Integer y;

    /**
     * Конструктор для создания объекта base_class.Coordinates.
     * @param x координата x
     * @param y координата y
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
