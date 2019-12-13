import { Component,OnInit,ViewChild } from '@angular/core';
import {FlightserviceService} from '../app/flightservice.service';
import { MatTableDataSource,MatDatepickerInputEvent } from '@angular/material';
import { flight} from './flight';
import { HttpErrorResponse } from '@angular/common/http';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'my-app';
  flightServicesCol: string[] = ['flightNumber', 'carrier','origin','departure','destination','arrival','distance','travelTime', 'status'];
  dataSource = new MatTableDataSource();
  flightData : flight[] = [];
  errorMessage:string = '';

  constructor(private fs:FlightserviceService,private datePipe: DatePipe){}

  search(flightNumber:string,origin:string,destination:string, date:string){
      console.log(flightNumber +"-"+origin+"-"+destination+"-"+date);
      if(date === undefined){
        return this.errorMessage = 'Date cannot be Empty - Please enter date';
      }
      if(flightNumber === undefined || (origin === undefined && destination === undefined)){
        return this.errorMessage = 'Flight Number OR with origin AND destination is required';
      }

      console.log(this.datePipe.transform(date, "yyyy-MM-dd'T'HH:mm:ss"));
      const updateDate = this.datePipe.transform(date, "yyyy-MM-dd'T'HH:mm:ss");
      this.fs.search(flightNumber,origin,destination,updateDate).subscribe(res =>{
        console.log(res);
        this.flightData = res;
        this.dataSource = new MatTableDataSource(this.flightData);
      }, error => this.handleError(error))
  }

  handleError(error) {
    if (error instanceof HttpErrorResponse) {
      if(200 == error.status && error.name === "HttpErrorResponse"){
        this.errorMessage = 'BAD REQUEST - Null/change Parameters';
      }
      if(400 == error.status){
        this.errorMessage = 'Flight Number Cannot be empty';
      }
    }
  }
}