package brave.chen.tinyspringstudy.factory;

import brave.chen.tinyspringstudy.BeanDefinition;
import brave.chen.tinyspringstudy.BeanReference;
import brave.chen.tinyspringstudy.PropertyValue;

import java.lang.reflect.Field;

/**
 * @description: 自动创建
 * @author: brave.chen
 * @create: 2019-10-16 09:35
 **/
public class AutowireCapableBeanFactory extends AbstractBeanFactory {


    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            Field declareField = bean.getClass().getDeclaredField(propertyValue.getName());
            declareField.setAccessible(true);
            Object value = propertyValue.getValue();
            if( value instanceof BeanReference){
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            declareField.set(bean,value);
        }
    }

    /**
     * 创建一个bean分为两步
     * 1.创建class
     * 2.属性赋值
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean  = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean,beanDefinition);
        return bean;
    }
}
