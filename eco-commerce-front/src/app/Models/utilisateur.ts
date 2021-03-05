export class utilisateur{

    nom:string;
    prenom:string;
    email:string;
    password:string;
    token: string;

    constructor(nom?:string,prenom?:string,Email?:string,password?:string, token?: string){
        this.nom = nom;
        this.prenom = prenom;
        this.email = Email;
        this.password = password;
        this.token = token;

    };

}