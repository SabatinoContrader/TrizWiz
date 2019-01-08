import { Component, OnInit } from "@angular/core";
import { SuperuserService } from "src/services/superuser.service";

@Component({
    selector: 'app-updateTool',
    templateUrl: './updateTool.component.html',
    styleUrls: ['./updateTool.component.css']
  })
  export class UpdateToolComponent implements OnInit{
    constructor(private superuserService: SuperuserService ){

    }
    ngOnInit(){

    }
  }
  