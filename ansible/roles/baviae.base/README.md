Role Name
=========

A brief description of the role goes here.

Requirements
------------

Any pre-requisites that may not be covered by Ansible itself or the role should be mentioned here. For instance, if the role uses the EC2 module, it may be a good idea to mention in this section that the boto package is required.

Role Variables
--------------

A description of the settable variables for this role should go here, including any variables that are in defaults/main.yml, vars/main.yml, and any variables that can/should be set via parameters to the role. Any variables that are read from other roles and/or the global scope (ie. hostvars, group vars, etc.) should be mentioned here as well.

Dependencies
------------

A list of other roles hosted on Galaxy should go here, plus any details in regards to parameters that may need to be set for other roles, or variables that are used from other roles.

Example Playbook
----------------

Including an example of how to use your role (for instance, with variables passed in as parameters) is always nice for users too:

    - hosts: servers
      roles:
         - { role: username.rolename, x: 42 }

License
-------

BSD

Author Information
------------------

An optional section for the role authors to include contact information, or a website (HTML is not allowed).

##****************************************************************************
##****************************************************************************
##****************************************************************************

## Lancement des playbook 

## Local
sudo apt update
sudo apt upgrade -y
sudo apt install python3 -y
sudo apt install ansible -y #on installe ansible pour permettre le lancemant du playbook la premier fois
git clone "cloner le projet" #avant de cloner changer les ip, user et le vault dans : host_vars/controlleur_test.yml
# bien propager votre cle ssh pour la connection en remote
ssh-keygen -t rsa -b 4096 # tout mettre par defaut
ssh-copy-id user@ip-adress # permet de copier simplement la clé vers la remote
# lancement du playbook local
cd fil-rouge/ansible
#ansible-playbook -i host_vars/controleur_test.yml workstation.yml --ask-vault-pass #  nous demande le mdp du vault 

# lancement du playbook remote
python3 -m venv venv
source venv/bin/activate
pip3 install ansible
ansible-playbook -i staging.yml server.yml -e 'ansible_python_interpreter=/usr/bin/python3' --ask-vault-pass



