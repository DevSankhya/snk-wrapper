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
    implementation(mapOf("name" to "activiti-cxf-5.17.0"))
    implementation(mapOf("name" to "activiti-engine-5.17.0"))
    implementation(mapOf("name" to "commons-fileupload-1.2.2"))
    implementation(mapOf("name" to "commons-io-2.1"))
    implementation(mapOf("name" to "cuckoo"))
    implementation(mapOf("name" to "gson-2.1"))
    implementation(mapOf("name" to "jackson-annotations-2.13.3"))
    implementation(mapOf("name" to "jackson-core-2.1.3"))
    implementation(mapOf("name" to "jape"))
    implementation(mapOf("name" to "javax.servlet"))
    implementation(mapOf("name" to "joda-time-2.3"))
    implementation(mapOf("name" to "json-20140107"))
    implementation(mapOf("name" to "mge-modelcore-4.10b62"))
    implementation(mapOf("name" to "mgecom-model"))
    implementation(mapOf("name" to "ojdbc7_12c"))
    implementation(mapOf("name" to "okhttp-3.9.0"))
    implementation(mapOf("name" to "okio-1.13.0"))
    implementation(mapOf("name" to "SankhyaW-extensions"))
    implementation(mapOf("name" to "sanutil"))
    implementation(mapOf("name" to "sanws"))
    implementation(mapOf("name" to "tika-core-1.16"))

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
