import { Component, OnInit } from "@angular/core";
import { SuperuserService } from "src/services/superuser.service";

@Component({
    selector: 'app-gestioneTool',
    templateUrl: './gestioneTool.component.html',
    styleUrls: ['./gestioneTool.component.css']
  })
  export class GestioneToolComponent implements OnInit{
    constructor(private superuserService: SuperuserService ){

    }
    ngOnInit(){

    }
  }