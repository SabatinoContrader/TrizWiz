import { OnInit, Component } from "@angular/core";
import { CustomerService } from "src/services/customer.service";
import { Router, ROUTER_CONFIGURATION } from "@angular/router";
import { NewCustomer } from "src/models/NewCustomer";
import { NgForm } from "@angular/forms";
import { NewUtenteLocale } from "src/models/NewUtenteLocale";
import { utentiLocaliService } from "src/services/utentiLocali.service";
import { UtenteLocale } from "src/models/UtenteLocale";

@Component({
    selector: 'app-deleteTrizConsultant',
    templateUrl: './deleteTrizConsultant.component.html',
    styleUrls: ['./deleteTrizConsultant.component.css']
})
export class DeleteTrizConsultantComponent implements OnInit{
    public utenti: Array<NewUtenteLocale>; //array di utenti selezionati nel ngOnInit
    public utenteLocale: UtenteLocale;
    public username : string;
    constructor(private utentiLocaliService: utentiLocaliService, private router: Router){}
        ngOnInit(){ 
        this.utentiLocaliService.readAll().subscribe((response) => {
            this.utenti = response;
            //console.log("la size è "+ this.utenti.length);
        });
}
    delete(f:NgForm){
        this.username=f.value.usernameSelected;  ///<!-- usernameSelected -->
        //console.log("la size del cazzo è "+ f.value.usernameSelected);
        this.utentiLocaliService.delete(this.username).subscribe((response) => {
        //this.utentiLocaliService.delete(f.value.usernameSelected).subscribe((response)=>{
            if (response != null) {
                this.router.navigateByUrl("/superuser");
              }
        });
    }

    indietro(i:NgForm) {
        this.router.navigateByUrl("/superuser");
    }
}