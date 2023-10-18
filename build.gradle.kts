buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.0.2")
        classpath(kotlin("gradle-plugin", version = "1.7.10"))
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.45")
    }
}

allprojects {
    repositories {
        maven{
            url = uri("https://jitpack.io")
            content {
                includeGroupByRegex("com\\.github.*")
            }
        }
        google()
        mavenCentral()
    }
}

task("clean") {
    delete(rootProject.buildDir)
}
