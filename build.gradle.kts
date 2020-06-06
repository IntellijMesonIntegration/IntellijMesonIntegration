plugins {
    kotlin("jvm") version "1.3.72"
    id("org.jetbrains.intellij") version "0.4.21"
}

group = "com.nonnulldinu.mesonintegration"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation(group = "junit", name = "junit", version = "4.12")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    type = "CL"
    version = "2020.1.1"
}

tasks {
    patchPluginXml {
        changeNotes("""
        0.0.1 - To be released:
        - Meson syntax highlight
        """.trimMargin())
    }
}

sourceSets {
    main {
        java {
            srcDir("src/main/gen")
        }
    }
}