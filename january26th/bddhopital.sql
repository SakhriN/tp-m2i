CREATE DATABASE IF NOT EXISTS tp26jan;

USE tp26jan;

CREATE TABLE IF NOT EXISTS patient(
id_pa INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nom VARCHAR(50),
prenom VARCHAR(50),
datenais DATE,
photo VARCHAR(2083)
);

CREATE TABLE IF NOT EXISTS consultation(
id_co INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
datecons DATE,
nom_medecin VARCHAR(50),
id_pa INT,
CONSTRAINT id_pa FOREIGN KEY(id_pa) REFERENCES patient(id_pa)
);

CREATE TABLE IF NOT EXISTS prescription(
id_pr INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
type_medicament VARCHAR(50),
duree_pr INT,
id_co_pr INT,
 CONSTRAINT id_co_pr FOREIGN KEY (id_co_pr) REFERENCES consultation(id_co)
);

CREATE TABLE IF NOT EXISTS fichesoin(
id_fi INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
type_soin VARCHAR(50),
duree_fi INT,
id_co_fi INT,
 CONSTRAINT id_co_fi FOREIGN KEY (id_co_fi) REFERENCES consultation(id_co)
);

-- DROP TABLE patient;
-- DROP TABLE consultation;
-- DROP TABLE prescription;
-- DROP TABLE fichesoin;




