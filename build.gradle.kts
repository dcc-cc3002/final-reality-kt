@file:Suppress("SpellCheckingInspection")

import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType.HTML

plugins {
    kotlin("jvm") version "1.7.10"
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
}

group = "cl.uchile.dcc.finalreality"
version = "1.0-RELEASE"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.kotest:kotest-property:5.4.2")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.4.2")
}

tasks.test {
    useJUnitPlatform()
}

configure<KtlintExtension> {
    verbose.set(true)
    outputToConsole.set(true)
    reporters {
        reporter(HTML)
    }
}
