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
    /**
     * 懒汉模式  只有调用的时候才会去知道docreateBean方法可能会比较耗时
     * @throws Exception
     */
    @Test
    public void testLazy() throws Exception {
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
    /**
     * 饿汉模式  执行preInstantiateSingletons
     * @throws Exception
     */
    @Test
    public void testPreInstantiate() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinations("tinyioc.xml");

        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        ((AutowireCapableBeanFactory) beanFactory).preInstantiateSingletons();;

        HelloWorldService helloWorldService = (HelloWorldService)beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
