export class Utente{
    username: string;
    password: string;
    nome: string;
    cognome: string;
    ruolo: number;
  
    constructor(username: string, password: string,nome: string, cognome: string, ruolo: number){
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
        
    }
}
