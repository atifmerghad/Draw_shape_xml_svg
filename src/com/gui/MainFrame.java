package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import com.svg.SvgWriter;
import com.xml.XmlException;
import com.xml.XmlWriter;

public class MainFrame extends JFrame{
	private JPanel menuPanel=new JPanel();
	private PaintPanel paintPanel;
	private JPanel commentPanel=new JPanel();
	public JLabel commentLabel=new JLabel();
    private JComboBox cb = new JComboBox();

	public MainFrame(){
		paintPanel=new PaintPanel(this);
		//conctruire le menu
		JButton convertToXmlBtn = new JButton("Convertir en xml");
		JButton convertToSvgBtn = new JButton("Convertir en svg");
		JButton readXml=new JButton("Lire Xml");
		JButton changeMode= new JButton("Activer/Desactiver dessin");
		JButton clear=new JButton("Clear");

		String[] tab = {"Line", "Circle", "Rectangle", "Triangle"};
		cb = new JComboBox(tab);
		
		menuPanel.add(cb,JPanel.RIGHT_ALIGNMENT);
		menuPanel.add(readXml, JPanel.RIGHT_ALIGNMENT);
		menuPanel.add(convertToXmlBtn, JPanel.LEFT_ALIGNMENT);
		menuPanel.add(convertToSvgBtn, JPanel.LEFT_ALIGNMENT);
		menuPanel.add(changeMode, JPanel.LEFT_ALIGNMENT);
		menuPanel.add(clear, JPanel.LEFT_ALIGNMENT);
		clear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				paintPanel.repaint();
				paintPanel.getFigure().getLines().clear();
				paintPanel.getFigure().getCircles().clear();
				paintPanel.getFigure().getRectangles().clear();
				paintPanel.getFigure().getTriangles().clear();
			}
		});
		changeMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(paintPanel.getFigure().getCircles().size()==0 && paintPanel.getFigure().getLines().size()==0 && paintPanel.getFigure().getRectangles().size()==0){
					JOptionPane.showMessageDialog(null, "Dessiner au moin une figure");
					}
				else if(paintPanel.isDrawMode()==true){
					paintPanel.setDrawMode(!paintPanel.isDrawMode());	
					paintPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				else{
					paintPanel.setDrawMode(!paintPanel.isDrawMode());	
					paintPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			}
		});
		convertToXmlBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Convertir les forme en XML
				XmlWriter xmlWriter=new XmlWriter();
				try {
					xmlWriter.convert("D:\\exemple.xml", paintPanel.getFigure());
					JOptionPane.showMessageDialog(null,"fichier xml crée correctement","OK", JOptionPane.INFORMATION_MESSAGE);
				} catch (XmlException e1) {
					JOptionPane.showMessageDialog(null,"Erreur de convertion du fichier en XML","Message d'erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		convertToSvgBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SvgWriter svgWriter=new SvgWriter();
				
				JFrame parentFrame = new JFrame();
		        JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setDialogTitle("Specify a file to save");
		        int userSelection = fileChooser.showSaveDialog(parentFrame);
		        if (userSelection == JFileChooser.APPROVE_OPTION) {
		            File fileToSave = fileChooser.getSelectedFile();
		            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
				try{
					File file=new File(fileToSave.getAbsolutePath());
					svgWriter.convert(file,paintPanel.getFigure());
				}catch(Exception ex1){
					//JOptionPane.showMessageDialog(null,"Erreur de convertion du fichier en SVG","Message d'erreur", JOptionPane.ERROR_MESSAGE);
				}
		       }
			}
		});
		
		commentLabel.setText("TEST : ");
		commentPanel.add(commentLabel);
		paintPanel. setBackground( new Color(236, 240, 241));
		menuPanel.setBackground( new Color(44, 62, 80));
		add(menuPanel, BorderLayout.NORTH);
		add(commentPanel, BorderLayout.SOUTH);
		add(paintPanel);
		
		setTitle("Application XML");		
		
		setSize(810,640);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public JComboBox getCb() {
		return cb;
	}

	public void setCb(JComboBox cb) {
		this.cb = cb;
	}
	public void writeInCommentsLabel(String pString){
		commentLabel.setText(commentLabel.getText()+" | "+pString);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MainFrame();
			}
		});
		
	}
}
