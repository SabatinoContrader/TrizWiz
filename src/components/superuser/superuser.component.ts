import { Component, OnInit } from "@angular/core";
import { SuperuserService } from "src/services/superuser.service";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";

@Component({
    selector: 'app-superuser',
    templateUrl: './superuser.component.html',
    styleUrls: ['./superuser.component.css']
  })
  export class SuperuserComponent implements OnInit{
    constructor(private superuserService: SuperuserService, private router: Router){

    }
    ngOnInit(){

    }
    indietro(i:NgForm) {
      this.router.navigateByUrl("/superMenu");
  }
  }
  