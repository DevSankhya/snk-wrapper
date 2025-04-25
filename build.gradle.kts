import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("maven-publish")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.github.DevSankhya"
version = "1.0.6"

repositories {
    mavenCentral()
    mavenLocal()
    flatDir {
        dirs("libs") // sua pasta com os .jar
    }
}


dependencies {
    implementation(fileTree("libs") { include("*.jar") })

    implementation("jakarta.xml.bind:jakarta.xml.bind-api:2.3.3")
    implementation("org.glassfish.jaxb:jaxb-runtime:2.3.3")

}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
var fatJarName = "";

tasks.shadowJar {
    archiveBaseName.set("snk-wrapper")
    archiveVersion.set(project.version.toString())
    archiveClassifier.set("") // remove "-all" do nome final
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifact(tasks.named("shadowJar").get()) {
                classifier = null // evita conflito
            }

            groupId = project.group.toString()
            artifactId = "snk-wrapper"
            version = project.version.toString()
        }
    }
}