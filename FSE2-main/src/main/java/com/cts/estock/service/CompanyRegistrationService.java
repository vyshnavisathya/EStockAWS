package com.cts.estock.service;

import com.cts.estock.domain.CompanyRegistration;
import com.cts.estock.repository.CompanyRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyRegistrationService {

    @Autowired
    CompanyRegistrationRepository companyRegistrationRepository;

    RestTemplate restTemplate = new RestTemplate();

    public CompanyRegistration registerCompany(CompanyRegistration companyRegistration) {

        return companyRegistrationRepository.save(companyRegistration);

    }

    public Optional<CompanyRegistration> getCompanyDetails(long companyCode) {

        return companyRegistrationRepository.findById(companyCode);

    }

    public List<CompanyRegistration> getAllCompanyDetails() {

        return companyRegistrationRepository.findAll();
    }

    public void deleteCompany(Long companyCode) {
        Optional<CompanyRegistration> optionalCompany = companyRegistrationRepository.findById(companyCode);
        CompanyRegistration company = optionalCompany.get();
        restTemplate.delete("http://localhost:8095/api/v1.0/market/stock/delete/" + companyCode);
        companyRegistrationRepository.delete(company);
    }

}
