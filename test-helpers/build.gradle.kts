/*
 * Copyright 2019 Louis Cognault Ayeva Derman. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    `maven-publish`
}

android {
    setDefaults()
}

kotlin {
    android()
    jvm()
    js()
    macos()
    ios()
    linux(x64 = true)
    mingw(x64 = true)
    setupSourceSets()
    sourceSets {
        commonMain.dependencies {
            api(kotlin("stdlib-common"))
            api(kotlin("test-common"))
            api(kotlin("test-annotations-common"))
            api(Libs.kotlinX.coroutines.coreCommon)
        }
        allJvmMain {
            dependencies {
                api(Libs.kotlin.stdlibJdk7)
                api(Libs.kotlinX.coroutines.core)
                api(Libs.kotlin.testJunit)
            }
        }
        androidMain.dependencies {
            api(Libs.kotlinX.coroutines.android)
            api(Libs.androidX.test.ext.junit)
        }
        jsMain.dependencies {
            api(kotlin("stdlib-js"))
            api(Libs.kotlinX.coroutines.coreJs)
        }
        nativeMain {
            dependencies {
                api(Libs.kotlinX.coroutines.coreNative)
            }
        }
        all {
            languageSettings.apply {
                useExperimentalAnnotation("kotlin.Experimental")
            }
        }
    }
}