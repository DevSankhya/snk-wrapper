plugins {
    id("java")
    id("maven-publish")
}

group = "br.com.sankhya.ce"
version = "1.0.0"

repositories {
    mavenCentral()
    flatDir {
        dirs("libs") // sua pasta com os .jar
    }
}

dependencies {
    compileOnly(mapOf("name" to "activiti-cxf-5.17.0"))
    compileOnly(mapOf("name" to "activiti-engine-5.17.0"))
    compileOnly(mapOf("name" to "commons-fileupload-1.2.2"))
    compileOnly(mapOf("name" to "commons-io-2.1"))
    compileOnly(mapOf("name" to "cuckoo"))
    compileOnly(mapOf("name" to "gson-2.1"))
    compileOnly(mapOf("name" to "jackson-annotations-2.13.3"))
    compileOnly(mapOf("name" to "jackson-core-2.1.3"))
    compileOnly(mapOf("name" to "jape"))
    compileOnly(mapOf("name" to "javax.servlet"))
    compileOnly(mapOf("name" to "joda-time-2.3"))
    compileOnly(mapOf("name" to "json-20140107"))
    compileOnly(mapOf("name" to "mge-modelcore-4.10b62"))
    compileOnly(mapOf("name" to "mgecom-model"))
    compileOnly(mapOf("name" to "ojdbc7_12c"))
    compileOnly(mapOf("name" to "okhttp-3.9.0"))
    compileOnly(mapOf("name" to "okio-1.13.0"))
    compileOnly(mapOf("name" to "SankhyaW-extensions"))
    compileOnly(mapOf("name" to "sanutil"))
    compileOnly(mapOf("name" to "sanws"))
    compileOnly(mapOf("name" to "tika-core-1.16"))

}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}
