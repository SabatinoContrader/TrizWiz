export class NewUtenteLocale {
    nomeLogin: string; 
    passwordLogin: string;  
    nome: string;
    cognome: string; 
    ruolo: number;

    constructor (nomeLogin: string, passwordLogin: string, nome: string, cognome: string, ruolo: number){
        this.nomeLogin = nomeLogin;
        this.passwordLogin = passwordLogin;
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
    }
}