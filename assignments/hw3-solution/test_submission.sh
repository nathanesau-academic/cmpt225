#!/bin/bash

# NOTE: this script is intended to run in WSL
# run after zip_submission

mkdir tmp
cp assignment3.zip tmp
cd tmp
unzip assignment3.zip

cd src
ls
javac TestBinTrees.java
javac TestArithmeticExpressions.java

java TestBinTrees
java TestArithmeticExpressions

cd ..
cd ..
rm -rf tmp 