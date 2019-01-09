import { Component, OnInit } from "@angular/core";
import { toolService } from "src/services/tool.service";
import { Tool } from "src/models/Tool";
import { jsonpCallbackContext } from "@angular/common/http/src/module";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";



@Component({
    selector: 'app-readTool',
    templateUrl: './readTool.component.html',
    styleUrls: ['./readTool.component.css']
})


export class ReadToolComponent implements OnInit{
    
    constructor( private toolService: toolService, private router:  Router){
    }
    public tool: Array<Tool>;
    
    ngOnInit(){
        this.toolService.readAll().subscribe((response) => {
            this.tool = response;
            console.log(this.tool);

        });
    }

    indietro(i:NgForm) {
        this.router.navigateByUrl("/toolMenu");
    }
}    