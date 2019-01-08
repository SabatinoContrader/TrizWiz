import { Injectable } from "@angular/core";
import {Observable, of, BehaviorSubject} from 'rxjs';
import { tap, catchError } from 'rxjs/operators'
import { HttpClient, HttpParams } from "@angular/common/http";
import { Customer } from "src/models/Customer";
import { Listino } from "src/models/Listino";
import { Macro } from "src/models/Macro";



@Injectable({providedIn: 'root'})
export class macroService{

    constructor(private http : HttpClient){}
    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.log(result);
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }

    readAll(ses:string):Observable<Array<Macro>>{
        //const params = new HttpParams().set('username', ses);
        return this.http.get<Array<Macro>>('http://localhost:8080/Macro/read?ses='+ses);    
    }

    edit(idMacro:string ,tipologia:string, ses:string):Observable<Macro>{
        console.log("MacroID2:"+idMacro);

        const param = new HttpParams().set("idMacro",idMacro).set("tipologia",tipologia).set("nome", ses);
       // return this.http.post<Macro>("http://localhost:8080/Macro/edit?idMacro="+idMacro+"&tipologia="+tipologia+"&nome="+ses);
        return this.http.post<Macro>("http://localhost:8080/Macro/edit", param);
    }


    delete(username:string, ses:string):Observable<boolean>{
        const params = new HttpParams().set('username', username).set('ses',ses); //passo idMacro->username
        console.log("anche qui");                                                 //sessione->ses
        return this.http.post<boolean>('http://localhost:8080/Macro/delete',params);
    }


    /*
    newListino(nomeListino:string, anno:string, idManufacturer:string):Observable<Listino>{
        const params = new HttpParams().set("nomeListino",nomeListino).set("anno",anno).set("idManufacturer",idManufacturer);
        console.log("anno ="+anno);
        return this.http.post<Listino>("http://localhost:8080/Listino/insert", params)
*/
    newMacro(tipologia:string,nomeLogin:string):Observable<Macro>{
        const params = new HttpParams().set("tipologia",tipologia).set("username",nomeLogin);
        console.log("tipologia ="+tipologia);
       // return this.http.post<Macro>("http://localhost:8080/Macro/insert", params)
       return this.http.post<Macro>("http://localhost:8080/Macro/insert?tipologia="+tipologia+"&username="+nomeLogin, "");
        
    }
     //   return this.http.post<Macro>("http://localhost:8080/Macro/insert?tipologia="+tipologia+"&username="+nomeLogin, "");
    
/*
    readMacro():Observable<Array<Macro>>{
        return this.http.get<Array<Macro>>("http://localhost:8080/Macro/read")
    }

    delete(idMacro:number):Observable<boolean>{
        const params = new HttpParams().set("idMacro",idMacro);
        return this.http.post<boolean>("http://localhost:8080/Macro/delete",params)
    }

    edit(idMacro:string ,tipologia:string, username:string):Observable<Listino>{
        const params = new HttpParams().set("idMacro",idMacro).set("tipologia",tipologia).set("username",username);
        return this.http.post<Macro>("http://localhost:8080/Macro/edit", params)
    }

  */ 
}