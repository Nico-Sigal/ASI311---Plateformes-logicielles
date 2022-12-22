# ASI311-Plateformes-logicielles/TP3

Pour lancer le build : cd myfilmlist && mvn clean install
Pour lancer le main : dans les options de la flèche play, run Java

## PARTIE 1

### Sortie terminal lors de l'exécution de MyFilmsListTest.java (réalisé jusqu'à la question bonus partie 1.5)  

"(base) nicolassigal@mac-nico ASI311-Testing %  /usr/bin/env /Users/nicolassigal/opt/anaconda3/bin/java @/var/folders/ps/6c7w4gcs2t33_1x_8gxgrpqh0000gn/T/
cp_18u2z9ma2jhxzpt9j2lqyfihx.argfile com.ensta.myfilmlist.MyfilmlistMain

Initialisation de la base de donnees effectuee avec succes

James Cameron est-il celebre ? false
Peter Jackson est-il celebre ? true

La duree totale de la trilogie "Le Seigneur des Anneaux" est de : 558 minutes

La note moyenne est : 15.17
------ BONUS -------
Vérification de la modification des attributs célèbres :
Peter Jackson est-il celebre ? true
James Cameron est-il celebre ? false
Quentin Tarantino est-il celebre ? true

La liste des réalisateurs célèbres parmi ceux demandés est la suivante : 
Peter Jackson
Quentin Tarantino"

Springboot : une fois les Beans ajoutés, run MyfilmlistApplication.java pour lancer l'ouverture du port 8080 en localhost, accéder ensuite à localhost:8080/swagger-ui/index.html et localhost:8080/h2-console
