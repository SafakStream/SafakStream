version = 12

android {
    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/java")
        }
    }
}

cloudstream {
    authors     = listOf("SafakStream")
    language    = "tr"
    description = "Canlı spor yayınları ve maç özetleri izle."

    status  = 1
    tvTypes = listOf("Live")
    iconUrl = "https://www.google.com/s2/favicons?domain=selcuksportshd.com&sz=%size%"
}
