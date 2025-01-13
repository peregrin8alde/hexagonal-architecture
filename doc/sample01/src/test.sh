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
docker run \
  -it --rm \
  -u 1000:1000 \
  -v `pwd`:/prj \
  -w /prj/${ARTIFACTID} \
  -e MAVEN_CONFIG=/prj/maven/.m2 \
  maven:3.9 \
    java -cp target/sampleapp-1.0-SNAPSHOT.jar:target/dependency/* sample.adapter.primary.cmd.UserCmd -i 100


exit 0
