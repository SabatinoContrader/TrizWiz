import { Component, OnInit } from "@angular/core";
import { SuperuserService } from "src/services/superuser.service";

@Component({
    selector: 'app-updateMacro',
    templateUrl: './updateMacro.component.html',
    styleUrls: ['./updateMacro.component.css']
  })
  export class UpdateMacroComponent implements OnInit{
    constructor(private superuserService: SuperuserService ){

    }
    ngOnInit(){

    }
  }
  