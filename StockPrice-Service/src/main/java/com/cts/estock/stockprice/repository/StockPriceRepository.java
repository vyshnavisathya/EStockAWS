package com.cts.estock.stockprice.repository;

import com.cts.estock.stockprice.model.Company;
import com.cts.estock.stockprice.model.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface StockPriceRepository extends CrudRepository<StockPrice, Integer> {
//
//    @Query("select * from stock_price s where s.company_code = ?1 and s.stock_date_time between ?2 and ?3")
//    List<StockPrice> findAllByCompanyCodeAndBetweenStartEndDate(Long companyCode,
//                                                                    LocalDate startDate,
//                                                                    LocalDate endDate);
//
//    List<StockPrice> findAllByCompanyCode(Long companyCode);
	
	//@Query(value = "SELECT * FROM stock_price WHERE company_code=?1 start_date_time BETWEEN :?2 AND :?3", nativeQuery = true)
	List<StockPrice> findAllByCompanyCodeAndDateGreaterThanEqualAndDateLessThanEqual(Long companyCode,String startDate,String endDate);

	@Query(value = "Select * from stock_price where company_code=?1",nativeQuery = true)
	List<StockPrice> findAllByCompanyCode(Long companyCode);

	@Query(value=" Select count(*) from stock_price", nativeQuery = true)
	int getAllcount();


}
