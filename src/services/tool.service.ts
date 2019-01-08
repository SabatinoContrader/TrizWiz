import { Injectable } from "@angular/core";
import {Observable, of, BehaviorSubject} from 'rxjs';
import { tap, catchError } from 'rxjs/operators'
import { HttpClient, HttpParams } from "@angular/common/http";
import { Tool } from "src/models/Tool";



@Injectable({providedIn: 'root'})
export class toolService{

    constructor(private http : HttpClient){}
    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.log(result);
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }

    readAll():Observable<Array<Tool>>{
        return this.http.get<Array<Tool>>('http://localhost:8080/Tool/read');    
    }

    
    delete(id:string):Observable<boolean>{
        const params = new HttpParams().set('id', id);
        return this.http.post<boolean>('http://localhost:8080/Tool/delete',params);
    }
/*
    edit(idMacro:string ,tipologia:string, ses:string):Observable<Macro>{
        console.log("MacroID2:"+idMacro);

        const param = new HttpParams().set("idMacro",idMacro).set("tipologia",tipologia).set("nome", ses);
       // return this.http.post<Macro>("http://localhost:8080/Macro/edit?idMacro="+idMacro+"&tipologia="+tipologia+"&nome="+ses);
        return this.http.post<Macro>("http://localhost:8080/Macro/edit", param);
    }

*/
    newTool(tipologia:string):Observable<Tool>{
        const params = new HttpParams().set("tipologia",tipologia);
        console.log("tipologia ="+tipologia);
        return this.http.post<Tool>("http://localhost:8080/Tool/insert", params) 
    }
}