import { Component, OnInit } from "@angular/core";
import { SuperuserService } from "src/services/superuser.service";

@Component({
    selector: 'app-superuser',
    templateUrl: './deleteMacro.component.html',
    styleUrls: ['./deleteMacro.component.css']
  })
  export class DeleteMacroComponent implements OnInit{
    constructor(private superuserService: SuperuserService ){

    }
    ngOnInit(){

    }
  }
  