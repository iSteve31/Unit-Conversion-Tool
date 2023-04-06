package com.mycompany.toolpack.models;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyImgLabel extends JLabel {

	public MyImgLabel(Dimension size, String img, int marginW, int marginH) {
		super();
		
		setPreferredSize(size);
	 	ImageIcon imgLine = new ImageIcon(getClass().getResource("/assets/"+img));
	 	setIcon(new ImageIcon(imgLine.getImage().
	        		getScaledInstance((int) getPreferredSize().getWidth()-marginW,
	        						  (int) getPreferredSize().getHeight()-marginH, Image.SCALE_SMOOTH)));
	}
}
