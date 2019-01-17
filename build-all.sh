#!/bin/bash

set -e

SETTING_FILES=(
  settings.gradle.kts
  settings-axon-framework.gradle.kts
  settings-graphql-java.gradle.kts
)

for x in "${SETTING_FILES[@]}"; do
  echo "##### Processing $x #####"
  ./gradlew --settings-file $x --no-daemon build
done