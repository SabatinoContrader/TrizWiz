import {Utente} from "./Utente"
export class Macro
{
    id: number; 
    tipologia: string;  
    username:Utente;
    
    constructor(id: number, tipologia: string, username:Utente)
    {
        this.id = id;
        this.tipologia = tipologia;
       this.username=username;
    }
}