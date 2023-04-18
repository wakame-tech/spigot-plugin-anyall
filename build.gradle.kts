val spigotVersion = "1.19.4-R0.1-SNAPSHOT"
val kotlinVersion = "1.5.10"

plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.5.10"
    id("com.github.johnrengelman.shadow") version "7.0.0"
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
    api(kotlin("stdlib"))
    api(kotlin("reflect"))
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    compileOnly("org.spigotmc:spigot-api:$spigotVersion")
}

tasks {
    processResources {
        filesMatching("plugin.yml") {
            expand("version" to project.version)
            expand("main" to "tech.wakame.anyall.AnyallKt")
        }
    }

    compileJava {
        options.release.set(17)
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }

    shadowJar {
        archiveClassifier.set("plugin")
    }
}
