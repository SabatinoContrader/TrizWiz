import { Component, OnInit } from "@angular/core";
import { SuperuserService } from "src/services/superuser.service";

@Component({
    selector: 'app-updateFase',
    templateUrl: './updateFase.component.html',
    styleUrls: ['./updateFase.component.css']
  })
  export class UpdateFaseComponent implements OnInit{
    constructor(private superuserService: SuperuserService ){

    }
    ngOnInit(){

    }
  }
  