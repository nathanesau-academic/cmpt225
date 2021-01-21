#!/bin/bash
mkdir tmp
cd tmp

mkdir -p src
mkdir -p src/myiterators
mkdir -p src/rushhour

# solution files
cp ../src/myiterators/ArrayIterator.java src/myiterators
cp ../src/myiterators/FibonacciIterator.java src/myiterators
cp ../src/myiterators/RangeIterator.java src/myiterators
cp ../src/rushhour/RushHour.java src/rushhour
cp ../src/rushhour/IllegalMoveException.java src/rushhour

# provided files (optional)
cp ../src/myiterators/IntegerIterator.java src/myiterators
cp ../src/TestRushHour.java src
cp ../src/TestIterators.java src
cp ../src/board1.txt src
cp ../src/badboard.txt src

# zip files
zip -r assignment1.zip src
rm -rf src

cd ..
cp tmp/assignment1.zip assignment1.zip
rm -rf tmp
