package com.gui;
import java.util.List;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.bo.Circle;
import com.bo.Figure;
import com.bo.Line;
import com.bo.Point;
import com.bo.Rectangle;
import com.utils.Utils;

public class PaintPanel extends JPanel{

	private Figure figure= new Figure();
	public Figure getFigure() {
		return figure;
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}

	private boolean drawMode=true;
	private Line selectedLine;
	private static Line ld;
	
	public PaintPanel(MainFrame parent){
		addMouseListener(new MouseAdapter() {
			Point pointA=null;
			Point pointB=null;
			@Override
			public void mouseReleased(MouseEvent e) {
				Line lineDistanceMin = null;
				pointB=new Point(e.getX(),e.getY());
				if(drawMode){
					String value =parent.getCb().getSelectedItem().toString();
					if (value.equals("Line")){
						System.out.println("add line");
						figure.getLines().add(new Line(pointA,pointB)); 
	                }
					else if(value.equals("Circle")){
						System.out.println("add circle");
						figure.getCircles().add(new Circle(pointA,pointB));
					}
					else if(value.equals("Rectangle")){
						System.out.println("add Rectabgle");
						 int width=pointB.getX()-pointA.getX();
						 int height=pointB.getY()-pointA.getY();
						figure.getRectangles().add(new Rectangle(pointA,width, height));
					}
					else{
						//figure.getTriangles().add(new Triangle(pointA,pointB));
					}
					repaint();					
				}
				else{
					if(figure.getLines().size()!=0){
						lineDistanceMin=figure.getLines().get(0);
						for(Line it : figure.getLines()){
							if(Utils.distancePointLine(pointB,it)<Utils.distancePointLine(pointB,lineDistanceMin)){
								lineDistanceMin=it;
							}
						}
					}
					selectedLine=lineDistanceMin;
					String comment=JOptionPane.showInputDialog("Entrer votre commentaire");
					selectedLine.addComments(comment);
					parent.writeInCommentsLabel(getSelectedLine().getComments());
				}

			}
			@Override
			public void mousePressed(MouseEvent e) {
				pointA=new Point(e.getX(),e.getY());
			}
		});
	}
	
	public void drawLines(Graphics g){
		for(Line it : figure.getLines()){
			g.drawLine(it.getPa().getX(), it.getPa().getY(), it.getPb().getX(), it.getPb().getY());
		}
	}
	public void drawCircles(Graphics g){
		for(Circle it : figure.getCircles()){
			int ray=(int) Math.sqrt(Math.pow(it.getPa().getX()-it.getPb().getX(), 2)+Math.pow(it.getPa().getY()-it.getPb().getY(), 2));
			 g.drawOval(it.getPa().getX(), it.getPa().getY(),ray,ray);
		}
	}
	public void drawRectangles(Graphics g){
		for(Rectangle it : figure.getRectangles()){
			 g.drawRect(it.getPa().getX(), it.getPa().getY(),it.getWidth(),it.getHeight());
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawLines(g);
		drawCircles(g);
		drawRectangles(g);
	}

	public boolean isDrawMode() {
		return drawMode;
	}

	public void setDrawMode(boolean drawMode) {
		this.drawMode = drawMode;
	}

	public Line getSelectedLine() {
		return selectedLine;
	}

	public void setSelectedLine(Line selectedLine) {
		this.selectedLine = selectedLine;
	}
}
