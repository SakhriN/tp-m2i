let matAdd = document.getElementById("matAdd")
let noteAdd = document.getElementById("noteAdd")
let eleveAdd = document.getElementById("eleveAdd")



let person1 = {
    firstName: "Nassim",
    lastName: "Sakhri",
    matierePers: ["Mathématiques", "Français"],
    notePers: {
        Mathématiques: [20, 0],
        Français: [12, 20],
    }
}

let person2 = {
    firstName: "Jean-Marie",
    lastName: "Bigard",
    matierePers: ["Mathématiques", "Français"],
    notePers: {
        Mathématiques: [12, 19],
        Français: [2, 1],
    }
}

let classe = [person1, person2]

let exemple = document.querySelector(".table tbody")

function ajoutEleve() {
    for (let k = 0; k < classe.length; k++) {
        for (let j = 0; j < classe[k].matierePers.length; j++) {
            for (let i = 0; i < classe[k].matierePers.length; i++) {

                let ajoutLigne = document.createElement("tr")

                let celFirst = document.createElement("td");
                celFirst.textContent = classe[k].firstName;

                let celLast = document.createElement("td");
                celLast.textContent = classe[k].lastName;

                let celMat1 = document.createElement("td");
                celMat1.textContent = classe[k].matierePers[j];

                let celN1 = document.createElement("td");
                switch (j) {
                    case (j == 0):
                        celN1.textContent = classe[k].notePers.Mathématiques[i];
                        break;
                    default:
                        celN1.textContent = classe[k].notePers.Français[i];
                        break;
                }

                ajoutLigne.appendChild(celFirst);
                ajoutLigne.appendChild(celLast);
                ajoutLigne.appendChild(celMat1);
                ajoutLigne.appendChild(celN1);

                exemple.appendChild(ajoutLigne);
            }
        }
    }
}

ajoutEleve()


eleveAdd.addEventListener("click", function (e) {
    e.preventDefault
    let firstNameNew = document.getElementById("prenom").textContent;
    let lastNameNew = document.getElementById("nom").textContent;
    let matierePersNew = ["Mathématique", "Français"];
    let notePersNew = {
        Mathématiques: [15, 18],
        Français: [10, 14],
    }

    let newPerson = {
        firstName: firstNameNew,
        lastName: lastNameNew,
        matierePers: matierePersNew,
        notePers: notePersNew,
    };
    classe.push(newPerson);
    ajoutEleve()
})



function ajoutNote() {

}

function ajoutMatiere() {

}






console.log(newPerson.firstName + newPerson.lastName + newPerson.matierePers + newPerson.notePers.Mathématiques)