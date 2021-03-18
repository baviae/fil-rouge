export class produit {

    id:number;
	nom:string;
	description:string;
	image:string;
    prix:number;


    constructor(id?:number,nom?:string,description?:string,image?:string,prix?:number){
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.prix = prix;
    }

}