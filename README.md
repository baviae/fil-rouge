# fil-rouge
Fil rouge Aston

# Description de l'application
" Le nom de l'appli" est une applicatioon éco-commerce. Elle aura pour but de mettre en vente et d'afficher des articles respectueux de l'environnement(vêtement de second main, articles recyclés, ...)

# Installation de l'application partie Back-end API
- Java Jdk 8
- Maven
- PostgreSQL 12.6
- Postman dernière version
- DBeaver dernière version
- Lombok (ouvrir le projet sur eclipce, ouvrir l'arborescence aller dans libreries, maven dependencies,
  trouver lombok, click droit preferences, ouvrir l'emplacement du fichier et double click sur le jar 
  lombok pour l'installer).
    
- pour lancer l'application en ligne de commande placer vous dans le dossier avec le terminal
  eco-commerce puis taper : mvn spring-boot:run



# Configuration du serveur

### Création des utilisateurs

```shell
sudo adduser --gecos "Aeckeline Ravalomanda" --disabled-password ravalomanda
sudo adduser --gecos "Badrane Houmadi" --disabled-password houmadi
sudo adduser --gecos "Vincent Dubreu" --disabled-password dubreu
```

### Génération des clés ssh pour chaque utilisateur
```shell
ssh-keygen -t rsa -b 4096 
```
### Copie de la clé publique dans le répetoire .ssh de chaque utilisateur sous le nom _authorized_keys_
```shell
mv id_rsa.pub /home/usrname/.ssh/authorized_keys
```



  

