package com.svg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.transform.stream.StreamResult;

import com.bo.Circle;
import com.bo.Figure;
import com.bo.Line;
import com.bo.Rectangle;

public class SvgWriter {
	private StringBuilder htmlBuilder;
	
	public void convert(File pFile, Figure figure) throws IOException{
		htmlBuilder = new StringBuilder();
		htmlBuilder.append("<html>");
		htmlBuilder.append("<head><title>Svg Format</title></head>");		
		htmlBuilder.append("<body>");
		htmlBuilder.append("<svg height='"+1000+"'  width='"+1000+"'>");
		for(Circle it : figure.getCircles()){
			  int x=it.getPb().getX();
			  int y=it.getPb().getY();
			  int w=it.getPb().getX()-it.getPa().getX();
			  int h=it.getPb().getY()-it.getPa().getY();
			  htmlBuilder.append("<circle cx='"+x+"' cy='"+y+"' r='"+h+"' stroke='green' stroke-width='4' fill='yellow' />");
		}
		for(Rectangle it : figure.getRectangles()){
			  int x=it.getPa().getX();
			  int y=it.getPa().getY();
			  int w=it.getWidth();
			  int h=it.getHeight();
			  htmlBuilder.append("<rect x='"+x+"' y='"+y+"' rx='"+0+"' ry='"+0+"' width='"+w+"' height='"+h+"' style='fill:red;stroke:black;stroke-width:5;opacity:0.5' />");
		}
		for(Line it : figure.getLines()){
			int x1=it.getPa().getX();
			int x2=it.getPb().getX();
			int y1=it.getPa().getY();
			int y2=it.getPb().getY();
			htmlBuilder.append("<line x1='"+x1+"' y1='"+y1+"' x2='"+x2+"' y2='"+y2+"' style='stroke:rgb(255,0,0);stroke-width:2' />");
		}
		htmlBuilder.append("</svg>");
		htmlBuilder.append("</body>");
		htmlBuilder.append("</html>");
		
		String html = htmlBuilder.toString();
	    //StreamResult result = new StreamResult(new File(pFile));
	     FileWriter f=new FileWriter(pFile);
	     f.write(html);
	     f.close();
	}
}
