package com.vince.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class PersonHandler extends DefaultHandler {
    private List<Person> persons = null;
    private Person p;//当前正在解析的对象
    private String tag;//用于记录当前正在解析的标签名

    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        persons = new ArrayList<>();
        System.out.println("开始解析文档...");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("文档解析完毕...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if ("person".equals(qName)) {
            p = new Person();
            String personid = attributes.getValue("personid");
            p.setPersonid(personid);
        }
        tag = qName;
        //System.out.println("startElement" + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if ("person".equals(qName)) {
            persons.add(p);
        }
        tag = null;
        //System.out.println("endElement" + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (tag != null) {
            if ("name".equals(tag)) {
                p.setName(new String(ch, start, length));
            } else if("address".equals(tag)) {
                p.setAddress(new String(ch, start, length));
            } else if("tel".equals(tag)) {
                p.setTel(new String(ch, start, length));
            } else if("fax".equals(tag)) {
                p.setFax(new String(ch, start, length));
            } else if("email".equals(tag)) {
                p.setEmail(new String(ch, start, length));
            }
            //System.out.println(ch);
        }
    }
}
