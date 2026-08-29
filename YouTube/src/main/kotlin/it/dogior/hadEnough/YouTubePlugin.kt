package it.dogior.hadEnough

import android.app.AlertDialog
import android.content.Context
import android.content.ContextWrapper
import android.content.SharedPreferences
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
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
            showSettingsDialog(targetCtx)
        }
    }

    private fun showSettingsDialog(context: Context) {
        val layout = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(50, 40, 50, 20)
        }

        val langLabel = TextView(context).apply { text = "Dil Kodu (Örn: tr, en):" }
        val langInput = EditText(context).apply {
            setText(sharedPref?.getString("language", "tr") ?: "tr")
        }

        val countryLabel = TextView(context).apply { 
            text = "Ülke Kodu (Örn: TR, US):" 
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
            .setTitle("YouTube Ayarları")
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
            .setNegativeButton("İptal") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
