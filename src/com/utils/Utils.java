package com.utils;

import com.bo.Line;
import com.bo.Point;

public class Utils {
	
	public static double distancePointLine(Point p, Line l){
		int x1=l.getPa().getX();
		int x2=l.getPb().getX();
		
		int y1=l.getPa().getY();
		int y2=l.getPb().getY();
		return (Math.abs((y2-y1)*p.getX()-(x2-x1)*p.getY()+x2*y1-y2*x1)/ Math.sqrt(Math.pow(y2-y1,2)+Math.pow(x2-x1,2)));
	}
}
