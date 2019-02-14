# LivreOkaz
Création d'une app avec utilisation :<br/>
	- en back de SpringBoot et Hibernate avec persistence des données<br/>
	- en front via HTML, CSS et JavaScript<br/>


## Sujet :

Le but est de créer une application de vente de livre d'occasion avec nécessité de s'incrire et de s'authentifier.<br/>
Création d'une base de livre avec le passage de livre dans un panier puis de la commande avec moyen de paiement.

## Organisation :

Mise en place d'un Trello dès le début pour organiser les tâches à faire, en mettant l'avatar de la personne qui travaille sur un sujet.<br/>
Réunion en début de journée pour se coordonner sur les tâches à réaliser dans la journée. <br/>Point informel en milieu de journée (lors de la pause méridien en général). <br/>Entraide tout au long de la journée !

https://trello.com/b/SKUzleMh/livrokaz

## Création du MLD :
![image](https://github.com/matthieu33770/LivreOkaz/blob/master/src/main/resources/MCD.png)

## Principe :

Le principe est d'afficher les données d'une DataBase générées par les model du projet dont le schéma est créé au préalable.<br/>
Ces DataBase sont implémentées manuellement pour les besoins de la démonstration.<br/>
Puis création des boutons et des fonctions associées pour réaliser les opérations suivantes :<br/>
	- Tableau : lors de la connexion, affiche le tableau dans son ensemble<br/>
	- GET : fourni les données en fonction d'un paramètre<br/>
	- PUT : Modification des données en fonction d'un paramètre<br/>
	- POST : ajout dans une table<br/>
	- DELETE : suppression des données dans une table<br/>
	
Pour cette version initiale, les tests de ces méthodes CRUD sont réalisés avec le logiciel POSTMAN

## Dépendances : 

Les dépendances utilisées sont les suivantes :<br/>
	- spring-boot-starter-data-jpa V 2.1.1<br/>
	- spring-boot-starter-web V 2.1.1<br/>
	- mysql-connector-java V 5.1.47<br/>
	- spring-boot-devtools V 2.1.1<br/>

## Schéma explicatif :
![image](https://github.com/matthieu33770/LivreOkaz/blob/master/src/main/resources/Sch%C3%A9ma%20explicatif.jpg)

# Angular :
Mise en place du Front-End de l'application LivrOkaz
Nous avons travaillé tous les trois de manière totalement indépendante pour être sûr de bien comprendre, chacun d'entre nous, la façon de faire et de travailler avec Angular et les interactions.

Pour ce faire, nous avons généré un projet Angular. A l'intérieur de celui-ci, nous avons généré un model pour les ouvrages, à l'instar du modèle en Back-End. Nous avons créé un service Data pour nous permettre de faire "passerelle" avec le Back-End. Ce service regroupe les méthodes CRUD que nous envoyons ensuite au Back. Ces données sont récupérées ou envoyées par un composant. Il y a un composant pour consulter un livre, un pour afficher les listes des ouvrages disponibles et un pour la création, la modification ou la suppression d'ouvrage.

Nous avons utilisé Material d'Angular pour aider à la mise en forme des templates. Les templates communiquent avec les composants via les string interpolations et les two-way binding [(ngModel)].

Sur la liste des ourvrages, nous avons utilisé une boucle ngFor dans le template pour afficher l'ensembles des ouvrages.

L'ensemble des composants sont reliés par le module app-routing où sont déclarés les différentes routes internes en Angular.

![image](https://github.com/matthieu33770/LivreOkaz/blob/master/src/main/resources/Sch%C3%A9ma%20Angular.JPG)
