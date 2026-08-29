// ! Bu araç @Kraptor123 tarafından | @kekikanime için yazılmıştır.
version = 28

cloudstream {
    authors     = listOf("kraptor")
    language    = "en"
    description = "Streamed ile Canlı Spor Yayınlarını İzleyebilirsiniz."
    status      = 1
    tvTypes     = listOf("Live")
    iconUrl     = "https://t2.gstatic.com/faviconV2?client=SOCIAL&type=FAVICON&fallback_opts=TYPE,SIZE,URL&url=https://streamed.pk/&size=128"
}

android {
    namespace = "com.kraptor.streamed"

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
