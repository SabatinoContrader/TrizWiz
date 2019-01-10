import { Component, OnInit } from "@angular/core";
import { Fase } from "src/models/Fase";
import { Macro } from "src/models/Macro";
import { toolService } from "src/services/tool.service";
import { faseService } from "src/services/fase.service";
import { macroService } from "src/services/macro.service";
import { ActivatedRoute, Router } from "@angular/router";
import { NgForm } from "@angular/forms";
import { collegamentoService } from "src/services/collegamento.service";
import { Collegamento } from "src/models/Collegamento";
import { Tool } from "src/models/Tool";
@Component({
    selector: 'app-insertCollegamento',
    templateUrl: './insertCollegamento.component.html',
    styleUrls: ['./insertCollegamento.component.css']
})
export class InsertCollegamentoComponent implements OnInit {
    constructor(    private toolService: toolService,
                    private collegamentoService: collegamentoService, 
                    private router:  Router,
                    private faseService: faseService,
                    private macroService: macroService,
                    private route: ActivatedRoute,
    ){}

    public tool: Array<Tool>; // mi serve per stampare i tool
    public fase: Array<Fase>; // mi serve per stampare le fasi
    public macro: Array<Macro>; // mi serve per stampare le macro
    public collegamento: Array<Collegamento>; // mi serve per stampare i collegamenti
    idMacro : string;
    idFase: string;
    idTool: string;
    commento: string;

    ngOnInit(): void {
        this.toolService.readAll().subscribe((response) => {
            this.tool = response;
            console.log(this.tool);

        });
        
        var ses=JSON.parse(sessionStorage.getItem('user')).nomeLogin;
        console.log(ses);
        this.macroService.readAll(ses).subscribe((response) => {
            this.macro = response;
            console.log(this.macro);
        });


    }

    read (f:NgForm){
        this.idMacro= f.value.idMacroFase;
        console.log("ID MACRO"+this.idMacro);
        this.faseService.readAll(this.idMacro).subscribe((response) => {
          this.fase= response; })         
    }

    insert (t:NgForm){
        this.idFase= t.value.idFase;
        this.idTool= t.value.idTool;
        this.commento= t.value.commento;
        console.log("fase: "+this.idFase+" tool: "+ this.idTool+" commento: "+ this.commento);
        this.collegamentoService.newCollegamento(this.idFase,this.idTool,this.commento).subscribe((response) => {
            if(Response != null){
                this.router.navigateByUrl("/gestioneTool");
            } else{
                console.log("response è null");
            } })      
    }

}