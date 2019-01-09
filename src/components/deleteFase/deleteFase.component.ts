import { Component, OnInit } from "@angular/core";
import {faseService } from "src/services/fase.service";
import { Fase } from "src/models/Fase";
//import { Router } from "@angular/router";
import { Macro } from "src/models/Macro";
import { NgForm } from "@angular/forms";
import {macroService } from "src/services/macro.service";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
    selector: 'app-deleteFase',
    templateUrl: './deleteFase.component.html',
    styleUrls: ['./deleteFase.component.css']
  })
  export class DeleteFaseComponent implements OnInit{

    public macro: Array<Macro>;
    public fase: Array<Fase>;
    idFase: string;

    constructor(private faseService: faseService, private macroService: macroService, private route: ActivatedRoute, private router:Router ){

    }

    ngOnInit(){

        var ses=JSON.parse(sessionStorage.getItem('user')).nomeLogin;
          console.log(ses);
          this.macroService.readAll(ses).subscribe((response) => {
              this.macro = response;
              console.log(this.macro);
          });
    }

    delete(f:NgForm){
        this.idFase = f.value.idMacroFase;
            this.router.navigateByUrl("/deleteFaseDue/"+this.idFase);
        
     // this.username=JSON.parse(sessionStorage.getItem('user')).nomeLogin;
     // this.newIdMacro= f.value.idMacro;
     // console.log("MacroID:"+this.newIdMacro);
     //  console.log(this.username);
     //  this.tipologia= f.value.newTipologia;
     //  this.faseService.readAll(f.value.idMacroFase).subscribe((response) => {
     //     this.fase= response;
     //          this.router.navigateByUrl("/deleteFaseDue"+fase);

 
           
       
   
   }
   indietro(i:NgForm) {
    this.router.navigateByUrl("/gestioneFase");
}
  }

  