import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  addCompany = function() {
    this.router.navigate(['/login']);
  };

  getAllCompanies = function() {
    this.router.navigate(['/register']);
  };

  addStock = function() {
    this.router.navigate(['/add-stock']);
  };

  getStock = function() {
    this.router.navigate(['/get-stock']);
  };

  getCompany = function() {
    this.router.navigate(['/get-company']);
  };

}
