import { Component, OnInit } from "@angular/core";
import { CustomerService } from "src/services/customer.service";
import { Router } from "@angular/router";
import { NgForm } from "@angular/forms";
import { Customer } from "src/models/Customer";
import { identifierModuleUrl } from "@angular/compiler";
import { NewUtenteLocale } from "src/models/NewUtenteLocale";
import { utentiLocaliService } from "src/services/utentiLocali.service";
import { UtenteLocale } from "src/models/UtenteLocale";

@Component({
    selector: 'app-updateTrizConsultant',
    templateUrl: './updateTrizConsultant.component.html',
    styleUrls: ['./updateTrizConsultant.component.css']
})
export class UpdateTrizConsultantComponent implements OnInit{
    public utenti: Array<NewUtenteLocale>; //array di utenti selezionati nel ngOnInit
    public utenteLocale: UtenteLocale;
    public field : string;
    public username : string;
    public newValue : string;
    constructor(private utentiLocaliService: utentiLocaliService, private router: Router){
        
    }
    //esegue operazioni prima di caricare la pagina, azioni preliminari
    ngOnInit() {
        this.utentiLocaliService.readAll().subscribe((response) => {
            this.utenti = response;
            console.log("la size è "+ this.utenti.length);
        });
    }
    update(f:NgForm){
        
        this.username=f.value.usernameSelected;  ///<!-- usernameSelected -->
        this.field=f.value.fieldSelected;       ////variabile di scelta
        this.newValue=f.value.value;            ////modifica del campo
        this.utentiLocaliService.update(this.username,this.field,this.newValue).subscribe((response) => {
            this.router.navigateByUrl("/superuser");
        });
    }
    indietro(i:NgForm) {
        this.router.navigateByUrl("/superuser");
    }}