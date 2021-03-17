import { produit } from "./produit";

export class panier {
    id:number;
	produits: produit[] ;

    constructor(id?:number,produits?:produit[]){
        this.id = id;
        this.produits = produits;
    }
}