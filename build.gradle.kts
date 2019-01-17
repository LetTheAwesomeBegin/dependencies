group = "com.example"
version = "0.0.1-SNAPSHOT"

subprojects {
    apply(plugin = "java-library")

    repositories {
        mavenCentral()
        maven {
            url = uri("https://repo.spring.io/milestone")
        }
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    ext {
        set("awsJavaSdkVersion", "1.11.482")
        set("awsJavaSdk2Version", "2.3.1")
        set("axonFrameworkVersion", "4.0.3")
        set("azureVersion", "2.0.5")
        set("camelVersion", "2.23.0")
        set("graphqlSpringVersion", "5.0.2")
        set("graphqlSpringWebVersion", "1.0")
        set("immutablesVersion", "2.7.5")
        set("mybatisSpringBootVersion", "1.3.2")
        set("mapstructVersion", "1.2.0.Final")
        set("protobufVersion", "3.6.1")
        set("protobufGradlePluginVersion", "0.8.7")
        set("springBootVersion", "2.1.1.RELEASE")
        set("springBootAdminVersion", "2.1.1")
        set("springCloudServicesVersion", "2.0.3.RELEASE")
        set("springCloudVersion", "Greenwich.RC2")
        set("springSecurityVersion", "5.1.3.RELEASE")
        set("springSessionsVersion", "Bean-SR2")
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

configure(subprojects.filter { it.name.startsWith("com.amazonaws_") }) {
    dependencies {
        "implementation"(platform("com.amazonaws:aws-java-sdk-bom:${extra["awsJavaSdkVersion"]}"))
    }
}

configure(subprojects.filter { it.name.startsWith("software.amazon.awssdk_") }) {
    dependencies {
        "implementation"(platform("software.amazon.awssdk:bom:${extra["awsJavaSdk2Version"]}"))
    }
}

configure(subprojects.filter { it.name.startsWith("org.springframework.security_") }) {
    dependencies {
        "implementation"(platform("org.springframework.security:spring-security-bom:${extra["springSecurityVersion"]}"))
    }
}

configure(subprojects.filter { it.name.startsWith("org.springframework.session_") }) {
    dependencies {
        "implementation"(platform("org.springframework.session:spring-session-bom:${extra["springSessionsVersion"]}"))
    }
}