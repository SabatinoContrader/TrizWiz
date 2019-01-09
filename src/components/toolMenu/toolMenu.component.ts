import { Component, OnInit } from "@angular/core";
import { ToolMenuService } from "src/services/toolMenu.service";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";

@Component({
    selector: 'app-toolMenu',
    templateUrl: './toolMenu.component.html',
    styleUrls: ['./toolMenu.component.css']
  })
  export class ToolMenuComponent implements OnInit{
    constructor(private toolMenuService: ToolMenuService, private router: Router){

    }
    ngOnInit(){

    }
    indietro(i:NgForm) {
      this.router.navigateByUrl("/superMenu");
  }
  }
  