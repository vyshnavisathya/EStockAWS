package com.cts.estock.controller;


import com.cts.estock.domain.CompanyRegistration;
import com.cts.estock.service.CompanyRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1.0/market/")
public class CompanyRegistrationaController {

    @Autowired
    private CompanyRegistrationService companyRegistrationService;

    @PostMapping("company/info/register")
    public CompanyRegistration registerCompanyineStock(@RequestBody CompanyRegistration companyRegistration){
        System.out.print(companyRegistration);
        return companyRegistrationService.registerCompany(companyRegistration);
    }

    @GetMapping("company/info/{companyCode}")
    public Optional<CompanyRegistration> getCompanyDetails(@PathVariable long companyCode ){
        return companyRegistrationService.getCompanyDetails(companyCode);
    }

    @GetMapping("company/info/all")
    public List<CompanyRegistration> getAllCompanies() {
        return  companyRegistrationService.getAllCompanyDetails();
    }

    @DeleteMapping("/company/delete/{companyCode}")
    public void deleteCompany(@PathVariable long companyCode) {
        companyRegistrationService.deleteCompany(companyCode);
    }

}
