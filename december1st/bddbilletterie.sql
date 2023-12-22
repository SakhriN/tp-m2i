CREATE DATABASE IF NOT EXISTS bddbilletterie;

USE bddbilletterie;


CREATE TABLE IF NOT EXISTS lieu(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100),
address VARCHAR(100),
capacity INT NOT NULL
);

CREATE TABLE IF NOT EXISTS evenement(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100),
local_date DATE,
local_time TIME,
lieu_id INT,
CONSTRAINT fk_lieu_id FOREIGN KEY(lieu_id) REFERENCES lieu(id),
billets_dispo INT,
price FLOAT,
nb_tickets_sold INT
);

CREATE TABLE IF NOT EXISTS client(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50),
last_name VARCHAR(50),
email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS cli_eve(
nb_tickets_sold INT,
id_client INT NOT NULL,
id_evenement INT NOT NULL,
CONSTRAINT fk_id_client FOREIGN KEY(id_client) REFERENCES client(id),
CONSTRAINT fk_id_evenement FOREIGN KEY(id_client) REFERENCES evenement(id)
);

SELECT * FROM client;

UPDATE client SET name = "Clement", last_name = "Roelens", email = "test@test2.fr" WHERE id = 1;
UPDATE client SET name = "Clement", last_name = "Roelens" WHERE id = 2;

INSERT INTO client(name,last_name,email) VALUES("Nassimo","Testo","testo@tasoeur.fr");
	