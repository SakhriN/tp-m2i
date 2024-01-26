INSERT INTO patient(nom, prenom, datenais, photo) VALUES
("Pendragon","Artoria","2022-12-12","https://www.lucidsky.co/cdn/shop/products/CasterArtoria_13x19_Smartpress.jpg?v=1646947184&width=1445"),
("Ua Duibhne","Diarmuid","2023-12-31","https://cdn.anisearch.fr/images/character/cover/26/26674_300.webp"),
("Emiya","Kiritsugu","2024-06-30","https://cdn.anisearch.fr/images/character/cover/26/26725_400.webp"),
("Archer","Gilgamesh","1192-01-01","https://www.nautiljon.com/images/perso/00/22/archer_21622.webp"),
("Sessyoin","Kiara","2020-02-02","https://static.wikia.nocookie.net/fategrandorder/images/4/4a/S167_Stage1.webp/revision/latest?cb=20220911123007");

INSERT INTO consultation(datecons, nom_medecin, id_pa) VALUES
("2024-01-17","Nightingale",1),
("2024-01-17","Asclepius",2),
("2024-01-18","Nightingale",3),
("2024-01-18","Asclepius",4),
("2024-01-19","Nightingale",5),
("2024-01-19","Asclepius",1),
("2024-01-20","Nightingale",2),
("2024-01-20","Asclepius",3),
("2024-01-31","Nightingale",4),
("2024-01-31","Asclepius",5);

INSERT INTO fichesoin(type_soin ,duree_fi, id_co_fi) VALUES
("Meurtre",60,1),
("Prendre des medicaments",60,2),
("Repos",60,3),
("Sport",60,4),
("Sexe",60,5),
("Alcool",60,1),
("Cigarette",60,2),
("Manger sain",60,3),
("Jeux Videos",60,4),
("Poser son cul et regarder des vidéos",60,5);

INSERT INTO prescription(type_medicament ,duree_pr, id_co_pr) VALUES
("Analgesique",60,1),
("Antibiotique",60,2),
("Anti-inflammatoire",60,3),
("Anti-bacterien",60,4),
("Antiviraux",60,5),
("Antituberculeux",60,1),
("Antimycosique",60,2),
("Dietetique",60,3),
("Nutrition",60,4),
("Gastro-enterologue",60,5);
 