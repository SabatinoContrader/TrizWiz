import { Component, OnInit } from "@angular/core";


@Component({
    selector: 'app-readTool',
    templateUrl: './readTool.component.html',
    styleUrls: ['./readTool.component.css']
})


export class ReadToolComponent implements OnInit{
    toolService: any;
    constructor( ){
    }
    public tool: Array<ReadToolComponent>;
    
    ngOnInit(){
        var ses=JSON.parse(sessionStorage.getItem('user')).nomeLogin;
        console.log(ses);
        this.toolService.readAll(ses).subscribe((response) => {
            this.tool = response;
            console.log(this.tool);

        });
    }
}    