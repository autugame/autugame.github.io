package com.vince.aop;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class BeanFactory {
    Properties prop = new Properties();
    public BeanFactory(InputStream in) {
        try {
            prop.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Object getBean(String name) {
        String className = prop.getProperty(name);
        Object bean = null;
        try {
            Class<?> aClass = Class.forName(className);
            bean = aClass.newInstance();
            Object target = Class.forName(prop.getProperty(name + ".target")).newInstance();
            Object advice = Class.forName(prop.getProperty(name + ".advice")).newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : propertyDescriptors) {
                String PropertyName = pd.getName();
                Method writeMethod = pd.getWriteMethod();
                if ("target".equals(PropertyName)) {
                    writeMethod.invoke(bean, target);
                } else if("advice".equals(PropertyName)) {
                    writeMethod.invoke(bean, advice);
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return bean;
    }
}
