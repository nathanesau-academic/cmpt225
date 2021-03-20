#!/bin/bash

# NOTE: this script is intended to run in WSL
# run after zip_submission

mkdir tmp
cp assignment4.zip tmp
cd tmp
unzip assignment4.zip

cd src
ls
javac TestGraphs.java

java TestGraphs

cd ..
cd ..
rm -rf tmp 