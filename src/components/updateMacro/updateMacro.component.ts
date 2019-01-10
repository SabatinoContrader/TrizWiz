import { Component, OnInit } from "@angular/core";
import { SuperuserService } from "src/services/superuser.service";


import { macroService } from "src/services/macro.service";
import { Macro } from "src/models/macro";
import { Router } from "@angular/router";
import { NgForm } from "@angular/forms";



@Component({
    selector: 'app-updateMacro',
    templateUrl: './updateMacro.component.html',
    styleUrls: ['./updateMacro.component.css']
  })
  export class UpdateMacroComponent implements OnInit{

    public newIdMacro : string;
    public username : string;
    public tipologia : string;
    public macro: Array<Macro>;

    constructor(private macroService: macroService, private router:Router){
    }
    
    ngOnInit(){

      var ses=JSON.parse(sessionStorage.getItem('user')).nomeLogin;
        console.log(ses);
        this.macroService.readAll(ses).subscribe((response) => {
            this.macro = response;
            console.log(this.macro);
        });

    }

    update(f:NgForm){
     this.username=JSON.parse(sessionStorage.getItem('user')).nomeLogin;
     this.newIdMacro= f.value.idMacro;
     console.log("MacroID:"+this.newIdMacro);
      console.log(this.username);
      this.tipologia= f.value.newTipologia;
      this.macroService.edit(this.newIdMacro,this.tipologia,this.username).subscribe((response) => {
          if(response != null){
              this.router.navigateByUrl("/gestioneMacro");
          }

          
      })
  
  }

  indietro(i:NgForm) {
    this.router.navigateByUrl("/gestioneMacro");
}
  }
  