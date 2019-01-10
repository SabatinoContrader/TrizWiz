import { Fase } from "./Fase";
import { Tool } from "./Tool";

export class Collegamento{
    idCollegamento: number; 
    commento: string;  
    fase:Fase;
    tool:Tool;
    
    constructor(idCollegamento: number, commento: string, fase:Fase, tool:Tool)
    {
        this.idCollegamento = idCollegamento;
        this.commento = commento;
        this.fase=fase;
        this.tool=tool;

    }
}