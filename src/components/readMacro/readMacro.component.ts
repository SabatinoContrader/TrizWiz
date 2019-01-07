import { Component, OnInit } from "@angular/core";
import { macroService } from "src/services/macro.service";
import { Macro } from "src/models/Macro";
import { jsonpCallbackContext } from "@angular/common/http/src/module";

@Component({
    selector: 'app-readMacro',
    templateUrl: './readMacro.component.html',
    styleUrls: ['./readMacro.component.css']
})


export class ReadMacroComponent implements OnInit{
    constructor(private macroService: macroService ){
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
}
  
//definisco la classe come java per utilizzare i vari costrutti come this
//simboleggia la classe in java