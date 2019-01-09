import { Component, OnInit } from "@angular/core";
import { Fase } from "src/models/Fase";
import { Macro } from "src/models/Macro";import { faseService } from "src/services/fase.service";
import { macroService } from "src/services/macro.service";
import { ActivatedRoute, Router } from "@angular/router";
import { NgForm } from "@angular/forms";
@Component({
    selector: 'app-insertFase',
    templateUrl: './insertFase.component.html',
    styleUrls: ['./insertFase.component.css']
})
export class InsertFaseComponent implements OnInit {

    public macro: Array<Macro>;
    public fase: Array<Fase>;
    idFase: string;
    constructor(private faseService: faseService, private macroService: macroService, private route: ActivatedRoute, private router:Router) {
    }
    ngOnInit() {

        var ses=JSON.parse(sessionStorage.getItem('user')).nomeLogin;
        console.log(ses);
        this.macroService.readAll(ses).subscribe((response) => {
            this.macro = response;
            console.log(this.macro);
        });
    }

    insert(f:NgForm){
        this.faseService.newFase(f.value.tipologia, f.value.idMacroFase).subscribe((Response) => {
            console.log("compareeeee");
            if(Response != null){
                this.router.navigateByUrl("/gestioneFase");
            } else{
                console.log("response è null");
            }
        })          
   }
}