import { Component, OnInit } from "@angular/core";
import { UserService } from "src/services/user.service";
import { Router } from "@angular/router";
import { NgForm } from "@angular/forms";
import { Customer } from "src/models/Customer";
import { CustomerService } from "src/services/customer.service";
import { utentiLocaliService } from "src/services/utentiLocali.service";
import { UtenteLocale } from "src/models/UtenteLocale";

/*import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  feedback: string;
  user: User;

  constructor(private userService: UserService, private router: Router){

  }

  ngOnInit(){
    this.feedback = this.userService.feedback;
    this.userService.deleteFeedback();
  }

  login(f: NgForm): void{
      this.userService.login(f.value.username, f.value.password).subscribe((response) => {
        if (response != null) {
          this.user = response;
          sessionStorage.setItem("user", JSON.stringify(this.user));
          if(response.type == 1)
            this.router.navigateByUrl("/homeDriver");
          else if(response.type == 0)
            this.router.navigateByUrl("/homeOwner");
        } else
            this.feedback = "Username o password errati";
      });
  }


}
*/

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
        this.router.navigateByUrl("/gestioneUtenteLocale");   
     /*   if(response.ruolo==1)
            this.router.navigateByUrl("/superuser");
            else if(response.ruolo==2)
            this.router.navigateByUrl("/gestioneBuilding");
            else if(response.ruolo==3)
            this.router.navigateByUrl("/installer");
      
      */          } 
  });
}
}