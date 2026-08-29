import org.jetbrains.kotlin.konan.properties.Properties

// use an integer for version numbers
version = 33

cloudstream {
    description = "TV Shows and Movies from StreamingCommunity"
    authors = listOf("doGior")

    status = 1
    tvTypes = listOf(
        "TvSeries",
        "Movie",
        "Documentary",
        "Cartoon"
    )

    requiresResources = true
    language = "it"

    iconUrl = "https://streamingunity.dog/apple-touch-icon.png?v=2"
}

android {
    namespace = "it.dogior.hadEnough"

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    defaultConfig {
        val properties = Properties()
        val secretsFile = project.rootProject.file("secrets.properties")
        if (secretsFile.exists()) {
            properties.load(secretsFile.inputStream())
        }
        val simklId = properties.getProperty("SIMKL_CLIENT_ID") ?: ""
        buildConfigField("String", "SIMKL_CLIENT_ID", "\"$simklId\"")
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.room:room-compiler:2.8.4")
}
