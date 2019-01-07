import { Component, OnInit } from "@angular/core";
import { SuperuserService } from "src/services/superuser.service";
@Component({
    selector: 'app-insertFase',
    templateUrl: './insertFase.component.html',
    styleUrls: ['./insertFase.component.css']
})
export class InsertFaseComponent implements OnInit {
    constructor(private superuserService: SuperuserService) {
    }
    ngOnInit() {
    }
}