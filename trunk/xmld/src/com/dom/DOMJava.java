package com.dom;

import java.io.*; 
import org.w3c.dom.*; 
import javax.xml.parsers.*; 

/**
 * @Title: DOMJave.java
 * @Package com.dom
 * @company： 广东科贸职业学院软件工作室
 * @Description: TODO
 * @author shaoguangzheng
 * @date 2012-9-17 上午2:06:10
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
				System.out.print("车牌号码:"
						+ doc.getElementsByTagName("NO").item(i)
								.getFirstChild().getNodeValue());
				System.out.println(" 车主地址:"
						+ doc.getElementsByTagName("ADDR").item(i)
								.getFirstChild().getNodeValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("运行时间：" + (System.currentTimeMillis() - lasting)
				+ " 毫秒");
	}
}
