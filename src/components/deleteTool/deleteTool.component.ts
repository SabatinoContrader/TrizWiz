import { Component, OnInit } from "@angular/core";
import { toolService } from "src/services/tool.service";
import { Tool } from "src/models/Tool";
import { NgForm } from "@angular/forms";
import { jsonpCallbackContext } from "@angular/common/http/src/module";
import { Router, ROUTER_CONFIGURATION } from "@angular/router";

@Component({
    selector: 'app-deleteTool',
    templateUrl: './deleteTool.component.html',
    styleUrls: ['./deleteTool.component.css']
  })
  export class DeleteToolComponent implements OnInit{
    public tool: Array<Tool>;
    public Tool: Tool;
    public idTool : string;
    
    constructor(private toolService: toolService,  private router:  Router ){
    }
    
    ngOnInit(){
      this.toolService.readAll().subscribe((response) => {
        this.tool = response;
        console.log(this.tool);
       });
    }
    delete(f:NgForm){
      this.idTool=f.value.idSelected;  ///<!-- IdSelected -->
      //var ses=JSON.parse(sessionStorage.getItem('user')).nomeLogin;
      this.toolService.delete(this.idTool).subscribe((response) => {
          if (response != null) {
              this.router.navigateByUrl("/toolMenu");
            }
    });
  }

  indietro(i:NgForm) {
    this.router.navigateByUrl("/toolMenu");
}

}