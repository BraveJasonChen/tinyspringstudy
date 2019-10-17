package brave.chen.tinyspringstudy;

/**
 * @description: 只是为了标记ref 可以不用 需要其他标记手段
 * @author: brave.chen
 * @create: 2019-10-15 20:47
 **/
public class BeanReference {
    private String name;

    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
