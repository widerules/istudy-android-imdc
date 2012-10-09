package com.dom;

import java.io.*; 
import org.w3c.dom.*; 
import javax.xml.parsers.*; 

/**
 * @Title: DOMJave.java
 * @Package com.dom
 * @company�� �㶫��óְҵѧԺ���������
 * @Description: TODO
 * @author shaoguangzheng
 * @date 2012-9-17 ����2:06:10
 * @version V1.0
 */

public class DOMJava {

	public static void main(String arge[]) {
		long lasting = System.currentTimeMillis();
		try {
			File f = new File("data.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			NodeList nl = doc.getElementsByTagName("VALUE");
			for (int i = 0; i < nl.getLength(); i++) {
				System.out.print("���ƺ���:"
						+ doc.getElementsByTagName("NO").item(i)
								.getFirstChild().getNodeValue());
				System.out.println(" ������ַ:"
						+ doc.getElementsByTagName("ADDR").item(i)
								.getFirstChild().getNodeValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("����ʱ�䣺" + (System.currentTimeMillis() - lasting)
				+ " ����");
	}
}
