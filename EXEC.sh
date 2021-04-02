#! /bin/bash
# update all packages
sudo apt update -y
sudo apt upgrade -y

# install git and wget
sudo apt install git wget

# added monitoring tools
sudo apt install -y htop iotop iftop

# installation python3
sudo apt install -y python3
sudo apt install python3-pip -y

# install ansible last version
pip3 install natsort
pip3 install wheel
pip3 install --upgrade pip
pip3 install ansible
ansible --version

# run playbook installation de docker
ansible-playbook -i inventory ./ansible/playbook.yml --vault-password-file ./vault.txt

# run ansible playbook install Environnement et déploiement des applications
ansible-playbook -i inventory EnvInstallation.yml --vault-password-file ./vault.txt

