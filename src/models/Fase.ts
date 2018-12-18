import {Macro} from "./Macro"
export class Fase
{
    idFase: number; 
    tipologia: string;  
    idMacro:Macro;
     
    
    constructor(idFase: number, tipologia: string, idMacro:Macro)
    {
        this.idFase= idFase;
        this.tipologia = tipologia;
        this.idMacro=idMacro;
    }
}