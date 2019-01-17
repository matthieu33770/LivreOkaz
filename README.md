# LivreOkaz
Création d'une app avec utilisation :<br/>
	- en back de SpringBoot et Hibernate avec persistence des données<br/>
	- en front via HTML, CSS et JavaScript<br/>


## Sujet :

Le but est de créer une application de vente de livre d'occasion avec nécessité de s'incrire et de s'authentifier.
Création dune base de livre avec le passage d elivre dans un panier puis de la commande avec moyen de paiement.

## Organisation :

Mise en place d'un Trello dès le début pour organiser les tâches à faire, en mettant l'avatar de la personne qui travaille sur un sujet.
Réunion en début de journée pour se coordonner sur les tâches à réaliser dans la journée. Point informel en milieu de journée (lors de la pause méridien en général). Entraide tout au long de la journée !

https://trello.com/b/SKUzleMh/livrokaz

## Création du MCD :
![image](https://github.com/matthieu33770/LivreOkaz/blob/master/src/main/resources/MCD.jpg)

## Principe :

Le principe est d'afficher les données d'une DataBase générées par les model du projet dont le schéma est créé au préalable.
Ces DataBase sont implémentées manuellement pour les besoins de la démonstration.
Puis création des boutons et des fonctions associées pour réaliser les opérations suivantes :
	- Tableau : lors de la connexion, affiche le tableau dans son ensemble
	- GET : fourni les données en fonction d'un paramètre
	- PUT : Modification des données en fonction d'un paramètre
	- POST : ajout dans une table
	- DELETE : suppression des données dans une table

## Dépendances : 

Les dépendances utilisées sont les suivantes :
	- spring-boot-starter-jdbc V 2.1.1
	- spring-boot-starter-data-jpa V 2.1.1
	- spring-boot-starter-web V 2.1.0
	- mysql-connector-java V 5.1.47
	- spring-boot-devtools V 2.1.1

## Schéma explicatif :
![image](https://github.com/matthieu33770/LivreOkaz/blob/master/src/main/resources/Sch%C3%A9ma%20explicatif.jpg)
