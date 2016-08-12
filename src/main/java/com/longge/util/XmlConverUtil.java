package com.longge.util;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


public class XmlConverUtil {
	
	//mapתXML
	public static String map2Xml(Map map) {
		Document document = DocumentHelper.createDocument();
		Element nodeElement = document.addElement("nodes");
		for(Object obj:map.keySet()) {
			Element keyElement = nodeElement.addElement("key");
			keyElement.addAttribute("label", String.valueOf(obj));
			keyElement.setText(String.valueOf(map.get(obj)));
		}
		return doc2String(document);
	}
	//list��Ԫ��Ϊmap  ���mapתXML
	public static String list2Xml(List list) {
		Document document = DocumentHelper.createDocument();
		Element nodesElement = document.addElement("nodes");
		for(Object o:list) {
			Element nodeElement = nodesElement.addElement("node");
			for(Object obj:((Map)o).keySet()) {
				Element keyElement = nodeElement.addElement("key");
				keyElement.addAttribute("label", String.valueOf(obj));
				keyElement.setText(String.valueOf(((Map)o).get(obj)));
			}
		}
		return doc2String(document);
	}
	//�����ת��Ϊstring
	private static String doc2String(Document document) {
		String s = "";
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			OutputFormat format = new OutputFormat("",true,"UTF-8");
			XMLWriter writer = new XMLWriter(out,format);
			writer.write(document);
			s = out.toString("UTF-8");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	//JSONתXML
//	public static String json2Xml(String json) {
//		try{
//			XMLSerializer serializer = new XMLSerializer();
//			JSON jsonObject = JSONSerializer.toJSON(json);
//			return serializer.write(jsonObject);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	//XMLתJSON
//	public static String xml2Json(String xml) {
//		XMLSerializer xmlSerializer = new XMLSerializer();
//		return xmlSerializer.read(xml).toString();
//	}
	//XMLתmap
	public static Map xml2Map(String xml) {
		try {
			Map map = new HashMap();
			Document document = DocumentHelper.parseText(xml);
			Element nodeElement = document.getRootElement();
			List node = nodeElement.elements();
			for(Iterator it = node.iterator();it.hasNext();) {
				Element elm = (Element)it.next();
				map.put(elm.attributeValue("label"), elm.getText());
				elm = null;
			}
			node = null;
			nodeElement = null;
			document = null;
			return map;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//XMLתlist
	public static List xml2List(String xml) {
		try {
			List<Map> list = new ArrayList<Map>();
			Document document = DocumentHelper.parseText(xml);
			Element nodesElement = document.getRootElement();
			List nodes = nodesElement.elements();
			for(Iterator its = nodes.iterator();its.hasNext();) {
				Element nodeElement = (Element)its.next();
				Map map = xml2Map(nodeElement.asXML());
				list.add(map);
				map = null;
			}
			nodes = null;
			nodesElement = null;
			document = null;
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//test
	public static void main(String[] args) {
		XmlConverUtil util = new XmlConverUtil();
		Map map = new HashMap();
		map.put("�㽭", "����");
		map.put("�ӱ�", "����");
		map.put("�㶫", "����");
		map.put("����", "�Ͼ�");
		Map map2 = new HashMap();
		map2.put("����", "�Ϸ�");
		map2.put("����", "����");
		map2.put("ɽ��", "����");
		map2.put("ɽ��", "̫ԭ");
		List list = new ArrayList();
		list.add(map);
		list.add(map2);
//		System.out.println(util.map2Xml(map));
		System.out.println(util.list2Xml(list));
		
	}
	
	
}
