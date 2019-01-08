import { Component, OnInit } from "@angular/core";
import { UserService } from "src/services/user.service";
import { Router } from "@angular/router";
import { NgForm } from "@angular/forms";
import { Customer } from "src/models/Customer";
import { CustomerService } from "src/services/customer.service";
import { utentiLocaliService } from "src/services/utentiLocali.service";
import { UtenteLocale } from "src/models/UtenteLocale";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit{

  utenteLocale : UtenteLocale;

  constructor(private utentiLocaliService:utentiLocaliService, private router:  Router){

  }
  ngOnInit(){
    console.log("eccolo");

  }
  login(f:NgForm): void{
    console.log("mi arrivano username="+ f.value.username + " password= "+ f.value.password)
    this.utentiLocaliService.login(f.value.username, f.value.password).subscribe((response) => {
      if (response != null) {
        this.utenteLocale=response;
        sessionStorage.setItem("user", JSON.stringify(this.utenteLocale));
       // this.router.navigateByUrl("/gestioneUtenteLocale");   
      if(response.ruolo==0)
            this.router.navigateByUrl("/superMenu");
            else if(response.ruolo==1)
            this.router.navigateByUrl("/gestioneUtenteLocale");
            else if(response.ruolo<0||response.ruolo>1)
            this.router.navigateByUrl("/login");
      
               } 
  });
}
}