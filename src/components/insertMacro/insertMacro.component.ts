import { Component, OnInit } from "@angular/core";
import { SuperuserService } from "src/services/superuser.service";

@Component({
    selector: 'app-superuser',
    templateUrl: './insertMacro.component.html',
    styleUrls: ['./insertMacro.component.css']
  })
  export class InsertMacroComponent implements OnInit{
    constructor(private superuserService: SuperuserService ){

    }
    ngOnInit(){

    }
  }
  