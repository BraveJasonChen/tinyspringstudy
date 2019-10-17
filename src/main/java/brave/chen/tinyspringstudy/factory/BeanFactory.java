package brave.chen.tinyspringstudy.factory;

import brave.chen.tinyspringstudy.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 工厂
 * @author: brave.chen
 * @create: 2019-10-15 20:48
 **/
public interface BeanFactory {


    Object getBean(String name) throws Exception;

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
