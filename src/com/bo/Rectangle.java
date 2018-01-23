package com.bo;

import java.util.ArrayList;
import java.util.List;

public class Rectangle {
	private String id;
	private Point pa;
	private int width;
	private int height;
	private List<String> comments=new ArrayList<String>();
	
	public Rectangle() {
		super();
	}	
	public Rectangle(Point pa,int width, int height) {
		super();
		this.pa = pa;
		this.width=width;
		this.height=height;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Point getPa() {
		return pa;
	}
	public void setPa(Point pa) {
		this.pa = pa;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Rectangle [id=" + id + ", pa=" + pa + ", width=" + width + ", height=" + height + ", comments="
				+ comments + "]";
	}

}
