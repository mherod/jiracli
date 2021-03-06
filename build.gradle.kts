@file:Suppress("UNUSED_VARIABLE")

import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    kotlin("multiplatform") version "1.4.30-M1"
    kotlin("plugin.serialization") version "1.4.30-M1"
}

repositories {
    mavenCentral()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    maven("https://kotlin.bintray.com/kotlinx")
}

val kotlinVersion: String = KotlinCompilerVersion.VERSION
val ktorVersion = "1.4.3"
val coroutinesVersion = "1.4.2"

group = "resharker"
version = "1.0"

repositories {
    mavenCentral()
}

kotlin {
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        binaries {
            executable {
                entryPoint = "resharker.jiracli.main"
            }
        }
    }

    sourceSets {
        val nativeMain by getting {
            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion-native-mt")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-curl:$ktorVersion")
                implementation("io.ktor:ktor-client-json:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
            }
        }
        val nativeTest by getting
    }
}

tasks.register<Copy>("installBinary") {
    dependsOn(tasks.getByName("build"))
    from("$buildDir/bin/native/releaseExecutable/")
    include("**/*.kexe")
    rename { it.substringBefore('.') }
    into("/usr/local/bin/")
}
