export class utilisateur{

    nom:string;
    prenom:string;
    Email:string;
    password:string;

    constructor(nom?:string,prenom?:string,Email?:string,password?:string){
        this.nom = nom;
        this.prenom = prenom;
        this.Email = Email;
        this.password = password;
    };

}