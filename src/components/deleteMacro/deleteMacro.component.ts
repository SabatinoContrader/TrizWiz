import { Component, OnInit } from "@angular/core";
import { macroService } from "src/services/macro.service";
import { Macro } from "src/models/Macro";
import { NgForm } from "@angular/forms";
import { Router, ROUTER_CONFIGURATION } from "@angular/router";

@Component({
    selector: 'app-deleteMacro',
    templateUrl: './deleteMacro.component.html',
    styleUrls: ['./deleteMacro.component.css']
  })
  export class DeleteMacroComponent implements OnInit{
      constructor(private macroService: macroService, private router:  Router ){
      }
      public macro: Array<Macro>;
      public Macro: Macro;
      public idMacro : string;
      
      ngOnInit(){
          var ses=JSON.parse(sessionStorage.getItem('user')).nomeLogin;
          console.log(ses);
          this.macroService.readAll(ses).subscribe((response) => {
              this.macro = response;
              console.log(this.macro);
          });  
      }
      delete(f:NgForm){
        this.idMacro=f.value.idSelected;  ///<!-- usernameSelected -->
        var ses=JSON.parse(sessionStorage.getItem('user')).nomeLogin;
        console.log("felice è qui");
        this.macroService.delete(this.idMacro,ses).subscribe((response) => {
            if (response != null) {
                this.router.navigateByUrl("/gestioneMacro");
              }
        });
    }
  }
  