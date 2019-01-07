import { Component, OnInit } from "@angular/core";
import { InsertTrizConsultantService } from "src/services/insertTrizConsultant.service";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";
import { CustomerService } from "src/services/customer.service";
import { utentiLocaliService } from "src/services/utentiLocali.service";

@Component({
    selector: 'app-insertTrizConsultant',
    templateUrl: './insertTrizConsultant.component.html',
    styleUrls: ['./insertTrizConsultant.component.css']
  })
  export class InsertTrizConsultantComponent implements OnInit{
    constructor(private utentiLocaliService: utentiLocaliService , private router:  Router){

    }
    ngOnInit(){

    }
    register(f:NgForm){
   
      this.utentiLocaliService.newUtenteLocale(f.value.username,f.value.password, f.value.nome,f.value.cognome,"1").subscribe((response) => {
        if (response != null) {
          this.router.navigateByUrl("/superuser");
        }
        
    });
  
    }

    indietro(i:NgForm) {
      this.router.navigateByUrl("/superuser");
  }
  }