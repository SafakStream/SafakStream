// use an integer for version numbers
version = 31

cloudstream {
    language = "all"
    description = "Deportes eventos en vivo. Sports live events. Futbol. Soccer."
    authors = listOf("redblacker8")

    /**
     * Status int as the following:
     * 0: Down
     * 1: Ok
     * 2: Slow
     * 3: Beta only
     * */
    status = 1
    tvTypes = listOf(
        "Live",
    )

    iconUrl = "https://yt3.googleusercontent.com/T_d2j2xZMjAxPCehiFR6hAv7jE3swcUzfgV8wCXzv1IL7rCEDv3cgQtIxjdmLVyP6ZrSgIu0nw=s900-c-k-c0x00ffffff-no-rj"
}

android {
    namespace = "com.redblacker8"

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("com.google.android.material:material:1.12.0")
}
