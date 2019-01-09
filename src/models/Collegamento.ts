import { Fase } from "./Fase";
import { Tool } from "./Tool";

export class Collegamento{
    idCollegamento: number; 
    commento: string;  
    idFase:Fase;
    idTool:Tool;
    
    constructor(idCollegamento: number, commento: string, idFase:Fase, idTool:Tool)
    {
        this.idCollegamento = idCollegamento;
        this.commento = commento;
        this.idFase=idFase;
        this.idTool=idTool;

    }
}