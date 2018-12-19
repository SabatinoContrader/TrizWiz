import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { UtenteLocale } from "src/models/UtenteLocale";
import { NewUtenteLocale } from "src/models/NewUtenteLocale";
import { tap, catchError } from 'rxjs/operators';
import {Observable, of, BehaviorSubject} from 'rxjs';

@Injectable({ providedIn: 'root'}) 
export class utentiLocaliService{
    constructor( private http : HttpClient){}

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.log(result);
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }
    login(username:string, password:string):Observable<UtenteLocale>{
        const params = new HttpParams().set('username', username).set('password', password);
        return this.http.post<UtenteLocale>('http://localhost:8080/utente/login',params).
        pipe(tap((response) => console.log("Utente"), catchError(this.handleError("login error", {})))
        );
    }

    newUtenteLocale(nomeLogin:string, passwordLogin:string, nome: string, cognome: string,
        ruolo:string): Observable<NewUtenteLocale>{
        
          const params = new HttpParams().set('nomeLogin', nomeLogin).
           set('passwordLogin', passwordLogin).set('nome', nome).set('cognome', cognome).set('ruolo', ruolo);
        
        return this.http.post<NewUtenteLocale>('http://localhost:8080/UtentiLocali/new', params); 
  
    }
    /*
    newManufacturer(userRole:string, name:string, 
        email:string): Observable<NewCustomer>{
        
          const params = new HttpParams().set('userRole', userRole).
           set('name', name).set('email', email);
        
        return this.http.post<NewCustomer>('http://localhost:8080/Customer/manufacturer', params); 
  
    } 

    readAll():Observable<Array<NewCustomer>>{
        return this.http.get<Array<NewCustomer>>('http://localhost:8080/Customer/read');
    }
    readAllManufacturers():Observable<Array<NewCustomer>>{
        return this.http.get<Array<NewCustomer>>('http://localhost:8080/Customer/readManufacturers');
    }
    readOne(customerId:string): Observable<Customer>{
        return this.http.get<Customer>('http://localhost:8080/Customer?customerId='+customerId);
    }
    readByUsername(username:string): Observable<Customer>{
        const params = new HttpParams().set('username', username);
        return this.http.post<Customer>('http://localhost:8080/Customer/readOne',params);
    }
    delete(username:string):Observable<boolean>{
        const params = new HttpParams().set('username', username);
        return this.http.post<boolean>('http://localhost:8080/Customer/delete',params);
    }


    updateCustomer(nome:string, 
        cognome:string, email:string, username:string, oldUsername: string): Observable<NewCustomer>{
            console.log("in update "+ nome+"-"+ cognome+"-"+email+"-"+username);
            if(nome!="null"){
            const params = new HttpParams().set('nome', nome).set('oldUsername',oldUsername);
            return this.http.post<NewCustomer>('http://localhost:8080/Customer/edit', params); 
            }else if(cognome!="null"){
            const params= new HttpParams().set('cognome',cognome).set('oldUsername',oldUsername);
            return this.http.post<NewCustomer>('http://localhost:8080/Customer/edit', params); 
            }else if(email!=null){
            const params= new HttpParams().set('email',email).set('oldUsername',oldUsername);
            return this.http.post<NewCustomer>('http://localhost:8080/Customer/edit', params); 
            }else {
                const params= new HttpParams().set('password',username).set('oldUsername',oldUsername);
                return this.http.post<NewCustomer>('http://localhost:8080/Customer/edit', params); 
            }

    }
    update(username: string, field: string, newValue: string):Observable<NewCustomer>{
        const params= new HttpParams().set('username',username).set('field',field).set('newValue',newValue);
       return this.http.post<NewCustomer>('http://localhost:8080/Customer/editManufacturer', params);
    }


*/

}