-- Insertion de données pour la table Etablissement
INSERT INTO Etablissement (id_etablissement, nom_etablissement, ville_etablissement) VALUES 
(1, "Science Po", 'Paris'),
(2,"Science pas Po", 'Lyon'),
(3,"La Mafia ecologique", 'Marseille');

-- Insertion de données pour la table Enseignant
INSERT INTO Enseignant (id_enseignant, nom_enseignant, prenom_enseignant, date_naissance_enseignant) VALUES
(1, 'Dupont', 'Jean', '1980-05-15'),
(2, 'Martin', 'Sophie', '1975-08-22'),
(3, 'Leclerc', 'Pierre', '1990-02-10');

-- Insertion de données pour la table Examens
INSERT INTO Examens (id_examen, nom_examen, coefficient_examen, note_examen) VALUES
(1, 'Baccalauréat', 3, 0),
(2, 'Certificat', 2, 15.5),
(3, 'Diplôme', 4, 18.2);

-- Insertion de données pour la table Eleves
INSERT INTO Eleves (id_eleve, nom_eleve, prenom_eleve, date_naissance_eleve, id_etablissement) VALUES
(1, 'Durand', 'Alice', '2002-03-20', 1),
(2, 'Lefevre', 'Thomas', '2003-06-12', 2),
(3, 'Girard', 'Emma', '2001-11-05', 3);

-- Insertion de données pour la table Dossier
INSERT INTO Dossier (id_dossier, nom_dossier, id_eleve) VALUES
(1, 'Dossier1', 1),
(2, 'Dossier2', 2),
(3, 'Dossier3', 3);

-- Insertion de données pour la table Donner_accès
INSERT INTO Donner_acces (id_dossier, id_examen) VALUES
(1, 1),
(2, 2),
(3, 3);

-- Insertion de données pour la table Assister
INSERT INTO Assister (id_enseignant, id_examen) VALUES
(1, 1),
(2, 2),
(3, 3);

-- Insertion de données pour la table Travaille
INSERT INTO Travaille (id_etablissement, id_enseignant) VALUES
(1, 1),
(2, 2),
(3, 3);
