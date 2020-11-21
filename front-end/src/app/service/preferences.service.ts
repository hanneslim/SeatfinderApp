import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PreferencesService {

  // URL which returns list of JSON items (API end-point URL)
  private readonly URL = 'http://localhost:4200/assets/criteria.json';
  //private readonly URL = 'http://192.168.127.128:8080/criteria';

  constructor(private http: HttpClient) { }

  // create a method named: resolvePreferences()
  // this method returns list-of-preferences in form of Observable
  // every HTTP call returns Observable object
  resolvePreferences(): Observable<any> {
    
    console.log('Request is sent!');
    // this.http is a HttpClient library provide by @angular/common
    // we are calling .get() method over this.http object
    // this .get() method takes URL to call API

    
    return this.http.get(this.URL);
  }
}

