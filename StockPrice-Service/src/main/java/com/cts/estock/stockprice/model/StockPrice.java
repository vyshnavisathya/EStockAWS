package com.cts.estock.stockprice.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "stock_price")
public class StockPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    
    @Column (name = "stock_prices")
    private Long stockPrice;
    
    @Column (name = "company_code")
    private Long companyCode;
    
    @Column (name = "stock_date_time")
    private String date;

	public StockPrice() {
		super();
	}

	public StockPrice(int id, Long stockPrice, Long companyCode, String date) {
		super();
		this.id = id;
		this.stockPrice = stockPrice;
		this.companyCode = companyCode;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Long stockPrice) {
		this.stockPrice = stockPrice;
	}

	public Long getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "StockPrice [id=" + id + ", stockPrice=" + stockPrice + ", companyCode=" + companyCode + ", date=" + date
				+ "]";
	}

	

}
