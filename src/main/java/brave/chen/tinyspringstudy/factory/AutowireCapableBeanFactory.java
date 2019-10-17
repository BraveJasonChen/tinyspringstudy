package brave.chen.tinyspringstudy.factory;

import brave.chen.tinyspringstudy.BeanDefinition;
import brave.chen.tinyspringstudy.PropertyValue;

import java.lang.reflect.Field;

/**
 * @description: 自动创建
 * @author: brave.chen
 * @create: 2019-10-16 09:35
 **/
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doGetBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            Field declareField = bean.getClass().getDeclaredField(propertyValue.getName());
            declareField.setAccessible(true);
            declareField.set(bean,propertyValue.getValue());
        }
    }
}
