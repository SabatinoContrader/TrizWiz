import { Component, OnInit } from "@angular/core";
import { SuperuserService } from "src/services/superuser.service";

import { faseService } from "src/services/fase.service";
import { Fase } from "src/models/fase";
import { ActivatedRoute, Router } from "@angular/router";
import { NgForm } from "@angular/forms";



@Component({
  selector: 'app-updateFaseDue',
  templateUrl: './updateFaseDue.component.html',
  styleUrls: ['./updateFaseDue.component.css']
  })
  export class UpdateFaseDueComponent implements OnInit{


    public newIdFase : string;
    public username : string;
    public tipologia : string;
    public fase: Array<Fase>;
    idFase: string;

    constructor(private faseService: faseService, private route: ActivatedRoute, private router:Router ){
    }
    
    ngOnInit(){
        this.idFase = this.route.snapshot.paramMap.get('idFase');
        this.faseService.readAll(this.idFase).subscribe((response) => {
            this.fase = response;
            console.log(this.fase);
        });

      
    
    }

    update(f:NgForm){
      this.newIdFase= f.value.idFase;
     this.tipologia= f.value.newTipologia;
     console.log("FaseID:"+this.newIdFase);
      this.tipologia= f.value.newTipologia;
      this.faseService.edit(this.newIdFase, this.tipologia,this.idFase).subscribe((response) => {
          if(response != null){
              this.router.navigateByUrl("/gestioneFase");
          }

          
      })
  
  }

  indietro(i:NgForm) {
    this.router.navigateByUrl("/updateFase");
}
  }
  

  