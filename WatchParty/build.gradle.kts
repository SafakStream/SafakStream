@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("org.jetbrains.kotlin.plugin.serialization") version "2.4.0"
}

version = 7

cloudstream {
    authors = listOf("DieGon")
    status = 3 
    tvTypes = listOf("Others")
    iconUrl = "https://raw.githubusercontent.com/DieGon7771/ItaliaInStreaming/master/WatchParty/WatchParty_icon.png"
    description = "⚠️ BETA ⚠️ Watch movies and TV series together in real-time with live chat."
    requiresResources = true
}

android {
    namespace = "it.dogior.hadEnough"

    defaultConfig {
        val properties = Properties()
        val secretsFile = project.rootProject.file("secrets.properties")
        if (secretsFile.exists()) {
            properties.load(secretsFile.inputStream())
        }
        val relay = properties.getProperty("WATCHPARTY_RELAY").takeIf { !it.isNullOrEmpty() } ?: "wss://relay.damus.io"
        buildConfigField("String", "WATCHPARTY_RELAY", "\"$relay\"")
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    compileOnly("androidx.navigation:navigation-fragment-ktx:2.7.7")
    compileOnly("com.jaredrummler:colorpicker:1.1.0")
}
