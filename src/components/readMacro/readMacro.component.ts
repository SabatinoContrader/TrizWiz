import { Component, OnInit } from "@angular/core";
import { macroService } from "src/services/macro.service";
import { Macro } from "src/models/Macro";

@Component({
    selector: 'app-readMacro',
    templateUrl: './readMacro.component.html',
    styleUrls: ['./readMacro.component.css']
})


export class ReadMacroComponent implements OnInit{
    constructor(private macroService: macroService ){
    }
    public Macro: Array<Macro>;
    
    ngOnInit(){
        var ses= sessionStorage.getItem('nomeLogin');
        this.macroService.readAll(ses).subscribe((response) => {
            this.Macro = response;
        });  
    }
}
  
//definisco la classe come java per utilizzare i vari costrutti come this
//simboleggia la classe in java