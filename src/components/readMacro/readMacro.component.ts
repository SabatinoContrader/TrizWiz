import { Component, OnInit } from "@angular/core";
import { macroService } from "src/services/macro.service";
import { Macro } from "src/models/Macro";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";
import { jsonpCallbackContext } from "@angular/common/http/src/module";

@Component({
    selector: 'app-readMacro',
    templateUrl: './readMacro.component.html',
    styleUrls: ['./readMacro.component.css']
})


export class ReadMacroComponent implements OnInit{
    constructor(private macroService: macroService, private router:  Router){
    }
    public macro: Array<Macro>;
    
    ngOnInit(){
        var ses=JSON.parse(sessionStorage.getItem('user')).nomeLogin;
        console.log(ses);
        this.macroService.readAll(ses).subscribe((response) => {
            this.macro = response;
            console.log(this.macro);
        });  
    }

    indietro(i:NgForm) {
        this.router.navigateByUrl("/gestioneMacro");
    }
}
  
//definisco la classe come java per utilizzare i vari costrutti come this
//simboleggia la classe in java