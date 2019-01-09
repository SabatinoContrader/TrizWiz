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
           idFaseDel: string;

    constructor(private faseService: faseService, private route: ActivatedRoute, private router:Router ){

    }

    ngOnInit(){

      this.idFase = this.route.snapshot.paramMap.get('idFase');
      console.log("ID MACRO FASE"+this.idFase);
      this.faseService.readAll(this.idFase).subscribe((response) => {
      this.fase= response; })
    }

    delete(f:NgForm){
     
      this.idFaseDel=f.value.idFaseCanc;  ///<!-- usernameSelected -->
      this.faseService.delete(this.idFase,this.idFaseDel).subscribe((response) => {
          if (response != null) {
              this.router.navigateByUrl("/gestioneFase");
            }
      });
  }
  indietro(i:NgForm) {
    this.router.navigateByUrl("/deleteFase");
}
  }

  