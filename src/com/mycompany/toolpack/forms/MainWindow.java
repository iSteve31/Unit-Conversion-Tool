package com.mycompany.toolpack.forms;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mycompany.toolpack.models.MyImgLabel;
import com.mycompany.toolpack.models.MyTranspButton;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JLayeredPane mainPanel;
	private JPanel contentPanel;
	private JPanel bodyPanel;
	private JLabel lblTitle;
	private MyImgLabel lblConversorType;
	private JComboBox<String> boxConversorType;
	private JButton btnNext;
	private JPanel footerPanel;
	private JLabel lblAuthor;
	private JLabel lblRights;
	private JPanel floatPanel;
	private MyTranspButton btnHome;
	private MyTranspButton btnLinkedIn;
	private MyTranspButton btnGit;
	private MyImgLabel line;
	
	private int imgSizeW;
	private int imgSizeH;

	public MainWindow() {
		
		int winSizeWidht = 500;
		int winSizeHeight = 420;
		
		mainPanel = new JLayeredPane();
		mainPanel.setPreferredSize(new Dimension(winSizeWidht, winSizeHeight));
		setContentPane(mainPanel);
		
		contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, winSizeWidht, winSizeHeight);
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		contentPanel.setBackground(new Color(237, 237, 233));
		mainPanel.add(contentPanel, Integer.valueOf(0));
		
		bodyPanel = new JPanel();
		bodyPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
		bodyPanel.setLayout(new GridBagLayout());
		bodyPanel.setOpaque(false);
		contentPanel.add(bodyPanel);
		
		lblTitle = new JLabel("Conversion Tool");
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 45));
		lblTitle.setForeground(new Color(47,  62,  70));
		lblTitle.setVerticalAlignment(JLabel.CENTER);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 35, 0);
		bodyPanel.add(lblTitle, gbc);
		
		imgSizeW = 65;
		imgSizeH = 65;
		lblConversorType = new MyImgLabel(new Dimension(imgSizeW, imgSizeH), "currency.png", 0, 0);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 45, 0);
		bodyPanel.add(lblConversorType, gbc);
		
		boxConversorType = new JComboBox<>();
		String[] optConv = {"Currency Converter", "Temperature Converter"};
		DefaultComboBoxModel<String> optConvModel = new DefaultComboBoxModel<>(optConv);
		boxConversorType.setModel(optConvModel);
		boxConversorType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		boxConversorType.setPreferredSize(new Dimension(240, 28));
		boxConversorType.setFocusable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 50, 0);
		
		boxConversorType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boxConversorTypeActionPerformed();
			}
		});
		bodyPanel.add(boxConversorType, gbc);
		
		btnNext = new JButton("Next");
		btnNext.setFont(new Font("Arial", Font.BOLD, 14));
		btnNext.setForeground(new Color(254, 254, 254));
		btnNext.setBackground(new Color(1, 79, 134));
		btnNext.setPreferredSize(new Dimension(96, 34));
		btnNext.setFocusPainted(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 0, 0);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed();
			}
		});
		bodyPanel.add(btnNext, gbc);
		
		footerPanel = new JPanel();
		footerPanel.setBorder(new EmptyBorder(20, 0, 10, 0));
		footerPanel.setLayout(new BoxLayout(footerPanel, BoxLayout.Y_AXIS));
		footerPanel.setOpaque(false);
		contentPanel.add(footerPanel);
		
		lblAuthor = new JLabel("Designed and Built by Steve Rocha");
		lblAuthor.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblAuthor.setAlignmentX(Component.CENTER_ALIGNMENT);
		footerPanel.add(lblAuthor);
		
		lblRights = new JLabel("All rights reserved. © 2023");
		lblRights.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblRights.setAlignmentX(Component.CENTER_ALIGNMENT);
		footerPanel.add(lblRights);

		floatPanel = new JPanel();
		floatPanel.setBounds(10, winSizeHeight-140-10, 25, 140);
        floatPanel.setLayout(new GridBagLayout());
        floatPanel.setOpaque(false);
        mainPanel.add(floatPanel, Integer.valueOf(1));
        
        Dimension floatSize = new Dimension(25, 25);
        
        btnHome = new MyTranspButton(floatSize, "home.png", 5, 4, "https://www.linkedin.com/in/steverocha/"); 
        btnHome.setToolTipText("Home");
        GridBagConstraints floatGbc = new GridBagConstraints();
        floatGbc.gridx = 0;
        floatGbc.gridy = 0;
        floatGbc.anchor = GridBagConstraints.CENTER;
        floatGbc.insets = new Insets(0, 0, 0, 0);
        floatPanel.add(btnHome, floatGbc);
        
        line = new MyImgLabel(new Dimension(25, 20), "pipe.png", 0, 0);
        floatGbc = new GridBagConstraints();
        floatGbc.gridx = 0;
        floatGbc.gridy = 1;
        floatGbc.anchor = GridBagConstraints.CENTER;
        floatGbc.insets = new Insets(0, 0, 0, 0);
        floatPanel.add(line, floatGbc);

        btnLinkedIn = new MyTranspButton(floatSize, "linkedin-rect.png", 6, 6, "https://www.linkedin.com/in/steverocha/");
        btnLinkedIn.setToolTipText("LinkedIn");
        floatGbc = new GridBagConstraints();
        floatGbc.gridx = 0;
        floatGbc.gridy = 2;
        floatGbc.anchor = GridBagConstraints.CENTER;
        floatGbc.insets = new Insets(0, 0, 0, 0);
        floatPanel.add(btnLinkedIn, floatGbc);
        
        line = new MyImgLabel(new Dimension(25, 20), "pipe.png", 0, 0);
        floatGbc = new GridBagConstraints();
        floatGbc.gridx = 0;
        floatGbc.gridy = 3;
        floatGbc.anchor = GridBagConstraints.CENTER;
        floatGbc.insets = new Insets(0, 0, 0, 0);
        floatPanel.add(line, floatGbc);
        
        btnGit = new MyTranspButton(floatSize, "github.png", 5, 5, "https://github.com/iSteve31");
        btnGit.setToolTipText("GitHub");
        floatGbc = new GridBagConstraints();
        floatGbc.gridx = 0;
        floatGbc.gridy = 4;
        floatGbc.anchor = GridBagConstraints.CENTER;
        floatGbc.insets = new Insets(0, 0, 0, 0);
        floatPanel.add(btnGit, floatGbc);
        
        line = new MyImgLabel(floatSize, "cross.png", 0, 0);
        floatGbc = new GridBagConstraints();
        floatGbc.gridx = 0;
        floatGbc.gridy = 5;
        floatGbc.anchor = GridBagConstraints.CENTER;
        floatGbc.insets = new Insets(0, 0, 0, 0);
        floatPanel.add(line, floatGbc);
		
		setTitle("Unit Conversion Tool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
	
	public void boxConversorTypeActionPerformed() {
		int boxSelectedItem = boxConversorType.getSelectedIndex();
		if(boxSelectedItem == 0) {
			ImageIcon imgType = new ImageIcon(getClass().getResource("/assets/currency.png"));
			lblConversorType.setIcon(new ImageIcon(imgType.getImage().getScaledInstance(imgSizeW, imgSizeH, Image.SCALE_SMOOTH)));
		} else if(boxSelectedItem == 1) {
			ImageIcon imgType = new ImageIcon(getClass().getResource("/assets/temp.png"));
			lblConversorType.setIcon(new ImageIcon(imgType.getImage().getScaledInstance(imgSizeW, imgSizeH, Image.SCALE_SMOOTH)));
		}
	}
	
	public void btnNextActionPerformed() {
		//Creates linking to the one of the secondary windows.
		String boxSelectedItem = (String) boxConversorType.getSelectedItem();
		if(boxSelectedItem == "Currency Converter") {
			WinCurrency winCurrency = new WinCurrency(MainWindow.this);
			winCurrency.setVisible(true);
		} else if(boxSelectedItem == "Temperature Converter") {
			WinTemperature winTemperature = new WinTemperature(MainWindow.this);
			winTemperature.setVisible(true);
		} else{
			JOptionPane.showMessageDialog(null, "No option selected", "Message", JOptionPane.INFORMATION_MESSAGE, null);
		}
	}
}
