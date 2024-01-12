CREATE DATABASE tp;
DROP database tp;
use tp;

CREATE TABLE Etablissement(
   id_etablissement INT,
   nom_etablissement VARCHAR(50),
   ville_etablissement VARCHAR(50),
   PRIMARY KEY(id_etablissement)
);

CREATE TABLE Enseignant(
   id_enseignant INT,
   nom_enseignant VARCHAR(50),
   prenom_enseignant VARCHAR(50),
   date_naissance_enseignant DATE,
   PRIMARY KEY(id_enseignant)
);

CREATE TABLE Examens(
   id_examen INT,
   nom_examen VARCHAR(50),
   coefficient_examen INT,
   note_examen DECIMAL(21,1),
   PRIMARY KEY(id_examen)
);

CREATE TABLE Eleves(
   id_eleve INT,
   nom_eleve VARCHAR(50),
   prenom_eleve VARCHAR(50),
   date_naissance_eleve DATE,
   id_etablissement INT NOT NULL,
   PRIMARY KEY(id_eleve),
   FOREIGN KEY(id_etablissement) REFERENCES Etablissement(id_etablissement)
);

CREATE TABLE Dossier(
   id_dossier INT,
   nom_dossier VARCHAR(50),
   id_eleve INT NOT NULL,
   PRIMARY KEY(id_dossier),
   FOREIGN KEY(id_eleve) REFERENCES Eleves(id_eleve)
);

CREATE TABLE Donner_acces(
   id_dossier INT,
   id_examen INT,
   PRIMARY KEY(id_dossier, id_examen),
   FOREIGN KEY(id_dossier) REFERENCES Dossier(id_dossier),
   FOREIGN KEY(id_examen) REFERENCES Examens(id_examen)
);

CREATE TABLE Assister(
   id_enseignant INT,
   id_examen INT,
   PRIMARY KEY(id_enseignant, id_examen),
   FOREIGN KEY(id_enseignant) REFERENCES Enseignant(id_enseignant),
   FOREIGN KEY(id_examen) REFERENCES Examens(id_examen)
);

CREATE TABLE Travaille(
   id_etablissement INT,
   id_enseignant INT,
   PRIMARY KEY(id_etablissement, id_enseignant),
   FOREIGN KEY(id_etablissement) REFERENCES Etablissement(id_etablissement),
   FOREIGN KEY(id_enseignant) REFERENCES Enseignant(id_enseignant)
);


SELECT * FROM eleves;
SELECT * FROM examens;
SELECT * FROM dossier;
SELECT * FROM enseignant;
SELECT * FROM etablissement;
SELECT * FROM travaille;
SELECT * FROM assister;
SELECT * FROM Donner_acces;


-- Ex 1 :
SELECT * FROM eleves;

-- Ex 2 :
SELECT AVG(note_examen) as "Note moyenne du bac" FROM examens WHERE nom_examen = "Baccalauréat";

-- Ex 3 :
SELECT nom_enseignant, prenom_enseignant
FROM Enseignant
LEFT JOIN Travaille ON Enseignant.id_enseignant = Travaille.id_enseignant
LEFT JOIN Etablissement ON Travaille.id_etablissement = Etablissement.id_etablissement
WHERE ville_etablissement = "Paris";

-- Ex 4 :
SELECT nom_etablissement, COUNT(id_eleve) AS nombre_eleves_inscrits
FROM etablissement
LEFT JOIN Eleves ON Etablissement.id_etablissement = Eleves.id_etablissement
GROUP BY Etablissement.nom_etablissement;

-- Ex 5 :
SELECT nom_eleve, note_examen
FROM Eleves
JOIN Dossier ON Eleves.id_eleve = Dossier.id_eleve
JOIN Donner_acces ON Dossier.id_dossier = Donner_acces.id_dossier
JOIN Examens ON Donner_acces.id_examen = Examens.id_examen
WHERE Examens.note_examen > 15;

-- Ex 6 :
SELECT nom_examen, coefficient_examen
FROM Examens
JOIN Donner_acces ON Examens.id_examen = Donner_acces.id_examen;

-- Ex 7 :
SELECT nom_etablissement, COUNT(DISTINCT Examens.id_examen) AS nombre_examens
FROM Etablissement
LEFT JOIN Travaille ON Etablissement.id_etablissement = Travaille.id_etablissement
LEFT JOIN Enseignant ON Enseignant.id_enseignant = Travaille.id_enseignant
LEFT JOIN Assister ON Travaille.id_enseignant = Assister.id_enseignant
LEFT JOIN Examens ON Assister.id_examen = Examens.id_examen
GROUP BY Etablissement.nom_etablissement
ORDER BY nombre_examens DESC;

-- Ex 8 :
SELECT Eleves.nom_eleve
FROM Eleves
LEFT JOIN Dossier ON Eleves.id_eleve = Dossier.id_eleve
WHERE Dossier.id_dossier IS NULL;

-- Ex 9 :


-- Ex 10 :
SELECT Eleves.nom_eleve, MAX(Examens.note_examen) AS dernier_examen_note
FROM Eleves
LEFT JOIN Dossier ON Eleves.id_eleve = Dossier.id_eleve
LEFT JOIN Donner_acces ON Dossier.id_dossier = Donner_acces.id_dossier
LEFT JOIN Examens ON Donner_acces.id_examen = Examens.id_examen
GROUP BY Eleves.nom_eleve;