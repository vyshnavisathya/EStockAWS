package com.cts.estock.stockprice.controller;

import com.cts.estock.stockprice.model.FinalResult;
import com.cts.estock.stockprice.model.StockPrice;
import com.cts.estock.stockprice.service.StockPriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "/api/v1.0/market/stock")
public class StockPriceController {

    @Autowired
    StockPriceServiceImpl stockPriceService;

    @PostMapping("/add/{companyCode}")
    public StockPrice addStockPriceByCompanyCode(@PathVariable Long companyCode , @RequestBody StockPrice stockPrice){
        System.out.println("companycode { }"+ companyCode);
        System.out.println("stockPrice { }"+stockPrice);
        stockPrice.setCompanyCode(companyCode);
        return stockPriceService.addStockPrice(stockPrice);
    }

    @GetMapping(value = "/get/{companyCode}/{startDate}/{endDate}")
    public FinalResult getStockPriceBetweenDate(@PathVariable Long companyCode, @PathVariable  String startDate, @PathVariable  String endDate) {
//        System.out.println(startDate);
//        System.out.println(endDate);
        System.out.println(companyCode);
        FinalResult finalResult = new FinalResult();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date end = null;
        try {
             start = formatter.parse(startDate);
             end = formatter.parse(endDate);
        } catch (ParseException e) {e.printStackTrace();}
//        System.out.println(start);
//        System.out.println(end);
        StringBuffer stringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedstartDate = simpleDateFormat.format(start);
        String formattedendDate = simpleDateFormat.format(end);
        System.out.println(formattedstartDate);
        System.out.println(formattedendDate);
        List<StockPrice> stockPriceList = stockPriceService.getAllStockPriceByCompanyCodeBetweenDates(companyCode,formattedstartDate,formattedendDate);
        finalResult.setStockPriceList(stockPriceList);
        finalResult.setMinStockPrice(stockPriceList.stream().min(Comparator.comparing(StockPrice :: getStockPrice)).get().getStockPrice());
        finalResult.setMaxStockPrice(stockPriceList.stream().max(Comparator.comparing(StockPrice::getStockPrice)).get().getStockPrice());
        finalResult.setAvgStockPrice(stockPriceList.stream().mapToLong(StockPrice::getStockPrice).sum()/stockPriceList.stream().count());
        return finalResult;
    }

    @GetMapping(value= "/get/{companyCode}")
    public List<StockPrice> getStockPriceByCompany(@PathVariable Long companyCode) {
    	System.out.println(companyCode);
        List<StockPrice> stockPriceList = stockPriceService.getAllStockPriceByCompany(companyCode);
        System.out.println(stockPriceList);
//        if(stockPriceList.isEmpty()) {
//            return 0.0;
//        }
        return stockPriceList;

    }

    @DeleteMapping(value = "/delete/{companyCode}")
    public boolean deleteStockPriceByComapnyCode(@PathVariable Long companyCode) {
        return stockPriceService.deleteAll(companyCode);
    }

    @GetMapping(value= "/get/all")
    public List<StockPrice> getAllStockList() {
        return  stockPriceService.getAllStockList();
    }

}
