package com.xml;

import com.bo.Circle;
import com.bo.Figure;
import com.bo.Line;
import com.bo.Rectangle;
import com.bo.Triangle;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlWriter {
	private Document doc;
									
	public void convert(String pFile, Figure figure) throws XmlException{
		try{
			DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
			doc=dBuilder.newDocument();
			Element rootElement=doc.createElement("figures");
			doc.appendChild(rootElement);

			if(figure.getLines()!=null){
					for(Line it: figure.getLines()){
						//ligne : <ligne>
						Element ligne=doc.createElement("ligne");
						// son point a : <point x="100" y="200" />
						Element pointA=doc.createElement("pointA");
						pointA.setAttribute("x",String.valueOf(it.getPa().getX()));
						pointA.setAttribute("y",String.valueOf(it.getPa().getY()));
						//son point b :  <point x="100" y="200" />
						Element pointB=doc.createElement("pointB");
						pointB.setAttribute("x",String.valueOf(it.getPb().getX()));
						pointB.setAttribute("y",String.valueOf(it.getPb().getY()));
						
						ligne.appendChild(pointA);
						ligne.appendChild(pointB);
						
						rootElement.appendChild(ligne);
					}
				}
				if(figure.getCircles()!=null){
						for(Circle it: figure.getCircles()){
						Element circle=doc.createElement("circle");
						Element pointA=doc.createElement("pointA");
						pointA.setAttribute("x",String.valueOf(it.getPa().getX()));
						pointA.setAttribute("y",String.valueOf(it.getPa().getY()));
						Element pointB=doc.createElement("pointB");
						pointB.setAttribute("x",String.valueOf(it.getPb().getX()));
						pointB.setAttribute("y",String.valueOf(it.getPb().getY()));
						circle.appendChild(pointA);
						circle.appendChild(pointB);
						rootElement.appendChild(circle);
					}
				}
				if(figure.getRectangles()!=null){
					for(Rectangle it: figure.getRectangles()){
					Element rectangle=doc.createElement("rectangle");
					Element pointA=doc.createElement("pointA");
					pointA.setAttribute("x",String.valueOf(it.getPa().getX()));
					pointA.setAttribute("y",String.valueOf(it.getPa().getY()));
					Element width=doc.createElement("width");
					width.setTextContent(String.valueOf(it.getWidth()));
					Element height=doc.createElement("height");
					height.setTextContent(String.valueOf(it.getHeight()));
					rectangle.appendChild(pointA);
					rectangle.appendChild(width);
					rectangle.appendChild(height);
					rootElement.appendChild(rectangle);		
				 }
				}
	         // write the content into xml file
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         StreamResult result = new StreamResult(new File(pFile));
	         transformer.transform(source, result);
	         
	         // Output to console for testing
	         StreamResult consoleResult = new StreamResult(System.out);
	         transformer.transform(source, consoleResult);
		}catch(Exception ex){
			throw new XmlException(ex);
		}

	}
	
}
