package brave.chen.tinyspringstudy.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description: 这个是spring内部定位资源的接口
 * @author: brave.chen
 * @create: 2019-10-15 20:47
 **/
public interface Resource {

    InputStream getInputStream() throws IOException;
}
