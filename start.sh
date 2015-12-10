#!/usr/bin/env bash

DEBUG="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5015"
ENCODING="-Dfile.encoding=UTF-8"

export MAVEN_OPTS="$DEBUG $ENCODING"
echo "Using MAVEN_OPTS=$MAVEN_OPTS"

mvn clean package jetty:run

