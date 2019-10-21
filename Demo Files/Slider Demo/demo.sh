#!/bin/sh

#  Events.sh
#  
#
#  Created by Chaman Sabharwal on 10/8/15.
#
#keep the old code
#cp Demo.jar DemoO.jar
#expand jar file
#jar -xf Demo.jar *
#Compile
javac -d . *.java
#javadoc
#javadoc -d docs -quiet *.java
#make jar file
jar -cfm Demo.jar m.txt .
#execute
java -jar Demo.jar