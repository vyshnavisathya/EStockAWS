package com.cts.estock.stockprice.model;



import java.util.List;


public class FinalResult {

    private List<StockPrice> stockPriceList;
    private Long minStockPrice;
    private Long maxStockPrice;
    private Long avgStockPrice;
	public List<StockPrice> getStockPriceList() {
		return stockPriceList;
	}
	public void setStockPriceList(List<StockPrice> stockPriceList) {
		this.stockPriceList = stockPriceList;
	}
	public Long getMinStockPrice() {
		return minStockPrice;
	}
	public void setMinStockPrice(Long minStockPrice) {
		this.minStockPrice = minStockPrice;
	}
	public Long getMaxStockPrice() {
		return maxStockPrice;
	}
	public void setMaxStockPrice(Long maxStockPrice) {
		this.maxStockPrice = maxStockPrice;
	}
	public Long getAvgStockPrice() {
		return avgStockPrice;
	}
	public void setAvgStockPrice(Long avgStockPrice) {
		this.avgStockPrice = avgStockPrice;
	}
	@Override
	public String toString() {
		return "FinalResult [stockPriceList=" + stockPriceList + ", minStockPrice=" + minStockPrice + ", maxStockPrice="
				+ maxStockPrice + ", avgStockPrice=" + avgStockPrice + "]";
	}
	public FinalResult(List<StockPrice> stockPriceList, Long minStockPrice, Long maxStockPrice, Long avgStockPrice) {
		super();
		this.stockPriceList = stockPriceList;
		this.minStockPrice = minStockPrice;
		this.maxStockPrice = maxStockPrice;
		this.avgStockPrice = avgStockPrice;
	}
	public FinalResult() {
		super();
	}
    
    
}
