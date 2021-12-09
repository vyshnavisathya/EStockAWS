package com.cts.estock.stockprice.model;


import javax.persistence.Id;


public class Company {

    @Id
    private long companyCode;

    private String companyName;

    private String companyCeo;

    private double companyTurnover;

    private String companyWebsite;

    private String stockExchange;

    private double stockPriceofCompany;

	public long getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(long companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCeo() {
		return companyCeo;
	}

	public void setCompanyCeo(String companyCeo) {
		this.companyCeo = companyCeo;
	}

	public double getCompanyTurnover() {
		return companyTurnover;
	}

	public void setCompanyTurnover(double companyTurnover) {
		this.companyTurnover = companyTurnover;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public double getStockPriceofCompany() {
		return stockPriceofCompany;
	}

	public void setStockPriceofCompany(double stockPriceofCompany) {
		this.stockPriceofCompany = stockPriceofCompany;
	}

	@Override
	public String toString() {
		return "Company [companyCode=" + companyCode + ", companyName=" + companyName + ", companyCeo=" + companyCeo
				+ ", companyTurnover=" + companyTurnover + ", companyWebsite=" + companyWebsite + ", stockExchange="
				+ stockExchange + ", stockPriceofCompany=" + stockPriceofCompany + "]";
	}

	public Company(long companyCode, String companyName, String companyCeo, double companyTurnover,
			String companyWebsite, String stockExchange, double stockPriceofCompany) {
		super();
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.companyCeo = companyCeo;
		this.companyTurnover = companyTurnover;
		this.companyWebsite = companyWebsite;
		this.stockExchange = stockExchange;
		this.stockPriceofCompany = stockPriceofCompany;
	}

	public Company() {
		super();
	}

    

}
