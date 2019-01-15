#!/bin/bash

set -e

INPUT_FILE=a.txt
TARGET_PARENT_DIRECTORY=aws-java-sdk
TEMPLATE_PROJECT=spring-boot-template

for x in `cat ${INPUT_FILE}`; do
  PROJECT=$(echo ${x} | cut -d ":" -f 1,2 | sed 's/:/_/g')
  cp -r ${TEMPLATE_PROJECT} ${TARGET_PARENT_DIRECTORY}/${PROJECT}
  echo "dependencies { implementation(\"$x\") }" > ${TARGET_PARENT_DIRECTORY}/${PROJECT}/build.gradle.kts
  echo "include(\"${TARGET_PARENT_DIRECTORY}:${PROJECT}\")" >> settings.gradle.kts
done
