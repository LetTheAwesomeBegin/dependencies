#!/bin/bash

set -e

INPUT_FILE=a.txt
TARGET_PARENT_DIRECTORY=spring-boot-managed
TEMPLATE_PROJECT=spring-boot-template
SETTINGS_FILE=settings-spring-boot-managed.gradle.kts

if [ ! -d ${TARGET_PARENT_DIRECTORY} ]; then
  mkdir -v ${TARGET_PARENT_DIRECTORY}
fi

for x in `cat ${INPUT_FILE}`; do
  PROJECT=$(echo ${x} | cut -d ":" -f 1,2 | sed 's/:/_/g')
  cp -r ${TEMPLATE_PROJECT} ${TARGET_PARENT_DIRECTORY}/${PROJECT}
  printf "dependencies {\n  implementation(\"$x\")\n}" > ${TARGET_PARENT_DIRECTORY}/${PROJECT}/build.gradle.kts
  echo "include(\"${TARGET_PARENT_DIRECTORY}:${PROJECT}\")" >> ${SETTINGS_FILE}
done
