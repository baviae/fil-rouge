export class produit {

    id:number;
	nom:string;
	description:string;
	image:string;


    constructor(id?:number,nom?:string,description?:string,image?:string){
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.image = image;
    }

}