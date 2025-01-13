#!/bin/sh

ARTIFACTID=sampleapp

# Unit Test
docker run \
  -it --rm \
  -u 1000:1000 \
  -v `pwd`:/prj \
  -w /prj/${ARTIFACTID} \
  -e MAVEN_CONFIG=/prj/maven/.m2 \
  maven:3.9 \
    mvn test \
      -Duser.home=/prj/maven


# CMD Test



exit 0
