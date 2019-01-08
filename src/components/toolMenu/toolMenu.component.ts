import { Component, OnInit } from "@angular/core";
import { ToolMenuService } from "src/services/toolMenu.service";

@Component({
    selector: 'app-toolMenu',
    templateUrl: './toolMenu.component.html',
    styleUrls: ['./toolMenu.component.css']
  })
  export class ToolMenuComponent implements OnInit{
    constructor(private toolMenuService: ToolMenuService ){

    }
    ngOnInit(){

    }
  }
  