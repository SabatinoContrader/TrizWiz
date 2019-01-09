import { Component, OnInit } from "@angular/core";
import { Fase } from "src/models/Fase";
import { Macro } from "src/models/Macro";
import { faseService } from "src/services/fase.service";
import { macroService } from "src/services/macro.service";
import { ActivatedRoute, Router } from "@angular/router";
import { NgForm } from "@angular/forms";

@Component({
    selector: 'app-readFase',
    templateUrl: './readFase.component.html',
    styleUrls: ['./readFase.component.css']
})
export class ReadFaseComponent implements OnInit {


    public macro: Array<Macro>;
    public fase: Array<Fase>;
    idMacro: string;
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


    read (f:NgForm){
      this.idMacro= f.value.idMacroFase;
      this.faseService.readAll(this.idMacro).subscribe((response) => {
        this.fase= response; })         
   }


    indietro(i:NgForm) {
      this.router.navigateByUrl("/gestioneFase");
  }
  }
