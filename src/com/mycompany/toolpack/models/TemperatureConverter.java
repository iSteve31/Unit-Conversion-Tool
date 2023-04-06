package com.mycompany.toolpack.models;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemperatureConverter {

	public boolean validateAmount(String amount) {
		Pattern pattern = Pattern.compile("^(\\-)?\\d+(\\.\\d+)?$");
		Matcher matcher = pattern.matcher(amount);
		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}
	public String roundAmount(double amount) {
		DecimalFormat patternFormat = new DecimalFormat("#.###");
		String amountString = patternFormat.format(amount);
		return amountString;
	}
	
	public String convertC2F(String temp) {
		if(this.validateAmount(temp)) {
			double amount = Double.parseDouble(temp);
			double amountConverted = 1.8*amount + 32;
			return this.roundAmount(amountConverted);
		} else {
			return "ERROR";
		}
	}
	public String convertC2K(String temp) {
		if(this.validateAmount(temp)) {
			double amount = Double.parseDouble(temp);
			double amountConverted = amount + 273.15;
			return this.roundAmount(amountConverted);
		} else {
			return "ERROR";
		}
	}
	public String convertC2R(String temp) {
		if(this.validateAmount(temp)) {
			double amount = Double.parseDouble(temp);
			double amountConverted = 1.8*amount + 491.67;
			return this.roundAmount(amountConverted);
		} else {
			return "ERROR";
		}
	}
	public String convertF2C(String temp) {
		if(this.validateAmount(temp)) {
			double amount = Double.parseDouble(temp);
			double amountConverted = (amount-32) / 1.8;
			return this.roundAmount(amountConverted);
		} else {
			return "ERROR";
		}
	}
	public String convertF2K(String temp) {
		if(this.validateAmount(temp)) {
			double amount = Double.parseDouble(temp);
			double amountConverted = (amount+459.67) / 1.8;
			return this.roundAmount(amountConverted);
		} else {
			return "ERROR";
		}
	}
	public String convertF2R(String temp) {
		if(this.validateAmount(temp)) {
			double amount = Double.parseDouble(temp);
			double amountConverted = amount + 459.67;
			return this.roundAmount(amountConverted);
		} else {
			return "ERROR";
		}
	}
	public String convertK2C(String temp) {
		if(this.validateAmount(temp)) {
			double amount = Double.parseDouble(temp);
			double amountConverted = amount - 273.15;
			return this.roundAmount(amountConverted);
		} else {
			return "ERROR";
		}
	}
	public String convertK2F(String temp) {
		if(this.validateAmount(temp)) {
			double amount = Double.parseDouble(temp);
			double amountConverted = 1.8*amount - 459.67;
			return this.roundAmount(amountConverted);
		} else {
			return "ERROR";
		}
	}
	public String convertK2R(String temp) {
		if(this.validateAmount(temp)) {
			double amount = Double.parseDouble(temp);
			double amountConverted = 1.8*amount;
			return this.roundAmount(amountConverted);
		} else {
			return "ERROR";
		}
	}
	public String convertR2C(String temp) {
		if(this.validateAmount(temp)) {
			double amount = Double.parseDouble(temp);
			double amountConverted = (amount/1.8) - 273.15;
			return this.roundAmount(amountConverted);
		} else {
			return "ERROR";
		}
	}
	public String convertR2F(String temp) {
		if(this.validateAmount(temp)) {
			double amount = Double.parseDouble(temp);
			double amountConverted = amount - 459.67;
			return this.roundAmount(amountConverted);
		} else {
			return "ERROR";
		}
	}
	public String convertR2K(String temp) {
		if(this.validateAmount(temp)) {
			double amount = Double.parseDouble(temp);
			double amountConverted = amount/1.8;
			return this.roundAmount(amountConverted);
		} else {
			return "ERROR";
		}
	}
}