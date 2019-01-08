import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";
import { macroService } from "src/services/macro.service";
import { ConnectableObservable } from "rxjs";
import {Macro} from "src/models/Macro"


@Component({
    selector: 'app-insertMacro',
    templateUrl: './insertMacro.component.html',
    styleUrls: ['./insertMacro.component.css']
  })
  export class InsertMacroComponent implements OnInit{
    constructor(private macroService: macroService , private router:  Router ){

    }
    ngOnInit(){
     
    }
    register(f:NgForm){

      var customer = sessionStorage.getItem("user");
      var myCustomer = JSON.parse(customer);
      console.log(myCustomer.nomeLogin);
      console.log("compareeeee"+myCustomer.nomeLogin);
      this.macroService.newMacro(f.value.tipologia, myCustomer.nomeLogin).subscribe((Response) => {
          console.log("compareeeee");

          if(Response != null){
              this.router.navigateByUrl("/gestioneMacro");
          } else{
              console.log("response è null");
          }
      })
  }
}