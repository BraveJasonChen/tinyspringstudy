package brave.chenwei.tinyspringstudy;

/**
 * @description: helloWorld
 * @author: brave.chen
 * @create: 2019-10-15 20:49
 **/
public class HelloWorldService {

    private String text;

    private OutputService outputService;

    public void helloWorld(){
        outputService.output(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }

    public OutputService getOutputService() {
        return outputService;
    }
}
