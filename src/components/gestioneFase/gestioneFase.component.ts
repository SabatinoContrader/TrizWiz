import { Component, OnInit } from "@angular/core";
import { SuperuserService } from "src/services/superuser.service";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";

@Component({
    selector: 'app-gestioneFase',
    templateUrl: './gestioneFase.component.html',
    styleUrls: ['./gestioneFase.component.css']
  })
  export class GestioneFaseComponent implements OnInit{
    constructor(private superuserService: SuperuserService, private router: Router){

    }
    ngOnInit(){

    }
    indietro(i:NgForm) {
      this.router.navigateByUrl("/gestioneUtenteLocale");
  }
  }
  