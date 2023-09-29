import { recipes } from "./recipes.js";
const recipeNames = Object.keys(recipes).map(key => recipes[key]);
console.log(Object.keys(recipes).length);
const tableauReussis = [];
const nouvelleColonne = "ID";
let nouvelleColonneValeur = [];
for (let i = 0; i < (Object.keys(recipes).length); i++) {
    nouvelleColonneValeur = Object.keys(recipes)[i];
    recipeNames[i][nouvelleColonne] = nouvelleColonneValeur;
}
recipeNames.forEach((key) => {
    tableauReussis.push(key);
});
console.table(tableauReussis);
let list = document.getElementById("recipe-list");
// Stocker noms de recete
tableauReussis.forEach((recipe) => {
    let celluleButton = document.createElement("button");
    celluleButton.classList.add("btn", "btn-dark", "Summon");
    celluleButton.textContent = recipe.name; // mettre le nom dans chaque bouton
    list.appendChild(celluleButton);
    let rcpshow = document.getElementById("recipe-show");
    let summon = document.querySelector("Summon");
    summon === null || summon === void 0 ? void 0 : summon.addEventListener("click", () => {
        tableauReussis.forEach((recipe) => {
            let celluleRecipe = document.createElement("div");
            celluleRecipe.textContent = recipe.instructions; // mettre le nom dans chaque bouton
            rcpshow.appendChild(celluleRecipe);
        });
    });
});
