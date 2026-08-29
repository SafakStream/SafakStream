package it.dogior.hadEnough

import android.app.AlertDialog
import android.content.Context
import android.content.ContextWrapper
import android.content.SharedPreferences
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin
import org.schabi.newpipe.extractor.NewPipe
import org.schabi.newpipe.extractor.localization.ContentCountry
import org.schabi.newpipe.extractor.localization.Localization

@CloudstreamPlugin
class YouTubePlugin : Plugin() {
    private var sharedPref: SharedPreferences? = null

    private fun getValidContext(context: Context?): Context? {
        var ctx = context
        while (ctx is ContextWrapper) {
            if (ctx is AppCompatActivity) return ctx
            ctx = ctx.baseContext
        }
        return context
    }

    override fun load(context: Context) {
        sharedPref = context.getSharedPreferences("Youtube", Context.MODE_PRIVATE)

        var language = sharedPref?.getString("language", "tr") ?: "tr"
        var country = sharedPref?.getString("country", "TR") ?: "TR"

        if (language.isEmpty()) language = "tr"
        if (country.isEmpty()) country = "TR"

        try {
            NewPipe.setupLocalization(Localization(language), ContentCountry(country))
        } catch (e: Exception) {
            e.printStackTrace()
        }

        registerMainAPI(YouTubeProvider(language, sharedPref))
        registerMainAPI(YouTubePlaylistsProvider(language))
        registerMainAPI(YouTubeChannelProvider(language))

        openSettings = { ctx ->
            val targetCtx = getValidContext(ctx) ?: ctx
            showMainMenuDialog(targetCtx)
        }
    }

    // Ana Menü (Change localization / Change homepage sections)
    private fun showMainMenuDialog(context: Context) {
        val options = arrayOf("Change localization", "Change homepage sections")

        AlertDialog.Builder(context)
            .setTitle("YouTube plugin settings")
            .setItems(options) { dialog, which ->
                when (which) {
                    0 -> showLocalizationDialog(context)
                    1 -> showHomepageSectionsDialog(context)
                }
                dialog.dismiss()
            }
            .setNegativeButton("Kapat") { dialog, _ -> dialog.dismiss() }
            .show()
    }

    // 1. Bölüm: Dil ve Ülke Ayarları
    private fun showLocalizationDialog(context: Context) {
        val layout = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(50, 40, 50, 20)
        }

        val langLabel = TextView(context).apply { text = "Dil Kodu (Örn: tr, en, it):" }
        val langInput = EditText(context).apply {
            setText(sharedPref?.getString("language", "tr") ?: "tr")
        }

        val countryLabel = TextView(context).apply {
            text = "Ülke Kodu (Örn: TR, US, IT):"
            setPadding(0, 30, 0, 0)
        }
        val countryInput = EditText(context).apply {
            setText(sharedPref?.getString("country", "TR") ?: "TR")
        }

        layout.addView(langLabel)
        layout.addView(langInput)
        layout.addView(countryLabel)
        layout.addView(countryInput)

        AlertDialog.Builder(context)
            .setTitle("Change localization")
            .setView(layout)
            .setPositiveButton("Kaydet") { dialog, _ ->
                val newLang = langInput.text.toString().trim()
                val newCountry = countryInput.text.toString().trim().uppercase()

                sharedPref?.edit()?.apply {
                    putString("language", newLang)
                    putString("country", newCountry)
                    apply()
                }

                try {
                    NewPipe.setupLocalization(Localization(newLang), ContentCountry(newCountry))
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                dialog.dismiss()
            }
            .setNegativeButton("Geri") { dialog, _ ->
                dialog.dismiss()
                showMainMenuDialog(context)
            }
            .show()
    }

    // 2. Bölüm: Ana Sayfa Bölümleri (Trending Aç/Kapa + Playlist/Kanal Ekleme)
    private fun showHomepageSectionsDialog(context: Context) {
        val layout = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(50, 40, 50, 20)
        }

        // Trending Switch Satırı
        val isTrendingEnabled = sharedPref?.getBoolean("trending", true) ?: true
        val trendingSwitch = SwitchCompat(context).apply {
            text = "Trending"
            textSize = 16f
            isChecked = isTrendingEnabled
            setPadding(0, 10, 0, 30)
        }

        val urlLabel = TextView(context).apply {
            text = "Add playlist or channel (URL):"
            textSize = 14f
        }

        val urlInput = EditText(context).apply {
            hint = "https://www.youtube.com/playlist?list=..."
        }

        layout.addView(trendingSwitch)
        layout.addView(urlLabel)
        layout.addView(urlInput)

        AlertDialog.Builder(context)
            .setTitle("Change homepage sections")
            .setView(layout)
            .setPositiveButton("Kaydet") { dialog, _ ->
                val newTrending = trendingSwitch.isChecked
                val inputUrl = urlInput.text.toString().trim()

                val editor = sharedPref?.edit()
                editor?.putBoolean("trending", newTrending)

                if (inputUrl.isNotEmpty()) {
                    val currentUrls = sharedPref?.getStringSet("custom_urls", mutableSetOf())?.toMutableSet() ?: mutableSetOf()
                    currentUrls.add(inputUrl)
                    editor?.putStringSet("custom_urls", currentUrls)
                    Toast.makeText(context, "URL eklendi!", Toast.LENGTH_SHORT).show()
                }

                editor?.apply()
                dialog.dismiss()
            }
            .setNegativeButton("Geri") { dialog, _ ->
                dialog.dismiss()
                showMainMenuDialog(context)
            }
            .show()
    }
}
