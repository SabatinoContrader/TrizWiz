import { Component, OnInit } from "@angular/core";
import { macroService } from "src/services/macro.service";

@Component({
    selector: 'app-gestioneMacro',
    templateUrl: './gestioneMacro.component.html',
    styleUrls: ['./gestioneMacro.component.css']
  })
  export class GestioneMacroComponent implements OnInit{
    constructor(private macroService: macroService ){

    }
    ngOnInit(){

    }
  }
  