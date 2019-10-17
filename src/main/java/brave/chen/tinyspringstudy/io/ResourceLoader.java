package brave.chen.tinyspringstudy.io;

import java.net.URL;

/**
 * @description: 资源loader
 * @author: brave.chen
 * @create: 2019-10-17 08:53
 **/
public class ResourceLoader {

    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return  new UrlResource(resource);
    }
}
