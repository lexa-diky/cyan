package io.github.lexadiky.cyan

import io.github.lexadiky.cyan.mixin.TestMixin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.extra
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

class ConventionLibraryJvmPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.plugins.apply("org.jetbrains.kotlin.jvm")
        target.plugins.apply("org.jetbrains.kotlinx.kover")

        target.extensions.configure<KotlinProjectExtension> {
            jvmToolchain(resolveJvmToolchainVersion(target))
        }

        TestMixin.apply(target, false)
    }

    private fun resolveJvmToolchainVersion(target: Project): Int {
        return target.extra["cyan.kotlin.jvm-toolchain"].toString().toInt()
    }
}
