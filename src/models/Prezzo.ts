import { ItemType } from "./ItemType";
import { Listino } from "./Listino";

export class Prezzo{
    id:number
    prezzo:number
    itemTypeId: number
    idListino: number
    
        constructor( id:number, prezzo:number, itemTypeId: number, idListino: number ){
          this.id=id;
          this.prezzo=prezzo;
          this.itemTypeId=itemTypeId;
          this.idListino=idListino;
           
        }
    }