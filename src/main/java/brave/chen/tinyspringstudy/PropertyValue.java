package brave.chen.tinyspringstudy;

import java.util.Objects;

/**
 * @description: 用于bean的属性注入
 * @author: brave.chen
 * @create: 2019-10-16 19:19
 **/
public class PropertyValue {
    private String name;
    private Object value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropertyValue)) return false;
        PropertyValue that = (PropertyValue) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
