group = "com.example"
version = "0.0.1-SNAPSHOT"

subprojects {
    apply(plugin = "java-library")

    repositories {
        mavenCentral()
        maven {
            url = uri("https://repo.spring.io/milestone")
        }
    }
    ext {
        set("azureVersion", "2.0.5")
        set("camelVersion", "2.23.0")
        set("mybatisSpringBootVersion", "1.3.2")
        set("springBootVersion", "2.1.1.RELEASE")
        set("springBootAdminVersion", "2.1.1")
        set("springCloudServicesVersion", "2.0.3.RELEASE")
        set("springCloudVersion", "Greenwich.RC2")
        set("springShellVersion", "2.0.0.RELEASE")
        set("springStatemachineVersion", "2.0.1.RELEASE")
        set("vaadinVersion", "12.0.3")
    }
    dependencies {
        "implementation"(platform("org.springframework.boot:spring-boot-dependencies:${extra["springBootVersion"]}"))
    }
}

configure(subprojects.filter { it.name.startsWith("spring-cloud") }) {
    dependencies {
        "implementation"(platform("org.springframework.cloud:spring-cloud-dependencies:${extra["springCloudVersion"]}"))
    }
}


configure(subprojects.filter { it.name.startsWith("spring-boot-admin-") }) {
    dependencies {
        "implementation"(platform("de.codecentric:spring-boot-admin-dependencies:${extra["springBootAdminVersion"]}"))
    }
}

configure(subprojects.filter { it.name.startsWith("spring-cloud-services-") }) {
    dependencies {
        "implementation"(platform("io.pivotal.spring.cloud:spring-cloud-services-dependencies:${extra["springCloudServicesVersion"]}"))
    }
}

configure(subprojects.filter { it.name.startsWith("azure-") }) {
    dependencies {
        "implementation"(platform("com.microsoft.azure:azure-spring-boot-bom:${extra["azureVersion"]}"))
    }
}