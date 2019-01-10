import { Component, OnInit } from "@angular/core";
import { Fase } from "src/models/Fase";
import { Macro } from "src/models/Macro";
import { faseService } from "src/services/fase.service";
import { macroService } from "src/services/macro.service";
import { ActivatedRoute, Router } from "@angular/router";
import { NgForm } from "@angular/forms";
import { collegamentoService } from "src/services/collegamento.service";
import { Collegamento } from "src/models/Collegamento";
import { Tool } from "src/models/Tool";

@Component({
    selector: 'app-deleteCollegamento',
    templateUrl: './deleteCollegamento.component.html',
    styleUrls: ['./deleteCollegamento.component.css']
})
export class DeleteCollegamentoComponent implements OnInit {


    public macro: Array<Macro>;
    public fase: Array<Fase>;
    public collegamento: Array<Collegamento>;
    public tool: Tool;
    idMacro: string;
    constructor(private faseService: faseService,private collegamentoService: collegamentoService, private macroService: macroService, private route: ActivatedRoute, private router:Router) {
    }
    ngOnInit() {

        var ses=JSON.parse(sessionStorage.getItem('user')).nomeLogin;
        console.log(ses);
        this.macroService.readAll(ses).subscribe((response) => {
            this.macro = response;
            console.log(this.macro);
        });
    }


    read (f:NgForm){
      this.idMacro= f.value.idMacroFase;
      this.faseService.readAll(this.idMacro).subscribe((response) => {
        this.fase= response; })         
   }

   readFase(g:NgForm){
       var idFase=g.value.idFase;
       this.collegamentoService.readAll(idFase).subscribe((response) => {
        this.collegamento= response; 
       /*this.collegamento.forEach(coll => {   --> Stampa di array
            this.tool=coll.tool;
        console.log("ID TOOL"+coll.tool.idTool);
        });*/
       
     // console.log(this.collegamento);
        })  
        
          
   }
   delete(h:NgForm){
    var idCollegamento=h.value.idCollegamento;  ///<!-- usernameSelected -->
    this.collegamentoService.delete(idCollegamento).subscribe((response) => {
        if (response != null) {
            this.router.navigateByUrl("/gestioneTool");
          }
    });
   }


    indietro(i:NgForm) {
      this.router.navigateByUrl("/gestioneTool");
  }
  }
