# fil-rouge
Fil rouge Aston

# Description de l'application
L'applicatioon "éco-commerce" est une plateforme de vente en ligne des articles de second main et des objets recycles destinés à toute personnes à faible ou au moyen revenu.

[Le Lean Canvas](https://docs.google.com/spreadsheets/d/1Ip7EwaUnPo0Waj7vnq1TA4c3rcOTB432nLBmfSh32B4/edit?usp=sharing)

[Méthode Scrum](https://aeckeline.atlassian.net/jira/software/c/projects/ECO/boards/2/roadmap)


# Installation de l'application partie Back-end API
- Java Jdk 8
- Maven
- PostgreSQL 12.6
- Postman dernière version
- DBeaver dernière version
- Lombok (ouvrir le projet sur eclipse, ouvrir l'arborescence aller dans librairies, maven dependencies,
  trouver lombok, click droit preferences, ouvrir l'emplacement du fichier et double click sur le jar 
  lombok pour l'installer).
    
- pour lancer l'application en ligne de commande, placer vous dans le dossier avec le terminal
  eco-commerce puis taper : mvn spring-boot:run

# Installer l'application partie Front-end Angular

- Installer NPM (node package manager) version 14.6 LTS.
- Installer Angular-cli grace a npm avec la commande : npm install -g angular-cli
- si angular a des problemes de lancement faire : 
Remove one / from /// on line number 7 in file node_modules/@types/node/index.d.ts

  

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
### Commande lancement playbook sur serveur de test
```shell
ansible-playbook -i staging.yml  --vault-password-file ~/password_file server.yml
```
# Mise en place de jenkins-pic
```shell

