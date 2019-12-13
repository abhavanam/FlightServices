import { Injectable } from '@angular/core';
import { HttpClient, HttpParams,HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FlightserviceService {

  constructor(private httpClient: HttpClient) { }

  private headers = {headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Accept': 'application/json',
    'Access-Control-Allow-Headers': '*',
    'Access-Control-Allow-Methods': 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
  })};

  search(flightNumber:string,origin:string,destination:string,date:string){
    const params = new HttpParams();
    const url = "http://localhost:8080/flights/"+
                flightNumber+"/origin/"+origin+"/destination/"+destination+"/date/"+date;
    console.log(url);
    return this.httpClient.get<any>(url, { params });
  }
}
