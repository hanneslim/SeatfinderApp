import { Component, OnInit, Input, NgModule } from '@angular/core';
import { MAT_DATE_LOCALE } from '@angular/material/core';
import { Observable } from 'rxjs';
import { PreferencesService } from '../service/preferences.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-preferences',
  templateUrl: './preferences.component.html',
  styleUrls: ['./preferences.component.css']
})


export class PreferencesComponent implements OnInit {
  
  //Stepps für das Dropdown vor und zurück
  step = 0;

  setStep(index: number) {
    this.step = index;
  }

  nextStep() {
    this.step++;
  }

  prevStep() {
    this.step--;
  }


  criteriaData: any[] = [];
  prio1Data: any[] = []; //Für Alle Json Elemente mit Prio 1
  prio2Data: any[] = []; //Für Alle Json Elemente mit Prio 2
  prio3Data: any[] = []; //Für Alle Json Elemente mit Prio 3
  
  //Nachfolgend für die Uhrzeit
  /* 
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

*/
  code:boolean=false;

  @Input()
  result$: Observable<any>;
  
  constructor(private preferencesService: PreferencesService, private router: Router) {
    this.result$ = preferencesService.resolvePreferences();
    if (this.result$ !=null)
    {this.code=true;}
  }

  ngOnInit(){
    this.preferencesService.resolvePreferences().subscribe(data =>{

      for (let index = 0; index < data.criteria.length; index++) {
        if(data.criteria[index].priority==1)
        {
          this.prio1Data.push(data.criteria[index]);
          console.log(this.prio1Data);
        }
        else if(data.criteria[index].priority==2)
        {
          this.prio2Data.push(data.criteria[index]);
          console.log(this.prio2Data);
        }
        else if(data.criteria[index].priority==3)
        {
          this.prio3Data.push(data.criteria[index]);
          console.log(this.prio3Data);
        }
      }


      this.criteriaData = data.criteria;
      //console.log(this.criteriaData)
    })

  }

  onClickNext() {
    console.log("Weiter clicked.")
    this.router.navigate(['/suggestions']);
  }

}
