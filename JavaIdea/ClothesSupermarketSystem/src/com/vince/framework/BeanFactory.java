package com.vince.framework;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class BeanFactory {
    private Iterator<Element> iterator;
    public static BeanFactory beanFactory = null;

    public static BeanFactory init() {
        beanFactory = new BeanFactory("bean.xml");
        return beanFactory;
    }

    private BeanFactory(String xml) {
//        System.out.println("不允许创建对象");
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(xml);
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(is);
            Element rootElement = document.getRootElement();
            iterator = rootElement.elementIterator();
            is.close();
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Object getBean(String id) {
        while (iterator.hasNext()) {
            Element bean = iterator.next();
            String sid = bean.attributeValue("id");
            if (sid.equals(id)) {
                String className = bean.attributeValue("class");
                try {
                    return Class.forName(className).newInstance();
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }
}
