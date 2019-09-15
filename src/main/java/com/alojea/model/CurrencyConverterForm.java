 package com.alojea.model;

public class CurrencyConverterForm {

	private Float amount;
	private String fromCurrency;
	private String toCurrency;
	private RateValues rateValues;
	
	public CurrencyConverterForm() {
		super();
	}
	
	public RateValues getRateValues() {
		return rateValues;
	}
	
	public void setRateValues(RateValues rateValues) {
		this.rateValues = rateValues;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

}
