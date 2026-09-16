package turkspor.common;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ChannelGroups.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005JF\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\t0\u000f0\t\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00050\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lturkspor/common/ChannelGroups;", "", "<init>", "()V", "NOTICE", "", "key", "s", "order", "", "getOrder", "()Ljava/util/List;", "category", "title", "sections", "Lkotlin/Pair;", "T", "rows", "Lkotlin/Function1;", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChannelGroups.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelGroups.kt\nturkspor/common/ChannelGroups\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,28:1\n777#2:29\n873#2,2:30\n1665#2:32\n1691#2,3:33\n1694#2,3:43\n1221#2:46\n460#3,7:36\n*S KotlinDebug\n*F\n+ 1 ChannelGroups.kt\nturkspor/common/ChannelGroups\n*L\n26#1:29\n26#1:30,2\n26#1:32\n26#1:33,3\n26#1:43,3\n26#1:46\n26#1:36,7\n*E\n"})
public final class ChannelGroups {

    @NotNull
    public static final String NOTICE = "Bazı yayınlar yalnızca maç saatinde açılır. Erişim sorunu varsa WARP ile deneyin.";

    @NotNull
    public static final ChannelGroups INSTANCE = new ChannelGroups();

    @NotNull
    private static final List<String> order = CollectionsKt.listOf(new String[]{"beIN Sports", "S Sport", "S Plus", "Tivibu", "tabii", "Exxen", "Spor Smart", "Ulusal", "Yabancı Spor", "Diğer Spor"});

    private ChannelGroups() {
    }

    private final String key(String s) {
        String lowerCase = s.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return new Regex("[^a-z0-9]").replace(Normalizer.normalize(StringsKt.replace$default(lowerCase, (char) 305, 'i', false, 4, (Object) null), Normalizer.Form.NFD), "");
    }

    @NotNull
    public final List<String> getOrder() {
        return order;
    }

    @NotNull
    public final String category(@NotNull String title) {
        String n = key(title);
        if (StringsKt.contains$default(title, '[', false, 2, (Object) null)) {
            return "Yabancı Spor";
        }
        if (StringsKt.startsWith$default(n, "bein", false, 2, (Object) null)) {
            return "beIN Sports";
        }
        if (StringsKt.startsWith$default(n, "splus", false, 2, (Object) null) || StringsKt.startsWith$default(n, "ssportplus", false, 2, (Object) null) || StringsKt.startsWith$default(title, "S+", false, 2, (Object) null)) {
            return "S Plus";
        }
        if (StringsKt.startsWith$default(n, "ssport", false, 2, (Object) null)) {
            return "S Sport";
        }
        if (StringsKt.startsWith$default(n, "tivibu", false, 2, (Object) null)) {
            return "Tivibu";
        }
        if (StringsKt.startsWith$default(n, "tabii", false, 2, (Object) null)) {
            return "tabii";
        }
        if (StringsKt.startsWith$default(n, "exxen", false, 2, (Object) null)) {
            return "Exxen";
        }
        if (StringsKt.startsWith$default(n, "sporsmart", false, 2, (Object) null) || StringsKt.startsWith$default(n, "smartspor", false, 2, (Object) null)) {
            return "Spor Smart";
        }
        return new Regex("^(trt|aspor|htspor|tv8|atv|a2|tv100|ekol|sports?tv|fb|gs)").containsMatchIn(n) ? "Ulusal" : "Diğer Spor";
    }

    @NotNull
    public final <T> List<Pair<String, List<T>>> sections(@NotNull List<? extends T> rows, @NotNull Function1<? super T, String> title) {
        ArrayList answer$iv$iv$iv;
        List<? extends T> $this$filter$iv = rows;
        Collection destination$iv$iv = new ArrayList();
        for (T t : $this$filter$iv) {
            if (ChannelRules.INSTANCE.visible((String) title.invoke(t))) {
                destination$iv$iv.add(t);
            }
        }
        Iterable $this$groupBy$iv = (List) destination$iv$iv;
        Map destination$iv$iv2 = new LinkedHashMap();
        for (T t2 : $this$groupBy$iv) {
            String strCategory = INSTANCE.category((String) title.invoke(t2));
            Object value$iv$iv$iv = destination$iv$iv2.get(strCategory);
            if (value$iv$iv$iv == null) {
                answer$iv$iv$iv = new ArrayList();
                destination$iv$iv2.put(strCategory, answer$iv$iv$iv);
            } else {
                answer$iv$iv$iv = value$iv$iv$iv;
            }
            Object key$iv$iv$iv = answer$iv$iv$iv;
            List list$iv$iv = (List) key$iv$iv$iv;
            list$iv$iv.add(t2);
        }
        Iterable $this$sortedBy$iv = MapsKt.toList(destination$iv$iv2);
        return CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: turkspor.common.ChannelGroups$sections$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                Pair it = (Pair) t3;
                Pair it2 = (Pair) t4;
                return ComparisonsKt.compareValues(Integer.valueOf(ChannelGroups.INSTANCE.getOrder().indexOf(it.getFirst())), Integer.valueOf(ChannelGroups.INSTANCE.getOrder().indexOf(it2.getFirst())));
            }
        });
    }
}
