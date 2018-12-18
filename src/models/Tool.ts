import {Macro} from "./Macro"
export class Fase
{
    id: number; 
    tipologia: string;  
    idFase:Fase;
    
    constructor(id: number, tipologia: string, idFase:Fase)
    {
        this.id = id;
        this.tipologia = tipologia;
       this.idFase=idFase;
    }
}