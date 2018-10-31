# Microcommerce
  Application simulant un site ecommerce (la partie paiement n'est pas encore finalisée)

# Objectif
  L'objectif est de mettre en oeuvre l'architecture micro services au sein d'une application
  
# Structure du projet
   Le projet est composé de plusieurs modules (chaque microservice correspond à un module)
      * module client-ui: module représentant le client de notre application
      * module config-server : module permettant de définir le dépôt distant qui contiendra les "properties" des microservices de l'application
      * module config-server-repo : module contenant les propriétés des autres microservices
      * module eureka-server : module permettant de voir toutes les instances des microservices actives dans l'application
      * module microservice-produit : module représentant les produits à acheter
      * module microservice-commande : module permettant de commander le produit après l'avoir choisi (panier)
      * module microservice-paiement : module permettant de confirmer le paiement du produit
      * module spring-admin : module permettant de surveiller le fonctionnement et l'état des microservices de l'application
      * module zuul-server : module qui contient l'API Gateway, point d'entrée de l'application et qui redirige vers le microservice correspondant
      


# Installation
* Cloner le projet ou télécharger le fichier zip sur votre machine locale et l'importer dans votre IDE favori (IntelliJ, Eclipse, Netbeans) 
* 
##Prérequis
  * IDE (Eclipse, IntelliJ, Netbeans) installé sur votre ordinateur
  * 4 GB of RAM


## Build with 
* [Maven](https://maven.apache.org/) 

