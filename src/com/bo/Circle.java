package com.bo;

import java.util.ArrayList;
import java.util.List;

public class Circle {
	private String id;
	private Point pa;
	private Point pb;
	private List<String> comments=new ArrayList<String>();
	
	
	public Circle() {
		super();
	}	
	public Circle(Point pa, Point pb) {
		super();
		this.pa = pa;
		this.pb = pb;
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
	public Point getPb() {
		return pb;
	}
	public void setPb(Point pb) {
		this.pb = pb;
	}
	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Circle [id=" + id + ", pa=" + pa + ", pb=" + pb + ", comments=" + comments + "]";
	}
	
	

}
