import {NewUtenteLocale} from "./NewUtenteLocale"
export class Macro
{
    idMacro: number; 
    tipologia: string;  
    username: NewUtenteLocale;
    
    constructor(idMacro: number, tipologia: string, username:NewUtenteLocale)
    {
        this.idMacro = idMacro;
        this.tipologia = tipologia;
        this.username = username;

    }
}