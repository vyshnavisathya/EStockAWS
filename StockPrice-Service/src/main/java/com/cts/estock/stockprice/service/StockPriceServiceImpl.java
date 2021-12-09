package com.cts.estock.stockprice.service;


import com.cts.estock.stockprice.model.Company;
import com.cts.estock.stockprice.model.StockPrice;
import com.cts.estock.stockprice.repository.StockPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StockPriceServiceImpl {

    @Autowired
    StockPriceRepository stockPriceRepository;

    RestTemplate restTemplate = new RestTemplate();

    public StockPrice addStockPrice(StockPrice stockPrice) {

        Company company = restTemplate.getForEntity("http://localhost:8081/api/v1.0/market/company/info/" + stockPrice.getCompanyCode(), Company.class).getBody();
        Optional<StockPrice> stockPrice1 = stockPriceRepository.findById(stockPrice.getId());
        //int stockId = stockPriceRepository.getAllcount();
        System.out.print(stockPrice1);
        System.out.print(stockPrice);
        System.out.print(company);
        if (company != null){
           // stockPrice.setId(stockId+1);
            stockPriceRepository.save(stockPrice);
            System.out.print("true");
        }

        return stockPrice;
    }

    public List<StockPrice> getAllStockPriceByCompanyCodeBetweenDates(Long companyCode, String startDate, String endDate) {
        return stockPriceRepository.findAllByCompanyCodeAndDateGreaterThanEqualAndDateLessThanEqual(companyCode, startDate, endDate);
    }

    public List<StockPrice> getAllStockPriceByCompany(Long companyCode) {
    	System.out.println("compny"+companyCode);
        return  stockPriceRepository.findAllByCompanyCode(companyCode);
    }

    public boolean deleteAll(Long companyCode) {
        List<StockPrice> stockPrices = stockPriceRepository.findAllByCompanyCode(companyCode);
        stockPriceRepository.deleteAll(stockPrices);
        if(stockPriceRepository.findAllByCompanyCode(companyCode).isEmpty()){
            return true;
        }
        return false;
    }

    public List<StockPrice> getAllStockList() {
        return (List<StockPrice>) stockPriceRepository.findAll();
    }

}
