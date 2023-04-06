package com.mycompany.toolpack.models;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRate {

	private Map<String, Double> rate;
	
	public ExchangeRate() {
		this.rate = new HashMap<String, Double>();
		rate.put("PEN-PEN", 1.000);
		rate.put("PEN-USD", 3.7763);
		rate.put("PEN-EUR", 4.0666);
		rate.put("PEN-GBP", 4.6141);
		rate.put("PEN-JPY", 0.0284);
		rate.put("PEN-KRW", 0.00288);
		rate.put("USD-PEN", 0.2648);
		rate.put("USD-USD", 1.000);
		rate.put("USD-EUR", 1.0768);
		rate.put("USD-GBP", 1.2218);
		rate.put("USD-JPY", 0.0075);
		rate.put("USD-KRW", 0.00076);
		rate.put("EUR-PEN", 0.2458);
		rate.put("EUR-USD", 0.9286);
		rate.put("EUR-EUR", 1.000);
		rate.put("EUR-GBP", 1.1345);
		rate.put("EUR-JPY", 0.0070);
		rate.put("EUR-KRW", 0.00071);
		rate.put("GBP-PEN", 0.2167);
		rate.put("GBP-USD", 0.8184);
		rate.put("GBP-EUR", 0.88137);
		rate.put("GBP-GBP", 1.000);
		rate.put("GBP-JPY", 0.00617);
		rate.put("GBP-KRW", 0.00062);
		rate.put("JPY-PEN", 35.1352);
		rate.put("JPY-USD", 132.6652);
		rate.put("JPY-EUR", 142.8444);
		rate.put("JPY-GBP", 162.0728);
		rate.put("JPY-JPY", 1.000);
		rate.put("JPY-KRW", 0.10149);
		rate.put("KRW-PEN", 346.1315);
		rate.put("KRW-USD", 1307.1523);
		rate.put("KRW-EUR", 1407.4324);
		rate.put("KRW-GBP", 1596.8529);
		rate.put("KRW-JPY", 9.8514);
		rate.put("KRW-KRW", 1.000);
	}
	
	public double getRate(String fromCurrency, String toCurrency) {
		String pair = fromCurrency+"-"+toCurrency;
		if(rate.containsKey(pair)) {
			return rate.get(pair);
		} else {
			throw new IllegalArgumentException("Undefined exchange rate for "+pair);
		}
	}
	
	public void setRate(String fromCurrency, String toCurrency, Double newRate) {
		String pair = fromCurrency+"-"+toCurrency;
		if(rate.containsKey(pair)) {
			rate.put(pair, newRate);
		} else {
			throw new IllegalArgumentException("Undefined exchange rate for "+pair);
		}
	}
	
	public void addRate(String fromCurrency, String toCurrency, Double newRate) {
		String pair = fromCurrency+"-"+toCurrency;
		if(rate.containsKey(pair)) {
			throw new IllegalArgumentException("Exchange rate already defined for "+pair);
		} else {
			rate.put(pair, newRate);
		}
	}
}
