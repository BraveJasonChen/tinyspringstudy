package brave.chen.tinyspringstudy;

/**
 * 从配置中读取beanDefinition
 */
public interface BeanDefinitionReader {

    void loadBeanDefinations(String location) throws Exception;
}
