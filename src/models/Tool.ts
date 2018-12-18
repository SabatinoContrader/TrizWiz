import {Macro} from "./Macro"
export class Fase
{
    id: number; 
    tipologia: string;  
    fase:Fase;
    
    constructor(id: number, tipologia: string, fase:Fase)
    {
        this.id = id;
        this.tipologia = tipologia;
       this.fase=fase;
    }
}