package cn.demo02;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class HomeWork {
	
//	public static void main(String[] args) {
//		
//	}
	@Test
	public void myTest() {
		
		SAXReader saxReader = new SAXReader();
		try {
			Document read = saxReader.read("src\\cn\\demo02\\MyXml.xml");
			Element rootElement = read.getRootElement();
			List<Element> elements = rootElement.elements();
			for (Element element : elements) {
				if(element.getName()=="servlet") {
					System.out.println(element.element("servlet-name").getText());
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
