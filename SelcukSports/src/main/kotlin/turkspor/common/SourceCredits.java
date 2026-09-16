package turkspor.common;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.text.Normalizer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import turkspor.DomainResolver;

/* JADX INFO: compiled from: SourceCredits.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\nJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lturkspor/common/SourceCredits;", "", "<init>", "()V", "aslan", "Lturkspor/common/SourceCredit;", "getAslan", "()Lturkspor/common/SourceCredit;", "sources", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "forTitle", "title", "open", "", "context", "Landroid/content/Context;", "credit", "showAslanThanks", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSourceCredits.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SourceCredits.kt\nturkspor/common/SourceCredits\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,54:1\n296#2,2:55\n1#3:57\n*S KotlinDebug\n*F\n+ 1 SourceCredits.kt\nturkspor/common/SourceCredits\n*L\n42#1:55,2\n*E\n"})
public final class SourceCredits {

    @NotNull
    public static final SourceCredits INSTANCE = new SourceCredits();

    @NotNull
    private static final SourceCredit aslan;

    @NotNull
    private static final LinkedHashMap<String, SourceCredit> sources;

    private SourceCredits() {
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        String str = null;
        aslan = new SourceCredit("Aslan TV", null, str, "Kaynaklarını TurkSpor’da derlememize izin veren Aslan TV yapımcısına teşekkür ederiz. Listeleri hazırlayan ve güncel tutan emeğin sahibi Aslan TV’dir. ♥", 4, defaultConstructorMarker);
        int r8 = 12;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        String str2 = null;
        sources = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("selcuksports", new SourceCredit("SelçukSports", DomainResolver.GATEWAY, str, null, 12, defaultConstructorMarker)), TuplesKt.to("taraftarium24", new SourceCredit("Taraftarium24", "https://taraftarium24.ch/", str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("inatbox", new SourceCredit("İnat Box", null, str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("inattv", new SourceCredit("İnat TV", "https://www.inatgiris.com/", str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("crex", new SourceCredit("Crex", "https://crex1.vercel.app/", str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("mahsunsports", new SourceCredit("MahsunSports", "https://mahsunsports.com/", str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("ardaspor", new SourceCredit("ArdaSpor", "https://www.ardasporgiris.site/", str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("mackeyfi", new SourceCredit("MaçKeyfi / Canlımaçlar", "https://www.mackeyfi559.sbs/", str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("zbahis", new SourceCredit("Zbahis / Baywin TV", "https://zbahistv65.com/", str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("intersportv", new SourceCredit("InterSporTV", "https://intersportv1.live/", str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("beyazelma", new SourceCredit("BeyazElma", "https://beyazelma78.com/", str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("betmatiktv", new SourceCredit("Betmatik TV", "https://betmatiktv155.com/", str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("netvgold", new SourceCredit("NETV Gold", null, str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("ntvstream", new SourceCredit("NTVStream", "https://www.ntvs.cx/channels", str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("daddylive", new SourceCredit("DaddyLive", "https://daddylive.pk/", str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("streameast", new SourceCredit("StreamEast", "https://streamea.st/", str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("hesgoal", new SourceCredit("Hesgoal", "https://hesgoal.ltd/", str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("livextv", new SourceCredit("LiveXTV", "https://livextv.pro/", str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("papazsports", new SourceCredit("PapazSports", "https://www.papazsports1022.pro/", str2, defaultConstructorMarker, r8, defaultConstructorMarker2)), TuplesKt.to("aslan", aslan)});
    }

    @NotNull
    public final SourceCredit getAslan() {
        return aslan;
    }

    @Nullable
    public final SourceCredit forTitle(@NotNull String title) {
        Object element$iv;
        Map.Entry it;
        String lowerCase = new Regex("\\p{M}+").replace(Normalizer.normalize(title, Normalizer.Form.NFD), "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String normalized = new Regex("[^a-z0-9]").replace(StringsKt.replace$default(lowerCase, (char) 305, 'i', false, 4, (Object) null), "");
        Iterable $this$firstOrNull$iv = sources.entrySet();
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it2.next();
            it = (Map.Entry) element$iv;
        } while (!StringsKt.startsWith$default(normalized, (String) it.getKey(), false, 2, (Object) null));
        Map.Entry entry = (Map.Entry) element$iv;
        if (entry != null) {
            return (SourceCredit) entry.getValue();
        }
        return null;
    }

    public final void open(@NotNull Context context, @NotNull SourceCredit credit) {
        String url = credit.getUrl();
        if (url == null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            SourceCredits sourceCredits = this;
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)).addFlags(268435456));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public final void showAslanThanks(@NotNull Context context) {
        new MaterialAlertDialogBuilder(context).setTitle("Teşekkürler, Aslan TV ♥").setMessage(aslan.getThanks()).setNegativeButton("Kapat", (DialogInterface.OnClickListener) null).show();
    }
}
