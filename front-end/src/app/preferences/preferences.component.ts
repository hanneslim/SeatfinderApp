import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { PreferencesService } from '../service/preferences.service';

@Component({
  selector: 'app-preferences',
  templateUrl: './preferences.component.html',
  styleUrls: ['./preferences.component.css']
})
export class PreferencesComponent implements OnInit {
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
