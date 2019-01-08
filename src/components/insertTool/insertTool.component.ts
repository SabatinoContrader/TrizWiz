import { Component, OnInit } from "@angular/core";
import { SuperuserService } from "src/services/superuser.service";

@Component({
    selector: 'app-insertTool',
    templateUrl: './insertTool.component.html',
    styleUrls: ['./insertTool.component.css']
  })
  export class InsertToolComponent implements OnInit{
    constructor(private superuserService: SuperuserService ){

    }
    ngOnInit(){

    }
  }
  