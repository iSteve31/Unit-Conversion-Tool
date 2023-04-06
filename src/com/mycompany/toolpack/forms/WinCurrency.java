package com.mycompany.toolpack.forms;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import com.mycompany.toolpack.models.CurrencyConverter;
import com.mycompany.toolpack.models.ExchangeRate;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WinCurrency extends JDialog {
	//Create components
	private JPanel contentPanel;
	private JPanel headerPanel;
	private JLabel lblTitle;
	private JPanel bodyPanel;
	private JPanel inputPanel;
	private JLabel lblAmount;
	private JTextField txtAmount;
	private JLabel lblFrom;
	private JComboBox<String> boxFromCurrency;
	private JLabel lblTo;
	private JButton reverse;
	private JComboBox<String> boxToCurrency;
	private JPanel outputPanel;
	private JLabel lblOutput;
	private JLabel lblRateFrom;
	private JLabel lblRateTo;
	private JPanel footerPanel;
	private JLabel lblBack;
	private JButton btnBack;
	private JButton btnConvert;
	
	public WinCurrency(JFrame owner) {
		super(owner, "Currency Converter", true);
		
		contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		contentPanel.setBackground(new Color(232, 239, 247));
		setContentPane(contentPanel);		//Set the main window.
		
		headerPanel = new JPanel();
		headerPanel.setLayout(new GridBagLayout());		//Useful to center one component.
		headerPanel.setBorder(new EmptyBorder(10, 0, 10, 0));	//Sets the insets for headerPanel.
		headerPanel.setOpaque(false);
		contentPanel.add(headerPanel);
		
		Color txtColor = new Color(3, 4, 94);
		
		lblTitle = new JLabel("Currency Converter");
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 34));
		lblTitle.setForeground(txtColor);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setPreferredSize(new Dimension(390, 41));
		headerPanel.add(lblTitle, new GridBagConstraints());	//Centers the component without specifying any type of constraint.
		
		bodyPanel = new JPanel();
		bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
		bodyPanel.setOpaque(false);
		contentPanel.add(bodyPanel);

		inputPanel = new JPanel();
		inputPanel.setLayout(new GridBagLayout());
		inputPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
		inputPanel.setOpaque(false);
		bodyPanel.add(inputPanel);
		
		Dimension inputSize = new Dimension(250, 28);
		
		lblAmount = new JLabel("Amount:");
		lblAmount.setFont(new Font("Arial", Font.PLAIN, 18));
		lblAmount.setForeground(txtColor);
		lblAmount.setPreferredSize(inputSize);
		lblAmount.setVerticalAlignment(SwingConstants.CENTER);
		lblAmount.setHorizontalAlignment(JLabel.LEFT);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 10, 0);
		inputPanel.add(lblAmount, gbc);
		
		txtAmount = new JTextField();
		txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAmount.setPreferredSize(inputSize);
		txtAmount.setBorder(new CompoundBorder(new LineBorder(Color.gray), new EmptyBorder(0, 5, 0, 5)));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 10, 0);
		inputPanel.add(txtAmount, gbc);
		
		lblFrom = new JLabel("From:");
		lblFrom.setFont(new Font("Arial", Font.PLAIN, 18));
		lblFrom.setForeground(txtColor);
		lblFrom.setPreferredSize(inputSize);
		lblFrom.setVerticalAlignment(JLabel.CENTER);
		lblFrom.setHorizontalAlignment(JLabel.LEFT);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 10, 0);
		inputPanel.add(lblFrom, gbc);
		
		boxFromCurrency = new JComboBox<>();
		boxFromCurrency.setFont(new Font("Arial", Font.PLAIN, 16));
		boxFromCurrency.setForeground(txtColor);
		String[] fromCoin = {"PEN - Peruvian sol", "USD - United States Dollar", "EUR - Euro", "GBP - British Pound",
								"JPY  - Japanese Yen", "KRW - South Korea Won"};
		DefaultComboBoxModel<String> fromCurrencyModel = new DefaultComboBoxModel<>(fromCoin);
		boxFromCurrency.setModel(fromCurrencyModel);
		boxFromCurrency.setPreferredSize(inputSize);
		boxFromCurrency.setFocusable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 10, 0);
		inputPanel.add(boxFromCurrency, gbc);
		
		lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTo.setForeground(txtColor);
		lblTo.setPreferredSize(inputSize);
		lblTo.setVerticalAlignment(JLabel.CENTER);
		lblTo.setHorizontalAlignment(JLabel.LEFT);
		lblTo.setLayout(null);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 10, 0);
		inputPanel.add(lblTo, gbc);
		
		reverse = new JButton();
		int revX = (int) lblTo.getPreferredSize().getWidth()/2;
		int revY = (int) lblTo.getPreferredSize().getHeight()/2;
		reverse.setBounds(revX-13, revY-13, 26, 26);
		ImageIcon imgReverse = new ImageIcon(getClass().getResource("/assets/reverse.png"));
		reverse.setIcon(new ImageIcon(imgReverse.getImage().getScaledInstance(reverse.getWidth()-4, reverse.getHeight()-4, Image.SCALE_SMOOTH)));
		reverse.setFocusPainted(false);
		reverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reverseActionPerformed();
			}
		});
		lblTo.add(reverse);
		
		boxToCurrency = new JComboBox<>();
		boxToCurrency.setFont(new Font("Arial", Font.PLAIN, 16));
		boxToCurrency.setForeground(txtColor);
		String[] toCoin = {"PEN - Peruvian sol", "USD - United States Dollar", "EUR - Euro", "GBP - British Pound",
							"JPY  - Japanese Yen", "KRW - South Korea Won"};
		DefaultComboBoxModel<String> toCurrencyModel = new DefaultComboBoxModel<>(toCoin);
		boxToCurrency.setModel(toCurrencyModel);
		boxToCurrency.setPreferredSize(inputSize);
		boxToCurrency.setFocusable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 0, 0);
		inputPanel.add(boxToCurrency, gbc);
		
		outputPanel = new JPanel();
		outputPanel.setLayout(new GridBagLayout());
		outputPanel.setBorder(new EmptyBorder(20, 0, 20, 0));
		outputPanel.setOpaque(false);
		bodyPanel.add(outputPanel);
		
		lblOutput = new JLabel(" ");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblOutput.setForeground(txtColor);
		lblOutput.setVerticalAlignment(JLabel.CENTER);
		lblOutput.setHorizontalAlignment(JLabel.CENTER);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 6, 0);
		outputPanel.add(lblOutput, gbc);
		
		lblRateFrom = new JLabel(" ");
		lblRateFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRateFrom.setForeground(txtColor);
		lblRateFrom.setVerticalAlignment(JLabel.CENTER);
		lblRateFrom.setHorizontalAlignment(JLabel.CENTER);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(6, 0, 0, 0);
		outputPanel.add(lblRateFrom, gbc);
		
		lblRateTo = new JLabel(" ");
		lblRateTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRateTo.setForeground(txtColor);
		lblRateTo.setVerticalAlignment(JLabel.CENTER);
		lblRateTo.setHorizontalAlignment(JLabel.CENTER);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(2, 0, 0, 0);
		outputPanel.add(lblRateTo, gbc);
		
		footerPanel = new JPanel();
		footerPanel.setPreferredSize(new Dimension(390, 70));
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
		
		btnConvert = new JButton("Convert");
		btnConvert.setFont(new Font("Arial", Font.BOLD, 14));
		btnConvert.setForeground(new Color(254, 254, 254));
		btnConvert.setBackground(new Color(1, 79, 134));
		int convX = (int) footerPanel.getPreferredSize().getWidth()/2;
		int convY = (int) footerPanel.getPreferredSize().getHeight()/2;
		btnConvert.setBounds(convX-48, convY-22, 96, 34);
		btnConvert.setFocusPainted(false);

		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConvertActionPerfomed();
			}
		});
		btnConvert.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnConvertMousePressed();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnConvertMouseReleased();
			}
		});
		footerPanel.add(btnConvert);
		
		//Window settings.
		pack();
		setLocationRelativeTo(owner);
		setResizable(false);
	}
	
	public void reverseActionPerformed() {
		int fromItem = boxFromCurrency.getSelectedIndex();
		int toItem = boxToCurrency.getSelectedIndex();
		boxFromCurrency.setSelectedIndex(toItem);
		boxToCurrency.setSelectedIndex(fromItem);
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
	
	public String getCoin(JComboBox<String> box) {
		String boxSelectedItem = (String) box.getSelectedItem();
		return boxSelectedItem.substring(0, 3);
	}
	
	public void btnConvertActionPerfomed() {
		String amountIn = txtAmount.getText();
		String fromCurrency = getCoin(boxFromCurrency);
		String toCurrency = getCoin(boxToCurrency);

		CurrencyConverter converter = new CurrencyConverter();
		String amountOut = converter.convertX2Y(amountIn, fromCurrency, toCurrency);
		
		ExchangeRate exRate = new ExchangeRate();
		String rateTo = Double.toString(exRate.getRate(toCurrency, fromCurrency));
		String rateFrom = Double.toString(exRate.getRate(fromCurrency, toCurrency));

		lblOutput.setText(amountOut+" "+toCurrency);
		lblRateFrom.setText("1 "+fromCurrency+" = "+rateTo+" "+toCurrency);
		lblRateTo.setText("1 "+toCurrency+" = "+rateFrom+" "+fromCurrency);
	}
	
	public void btnConvertMousePressed() {
		btnConvert.setForeground(new Color(1, 79, 134));
	}
	public void btnConvertMouseReleased() {
		btnConvert.setForeground(new Color(254, 254, 254));
	}
}
