import { Component, OnInit } from "@angular/core";
import { SuperuserService } from "src/services/superuser.service";

@Component({
    selector: 'app-readFase',
    templateUrl: './readFase.component.html',
    styleUrls: ['./readFase.component.css']
  })
  export class ReadFaseComponent implements OnInit{
    constructor(private superuserService: SuperuserService ){

    }
    ngOnInit(){

    }
  }
  