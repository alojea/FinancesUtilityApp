package com.alojea.model;

import java.time.LocalDateTime;

public class RateValues {
	
	public RateValues(String fromCurrencyCode, String fromCurrencyName, String currencyCode, String currencyName,
			Float exchangeRate, LocalDateTime lastRefreshed, String timeZone, Float bidPrice, Float askPrice) {
		super();
		this.fromCurrencyCode = fromCurrencyCode;
		this.fromCurrencyName = fromCurrencyName;
		this.currencyCode = currencyCode;
		this.currencyName = currencyName;
		this.exchangeRate = exchangeRate;
		this.lastRefreshed = lastRefreshed;
		this.timeZone = timeZone;
		this.bidPrice = bidPrice;
		this.askPrice = askPrice;
	}
	
	private String fromCurrencyCode;
	private String fromCurrencyName;
	private String currencyCode;
	private String currencyName;
	private Float exchangeRate;
	private LocalDateTime lastRefreshed;
	private String timeZone;
	private Float bidPrice;
	private Float askPrice;
	private Float finalExchangeRate;
	
	public Float getFinalExchangeRate() {
		return finalExchangeRate;
	}
	public void setFinalExchangeRate(Float finalExchangeRate) {
		this.finalExchangeRate = finalExchangeRate;
	}
	public String getFromCurrencyCode() {
		return fromCurrencyCode;
	}
	public void setFromCurrencyCode(String fromCurrencyCode) {
		this.fromCurrencyCode = fromCurrencyCode;
	}
	public String getFromCurrencyName() {
		return fromCurrencyName;
	}
	public void setFromCurrencyName(String fromCurrencyName) {
		this.fromCurrencyName = fromCurrencyName;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public Float getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(Float exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public LocalDateTime getLastRefreshed() {
		return lastRefreshed;
	}
	public void setLastRefreshed(LocalDateTime lastRefreshed) {
		this.lastRefreshed = lastRefreshed;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public Float getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(Float bidPrice) {
		this.bidPrice = bidPrice;
	}
	public Float getAskPrice() {
		return askPrice;
	}
	public void setAskPrice(Float askPrice) {
		this.askPrice = askPrice;
	}
	
}
