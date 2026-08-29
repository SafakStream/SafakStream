package com.keyiflerolsun

import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class YoutubeTRPlugin : Plugin() {
    override fun load() {

        registerMainAPI(YoutubeTR())

    }
}
