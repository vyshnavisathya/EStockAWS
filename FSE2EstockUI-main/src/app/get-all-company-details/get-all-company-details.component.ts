import { Component, OnInit } from '@angular/core';
import { Company } from '../model/company';
import { CompanyServiceService } from '../service/company-service.service';

@Component({
  selector: 'app-get-all-company-details',
  templateUrl: './get-all-company-details.component.html',
  styleUrls: ['./get-all-company-details.component.scss']
})
export class GetAllCompanyDetailsComponent implements OnInit {

  companies: any;
  constructor(private companyService: CompanyServiceService) {
    this.companies = [];
  }

  ngOnInit() {
    this.getAllCompanyDetails();
  }

  getAllCompanyDetails() {
    this.companyService.getAllCompanyDetails().subscribe(
      data => {
        console.log('companies', data);
        this.companies = data;
      },
      err => {
        console.log('Error in retriving companies:(');
      });
  }

}
