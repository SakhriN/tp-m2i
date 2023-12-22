CREATE DATABASE tp_sql;

USE tp_sql;

-- Etape 1 :
CREATE TABLE clients(
id_clients INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
nom VARCHAR(50) NOT NULL,
prenom VARCHAR(50) NOT NULL,
email VARCHAR(255) NOT NULL,
address VARCHAR(255),
telephone VARCHAR(11)
);

CREATE TABLE categories(
id_categories INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nom VARCHAR(50) NOT NULL
);

CREATE TABLE jeux(
id_jeux INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nom VARCHAR(50) NOT NULL,
descriptionJeu VARCHAR(250),
price INT NOT NULL,
id_categories INT NOT NULL,
CONSTRAINT fk_id_categories FOREIGN KEY(id_categories) REFERENCES categories(id_categories)
);


CREATE TABLE commandes(
id_commandes INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_clients INT NOT NULL,
CONSTRAINT fk_id_clients FOREIGN KEY(id_clients) REFERENCES clients(id_clients),
commande_date DATE NOT NULL,
adresse_livraison VARCHAR(50) NOT NULL,
status VARCHAR(20)
);
DROP TABLE jeux;
DROP TABLE categories;
DROP TABLE clients;
DROP TABLE commandes;

SELECT * FROM jeux;
SELECT * FROM categories;
SELECT * FROM clients;
SELECT * FROM commandes;

-- Etape 2 :

UPDATE jeux 
SET PRICE = 35 
WHERE id_jeux = 3;


DELETE FROM jeux WHERE id_jeux = 2;


-- Etape 3 :

-- Categories :
-- 1 :
SELECT DISTINCT nom FROM jeux;

-- 2 :
Select * FROM categories WHERE nom LIKE "A%" OR nom LIKE "S%";

-- 3 :
Select * FROM categories WHERE id_categories BETWEEN 2 AND 5; 

-- 4 :
SELECT DISTINCT COUNT(*) as "nombres de categories differentes" FROM categories;

-- 5 :
SELECT MAX(nom) AS"Nom le plus long" FROM categories;

-- 6 :
SELECT * FROM jeux, categories WHERE jeux.id_categories = categories.id_categories ORDER BY jeux.id_categories;

-- 7 :
SELECT * FROM categories ORDER BY nom DESC;

-- Jeux :
-- 1 :
SELECT DISTINCT nom FROM jeux;

-- 2 :
SELECT * FROM  jeux WHERE price BETWEEN 25 AND 40;

-- 3 :
SELECT * FROM jeux WHERE id_categories = 3;

-- 4 :
SELECT * FROM jeux WHERE descriptionJeu LIKE "%aventure%";

-- 5 :
SELECT nom, price FROM jeux WHERE price = (SELECT MIN(price) FROM jeux);

-- 6 :
SELECT SUM(price) AS "Prix pour tous les jeux réunis" FROM jeux ORDER BY price;

-- 7 :
SELECT * FROM jeux ORDER BY nom LIMIT 5;


-- Clients :
-- 1 :
SELECT DISTINCT * FROM clients;

-- 2 :
SELECT * FROM clients WHERE address LIKE "%Rue%" AND telephone LIKE "+1%";

-- 3 :
SELECT * FROM clients WHERE nom LIKE "M%" OR nom LIKE "R%";

-- 4 :
SELECT * FROM clients WHERE email LIKE "%@%";

-- 5 :
SELECT * FROM clients WHERE LENGTH(prenom) = (SELECT (MIN(LENGTH(prenom))) FROM clients);

-- 6 : 
SELECT COUNT(*) AS "Nombre de clients enregistrés" FROM clients;

-- 7 :
SELECT * FROM clients ORDER BY nom LIMIT 12 OFFSET 3 ;
