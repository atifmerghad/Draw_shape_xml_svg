package com.bo;

import java.util.ArrayList;
import java.util.List;

public class Figure {
	private List<Line> lines=new ArrayList<>();
	private List<Circle> circles=new ArrayList<>();
	private List<Rectangle> rectangles=new ArrayList<>();
	private List<Triangle> triangles=new ArrayList<>();
	
	public void add(Line l){
		lines.add(l);
	}
	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}
	public void add(Circle c){
		circles.add(c);
	}
	public List<Circle> getCircles() {
		return circles;
	}

	public void setCircles(List<Circle> circles) {
		this.circles = circles;
	}
	public void add(Rectangle r){
		rectangles.add(r);
	}
	public List<Rectangle> getRectangles() {
		return rectangles;
	}

	public void setRectangles(List<Rectangle> rectangles) {
		this.rectangles = rectangles;
	}
	
	public void add(Triangle t){
		triangles.add(t);
	}
	public List<Triangle> getTriangles() {
		return triangles;
	}
	public void setTriangles(List<Triangle> triangles) {
		this.triangles = triangles;
	}

}
