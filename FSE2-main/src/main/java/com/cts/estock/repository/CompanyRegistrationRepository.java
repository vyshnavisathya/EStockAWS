package com.cts.estock.repository;


import com.cts.estock.domain.CompanyRegistration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRegistrationRepository extends MongoRepository<CompanyRegistration, Long> {


}
