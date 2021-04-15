import { panier } from "./panier";

export class utilisateur{

    id:number;
    nom:string;
    prenom:string;
    email:string;
    password:string;
    token: string;
    panier:panier;
	

    constructor(id?:number, nom?:string,prenom?:string,Email?:string,password?:string, token?: string,panier?:panier){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = Email;
        this.password = password;
        this.token = token;
        this.panier = panier;

    };

}