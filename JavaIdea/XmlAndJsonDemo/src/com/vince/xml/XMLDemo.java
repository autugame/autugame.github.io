package com.vince.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3DomDriver;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class XMLDemo {

    @Test
    public void xStream() {
        Person p = new Person();
        p.setPersonid("1212");
        p.setAddress("北京");
        p.setEmail("vince@163.com");
        p.setFax("70137409723094");
        p.setTel("173812374897");
        p.setName("38");
        XStream xStream = new XStream(new Xpp3DomDriver());
        xStream.alias("person", Person.class);
        xStream.useAttributeFor(Person.class, "personid");
        String s = xStream.toXML(p);
        System.out.println(s);

        Person person = (Person) xStream.fromXML(s);
        System.out.println(person);
    }

    @Test
    public void xmlDeCoder() throws FileNotFoundException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("text.xml"));
        XMLDecoder decoder = new XMLDecoder(in);
        Person person = (Person) decoder.readObject();
        System.out.println(person);
    }

    @Test
    public void xmlEnCoder() throws FileNotFoundException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("text.xml"));
        XMLEncoder xmlEncoder = new XMLEncoder(bos);
        Person p = new Person();
        p.setPersonid("1212");
        p.setAddress("北京");
        p.setEmail("vince@163.com");
        p.setFax("70137409723094");
        p.setTel("173812374897");
        p.setName("38");
        xmlEncoder.writeObject(p);
        xmlEncoder.close();
        System.out.println("对象写入成功");
    }

    @Test
    public void dom4j() throws DocumentException {
        SAXReader reader = new SAXReader();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/xml/person.xml");
        org.dom4j.Document doc = reader.read(is);
        org.dom4j.Element rootElement = doc.getRootElement();
        Iterator<org.dom4j.Element> iterator = rootElement.elementIterator();
        ArrayList<Person> persons = new ArrayList<>();
        Person p = null;
        while (iterator.hasNext()) {
            p = new Person();
            org.dom4j.Element e = iterator.next();
            p.setPersonid(e.attributeValue("personid"));
            Iterator<org.dom4j.Element> iterator1 = e.elementIterator();
            while (iterator1.hasNext()) {
                org.dom4j.Element next = iterator1.next();
                String tag = next.getName();
                if ("name".equals(tag)) {
                    p.setName(next.getText());
                } else if ("address".equals(tag)) {
                    p.setAddress(next.getText());
                } else if ("tel".equals(tag)) {
                    p.setTel(next.getText());
                } else if ("fax".equals(tag)) {
                    p.setFax(next.getText());
                } else if ("email".equals(tag)) {
                    p.setEmail(next.getText());
                }
            }
            persons.add(p);
        }
        System.out.println(Arrays.toString(persons.toArray()));
    }

    @Test
    public void jdonParseXML() throws IOException, JDOMException {
        //创建JDOM解析器
        SAXBuilder builder = new SAXBuilder();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/xml/person.xml");
        org.jdom2.Document build = builder.build(is);
        Element rootElement = build.getRootElement();
        List<Person> list = new ArrayList<>();
        Person person = null;
        List<Element> children = rootElement.getChildren();
        for (Element element : children) {
            person = new Person();
            String personid = element.getAttributeValue("personid");
            person.setPersonid(personid);
            List<Element> children1 = element.getChildren();
            for (Element e : children1) {
                String name = e.getName();
                if ("name".equals(name)) {
                    person.setName(e.getText());
                } else if ("address".equals(name)) {
                    person.setAddress(e.getText());
                } else if ("tel".equals(name)) {
                    person.setTel(e.getText());
                } else if ("fax".equals(name)) {
                    person.setFax(e.getText());
                } else if ("email".equals(name)) {
                    person.setEmail(e.getText());
                }
            }
            list.add(person);
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    @Test
    public void domParseXML() throws ParserConfigurationException, IOException, SAXException {
        //1.创建一个DOM解析器工厂对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //2.通过工厂对象生成解析器对象
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        //3.解析文档
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/xml/person.xml");
        Document doc = documentBuilder.parse(is);
        //4.从内存中读取数据
        NodeList personNodeList = doc.getElementsByTagName("person");
        ArrayList<Person> persons = new ArrayList<>();
        Person p = null;
        for (int i = 0; i < personNodeList.getLength(); i++) {
            Node personNode = personNodeList.item(i);
            p = new Person();
            String personid = personNode.getAttributes().getNamedItem("personid").getNodeValue();
            p.setPersonid(personid);
            NodeList childNodes = personNode.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node item = childNodes.item(j);
                String nodeName = item.getNodeName();
                if ("name".equals(nodeName)) {
                    p.setName(item.getFirstChild().getNodeValue());
                } else if ("address".equals(nodeName)) {
                    p.setAddress(item.getFirstChild().getNodeValue());
                } else if("tel".equals(nodeName)) {
                    p.setAddress(item.getFirstChild().getNodeValue());
                } else if("fax".equals(nodeName)) {
                    p.setAddress(item.getFirstChild().getNodeValue());
                } else if("email".equals(nodeName)) {
                    p.setAddress(item.getFirstChild().getNodeValue());
                }
            }
            persons.add(p);
        }
        System.out.println("结果");
        System.out.println(Arrays.toString(persons.toArray()));
    }

    @Test
    public void saxParseXML() {
        //1.创建一个sax解析器工厂对象
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        //2.通过工厂对象创建SAX解析器
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            //3.创建一个数据处理器
            PersonHandler personHandler = new PersonHandler();
            //4.开始解析
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/xml/person.xml");
            saxParser.parse(is, personHandler);
            List<Person> persons = personHandler.getPersons();
            for (Person p : persons) {
                System.out.println(p);
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
