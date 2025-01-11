#!/bin/sh

ARTIFACTID=sampleapp

docker run \
  -it --rm \
  -u 1000:1000 \
  -v `pwd`:/prj \
  -w /prj/${ARTIFACTID} \
  -e MAVEN_CONFIG=/prj/maven/.m2 \
  maven:3.9 \
    mvn package \
      -Duser.home=/prj/maven


exit 0
