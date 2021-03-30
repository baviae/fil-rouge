sudo apt-get update
sudo apt-get upgrade
wget https://www.python.org/ftp/python/3.9.2/Python-3.9.2.tgz
tar -zxvf Python-3.9.2.tgz 
cd Python-3.9.2
sudo apt-get -y install build-essential  # install gcc et ses outils
sudo apt-get -y install libreadline-dev  # permet le rappel des commandes
sudo apt-get -y install libsqlite3-dev   # sqlite
sudo apt-get -y install libssl-dev libffi-dev libgdm-dev # libraries systeme
sudo apt-get -y install zlib1g-dev  lzma-dev libbz2-dev  # libraries de compression
sudo apt-get -y install uuid-dev  # creer des uuid
gcc --version  # should be 9.3.0
./configure --enable-optimizations --enable-shared
# Profile guided optimization (PGO) et Link Time Optimization (LTO).
# significant speed boost 10%-20%. 
# Creation d'une shared library pour l'ajouter ensuite dans postgresql
make -j`nproc`  # compile le code en parallele sur les cores
sudo make install # install dans la directory /usr/local/bin