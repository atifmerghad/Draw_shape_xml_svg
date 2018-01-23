package com.bo;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private String id;
	private Point pa;
	private Point pb;
	private List<String> comments=new ArrayList<String>();
	
	public Line() {
		super();
	}
	public Line(Point pa, Point pb) {
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
	public void addComments(String comment){
		comments.add(comment);
	}
	public String getComments(){
		StringBuffer bs=new StringBuffer();
		for(String it : comments){
			bs.append(it);
			bs.append(" | ");
		}
		return bs.toString();
	}
	@Override
	public String toString() {
		return "Line [id=" + id + ", pa=" + pa + ", pb=" + pb + "]";
	}

}
