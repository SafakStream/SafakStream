package turkspor;

import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: SportsParser.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lturkspor/SportsParser;", "", "<init>", "()V", "hostPattern", "Lkotlin/text/Regex;", "siteUrl", "", "value", "gatewayTargets", "", "html", "base", "channels", "Lturkspor/SportsChannel;", "queryParam", "url", "key", "streamUrl", "player", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSportsParser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportsParser.kt\nturkspor/SportsParser\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,60:1\n1795#2,10:61\n2068#2:71\n2069#2:73\n1805#2:74\n1795#2,10:78\n2068#2:88\n2069#2:91\n1805#2:92\n1849#2,8:93\n296#2,2:104\n1#3:72\n1#3:89\n1#3:90\n1#3:106\n78#4:75\n99#4,2:76\n101#4,3:101\n*S KotlinDebug\n*F\n+ 1 SportsParser.kt\nturkspor/SportsParser\n*L\n21#1:61,10\n21#1:71\n21#1:73\n21#1:74\n29#1:78,10\n29#1:88\n29#1:91\n29#1:92\n37#1:93,8\n42#1:104,2\n21#1:72\n29#1:90\n28#1:75\n28#1:76,2\n28#1:101,3\n*E\n"})
public final class SportsParser {

    @NotNull
    public static final SportsParser INSTANCE = new SportsParser();

    @NotNull
    private static final Regex hostPattern = new Regex("^(www\\.)?selcuksportshd[a-z0-9]*\\.(xyz|is)$", RegexOption.IGNORE_CASE);

    private SportsParser() {
    }

