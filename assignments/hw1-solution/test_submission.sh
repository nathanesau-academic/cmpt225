#!/bin/bash
# run after zip_submission
mkdir tmp
cp assignment1.zip tmp
cd tmp
unzip assignment1.zip

cd src
javac TestIterators.java
javac TestRushHour.java

java TestIterators
java TestRushHour

cd ..
cd ..
rm -rf tmp