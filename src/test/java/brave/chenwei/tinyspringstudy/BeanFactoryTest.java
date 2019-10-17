package brave.chenwei.tinyspringstudy;

import brave.chen.tinyspringstudy.BeanDefinition;
import brave.chen.tinyspringstudy.PropertyValue;
import brave.chen.tinyspringstudy.PropertyValues;
import brave.chen.tinyspringstudy.factory.AutowireCapableBeanFactory;
import brave.chen.tinyspringstudy.factory.BeanFactory;
import brave.chen.tinyspringstudy.io.ResourceLoader;
import brave.chen.tinyspringstudy.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * @description: test
 * @author: brave.chen
 * @create: 2019-10-15 20:51
 **/
public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinations("tinyioc.xml");

        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }


        HelloWorldService helloWorldService = (HelloWorldService)beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
