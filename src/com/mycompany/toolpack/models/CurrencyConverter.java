package com.mycompany.toolpack.models;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class CurrencyConverter {
	
	private ExchangeRate rate;
	
	public CurrencyConverter() {
		this.rate = new ExchangeRate();
	}
	
	public boolean validateAmount(String amount) {
		Pattern pattern = Pattern.compile("^\\d+(\\.\\d+)?$");
		Matcher matcher = pattern.matcher(amount);
		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}
	public String roundAmount(double amount) {
		DecimalFormat patternFormat = new DecimalFormat("#.####");
		String amountString = patternFormat.format(amount);
		return amountString;
	}
	
	public String convertX2Y(String amount, String fromCurrency, String toCurrency) {
		double amountConverted = 0.0000;
		
		if(this.validateAmount(amount)) {
			double amountDouble = Double.parseDouble(amount);
			double xRate = rate.getRate(toCurrency, fromCurrency);
			amountConverted = (amountDouble * xRate * Math.pow(10, 4))/Math.pow(10, 4);
		} else {
			JOptionPane.showMessageDialog(null, "Please enter only positive numeric values!", "Message", JOptionPane.INFORMATION_MESSAGE);
		}
		return this.roundAmount(amountConverted);
	}
}
