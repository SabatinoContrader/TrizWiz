import { Component, OnInit } from "@angular/core";
import { SuperuserService } from "src/services/superuser.service";

@Component({
    selector: 'app-deleteFase',
    templateUrl: './deleteFase.component.html',
    styleUrls: ['./deleteFase.component.css']
  })
  export class DeleteFaseComponent implements OnInit{
    constructor(private superuserService: SuperuserService ){

    }
    ngOnInit(){

    }
  }
  