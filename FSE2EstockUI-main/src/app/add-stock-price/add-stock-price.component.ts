import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormGroupDirective, Validators } from '@angular/forms';
import { send } from 'process';
import { Stock } from '../model/stock';
import { StockServiceService } from '../service/stock-service.service';

@Component({
  selector: 'app-add-stock-price',
  templateUrl: './add-stock-price.component.html',
  styleUrls: ['./add-stock-price.component.scss']
})
export class AddStockPriceComponent implements OnInit {

  stock: Stock;
  stockForm: FormGroup;

  constructor(private stockService: StockServiceService) { }

  ngOnInit() {
    this.stockForm = new FormGroup({
      // id : new FormControl('', [Validators.required]),
      stockPrice : new FormControl('', [Validators.required]),
      companyCode : new FormControl('', [Validators.required])
    });
  }
  send(stockForm) {
    console.log('stock Fprm' , stockForm.value);
    this.stockService.addStock(stockForm.value).subscribe(
      data => {
        stockForm.reset();
      }, err  => {
        alert('API call failed:(');
      }
    );

  }

  resetForm(stockForm ) {
    stockForm.reset();
  }

}
