import { Component, OnInit } from "@angular/core";
import { toolService } from "src/services/tool.service";
import { Tool } from "src/models/Tool";
import { jsonpCallbackContext } from "@angular/common/http/src/module";
import { Router } from "@angular/router";
import { NgForm } from "@angular/forms";


@Component({
    selector: 'app-updateTool',
    templateUrl: './updateTool.component.html',
    styleUrls: ['./updateTool.component.css']
})



export class UpdateToolComponent implements OnInit{    
    constructor(private toolService: toolService, private router: Router ){
//////gli import di pacchetti i quali si utilizzano funzioni vanno messi nelle parentesi tonde del costruttore
////// I quali saranno utilizzati come variabili di istanza con la parola speciale THIS
    }
    /////// variabili di istanza dell'oggetto
    public tool: Array<Tool>;
    public tipologia : string;    //USARE STRING MINUSCOLO
    public id:string;
    
    ngOnInit(){
        this.toolService.readAll().subscribe((response) => {
            this.tool = response;
            console.log(this.tool);
        });  
    }
    update(f:NgForm){
      this.id= f.value.idselected;   // id tool
      console.log(this.id);
      this.tipologia= f.value.newTipologia;   //tipologia 
      this.toolService.edit(this.id, this.tipologia).subscribe((response) => {
           if(response != null){
               this.router.navigateByUrl("/toolMenu");
           }
       })
     }
//definisco la classe come java per utilizzare i vari costrutti come this
//simboleggia la classe in java
    indietro(i:NgForm) {
      this.router.navigateByUrl("/toolMenu");
  }
  }

  
