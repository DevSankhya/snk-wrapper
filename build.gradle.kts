plugins {
    id("java")
    id("maven-publish")
}

group = "br.com.sankhya.ce"
version = "1.0.0"

repositories {
    mavenCentral()
    mavenLocal()
    flatDir {
        dirs("libs") // sua pasta com os .jar
    }
}

dependencies {
    implementation(mapOf("group" to "br.com.sankhya","name" to "activiti-cxf-5.17.0", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "activiti-engine-5.17.0", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "commons-fileupload-1.2.2", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "commons-io-2.1", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "cuckoo", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "gson-2.1", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "jackson-annotations-2.13.3", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "jackson-core-2.1.3", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "jape", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "javax.servlet", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "joda-time-2.3", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "json-20140107", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "mge-modelcore-4.10b62", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "mgecom-model", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "ojdbc7_12c", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "okhttp-3.9.0", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "okio-1.13.0", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "SankhyaW-extensions", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "sanutil", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "sanws", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "SimpleJSON", "version" to "master"))
    implementation(mapOf("group" to "br.com.sankhya","name" to "tika-core-1.16", "version" to "master"))

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
