import { recipes } from "./recipes.js";


const recipeNames = Object.keys(recipes).map(key => recipes[key]);

console.log(Object.keys(recipes).length)


const tableauReussis: any = [];

const nouvelleColonne = "ID"
let nouvelleColonneValeur: any = []
for (let i = 0; i < (Object.keys(recipes).length); i++) {
    nouvelleColonneValeur = Object.keys(recipes)[i]
    recipeNames[i][nouvelleColonne] = nouvelleColonneValeur
}

recipeNames.forEach((key) => {
    tableauReussis.push(key);
})
console.table(tableauReussis.name)

let list = document.getElementById("recipe-list") as HTMLDataListElement;

// Stocker noms de recete
tableauReussis.forEach((recipe:any) => {
    let celluleButton: HTMLButtonElement = document.createElement("button");
    celluleButton.classList.add("btn", "btn-dark", "Summon")
    celluleButton.textContent = recipe.name; // mettre le nom dans chaque bouton
    list.appendChild(celluleButton);
});





