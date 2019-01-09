import { Component, OnInit } from "@angular/core";
import { macroService } from "src/services/macro.service";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";

@Component({
    selector: 'app-gestioneMacro',
    templateUrl: './gestioneMacro.component.html',
    styleUrls: ['./gestioneMacro.component.css']
  })
  export class GestioneMacroComponent implements OnInit{
    constructor(private macroService: macroService, private router: Router){

    }
    ngOnInit(){

    }

    indietro(i:NgForm) {
      this.router.navigateByUrl("/gestioneUtenteLocale");
  }
  }
  