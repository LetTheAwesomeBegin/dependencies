#!/bin/bash

set -e

SETTING_FILES=(
  settings-aws.gradle.kts
  settings-axon-framework.gradle.kts
  settings-camel.gradle.kts
  settings-gradle-plugins.gradle.kts
  settings-graphql-java.gradle.kts
  settings-jackson.gradle.kts
  settings-micrometer.gradle.kts
  settings-project-reactor.gradle.kts
  settings-spring.gradle.kts
  settings-spring-boot.gradle.kts
  settings-spring-boot-admin.gradle.kts
  settings-spring-boot-managed.gradle.kts
  settings-spring-cloud.gradle.kts
  settings-spring-data.gradle.kts
  settings-spring-security.gradle.kts
  settings-spring-session.gradle.kts
  settings-springfox.gradle.kts
  settings-third-party.gradle.kts
)

for x in "${SETTING_FILES[@]}"; do
  echo "#################### Processing $x #########################"
  ./gradlew --settings-file $x --no-daemon build
done
