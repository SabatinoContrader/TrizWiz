import { LoginComponent } from "../components/login/login.component";
import { FormsModule } from "@angular/forms";
import { NgModule } from "@angular/core";
import { TreeModule } from 'primeng/primeng';
import { DragDropModule} from 'primeng/dragdrop';
import { HttpClientModule } from "@angular/common/http";
import { AppRoutingModule } from "./app-routing.module";
import { UserService } from "../services/user.service";
import {BrowserModule} from '@angular/platform-browser';
import { AppComponent } from "./app.component";
import { SignupComponent } from "../components/signup/signup.component";
import { AgmCoreModule } from '@agm/core';
import { SuperuserComponent } from '../components/superuser/superuser.component';
import { SuperuserService } from '../services/superuser.service';
import { InsertTrizConsultantComponent } from '../components/insertTrizConsultant/insertTrizConsultant.component';
import { ReadTrizConsultantComponent } from '../components/readTrizConsultant/readTrizConsultant.component';
import { UpdateTrizConsultantComponent } from '../components/updateTrizConsultant/updateTrizConsultant.component';
import { DeleteTrizConsultantComponent } from '../components/deleteTrizConsultant/deleteTrizConsultant.component';
import { utentiLocaliService } from '../services/utentiLocali.service';
import { GestioneUtenteLocaleComponent } from '../components/gestioneUtenteLocale/gestioneUtenteLocale.component';
import { GestioneMacroComponent } from '../components/gestioneMacro/gestioneMacro.component';
import { DeleteMacroComponent } from '../components/deleteMacro/deleteMacro.component';
import { InsertMacroComponent } from '../components/insertMacro/insertMacro.component';
import { ReadMacroComponent } from '../components/readMacro/readMacro.component';
import { UpdateMacroComponent } from '../components/updateMacro/updateMacro.component';
import { macroService } from '../services/macro.service';
import { GestioneFaseComponent } from 'src/components/gestioneFase/gestioneFase.component';
import { InsertFaseComponent } from 'src/components/insertFase/insertFase.component';
import { ReadFaseComponent } from 'src/components/readFase/readFase.component';
import { UpdateFaseComponent } from 'src/components/updateFase/updateFase.component';
import { DeleteFaseComponent } from 'src/components/deleteFase/deleteFase.component';
import { DeleteFaseDueComponent } from 'src/components/deleteFaseDue/deleteFaseDue.component';
import { GestioneToolComponent } from 'src/components/gestioneTool/gestioneTool.component';
import { InsertToolComponent } from 'src/components/insertTool/insertTool.component';
import { ReadToolComponent } from 'src/components/readTool/readTool.component';
import { DeleteToolComponent } from 'src/components/deleteTool/deleteTool.component';
import { toolService } from '../services/tool.service';
import { faseService } from '../services/fase.service';
import { SuperMenuService } from 'src/services/superMenu.service';
import { SuperMenuComponent } from 'src/components/superMenu/superMenu.component';
import { ToolMenuComponent } from 'src/components/toolMenu/toolMenu.component';
import { ToolMenuService } from 'src/services/toolMenu.service';
import { UpdateToolComponent } from 'src/components/updateTool/updateTool.component';
import { ReadCollegamentoComponent } from 'src/components/readCollegamento/readCollegamento.component';
import { InsertCollegamentoComponent } from 'src/components/insertCollegamento/insertCollegamento.component';
import { DeleteCollegamentoComponent } from 'src/components/deleteCollegamento/deleteCollegamento.component';
import { UpdateFaseDueComponent } from 'src/components/updateFaseDue/updateFaseDue.component';
import { collegamentoService } from 'src/services/collegamento.service';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    SuperuserComponent,
    InsertTrizConsultantComponent,
    ReadTrizConsultantComponent, 
    UpdateTrizConsultantComponent,
    DeleteTrizConsultantComponent,
    DeleteTrizConsultantComponent,
    GestioneUtenteLocaleComponent,
    GestioneMacroComponent,
    DeleteMacroComponent,
    InsertMacroComponent,
    ReadMacroComponent,
    UpdateMacroComponent,
    GestioneFaseComponent,
    InsertFaseComponent,
    ReadFaseComponent,
    UpdateFaseComponent,
    DeleteFaseComponent,
    GestioneToolComponent,
    InsertToolComponent,
    ReadToolComponent,
    DeleteToolComponent,
    DeleteFaseDueComponent,
    SuperMenuComponent,
    ToolMenuComponent,
    UpdateToolComponent,
    ReadToolComponent,
    ReadCollegamentoComponent,
    InsertCollegamentoComponent,
    DeleteCollegamentoComponent,
    UpdateFaseDueComponent

    

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAUf_fIZF0iu40Uiwhj3RhFE3Kd1KrWUFw',
      libraries: ["places"]
    }),
    TreeModule,
    DragDropModule
  ],
  providers: [
    UserService,
    SuperuserService, 
    UserService,
    SuperuserService, 
    utentiLocaliService,
    macroService,
    toolService,
    faseService,
    toolService, 
    SuperMenuService,
    ToolMenuService,
    collegamentoService

  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
