import { NgModule, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppComponent } from './app.component';
import {RouterModule, Routes} from '@angular/router';
import { LoginComponent } from '../components/login/login.component';
import { SignupComponent } from '../components/signup/signup.component';
import { SuperuserComponent} from '../components/superuser/superuser.component';
import { InsertTrizConsultantComponent } from '../components/insertTrizConsultant/insertTrizConsultant.component';
import { ReadTrizConsultantComponent } from '../components/readTrizConsultant/readTrizConsultant.component';
import { UpdateTrizConsultantComponent } from '../components/updateTrizConsultant/updateTrizConsultant.component';
import { DeleteTrizConsultantComponent } from '../components/deleteTrizConsultant/deleteTrizConsultant.component';
import { GestioneUtenteLocaleComponent } from '../components/gestioneUtenteLocale/gestioneUtenteLocale.component';
import { GestioneMacroComponent } from 'src/components/gestioneMacro/gestioneMacro.component';
import { InsertMacroComponent } from 'src/components/insertMacro/insertMacro.component';
import { DeleteMacroComponent } from 'src/components/deleteMacro/deleteMacro.component';
import { UpdateMacroComponent } from 'src/components/updateMacro/updateMacro.component';
import { ReadMacroComponent } from 'src/components/readMacro/readMacro.component';
import { GestioneFaseComponent } from 'src/components/gestioneFase/gestioneFase.component';
import { InsertFaseComponent } from 'src/components/insertFase/insertFase.component';
import { ReadFaseComponent } from 'src/components/readFase/readFase.component';
import { UpdateFaseComponent } from 'src/components/updateFase/updateFase.component';
import { DeleteFaseComponent } from 'src/components/deleteFase/deleteFase.component';
import { DeleteFaseDueComponent } from 'src/components/deleteFaseDue/deleteFaseDue.component';

import { UpdateFaseDueComponent } from 'src/components/updateFaseDue/updateFaseDue.component';

import { DeleteToolComponent } from 'src/components/deleteTool/deleteTool.component';
import { InsertToolComponent } from 'src/components/insertTool/insertTool.component';
import { GestioneToolComponent } from 'src/components/gestioneTool/gestioneTool.component';
import { ReadToolComponent } from 'src/components/readTool/readTool.component';
import { SuperMenuComponent } from 'src/components/superMenu/superMenu.component';
import { ToolMenuComponent } from 'src/components/toolMenu/toolMenu.component';
import { UpdateToolComponent } from 'src/components/updateTool/updateTool.component';
import { ReadCollegamentoComponent } from 'src/components/readCollegamento/readCollegamento.component';
import { InsertCollegamentoComponent } from 'src/components/insertCollegamento/insertCollegamento.component';
import { DeleteCollegamentoComponent } from 'src/components/deleteCollegamento/deleteCollegamento.component';


const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'superuser', component: SuperuserComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'insertTrizConsultant', component: InsertTrizConsultantComponent},
  {path: 'readTrizConsultant', component: ReadTrizConsultantComponent},  
  {path: 'updateTrizConsultant', component: UpdateTrizConsultantComponent},
  {path: 'deleteTrizConsultant', component: DeleteTrizConsultantComponent},
  {path: 'gestioneMacro', component:GestioneMacroComponent},
  {path: 'insertMacro', component:InsertMacroComponent},
  {path: 'deleteMacro', component:DeleteMacroComponent},
  {path: 'updateMacro', component:UpdateMacroComponent},
  {path: 'readMacro', component:ReadMacroComponent},
  {path: 'gestioneFase', component:GestioneFaseComponent},
  {path: 'insertFase', component:InsertFaseComponent},
  {path: 'readFase', component:ReadFaseComponent},
  {path: 'updateFase', component:UpdateFaseComponent},
  {path: 'updateFaseDue', component:UpdateFaseDueComponent},
  {path: 'deleteFase', component:DeleteFaseComponent},
  {path: 'deleteFaseDue', component:DeleteFaseDueComponent},
  {path: 'deleteFase/delete/:idFase', component: DeleteFaseComponent},
  //nomeComponent/nomeMetodoComponent/:nomeVariabileGlobale
  {path: 'deleteFaseDue/:idFase', component: DeleteFaseDueComponent},
  //nomeComponent/:nomeVariabileGlobale
  {path: 'updateFase/update/:idFase', component:UpdateFaseComponent},
  //nomeComponent/nomeMetodoComponent/:nomeVariabileGlobale
  {path: 'updateFaseDue/:idFase', component: UpdateFaseDueComponent},
  //nomeComponent/:nomeVariabileGlobale
  {path: 'insertTool', component:InsertToolComponent},
  {path: 'deleteTool', component:DeleteToolComponent},
  {path: 'readTool', component:ReadToolComponent},
  {path: 'gestioneTool', component:GestioneToolComponent},
  {path: 'superMenu', component:SuperMenuComponent},
  {path: 'toolMenu', component:ToolMenuComponent},
  {path: 'gestioneUtenteLocale', component: GestioneUtenteLocaleComponent},
  {path: 'updateTool', component:UpdateToolComponent}, /////update tool
  {path: 'readCollegamento', component:ReadCollegamentoComponent},
  {path: 'insertCollegamento', component:InsertCollegamentoComponent},
  {path: 'deleteCollegamento', component:DeleteCollegamentoComponent}

];

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes, {useHash: true, onSameUrlNavigation: 'reload'})],
  declarations: []
})
export class AppRoutingModule { }
