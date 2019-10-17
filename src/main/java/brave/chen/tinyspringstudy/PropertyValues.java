package brave.chen.tinyspringstudy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 包装一个对象所有的PropertyValue
 * @author: brave.chen
 * @create: 2019-10-16 19:20
 **/
public class PropertyValues {

    private HashSet<PropertyValue> propertyValueList = new HashSet<PropertyValue>();

    public PropertyValues() {
    }

    /**
     * 添加属性
     * @param propertyValue
     */
    public void addPropertyValue(PropertyValue propertyValue){
        //如果元素已经存在 那么就抛出异常，同一个属性无法赋值两次
        if(this.getPropertyValues().contains(propertyValue)){
            throw new RuntimeException("这个元素已经存在 无法add");
        }
        this.propertyValueList.add(propertyValue);
    }

    public HashSet<PropertyValue> getPropertyValues(){
        return this.propertyValueList;
    }
}
