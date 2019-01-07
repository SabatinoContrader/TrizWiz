import { Component, OnInit } from "@angular/core";
import { CustomerService } from "src/services/customer.service";
import { Router } from "@angular/router";
import { NgForm } from "@angular/forms";
import { NewUtenteLocale } from "src/models/NewUtenteLocale";
import { utentiLocaliService } from "src/services/utentiLocali.service";

@Component({
    selector: 'app-readTrizConsultant',
    templateUrl: './readTrizConsultant.component.html',
    styleUrls: ['./readTrizConsultant.component.css']
})
export class ReadTrizConsultantComponent implements OnInit{

    public utenti: Array<NewUtenteLocale>;

    constructor(private utentiLocaliService: utentiLocaliService, private router: Router){

    }
    ngOnInit(){
        this.utentiLocaliService.readAll().subscribe((response) => {
            this.utenti = response;
        });
    }

    indietro(i:NgForm) {
        this.router.navigateByUrl("/superuser");
    }
}