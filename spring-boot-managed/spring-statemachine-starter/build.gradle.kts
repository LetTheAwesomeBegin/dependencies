dependencies {
    implementation(platform("org.springframework.statemachine:spring-statemachine-bom:${extra["springStatemachineVersion"]}"))
    implementation("org.springframework.statemachine:spring-statemachine-starter")
}
