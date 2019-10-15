#!/bin/bash

echo "Running Java File..."
javac -d . source/*.java
jar -cfm Demo.jar m.txt .
java -jar Demo.jar