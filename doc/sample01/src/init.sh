#!/bin/sh

GRPID=sample
ARTIFACTID=sampleapp
VERSION=0.0.1

# https://hub.docker.com/_/maven
# https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
docker run \
  -it --rm \
  -u 1000:1000 \
  -v `pwd`:/prj \
  -w /prj \
  -e MAVEN_CONFIG=/prj/maven/.m2 \
  maven:3.9 \
    mvn archetype:generate \
      -Duser.home=/prj/maven \
      -DgroupId=${GRPID} \
      -DartifactId=${ARTIFACTID} \
      -DarchetypeGroupId=org.apache.maven.archetypes \
      -DarchetypeArtifactId=maven-archetype-quickstart \
      -DarchetypeVersion=1.5 \
      -DinteractiveMode=false


exit 0
