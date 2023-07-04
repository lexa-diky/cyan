package io.github.lexadiky.cyan.mixin

import io.github.lexadiky.cyan.AndroidSettings
import io.github.lexadiky.cyan.android
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.extra

object AndroidCommonMixin {

    fun apply(target: Project) {
        target.extensions.android.apply {
            compileSdk = AndroidSettings.targetSdk(target)

            val namespaceSuffix = createNamespaceSuffix(target)
            namespace = "io.github.lexadiky.cyan.$namespaceSuffix" // TODO think about it!

            defaultConfig {
                minSdk = AndroidSettings.minSdk(target)
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                vectorDrawables {
                    useSupportLibrary = true
                }
            }

            buildTypes.findByName("release")?.apply {
                isMinifyEnabled = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
                isCoreLibraryDesugaringEnabled = true
            }
            packaging {
                resources {
                    excludes += listOf(
                        "/META-INF/{AL2.0,LGPL2.1}",
                        "/META-INF/versions/9/previous-compilation-data.bin"
                    )
                }
            }
        }
    }

    private fun createNamespaceSuffix(target: Project) =
        target.path.replace(':', '.')
            .replace("-", "")
            .substring(1)
}
