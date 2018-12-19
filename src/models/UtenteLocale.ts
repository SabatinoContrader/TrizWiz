export class UtenteLocale {
    nomeLogin: string;
    nome: string;
    cognome: string;    
    ruolo: number;

    constructor (nomeLogin: string, nome: string, cognome: string, ruolo: number){
        this.nomeLogin = nomeLogin;
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
    }
}