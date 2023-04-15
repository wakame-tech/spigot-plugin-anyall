val spigotVersion = "1.19.4-R0.1-SNAPSHOT"
val kotlinVersion = "1.5.10"

plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.5.10"
    id("net.minecrell.plugin-yml.bukkit") version "0.3.0"
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

bukkit {
    main = "tech.wakame.anyall.AnyAll"
    apiVersion = "1.19"
}