import { Component, OnInit } from "@angular/core";
import { SuperMenuService } from "src/services/superMenu.service";

@Component({
    selector: 'app-superMenu',
    templateUrl: './superMenu.component.html',
    styleUrls: ['./superMenu.component.css']
  })
  export class SuperMenuComponent implements OnInit{
    constructor(private superMenuService: SuperMenuService ){

    }
    ngOnInit(){

    }
  }
  