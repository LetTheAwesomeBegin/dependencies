buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("io.spring.gradle:dependency-management-plugin:1.0.6.RELEASE")
    }
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "io.spring.dependency-management")

    repositories {
        mavenCentral()
        //jcenter()
//        maven {
//            url = uri("https://repo.spring.io/milestone")
//        }
//        maven {
//            url = uri("https://repo.spring.io/libs-milestone-local")
//        }
//        maven {
//            url = uri("https://repo.spring.io/release")
//        }
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        maven {
            url = uri("http://maven.imagej.net/content/repositories/public/")
        }
        maven {
            url = uri("https://packages.atlassian.com/maven-3rdparty/")
        }
        maven {
            url = uri("http://maven.geotoolkit.org/")
        }
    }
    ext {
        set("awsJavaSdkVersion", "1.11.482")
        set("awsJavaSdk2Version", "2.3.1")
        set("axonFrameworkVersion", "4.0.3")
        set("azureVersion", "2.0.5")
        set("camelVersion", "2.23.0")
        set("commonsCollections4Version", "4.2")
        set("commonsCompressVersion", "1.18")
        set("commonsIoVersion", "2.6")
        set("commonsTextVersion", "1.6")
        set("graphqlSpringVersion", "5.0.2")
        set("graphqlSpringWebVersion", "1.0")
        set("hibernateJpa21ApiVersion", "1.0.2.Final")
        set("immutablesVersion", "2.7.5")
        set("jaiCodecVersion", "1.1.3")
        set("jaiCoreVersion", "1.1.3")
        set("jaiImageioVersion", "1.1")
        set("jaiImageioCoreVersion", "1.4.0")
        set("jaiImageioJpeg2000Version", "1.3.0")
        set("jasyptVersion", "1.9.2")
        set("jasyptSpringBootStarterVersion", "2.1.0")
        set("jettisonVersion", "1.4.0")
        set("joolVersion", "0.9.14")
        set("jschVersion", "0.1.55")
        set("mybatisSpringBootVersion", "1.3.2")
        set("mapstructVersion", "1.2.0.Final")
        set("micrometerVersion", "1.1.2")
        set("pdfboxVersion", "1.8.16")
        set("poiVersion", "3.17")
        set("protobufVersion", "3.6.1")
        set("protobufGradlePluginVersion", "0.8.7")
        set("reactorVersion", "Californium-SR4")
        set("springBootVersion", "2.1.1.RELEASE")
        set("springBootAdminVersion", "2.1.1")
        set("springCloudServicesVersion", "2.0.3.RELEASE")
        set("springCloudVersion", "Finchley.SR2")
        set("springCloudGcpVersion", "1.0.0.RELEASE")
        set("springCloudStreamBinderKinesisVersion", "1.0.0.RELEASE")
//        set("springCloudStreamVersion", "Fishtown.RELEASE")
        set("springfoxVersion", "2.9.2")
        set("springIntegrationVersion", "5.1.2.RELEASE")
        set("springIntegrationAwsVersion", "2.0.0.RELEASE")
        set("springStatemachineVersion", "2.0.1.RELEASE")
        set("twelevemonkeysImageioVersion", "3.4.1")
        set("urlrewritefilterVersion", "4.0.4")
        set("vaadinVersion", "12.0.3")
        set("vtdXmlVersion", "2.13.4")
        set("xmlbeansVersion", "2.6.0")

        // Gradle Plugins
        set("gradleNodePluginVersion", "1.2.0")
        set("gradleCssPluginVersion", "1.11.1")
        set("gradleJsPluginVersion", "1.12.0")
        set("gradleDownloadTaskVersion", "3.4.3")
        set("gradleJaxbPluginVersion", "1.3.6")
        set("gradleNodePluginVersion", "1.2.0")
        set("gradleNexusPluginVersion", "2.3.1")
        set("gradleVersionsPluginVersion", "0.11.1")
        set("gradleSshPluginVersion", "2.2.0")
        set("sonarqubeGradlePluginVersion", "2.7")
        set("gradleAptPluginVersion", "0.20")
        set("typescriptGeneratorGradlePluginVersion", "2.11.472")
        set("asciidoctorGradlePluginVersion", "1.5.9.2")
        set("gradleAvroPluginVersion", "0.16.0")
        set("querydslPluginVersion", "1.0.10")
    }
    dependencies {
        "implementation"(platform("org.springframework.boot:spring-boot-dependencies:${extra["springBootVersion"]}"))
        "implementation"(platform("org.springframework.cloud:spring-cloud-dependencies:${extra["springCloudVersion"]}"))
        "implementation"(platform("org.springframework.cloud:spring-cloud-gcp-dependencies:${extra["springCloudGcpVersion"]}"))
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

configure(subprojects.filter { it.name.startsWith("org.apache.camel_") }) {
    dependencies {
        "implementation"(platform("org.apache.camel:camel-bom:${extra["camelVersion"]}"))
    }
}

configure(subprojects.filter { it.name.startsWith("de.codecentric_spring-boot-admin") }) {
    dependencies {
            "implementation"(platform("de.codecentric:spring-boot-admin-dependencies:${extra["springBootAdminVersion"]}"))
    }
}

configure(subprojects.filter { it.name.startsWith("spring-cloud-services-") }) {
    dependencies {
        "implementation"(platform("io.pivotal.spring.cloud:spring-cloud-services-dependencies:${extra["springCloudServicesVersion"]}"))
    }
}
