package it.dogior.hadEnough

import android.content.Context
import android.content.ContextWrapper
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin
import it.dogior.hadEnough.settings.SettingsFragment
import org.schabi.newpipe.extractor.NewPipe
import org.schabi.newpipe.extractor.localization.ContentCountry
import org.schabi.newpipe.extractor.localization.Localization

@CloudstreamPlugin
class YouTubePlugin : Plugin() {
    private var sharedPref: SharedPreferences? = null

    private fun getAppCompatActivity(context: Context?): AppCompatActivity? {
        var ctx = context
        while (ctx is ContextWrapper) {
            if (ctx is AppCompatActivity) {
                return ctx
            }
            ctx = ctx.baseContext
        }
        return null
    }

    override fun load(context: Context) {
        sharedPref = context.getSharedPreferences("Youtube", Context.MODE_PRIVATE)

        var language = sharedPref?.getString("language", "tr") ?: "tr"
        var country = sharedPref?.getString("country", "TR") ?: "TR"

        if (language.isEmpty()) { language = "tr" }
        if (country.isEmpty()) { country = "TR" }
        
        try {
            NewPipe.setupLocalization(Localization(language), ContentCountry(country))
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // All providers
        registerMainAPI(YouTubeProvider(language, sharedPref))
        registerMainAPI(YouTubePlaylistsProvider(language))
        registerMainAPI(YouTubeChannelProvider(language))

        openSettings = { ctx ->
            val appCompatActivity = getAppCompatActivity(ctx)
            if (appCompatActivity != null) {
                val frag = SettingsFragment(this, sharedPref)
                frag.show(appCompatActivity.supportFragmentManager, "Frag")
            }
        }
    }
}
