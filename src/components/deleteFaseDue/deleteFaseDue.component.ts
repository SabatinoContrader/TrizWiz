import { Component, OnInit } from "@angular/core";
import {faseService } from "src/services/fase.service";
import { Fase } from "src/models/Fase";
//import { Router } from "@angular/router";
import { Macro } from "src/models/Macro";
import { NgForm } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
    selector: 'app-deleteFaseDue',
    templateUrl: './deleteFaseDue.component.html',
    styleUrls: ['./deleteFaseDue.component.css']
  })
  export class DeleteFaseDueComponent implements OnInit{

    //public macro: Array<Macro>;
    public fase: Array<Fase>;
           idFase: string;

    constructor(private faseService: faseService, private route: ActivatedRoute, private router:Router ){

    }

    ngOnInit(){

      this.idFase = this.route.snapshot.paramMap.get('idFase');
      console.log("ID MACRO FASE"+this.idFase);
      this.faseService.readAll(this.idFase).subscribe((response) => {
      this.fase= response; })
    }

   /* delete(f:NgForm){
     // this.username=JSON.parse(sessionStorage.getItem('user')).nomeLogin;
     // this.newIdMacro= f.value.idMacro;
     // console.log("MacroID:"+this.newIdMacro);
     //  console.log(this.username);
     //  this.tipologia= f.value.newTipologia;
       this.faseService.readAll(f.value.idMacroFase).subscribe((response) => {
          //this.fase= response;
               this.router.navigateByUrl("/gestioneMacro");
 
           
       })
   
   }*/
  }

  