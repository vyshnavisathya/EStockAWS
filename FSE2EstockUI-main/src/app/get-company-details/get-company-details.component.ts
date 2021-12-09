import { Component, NgModule, OnInit } from '@angular/core';
import { Company } from '../model/company';
import { CompanyServiceService } from '../service/company-service.service';


@Component({
  selector: 'app-get-company-details',
  templateUrl: './get-company-details.component.html',
  styleUrls: ['./get-company-details.component.scss']
})

export class GetCompanyDetailsComponent implements OnInit {

  companies: any;
  ifPresent = false;
  searchKeyword: string;
  constructor(private companyService: CompanyServiceService) {
    this.companies = [];
  }

  ngOnInit() {
   this.getCompanyDetails();

  }

  getCompanyDetails() {
    this.companyService.getAllCompanyDetails().subscribe(
      data => {
        console.log('Company details ' , data);
        this.companies = data;
        this.ifPresent = true;
      }
    );
  }

}
