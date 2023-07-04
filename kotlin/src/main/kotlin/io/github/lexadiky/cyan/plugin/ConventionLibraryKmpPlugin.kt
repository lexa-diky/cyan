package io.github.lexadiky.cyan.plugin

import io.github.lexadiky.cyan.Settings
import io.github.lexadiky.cyan.mixin.TestMixin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ConventionLibraryKmpPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.plugins.apply("org.jetbrains.kotlin.multiplatform")
        target.plugins.apply("org.jetbrains.kotlinx.kover")

        target.extensions.configure<KotlinMultiplatformExtension> {
            jvm {
                jvmToolchain(Settings.jvmToolchainVersion(target))
                withJava()
                testRuns.named("test") {
                    executionTask.configure {
                        useJUnitPlatform()
                    }
                }
            }
        }

        TestMixin.apply(target = target, configureTasks = false)
    }
}
