package io.github.lexadiky.cyan.plugin

import io.github.lexadiky.cyan.KotlinSettings
import io.github.lexadiky.cyan.mixin.TestMixin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

class ConventionLibraryJvmPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.plugins.apply("org.jetbrains.kotlin.jvm")
        target.plugins.apply("org.jetbrains.kotlinx.kover")

        target.extensions.configure<KotlinProjectExtension> {
            jvmToolchain(KotlinSettings.jvmToolchainVersion(target))
        }

        TestMixin.apply(target, false)
    }
}
