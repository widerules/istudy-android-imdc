package com;

/**
 * @Title: XmlDocment.java
 * @Package org.com.ksda.dao
 * @company： 广东科贸职业学院软件工作室
 * @Description: TODO
 * @author shaoguangzheng
 * @date 2012-9-16 下午8:08:30
 * @version V1.0
 */
public interface XmlDocment {
	/**
	 * 
	* @Title: createXml
	* @Description: 建立xml文档
	* @param @param fileName    
	* @return void    
	* @throws
	 */
	public void createXml(String fileName);
	/**
	 * 
	* @Title: parserXml
	* @Description: 解析xml文档
	* @param @param fileName    
	* @return void    
	* @throws
	 */
	public void parserXml(String fileName);
}
