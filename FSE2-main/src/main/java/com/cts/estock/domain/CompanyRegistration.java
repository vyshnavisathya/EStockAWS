package com.cts.estock.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class CompanyRegistration {

    @Id
    private long companyCode;

    private String companyName;

    private String companyCeo;

    private double companyTurnover;

    private String companyWebsite;

    private String stockExchange;

    public CompanyRegistration() {
    }

    public CompanyRegistration(long companyCode, String companyName, String companyCeo, double companyTurnover, String companyWebsite, String stockExchange) {
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.companyCeo = companyCeo;
        this.companyTurnover = companyTurnover;
        this.companyWebsite = companyWebsite;
        this.stockExchange = stockExchange;
    }

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

    @Override
    public String toString() {
        return "CompanyRegistration{" +
                "companyCode=" + companyCode +
                ", companyName='" + companyName + '\'' +
                ", companyCeo='" + companyCeo + '\'' +
                ", companyTurnover=" + companyTurnover +
                ", companyWebsite='" + companyWebsite + '\'' +
                ", stockExchange='" + stockExchange + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyRegistration that = (CompanyRegistration) o;
        return companyCode == that.companyCode &&
                Double.compare(that.companyTurnover, companyTurnover) == 0 &&
                companyName.equals(that.companyName) &&
                companyCeo.equals(that.companyCeo) &&
                companyWebsite.equals(that.companyWebsite) &&
                stockExchange.equals(that.stockExchange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyCode, companyName, companyCeo, companyTurnover, companyWebsite, stockExchange);
    }
}
