package com.mycompany.toolpack.forms;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.mycompany.toolpack.models.MyImgLabel;
import com.mycompany.toolpack.models.TemperatureConverter;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class WinTemperature extends JDialog {

	private JPanel contentPanel;
	private JPanel headerPanel;
	private JLabel lblTitle;
	private JLabel lblMessage;
	private JPanel bodyPanel;
	private JLabel lblCelsius;
	private JTextField txtCelsius;
	private JLabel lblImgC;
	private JLabel lblFahrenheit;
	private JTextField txtFahrenheit;
	private JLabel lblImgF;
	private JLabel lblKelvin;
	private JTextField txtKelvin;
	private JLabel lblImgK;
	private JLabel lblRankine;
	private JTextField txtRankine;
	private JLabel lblImgR;
	private JPanel footerPanel;
	private JLabel lblBack;
	private JButton btnBack;
	private JButton btnReset;
	private boolean lockCelsius = false;
	private boolean lockFahrenheit = false;
	private boolean lockKelvin = false;
	private boolean lockRankine = false;
	
	public WinTemperature(JFrame owner) {
		super(owner, "Temperature Converter", true);
		
		contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		contentPanel.setBackground(new Color(242, 244, 255));
		setContentPane(contentPanel);
		
		headerPanel = new JPanel();
		headerPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
		headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
		headerPanel.setOpaque(false);
		contentPanel.add(headerPanel);

		Color txtColor = new Color(53, 46, 120);
		
		lblTitle = new JLabel("Temperature Converter");
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 34));
		lblTitle.setForeground(txtColor);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setVerticalAlignment(JLabel.CENTER);
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitle.setAlignmentY(Component.CENTER_ALIGNMENT);
		headerPanel.add(lblTitle);
		headerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		
		lblMessage = new JLabel("Write the value you want to convert ");
		lblMessage.setFont(new Font("Arial", Font.ITALIC, 15));
		lblMessage.setForeground(txtColor);
		lblMessage.setHorizontalAlignment(JLabel.CENTER);
		lblMessage.setVerticalAlignment(JLabel.CENTER);
		lblMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMessage.setAlignmentY(Component.CENTER_ALIGNMENT);
		headerPanel.add(lblMessage);
		
		bodyPanel = new JPanel();
		bodyPanel.setBorder(new EmptyBorder(10, 0, 20, 0));
		bodyPanel.setLayout(new GridBagLayout());
		bodyPanel.setOpaque(false);
		contentPanel.add(bodyPanel);
		
		Dimension inputSize = new Dimension(230, 28);
		
		lblCelsius = new JLabel("Celsius:");
		lblCelsius.setFont(new Font("Arial", Font.PLAIN, 18));
		lblCelsius.setForeground(txtColor);
		lblCelsius.setPreferredSize(inputSize);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 8, 0);
		bodyPanel.add(lblCelsius, gbc);
		
		txtCelsius = new JTextField();
		txtCelsius.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCelsius.setPreferredSize(inputSize);
		txtCelsius.setBorder(new CompoundBorder(new LineBorder(Color.gray), new EmptyBorder(0, 5, 0, 5)));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 0, 10);
		bodyPanel.add(txtCelsius, gbc);
		
		txtCelsius.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				txtCelsiusInsertRemoveUpdate();
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				txtCelsiusInsertRemoveUpdate();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		Dimension iconSize = new Dimension(28, 28);
		
		lblImgC = new MyImgLabel(iconSize, "celsius.png", 0, 0);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		bodyPanel.add(lblImgC, gbc);
		
		lblFahrenheit = new JLabel("Fahrenheit:");
		lblFahrenheit.setFont(new Font("Arial", Font.PLAIN, 18));
		lblFahrenheit.setForeground(txtColor);
		lblFahrenheit.setPreferredSize(inputSize);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(8, 0, 8, 0);
		bodyPanel.add(lblFahrenheit, gbc);
		
		txtFahrenheit = new JTextField();
		txtFahrenheit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFahrenheit.setPreferredSize(inputSize);
		txtFahrenheit.setBorder(new CompoundBorder(new LineBorder(Color.gray), new EmptyBorder(0, 5, 0, 5)));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 0, 10);
		bodyPanel.add(txtFahrenheit, gbc);
		
		txtFahrenheit.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				txtFahrenheitInsertRemoveUpdate();
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				txtFahrenheitInsertRemoveUpdate();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		lblImgF = new MyImgLabel(iconSize, "fahrenheit.png", 0, 0);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 0, 0, 0);
		bodyPanel.add(lblImgF, gbc);
		
		lblKelvin = new JLabel("Kelvin:");
		lblKelvin.setFont(new Font("Arial", Font.PLAIN, 18));
		lblKelvin.setForeground(txtColor);
		lblKelvin.setPreferredSize(inputSize);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(8, 0, 8, 0);
		bodyPanel.add(lblKelvin, gbc);
		
		txtKelvin = new JTextField();
		txtKelvin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtKelvin.setPreferredSize(inputSize);
		txtKelvin.setBorder(new CompoundBorder(new LineBorder(Color.gray), new EmptyBorder(0, 5, 0, 5)));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 0, 10);
		bodyPanel.add(txtKelvin, gbc);
		
		txtKelvin.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				txtKelvinInsertRemoveUpdate();
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				txtKelvinInsertRemoveUpdate();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		lblImgK = new MyImgLabel(iconSize, "kelvin.png", 0, 0);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.insets = new Insets(0, 0, 0, 0);
		bodyPanel.add(lblImgK, gbc);
		
		lblRankine = new JLabel("Rankine:");
		lblRankine.setFont(new Font("Arial", Font.PLAIN, 18));
		lblRankine.setForeground(txtColor);
		lblRankine.setPreferredSize(inputSize);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(8, 0, 8, 0);
		bodyPanel.add(lblRankine, gbc);
		
		txtRankine = new JTextField();
		txtRankine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtRankine.setPreferredSize(inputSize);
		txtRankine.setBorder(new CompoundBorder(new LineBorder(Color.gray), new EmptyBorder(0, 5, 0, 5)));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 0, 10);
		bodyPanel.add(txtRankine, gbc);
		
		txtRankine.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				txtRankineInsertRemoveUpdate();
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				txtRankineInsertRemoveUpdate();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		lblImgR = new MyImgLabel(iconSize, "rankine.png", 0, 0);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.insets = new Insets(0, 0, 0, 0);
		bodyPanel.add(lblImgR, gbc);
		
		footerPanel = new JPanel();
		footerPanel.setPreferredSize(new Dimension(420, 70));
		footerPanel.setLayout(null);
		footerPanel.setOpaque(false);
		contentPanel.add(footerPanel);
		
		lblBack = new JLabel("Back");
		lblBack.setFont(new Font("Arial", Font.ITALIC, 12));
		lblBack.setHorizontalAlignment(JLabel.CENTER);
		lblBack.setVerticalAlignment(JLabel.BOTTOM);
		int lblY = (int) footerPanel.getPreferredSize().getHeight()/2;
		lblBack.setBounds(15, lblY-23, 30, 46);
		lblBack.setLayout(null);
		footerPanel.add(lblBack);
		
		btnBack = new JButton();
		btnBack.setBounds(lblBack.getWidth()/2-14, 0, 28, 28);
		ImageIcon imgBack = new ImageIcon(getClass().getResource("/assets/back.png"));
		btnBack.setIcon(new ImageIcon(imgBack.getImage().getScaledInstance(btnBack.getWidth()-11, btnBack.getHeight()-13,
																			Image.SCALE_SMOOTH)));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBackActionPerformed();
			}
		});
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBackMouseEntered();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBackMouseExited();
			}
		});
		lblBack.add(btnBack);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Arial", Font.BOLD, 14));
		btnReset.setForeground(new Color(254, 254, 254));
		btnReset.setBackground(new Color(1, 79, 134));
		int convX = (int) footerPanel.getPreferredSize().getWidth()/2;
		int convY = (int) footerPanel.getPreferredSize().getHeight()/2;
		btnReset.setBounds(convX-43, convY-22, 96, 34);
		btnReset.setFocusPainted(false);

		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnResetActionPerfomed();
			}
		});
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnResetMousePressed();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnResetMouseReleased();
			}
		});
		footerPanel.add(btnReset);
		
		pack();
		setLocationRelativeTo(owner);
		setResizable(false);
	}
	
	public void txtCelsiusInsertRemoveUpdate() {
		if(!lockCelsius) {
			lockFahrenheit = true;
			lockKelvin = true;
			lockRankine = true;
			if(txtCelsius.getText().isEmpty()) {
				btnResetActionPerfomed();
			} else {
				TemperatureConverter temp = new TemperatureConverter();
				String tempF = temp.convertC2F(txtCelsius.getText());
				String tempK = temp.convertC2K(txtCelsius.getText());
				String tempR = temp.convertC2R(txtCelsius.getText());
				txtFahrenheit.setText(tempF);
				txtKelvin.setText(tempK);
				txtRankine.setText(tempR);
			}
			lockFahrenheit = false;
			lockKelvin = false;
			lockRankine = false;
		}
	}
	public void txtFahrenheitInsertRemoveUpdate() {
		if(!lockFahrenheit) {
			lockCelsius = true;
			lockKelvin = true;
			lockRankine = true;
			if(txtFahrenheit.getText().isEmpty()) {
				btnResetActionPerfomed();
			} else {
				TemperatureConverter temp = new TemperatureConverter();
				String tempC = temp.convertF2C(txtFahrenheit.getText());
				String tempK = temp.convertF2K(txtFahrenheit.getText());
				String tempR = temp.convertF2R(txtFahrenheit.getText());				
				txtCelsius.setText(tempC);
				txtKelvin.setText(tempK);
				txtRankine.setText(tempR);
			}
			lockCelsius = false;
			lockKelvin = false;
			lockRankine = false;
		}
	}
	public void txtKelvinInsertRemoveUpdate() {
		if(!lockKelvin) {
			lockCelsius = true;
			lockFahrenheit = true;
			lockRankine = true;
			if(txtKelvin.getText().isEmpty()) {
				btnResetActionPerfomed();
			} else {
				TemperatureConverter temp = new TemperatureConverter();
				String tempC = temp.convertK2C(txtKelvin.getText());
				String tempF = temp.convertK2F(txtKelvin.getText());
				String tempR = temp.convertK2R(txtKelvin.getText());				
				txtCelsius.setText(tempC);
				txtFahrenheit.setText(tempF);
				txtRankine.setText(tempR);
			}
			lockCelsius = false;
			lockFahrenheit = false;
			lockRankine = false;
		}
	}
	public void txtRankineInsertRemoveUpdate() {
		if(!lockRankine) {
			lockCelsius = true;
			lockFahrenheit = true;
			lockKelvin = true;
			if(txtRankine.getText().isEmpty()) {
				btnResetActionPerfomed();
			} else {
				TemperatureConverter temp = new TemperatureConverter();
				String tempC = temp.convertR2C(txtRankine.getText());
				String tempF = temp.convertR2F(txtRankine.getText());
				String tempK = temp.convertR2K(txtRankine.getText());				
				txtCelsius.setText(tempC);
				txtFahrenheit.setText(tempF);
				txtKelvin.setText(tempK);
			}
			lockCelsius = false;
			lockFahrenheit = false;
			lockKelvin = false;
		}
	}
	
	public void btnBackActionPerformed() {
		dispose();
	}
	public void btnBackMouseEntered() {
		btnBack.setBorderPainted(true);
	}
	public void btnBackMouseExited() {
		btnBack.setBorderPainted(false);
	}
	
	public void btnResetActionPerfomed() {
		txtCelsius.setText("");
		txtFahrenheit.setText("");
		txtKelvin.setText("");
		txtRankine.setText("");
	}
	public void btnResetMousePressed() {
		btnReset.setForeground(new Color(1, 79, 134));
	}
	public void btnResetMouseReleased() {
		btnReset.setForeground(new Color(254, 254, 254));
	}
}
