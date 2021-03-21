import { imageProduit } from "./imageProduit";

export class produit {

    id:number;
	nom:string;
	description:string;
	image:string;
    prix:number;
    imagePrd:imageProduit;


    constructor(id?:number,nom?:string,description?:string,image?:string,prix?:number){
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.prix = prix;
    }

}