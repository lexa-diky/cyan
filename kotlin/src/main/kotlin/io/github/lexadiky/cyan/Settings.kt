package io.github.lexadiky.cyan

import org.gradle.api.Project
import org.gradle.kotlin.dsl.extra

internal object Settings {

    fun jvmToolchainVersion(target: Project): Int {
        return target.extra["cyan.kotlin.jvm-toolchain"].toString().toInt()
    }
}