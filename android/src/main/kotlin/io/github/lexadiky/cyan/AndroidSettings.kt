package io.github.lexadiky.cyan

import org.gradle.api.Project
import org.gradle.kotlin.dsl.extra

internal object AndroidSettings {

    fun targetSdk(target: Project): Int {
        return target.extra["cyan.android.target-sdk"].toString().toInt()
    }

    fun minSdk(target: Project): Int {
        return target.extra["cyan.android.min-sdk"].toString().toInt()
    }
}