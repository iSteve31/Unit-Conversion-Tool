package com.mycompany.toolpack.models;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyTranspButton extends JButton{

	public MyTranspButton(Dimension size, String img, int marginW, int marginH, String web) {
		super();
		setPreferredSize(size);
        ImageIcon imgLink = new ImageIcon(getClass().getResource("/assets/"+img));
        setIcon(new ImageIcon(imgLink.getImage().
        		getScaledInstance((int) getPreferredSize().getWidth()-marginW,
        						  (int) getPreferredSize().getHeight()-marginH, Image.SCALE_SMOOTH)));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        
        addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Desktop.getDesktop().browse(new URI(web));
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
        
        addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		setBorderPainted(true);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		setBorderPainted(false);
        	}
        });
	}
}
