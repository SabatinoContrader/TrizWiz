import { Component, OnInit } from "@angular/core";
import { SuperuserService } from "src/services/superuser.service";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";

@Component({
    selector: 'app-gestioneTool',
    templateUrl: './gestioneTool.component.html',
    styleUrls: ['./gestioneTool.component.css']
  })
  export class GestioneToolComponent implements OnInit{
    constructor(private superuserService: SuperuserService, private router: Router){

    }
    ngOnInit(){

    }
    indietro(i:NgForm) {
      this.router.navigateByUrl("/gestioneUtenteLocale");
  }
  }