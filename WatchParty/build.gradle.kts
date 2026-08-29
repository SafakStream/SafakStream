@file:Suppress("UnstableApiUsage")

plugins {
    id("org.jetbrains.kotlin.plugin.serialization") version "2.4.0"
}

version = 6

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
        buildConfigField("String", "WATCHPARTY_RELAY", "\"wss://relay.dogior.it/\"")
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
