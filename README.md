# Microcommerce
  Application simulant un site ecommerce (la partie paiement n'est pas encore finalisée)

# Objectif
  L'objectif est de mettre en oeuvre l'architecture micro services au sein d'une application
  
# Structure du projet
   Le projet est composé de plusieurs modules (chaque microservice correspond à un module)

      * module client-ui: module représentant le client de notre application      
      * module config-server : module permettant de définir le dépôt distant qui contiendra les "properties" des microservices de l'application
      * module config-server-repo : module contenant les propriétés des autres microservices (ce module est présent à l'adresse https://github.com/cedriccob/mcommerce-repo.git) une modification dans le dépôt distant se répercute automatiquement sur le projet sans avoir besoin de le réinitialiser
      * module eureka-server : module permettant de voir toutes les instances des microservices actives dans l'application
      * module microservice-produit : module représentant les produits à acheter
      * module microservice-commande : module permettant de commander le produit après l'avoir choisi (panier)
      * module microservice-paiement : module permettant de confirmer le paiement du produit
      * module spring-admin : module permettant de surveiller le fonctionnement et l'état des microservices de l'application
      * module zuul-server : module qui contient l'API Gateway, point d'entrée de l'application et qui redirige vers le microservice correspondant
      


# Installation
*   Cloner le projet ou télécharger le fichier zip sur votre machine locale et l'importer dans IntelliJ sinon Eclipse ou Netbeans 

*   Lancer les microservices dans l'ordre suivant : 
    *  config-server 
    *  eureka-server accessible à l'url http://localhost:9001
    *  zuul-server 
    *  microservice-produits accessible à l'url http://localhost:9001
    *  microservice-commandes accessible à l'url http://localhost:9002
    *  microservice-paiement accessible à l'url http://localhost:9003
    *  microservice-expedition accessible à l'url http://localhost:9006
    *  client-ui
    *  springadmin accessible à l'url http://localhost:9105

*   Il est conseillé d'utiliser Postman ou un autre client API pour interroger les microservices produits, paiement, commande, expedition car cela permet de faire les méthodes du CRUD (Create Read Update Delete) sur les microservices

*   Pour accéder à la page principale http://localhost:8080 
 
# Prérequis
  * IDE IntelliJ de préférence sinon Eclipse ou Netbeans installé sur votre ordinateur
  * 4 GB of RAM


# Principales technos utilisées
* [Maven](https://maven.apache.org/) : Gestionnaire de dépendances

* [Spring Boot](http://spring.io/projects/spring-boot) : framework Java pour application web

* [Feign](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html) Web service client pour application REST

* [JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/) standard Java pour la persistence des données 

* [Hibernate](http://hibernate.org/) c'est un ORM(Object Relational Mapping) implémentation de JPA 

* [Netflix Eureka](https://cloud.spring.io/spring-cloud-netflix/) permet de visualiser les instances des microservices actives de l'application

* [Zuul](https://cloud.spring.io/spring-cloud-netflix/multi/multi__router_and_filter_zuul.html) API Gateway de l'application

* [Ribbon](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-ribbon.html) permet de répartir la charge de l'application entre les instances 

* [Thymeleaf](https://www.thymeleaf.org/) Moteur de templates qui permet d'afficher les pages de l'application dans un navigateur

* [Spring Admin](https://codecentric.github.io/spring-boot-admin/1.5.7/) permet de surveiller l'état de l'application


&copy; Cédric COBBOLD - Ingénieur Etudes et développement
