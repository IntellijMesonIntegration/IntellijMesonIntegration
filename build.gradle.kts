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
    implementation(group = "com.google.code.gson", name = "gson", version = "2.8.6")
    implementation(group = "org.eclipse.mylyn.github", name = "org.eclipse.egit.github.core", version = "2.1.5")

    testImplementation(group = "junit", name = "junit", version = "4.12")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    type = "CL"
    version = "2020.1.2"
//    setPlugins("org.rust.lang")
}

tasks {
    patchPluginXml {
        changeNotes("""
        0.0.1 - To be released:
        - Meson syntax highlighting (and basic parsing, but with cryptic errors)
        - Run configurations
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