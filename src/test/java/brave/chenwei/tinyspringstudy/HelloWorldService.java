package brave.chenwei.tinyspringstudy;

/**
 * @description: helloWorld
 * @author: brave.chen
 * @create: 2019-10-15 20:49
 **/
public class HelloWorldService {

    private String text;

    public void helloWorld(){
        System.out.println("text");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
