import { Component, OnInit } from "@angular/core";
import { toolService } from "src/services/tool.service";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";
import { ConnectableObservable } from "rxjs";

@Component({
    selector: 'app-insertTool',
    templateUrl: './insertTool.component.html',
    styleUrls: ['./insertTool.component.css']
  })
  export class InsertToolComponent implements OnInit{
    constructor(private toolService: toolService, 
                private router:  Router ){

    }
    ngOnInit(){
    }

    register(f:NgForm){

      /*var customer = sessionStorage.getItem("user"); VARIABILE DI SESSIONE
      var myCustomer = JSON.parse(customer);*/

      this.toolService.newTool(f.value.tipologia).subscribe((Response) => {
          if(Response != null){
              this.router.navigateByUrl("/toolMenu");
          }else{
              console.log("response è null");
          }
      })
  }

  indietro(i:NgForm) {
    this.router.navigateByUrl("/toolMenu");
}
  }
  