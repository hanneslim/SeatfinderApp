import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule, MAT_DATE_LOCALE } from '@angular/material/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PreferencesComponent } from './preferences/preferences.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule} from '@angular/material/slider';
import { SuggestionsComponent } from './suggestions/suggestions.component';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';

@NgModule({
  declarations: [
    AppComponent,
    PreferencesComponent,
    SuggestionsComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatExpansionModule,
    MatIconModule,
    MatButtonModule
  ],
  exports: [
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSliderModule,
    MatExpansionModule,
    MatButtonModule
  ],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'de-DE'},MatDatepickerModule,
    MatNativeDateModule,
    MatSliderModule,
    MatButtonModule ],
  bootstrap: [AppComponent]
})

export class AppModule { }
