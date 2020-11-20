import { Component, OnInit, Input, NgModule } from '@angular/core';
import { MAT_DATE_LOCALE } from '@angular/material/core';
import { Observable } from 'rxjs';
import { PreferencesService } from '../service/preferences.service';
import {
  FormBuilder,
  FormGroup,
  FormArray,
  FormControl,
  ValidatorFn
} from '@angular/forms';

@Component({
  selector: 'app-preferences',
  templateUrl: './preferences.component.html',
  styleUrls: ['./preferences.component.css']
})


export class PreferencesComponent implements OnInit {
  
  onChangeRange(rangeValue: any) {
    console.log(rangeValue);
    //this.showTime = rangeValue;
  }


  formatLabel(value: number | null) {
    if (!value) {
      return 0;
    }
    var hhPart;
    let decimalPart = +value.toString().replace(/^[^\.]+/,'0');
    let mm = decimalPart * 60;
    var mmPart = mm.toString().length == 1 ? mm.toString() + "0" : mm.toString();

    if (value >= 0) {
      let valueStr = value.toFixed(2);
      let strArr = valueStr.split(".");
      if(strArr[0].length == 1) {
        strArr[0] = "0" + strArr[0];
      }
      hhPart = strArr[0];
    }

    return hhPart + ":" + mmPart;
  }


  code:boolean=false;

  @Input()
  result$: Observable<any>;
  
  constructor(private preferencesService: PreferencesService) {
    this.result$ = preferencesService.resolvePreferences();
    if (this.result$ !=null)
    {this.code=true;}

  }

  ngOnInit(){
  }

}
