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
    public utenti: Array<NewUtenteLocale>;
    public utenteLocale: UtenteLocale;
    public field : string;
    public username : string;
    public newValue : string;
    constructor(private utentiLocaliService: utentiLocaliService, private router: Router){
        
    }
    ngOnInit() {
        this.utentiLocaliService.readAll().subscribe((response) => {
            this.utenti = response;
            console.log("la size è "+ this.utenti.length);
        });
    }
    update(f:NgForm){
        
        this.username=f.value.usernameSelected;
        this.field=f.value.fieldSelected;
        this.newValue=f.value.value;
        this.utentiLocaliService.update(this.username,this.field,this.newValue).subscribe((response) => {
            this.router.navigateByUrl("/gestioneCustomer");
        });
    }}