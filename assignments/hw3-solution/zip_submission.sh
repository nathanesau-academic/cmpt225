#!/bin/bash

# NOTE: this script is intended to run in WSL

# installation instructinos for zulu 11 (linux)
# sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys 0xB1998361219BD9C9
# wget https://cdn.azul.com/zulu/bin/zulu-repo_1.0.0-2_all.deb
# sudo apt-get install ./zulu-repo_1.0.0-2_all.deb
# sudo apt-get update
# sudo apt-get install zulu11-jdk

./gradlew createSubmission 