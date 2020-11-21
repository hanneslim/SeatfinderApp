import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-suggestions',
  templateUrl: './suggestions.component.html',
  styleUrls: ['./suggestions.component.css']
})
export class SuggestionsComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onClickNext() {
    console.log("Weiter clicked.")
    this.router.navigate(['/suggestions']);
  }

  onClickBack() {
    console.log("Zurück clicked.")
    this.router.navigate(['/preferences']);
  }

}
