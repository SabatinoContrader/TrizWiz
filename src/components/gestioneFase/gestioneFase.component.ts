import { Component, OnInit } from "@angular/core";
import { SuperuserService } from "src/services/superuser.service";

@Component({
    selector: 'app-gestioneFase',
    templateUrl: './gestioneFase.component.html',
    styleUrls: ['./gestioneFase.component.css']
  })
  export class GestioneFaseComponent implements OnInit{
    constructor(private superuserService: SuperuserService ){

    }
    ngOnInit(){

    }
  }
  