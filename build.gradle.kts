group = "com.example"
version = "0.0.1-SNAPSHOT"

//subprojects {
//
//
//    dependencies {
//        // import a BOM
//    }
//
//
//    ext {
//        set("azureVersion", "2.0.5")
//        set("springBootAdminVersion", "2.1.1")
//        set("springCloudServicesVersion", "2.0.3.RELEASE")
//        set("springCloudVersion", "Greenwich.RC2")
//        set("springStatemachineVersion", "2.0.1.RELEASE")
//        set("vaadinVersion", "12.0.3")
//    }
//
//}

subprojects {
    apply(plugin = "java-library")

    repositories {
        mavenCentral()
        maven {
            url = uri("https://repo.spring.io/milestone")
        }
    }
    ext {
        set("springBootVersion", "2.1.1.RELEASE")
    }
    dependencies {
        "implementation"(platform("org.springframework.boot:spring-boot-dependencies:2.1.1.RELEASE"))
    }
}

configure(subprojects.filter { it.name.startsWith("spring-cloud") }) {
    dependencies {
        "implementation"(platform("org.springframework.cloud:spring-cloud-dependencies:Greenwich.RC2"))
    }
}


configure(subprojects.filter { it.name.startsWith("spring-boot-admin-") }) {
    dependencies {
        "implementation"(platform("de.codecentric:spring-boot-admin-dependencies:2.1.1"))
    }
}

//set('azureVersion', '2.0.5')
////set('springBootAdminVersion', '2.1.1')
////set('springCloudServicesVersion', '2.0.3.RELEASE')
////set('springCloudVersion', 'Greenwich.RC2')
////set('springStatemachineVersion', '2.0.1.RELEASE')
////set('vaadinVersion', '12.0.3')
//
//mavenBom "de.codecentric:spring-boot-admin-dependencies:${springBootAdminVersion}"
//mavenBom "org.springframework.statemachine:spring-statemachine-bom:${springStatemachineVersion}"
//mavenBom "com.microsoft.azure:azure-spring-boot-bom:${azureVersion}"
//mavenBom "io.pivotal.spring.cloud:spring-cloud-services-dependencies:${springCloudServicesVersion}"
//mavenBom "com.vaadin:vaadin-bom:${vaadinVersion}"
//mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"