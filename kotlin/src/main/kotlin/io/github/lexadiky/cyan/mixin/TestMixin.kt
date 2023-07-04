package io.github.lexadiky.cyan.mixin

import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType

object TestMixin {

    fun apply(target: Project, configureTasks: Boolean) {
        if (configureTasks) {
            target.tasks.withType<Test> {
                useJUnitPlatform()
            }
        }

        target.dependencies {
            add("testImplementation", "io.kotest:kotest-runner-junit5:5.6.1")
            add("testImplementation", "io.kotest:kotest-property:5.6.1")
            add("testImplementation", "io.mockk:mockk:1.13.5")
        }
    }
}