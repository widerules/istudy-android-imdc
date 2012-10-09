package com;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @Title: XmlDemo.java
 * @Package com
 * @company： 广东科贸职业学院软件工作室
 * @Description: TODO
 * @author shaoguangzheng
 * @date 2012-9-16 下午8:19:08
 * @version V1.0
 */
public class XmlDemoActivity implements XmlDocment {
	private Document document;
	private String fileName;

	public void init() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			this.document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createXml(String fileName) {
		Element root= this.document.createElement("employees");
		this.document.appendChild(root);
		Element employee = this.document.createElement("employee");
		Element name = this.document.createElement("name");
		name.appendChild(this.document.createTextNode("shao"));
		employee.appendChild(name);
		Element sex = this.document.createElement("sex");
		employee.appendChild(sex);
		Element age = this.document.createElement("age");
		age.appendChild(this.document.createTextNode("30"));
		employee.appendChild(age);
		root.appendChild(employee);
		TransformerFactory tf = TransformerFactory.newInstance();
		try {
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
			StreamResult result = new StreamResult(pw);
			transformer.transform(source, result);
			System.out.println("生成xml成功");
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void parserXml(String fileName) {

	try {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(fileName);
		NodeList doc = document.getChildNodes();
		for(int i=0;i<doc.getLength();i++){
			Node node = doc.item(i);
			NodeList nodelist  = node.getChildNodes();
			for(int j =0;j<nodelist.getLength();j++){
				System.out.println("=="+nodelist.item(j).getNodeName());
			}
		}
		System.out.println("=====解析完毕====");
	} catch (ParserConfigurationException e) {
		e.printStackTrace();
	} catch (SAXException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
