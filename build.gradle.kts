val spigotVersion = "1.19.4-R0.1-SNAPSHOT"
val kotlinVersion = "1.5.10"

plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.5.10"
}

group = "tech.wakame"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven(url = "https://oss.sonatype.org/content/groups/public/")
    maven(url = "https://repo.codemc.io/repository/maven-public/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:$spigotVersion")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "16"
    }
}

//processResources {
//    def props = [version: version]
//    inputs.properties props
//    filteringCharset 'UTF-8'
//    filesMatching('plugin.yml') {
//        expand props
//    }
//}
