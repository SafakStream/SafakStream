package turkspor.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006R6\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lturkspor/common/CountryCatalog;", "", "<init>", "()V", "countries", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "country", "title", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAuthorizedSportsProviders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AuthorizedSportsProviders.kt\nturkspor/common/CountryCatalog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,403:1\n296#2:404\n1960#2,3:405\n297#2:408\n*S KotlinDebug\n*F\n+ 1 AuthorizedSportsProviders.kt\nturkspor/common/CountryCatalog\n*L\n236#1:404\n236#1:405,3\n236#1:408\n*E\n"})
final class CountryCatalog {

    @NotNull
    public static final CountryCatalog INSTANCE = new CountryCatalog();

    @NotNull
    private static final LinkedHashMap<String, List<String>> countries = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("Türkiye", CollectionsKt.listOf(new String[]{"turkey", "turkish", "trt ", "bein sports tr", "s sport"})), TuplesKt.to("Birleşik Krallık", CollectionsKt.listOf(new String[]{" uk", "britain", "sky sports", "tnt sports", "bbc", "itv"})), TuplesKt.to("ABD", CollectionsKt.listOf(new String[]{" usa", " us ", "espn", "fox sports", "cbs", "nbc", "nfl", "nba", "mlb"})), TuplesKt.to("Kanada", CollectionsKt.listOf(new String[]{"canada", " tsn", "sportsnet"})), TuplesKt.to("Almanya", CollectionsKt.listOf(new String[]{"germany", "deutsch", "dazn de"})), TuplesKt.to("Fransa", CollectionsKt.listOf(new String[]{"france", "french", "canal+", "rmc sport"})), TuplesKt.to("İtalya", CollectionsKt.listOf(new String[]{"italy", "italia", "sky sport it"})), TuplesKt.to("İspanya", CollectionsKt.listOf(new String[]{"spain", "spanish", "laliga", "movistar"})), TuplesKt.to("Portekiz", CollectionsKt.listOf(new String[]{"portugal", "sport tv"})), TuplesKt.to("Hollanda", CollectionsKt.listOf(new String[]{"netherlands", "ziggo"})), TuplesKt.to("Belçika", CollectionsKt.listOf("belgium")), TuplesKt.to("Yunanistan", CollectionsKt.listOf(new String[]{"greece", "cosmote"})), TuplesKt.to("Avustralya", CollectionsKt.listOf(new String[]{"australia", "fox cricket"})), TuplesKt.to("Hindistan", CollectionsKt.listOf(new String[]{"india", "star sports", "sony ten"})), TuplesKt.to("Pakistan", CollectionsKt.listOf(new String[]{"pakistan", "ptv sports"})), TuplesKt.to("Arap Ülkeleri", CollectionsKt.listOf(new String[]{"arab", "uae", "dubai", "ssc ", "bein sports mena"})), TuplesKt.to("Latin Amerika", CollectionsKt.listOf(new String[]{"mexico", "argentina", "brazil", "latino", "tudn"}))});

    private CountryCatalog() {
    }

    @NotNull
    public final String country(@NotNull String title) {
        Object obj;
        String str;
        String value;
        Iterable $this$firstOrNull$iv;
        StringBuilder sbAppend = new StringBuilder().append(' ');
        String lowerCase = title.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String value2 = sbAppend.append(lowerCase).append(' ').toString();
        Iterable $this$firstOrNull$iv2 = countries.entrySet();
        Iterator it = $this$firstOrNull$iv2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object element$iv = it.next();
            Iterable tokens = (List) ((Map.Entry) element$iv).getValue();
            Iterable $this$any$iv = tokens;
            boolean z = false;
            if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                Iterator it2 = $this$any$iv.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        value = value2;
                        $this$firstOrNull$iv = $this$firstOrNull$iv2;
                        break;
                    }
                    CharSequence p0 = (CharSequence) it2.next();
                    value = value2;
                    $this$firstOrNull$iv = $this$firstOrNull$iv2;
                    if (StringsKt.contains$default(value, p0, false, 2, (Object) null)) {
                        z = true;
                        break;
                    }
                    value2 = value;
                    $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                }
            } else {
                value = value2;
                $this$firstOrNull$iv = $this$firstOrNull$iv2;
            }
            if (z) {
                obj = element$iv;
                break;
            }
            value2 = value;
            $this$firstOrNull$iv2 = $this$firstOrNull$iv;
        }
        Map.Entry entry = (Map.Entry) obj;
        return (entry == null || (str = (String) entry.getKey()) == null) ? "Uluslararası" : str;
    }
}
