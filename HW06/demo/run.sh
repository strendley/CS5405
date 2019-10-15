#!/bin/bash

echo "Running Java File..."
javac -d . source/*.java
jar -cfm Demo.java m.txt .
java -jar Demo.java