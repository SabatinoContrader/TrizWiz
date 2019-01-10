import { Injectable } from "@angular/core";
import {Observable, of, BehaviorSubject} from 'rxjs';
import { tap, catchError } from 'rxjs/operators'
import { HttpClient, HttpParams } from "@angular/common/http";
import { Fase } from "src/models/Fase";
import { Collegamento } from "src/models/Collegamento";

@Injectable({providedIn: 'root'})
export class collegamentoService{
    constructor(private http : HttpClient){}
    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.log(result);
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }
    
    readAll(idFase:string):Observable<Array<Collegamento>>{
        //const params = new HttpParams().set('username', ses);
        return this.http.get<Array<Collegamento>>('http://localhost:8080/Collegamento/read?idFase='+idFase);    
    }
/*
    readAll(idFase:string):Observable<Array<Fase>>{
        //const params = new HttpParams().set('username', ses);
        return this.http.get<Array<Fase>>('http://localhost:8080/Fase/read?ses='+idFase);    
    }

    delete(idMacro:string, idFase:string):Observable<boolean>{
        const params = new HttpParams().set('idMacro', idMacro).set('idFase',idFase); //passo idMacro
        console.log("anche qui");                                                 //idFase
        return this.http.post<boolean>('http://localhost:8080/Fase/delete',params);
    }

    newFase(tipologia:string,idMacro:string):Observable<Fase>{
        const params = new HttpParams().set("tipologia",tipologia).set("idMacro",idMacro);
        console.log("tipologia ="+tipologia);
       // return this.http.post<Macro>("http://localhost:8080/Macro/insert", params)
       return this.http.post<Fase>("http://localhost:8080/Fase/insert?tipologia="+tipologia+"&idMacro="+idMacro, "");
        
    }

    updateFase(tipologia: string, idMacro: string): Observable<Fase> {
        const params = new HttpParams().set("tipologia",tipologia).set("idMacro",idMacro);
        console.log("tipologia ="+tipologia);
        return this.http.post<Fase>('http://localhost:8080/Fase/edit', params);

    }

    edit(idFase:string ,tipologia:string,idMacro:string):Observable<Fase>{
        

        const param = new HttpParams().set("idFase",idFase).set("tipologia",tipologia).set("idMacro",idMacro);
        return this.http.post<Fase>("http://localhost:8080/Fase/edit", param);
    }
*/
}