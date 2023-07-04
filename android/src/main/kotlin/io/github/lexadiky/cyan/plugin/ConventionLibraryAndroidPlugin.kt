package io.github.lexadiky.cyan.plugin

import io.github.lexadiky.cyan.mixin.AndroidCommonMixin
import io.github.lexadiky.cyan.mixin.DeshugaringMixin
import io.github.lexadiky.cyan.mixin.TestMixin
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("MagicNumber")
class ConventionLibraryAndroidPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.plugins.apply("com.android.library")
        target.plugins.apply("org.jetbrains.kotlin.android")
        target.plugins.apply("org.jetbrains.kotlinx.kover")

        AndroidCommonMixin.apply(target)
        TestMixin.apply(target, false)
        DeshugaringMixin.apply(target)
    }
}
