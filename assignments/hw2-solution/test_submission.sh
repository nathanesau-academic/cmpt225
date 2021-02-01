#!/bin/bash

# NOTE: this script is intended to run in WSL
# run after zip_submission

mkdir tmp
cp assignment2.zip tmp
cd tmp
unzip assignment2.zip

cd src
ls
javac TestCircularLinkedList.java
javac TestMyStackOperations.java
javac TestLinkedListReachableNodes.java

java TestCircularLinkedList
java TestMyStackOperations
java TestLinkedListReachableNodes

cd ..
cd ..
rm -rf tmp