version = 481

android {
    namespace = "com.megix"

    defaultConfig {
        android.buildFeatures.buildConfig = true

        buildConfigField(
            "String",
            "SIMKL_API",
            "\"\""
        )

        buildConfigField(
            "String",
            "TMDB_KEY",
            "\"\""
        )

        buildConfigField(
            "String",
            "CC_COOKIE",
            "\"\""
        )

        buildConfigField(
            "String",
            "CASTLE_KEY",
            "\"\""
        )

        buildConfigField(
            "String",
            "MOVIEBLAST_TOKEN",
            "\"\""
        )

        buildConfigField(
            "String",
            "MOVIEBLAST_API",
            "\"\""
        )

        buildConfigField(
            "String",
            "MOVIEBLAST_KEY",
            "\"\""
        )

        buildConfigField(
            "String",
            "NETMIRROR_TOKEN",
            "\"\""
        )
    }
}

cloudstream {
    language = "en"

    description =
        "One stop solution for Movies, Series, Anime, AsianDrama and Torrents"

    authors = listOf("megix")

    status = 1

    tvTypes = listOf(
        "TvSeries",
        "Movie",
        "AsianDrama",
        "Anime",
        "Torrent"
    )

    iconUrl =
        "https://github.com/SaurabhKaperwan/CSX/raw/refs/heads/master/CineStream/icon.png"
}
