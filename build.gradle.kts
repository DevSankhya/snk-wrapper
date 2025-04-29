import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("maven-publish")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.github.DevSankhya"
version = "1.0.9"

repositories {
    mavenCentral()
    mavenLocal()
    flatDir {
        dirs("libs") // sua pasta com os .jar
    }
}


dependencies {
    implementation(fileTree("libs") {
        include("*.jar")
    })

    implementation("jakarta.xml.bind:jakarta.xml.bind-api:2.3.3")
    implementation("org.glassfish.jaxb:jaxb-runtime:2.3.3")
    implementation("org.jdom", "jdom", "1.1.3")

}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
var fatJarName = "";

tasks.shadowJar {
    mergeServiceFiles()
    val runtimeClasspath = project.configurations.runtimeClasspath.get()
    val dependencies = runtimeClasspath
        .map(::zipTree) // OR .map { zipTree(it) }
    from(dependencies)
    configurations = listOf(runtimeClasspath)
    archiveBaseName.set("snk-wrapper")
    archiveVersion.set(project.version.toString())
    archiveClassifier.set("") // remove "-all" do nome final
}
publishing {
    publications {
        create<MavenPublication>("maven") {
//            from(components["java"]) // ou "shadow" se usar shadowJar

            groupId = project.group.toString()
            artifactId = "snk-wrapper"
            version = project.version.toString()

            artifact(tasks.named("shadowJar").get()) {
                builtBy(tasks.named("shadowJar"))
            }

            suppressAllPomMetadataWarnings()
        }
    }
    repositories {
        mavenLocal()
    }
}
tasks.named("jar").configure {
    enabled = false
}
tasks.named("assemble").configure {
    enabled = false
}
tasks.named("publishMavenPublicationToMavenLocal") {
    dependsOn(tasks.named("shadowJar"))
}