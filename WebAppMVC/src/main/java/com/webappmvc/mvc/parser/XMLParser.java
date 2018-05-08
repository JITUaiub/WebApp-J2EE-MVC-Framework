package com.webappmvc.mvc.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
/**
 * Parse XML file of Client project from WEB-INF/WebAppmvc-mappings.XML file
 * 
 * @author Md. Nashid Kamal
 * @version 1.0
 */
public class XMLParser {
	private static HashMap<Integer, MVCModule> map = new HashMap<Integer, MVCModule>();
	private int mapID;
	/**
	 * Default Constructor
	 */
	public XMLParser() {
		mapID = 0;
	}
	/**
	 * parse XML data and add it to {@link HashMap}<{@link Integer},{@link MVCModule}> object 
	 * 
	 * @param request - an HttpServletResponse object that contains the response the servlet sends to the client.
	 */
	private void parseXML(HttpServletRequest request) {
		InputStream iStream = request.getServletContext().getResourceAsStream("WEB-INF/webappmvc-mappings.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document document;
		try {
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			document = (Document) documentBuilder.parse(new InputSource(iStream));
			document.getDocumentElement().normalize();
			
			NodeList nList = document.getElementsByTagName("module");
			for (int temp = 0; temp < nList.getLength(); temp++) {
	               Node nNode = nList.item(temp);

	               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	                  Element eElement = (Element) nNode;
	                  String model = eElement.getElementsByTagName("model").item(0).getTextContent().toString();
	                  String view = eElement.getElementsByTagName("view").item(0).getTextContent().toString();
	                  String mapping = eElement.getElementsByTagName("mapping").item(0).getTextContent().toString();
	                  if (model == null) model = "empty";
	                  if(view == null) view = "empty";
	                  if(mapping == null) mapping = "empty";
	                  map.put(mapID++, new MVCModule(model, view, mapping));
	               }
	            }
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
	/**
	 * call {@link XMLParser#parseXML(HttpServletRequest)} and return {@link HashMap}<{@link Integer},{@link MVCModule}> object 
	 * 
	 * @param request - an HttpServletResponse object that contains the response the servlet sends to the client.
	 * @return {@link HashMap}<{@link Integer},{@link MVCModule}> object 
	 */
	public HashMap<Integer, MVCModule> getMap(HttpServletRequest request) {
		parseXML(request);
		return map;
	}
}