    @Nullable
    public final String siteUrl(@NotNull String value) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            SportsParser sportsParser = this;
            URI uri = new URI(StringsKt.trim(value).toString());
            if (Intrinsics.areEqual(uri.getScheme(), "https") && uri.getUserInfo() == null && CollectionsKt.listOf(new Integer[]{-1, 443}).contains(Integer.valueOf(uri.getPort()))) {
                Regex regex = hostPattern;
                String host = uri.getHost();
                if (host == null) {
                    host = "";
                }
                if (regex.matches(host)) {
                    StringBuilder sbAppend = new StringBuilder().append("https://");
                    String lowerCase = uri.getHost().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    obj = Result.constructor-impl(sbAppend.append(lowerCase).append('/').toString());
                }
                return (String) (Result.isFailure-impl(obj) ? null : obj);
            }
            return null;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    @NotNull
    public final List<String> gatewayTargets(@NotNull String html, @NotNull String base) {
        Iterable $this$mapNotNull$iv = Jsoup.parse(html, base).select("a[href]");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            String strSiteUrl = INSTANCE.siteUrl(it.absUrl("href"));
            if (strSiteUrl != null) {
                destination$iv$iv.add(strSiteUrl);
            }
        }
        return CollectionsKt.distinct((List) destination$iv$iv);
    }

    @NotNull
    public final List<SportsChannel> channels(@NotNull String html, @NotNull String base) {
        Object obj;
        char c;
        SportsChannel sportsChannel;
        String strText;
        Document doc = Jsoup.parse(html, base);
        if (!StringsKt.contains(doc.title(), "SelcukSports", true)) {
            return CollectionsKt.emptyList();
        }
        Map categories = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("tab5", "Spor Kanalları")});
        Map $this$flatMap$iv = categories;
        Collection destination$iv$iv = new ArrayList();
        for (Map.Entry element$iv$iv : $this$flatMap$iv.entrySet()) {
            String tab = (String) element$iv$iv.getKey();
            String category = (String) element$iv$iv.getValue();
            char c2 = '#';
            Iterable $this$mapNotNull$iv = doc.select('#' + tab + " a[data-url]");
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                Element a = (Element) element$iv$iv$iv;
                Element elementSelectFirst = a.selectFirst(".name");
                String string = (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null) ? null : StringsKt.trim(strText).toString();
                if (string == null) {
                    string = "";
                }
                String title = string;
                Document doc2 = doc;
                String player = StringsKt.substringBefore$default(a.attr("data-url"), c2, (String) null, 2, (Object) null);
                SportsParser sportsParser = INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    obj = Result.constructor-impl(new URI(player));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                URI uri = (URI) obj;
                if (uri == null) {
                    c = c2;
                    destination$iv$iv2 = destination$iv$iv2;
                    sportsChannel = null;
                } else if (Intrinsics.areEqual(uri.getScheme(), "https") && uri.getHost() != null && uri.getUserInfo() == null) {
                    String id = INSTANCE.queryParam(player, "id");
                    if (id == null) {
                        destination$iv$iv2 = destination$iv$iv2;
                        c = '#';
                        sportsChannel = null;
                    } else if ((title.length() == 0) || !new Regex("[A-Za-z0-9_-]{1,100}").matches(id)) {
                        c = '#';
                        sportsChannel = null;
                    } else {
                        Element elementSelectFirst2 = a.selectFirst("time");
                        String strText2 = elementSelectFirst2 != null ? elementSelectFirst2.text() : null;
                        destination$iv$iv2 = destination$iv$iv2;
                        c = '#';
                        sportsChannel = new SportsChannel(id, title, category, player, strText2 != null ? strText2 : "");
                    }
                } else {
                    c = '#';
                    sportsChannel = null;
                }
                if (sportsChannel != null) {
                    destination$iv$iv2.add(sportsChannel);
                }
                destination$iv$iv2 = destination$iv$iv2;
                c2 = c;
                doc = doc2;
            }
            Document doc3 = doc;
            Iterable $this$distinctBy$iv = (List) destination$iv$iv2;
            int $i$f$distinctBy = 0;
            HashSet set$iv = new HashSet();
            ArrayList list$iv = new ArrayList();
            for (Object e$iv : $this$distinctBy$iv) {
                SportsChannel it = (SportsChannel) e$iv;
                $this$distinctBy$iv = $this$distinctBy$iv;
                $i$f$distinctBy = $i$f$distinctBy;
                if (set$iv.add(TuplesKt.to(it.getTitle(), it.getId()))) {
                    list$iv.add(e$iv);
                }
            }
            ArrayList list$iv$iv = list$iv;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            doc = doc3;
        }
        return (List) destination$iv$iv;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0062  */
    @Nullable
    public final String queryParam(@NotNull String url, @NotNull String key) {
        Object obj;
        String strDecode;
        Iterable iterableSplit$default;
        Object element$iv;
        String it;
        try {
            Result.Companion companion = Result.Companion;
            SportsParser sportsParser = this;
            String rawQuery = new URI(url).getRawQuery();
            if (rawQuery == null || (iterableSplit$default = StringsKt.split$default(rawQuery, new char[]{'&'}, false, 0, 6, (Object) null)) == null) {
                strDecode = null;
            } else {
                Iterable $this$firstOrNull$iv = iterableSplit$default;
                Iterator it2 = $this$firstOrNull$iv.iterator();
                do {
                    if (!it2.hasNext()) {
                        element$iv = null;
                        break;
                    }
                    element$iv = it2.next();
                } while (!Intrinsics.areEqual(StringsKt.substringBefore$default((String) element$iv, '=', (String) null, 2, (Object) null), key));
                String str = (String) element$iv;
                if (str == null || (it = StringsKt.substringAfter$default(str, '=', (String) null, 2, (Object) null)) == null) {
                    strDecode = null;
                } else {
                    strDecode = URLDecoder.decode(it, "UTF-8");
                }
            }
            obj = Result.constructor-impl(strDecode);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (String) (Result.isFailure-impl(obj) ? null : obj);
    }

    @Nullable
    public final String streamUrl(@NotNull String html, @NotNull String player) {
        List groupValues;
        String base;
        Object obj;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("this\\.baseStreamUrl\\s*=\\s*['\"](https://[^'\"]+)['\"]"), html, 0, 2, (Object) null);
        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (base = (String) groupValues.get(1)) == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            SportsParser sportsParser = this;
            obj = Result.constructor-impl(new URI(base));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        URI uri = (URI) obj;
        if (uri == null || !Intrinsics.areEqual(uri.getScheme(), "https") || uri.getHost() == null || uri.getUserInfo() != null) {
            return null;
        }
        if (new Regex("(?:const|let|var)\\s+privateStream\\s*=\\s*1\\b").containsMatchIn(html)) {
            return base;
        }
        String id = queryParam(player, "id");
        if (id != null && new Regex("[A-Za-z0-9_-]{1,100}").matches(id) && StringsKt.contains$default(html, "/playlist.m3u8", false, 2, (Object) null)) {
            return StringsKt.trimEnd(base, new char[]{'/'}) + '/' + id + "/playlist.m3u8";
        }
        return null;
    }
}
