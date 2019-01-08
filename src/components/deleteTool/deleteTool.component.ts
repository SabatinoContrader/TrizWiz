import { Component, OnInit } from "@angular/core";
import { SuperuserService } from "src/services/superuser.service";

@Component({
    selector: 'app-deleteTool',
    templateUrl: './deleteTool.component.html',
    styleUrls: ['./deleteTool.component.css']
  })
  export class DeleteToolComponent implements OnInit{
    constructor(private superuserService: SuperuserService ){

    }
    ngOnInit(){

    }
  }
  