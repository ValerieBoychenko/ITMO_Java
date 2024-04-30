package baseClass;


import org.json.simple.JSONObject;

import java.io.Serializable;
import java.util.Objects;

/**
 * Класс, представляющий музыкальный лейбл.
 */
public class Label implements Serializable {
    private Long bands;

    /**
     * Конструктор для создания объекта base_class.Label с указанием количества групп.
     * @param bands количество групп в лейбле
     * @throws NullPointerException если переданное значение bands равно null
     */
    public Label(Long bands) throws NullPointerException {
        this.bands = Objects.requireNonNull(bands, "Field cannot be null");
    }

    /**
     * Преобразует информацию о лейбле в JSON объект.
     * @return JSON объект с информацией о лейбле
     */
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("bands", this.bands);
        return json;
    }
}
