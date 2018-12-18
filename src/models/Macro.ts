import {Utente} from "./Utente"
export class Macro
{
    idMacro: number; 
    tipologia: string;  
    username:Utente;
    
    constructor(idMacro: number, tipologia: string, username:Utente)
    {
        this.idMacro = idMacro;
        this.tipologia = tipologia;
       this.username=username;
    }
}