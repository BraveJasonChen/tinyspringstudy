package brave.chen.tinyspringstudy.factory;

import brave.chen.tinyspringstudy.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 抽象工厂
 * @author: brave.chen
 * @create: 2019-10-16 09:27
 **/
public abstract  class AbstractBeanFactory implements BeanFactory{
    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    @Override
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        Object bean = doGetBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(name,beanDefinition);
    }

    /**
     * 初始化bean
     * @param beanDefinition
     * @return
     */
    protected abstract Object doGetBean(BeanDefinition beanDefinition) throws Exception;


}
