#!/bin/bash

#Java Envirionment

export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export PATH=$JAVA_HOME/bin:$PATH
export PATH=/home/sigadmin/Projects/apache-maven-3.6.3/bin:$PATH
export PATH=/home/sigadmin/Projects/apache-tomcat-9.0.35/bin:$PATH
export PATH=/home/sigadmin/Projects/gerrit/bin:$PATH
