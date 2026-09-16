package turkspor.common;

import android.content.SharedPreferences;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LiveSearchResponse;
import com.lagradost.cloudstream3.LiveStreamLoadResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.VPNStatus;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010/\u001a\u000200H\u0086@¢\u0006\u0002\u00101J\u0012\u00102\u001a\u0004\u0018\u00010\u00072\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020'0\"H\u0082@¢\u0006\u0002\u00101J\u0010\u00107\u001a\u0002082\u0006\u00103\u001a\u00020'H\u0002J\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00070\"J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013J\u0014\u0010;\u001a\u00020<2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013J\u001e\u0010$\u001a\u00020>2\u0006\u0010?\u001a\u0002002\u0006\u0010@\u001a\u00020AH\u0096@¢\u0006\u0002\u0010BJ\u001c\u0010C\u001a\b\u0012\u0004\u0012\u0002080\"2\u0006\u0010D\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010EJ\u0016\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010EJF\u0010I\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u00182\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020<0M2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020<0MH\u0096@¢\u0006\u0002\u0010QR\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0018X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020+@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006R"}, d2 = {"Lturkspor/common/NtvsProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "preferences", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "hasMainPage", "", "getHasMainPage", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "vpnStatus", "Lcom/lagradost/cloudstream3/VPNStatus;", "getVpnStatus", "()Lcom/lagradost/cloudstream3/VPNStatus;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "cache", "Lturkspor/common/WebEvent;", "countryFilter", "Lturkspor/common/CountryFilter;", "value", "", "checkedAt", "getCheckedAt", "()J", "refresh", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "route", "row", "Lorg/json/JSONObject;", "slug", "rows", "result", "Lcom/lagradost/cloudstream3/LiveSearchResponse;", "countries", "selectedCountries", "setCountries", "", "values", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAuthorizedSportsProviders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AuthorizedSportsProviders.kt\nturkspor/common/NtvsProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,403:1\n1849#2,8:404\n1739#2:413\n1814#2,3:414\n1665#2:417\n1691#2,3:418\n1694#2,3:428\n1739#2:434\n1814#2,3:435\n777#2:439\n873#2,2:440\n1739#2:442\n1814#2,3:443\n296#2,2:446\n1#3:412\n460#4,7:421\n129#5:431\n158#5,2:432\n160#5:438\n*S KotlinDebug\n*F\n+ 1 AuthorizedSportsProviders.kt\nturkspor/common/NtvsProvider\n*L\n277#1:404,8\n300#1:413\n300#1:414,3\n303#1:417\n303#1:418,3\n303#1:428,3\n303#1:434\n303#1:435,3\n304#1:439\n304#1:440,2\n304#1:442\n304#1:443,3\n305#1:446,2\n303#1:421,7\n303#1:431\n303#1:432,2\n303#1:438\n*E\n"})
public final class NtvsProvider extends MainAPI {
    private long checkedAt;

    @NotNull
    private final CountryFilter countryFilter;
    private final boolean hasDownloadSupport;

    @NotNull
    private String mainUrl = "https://www.ntvs.cx";

    @NotNull
    private String name = "NTVStream • TurkSpor";

    @NotNull
    private String lang = "tr";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Live);
    private final boolean hasMainPage = true;

    @NotNull
    private final VPNStatus vpnStatus = VPNStatus.MightBeNeeded;

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("all", "Spor Kanalları")});

    @NotNull
    private List<WebEvent> cache = CollectionsKt.emptyList();

    /* JADX INFO: renamed from: turkspor.common.NtvsProvider$getMainPage$1, reason: invalid class name */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.NtvsProvider", f = "AuthorizedSportsProviders.kt", i = {0, 0}, l = {303}, m = "getMainPage", n = {"request", "page"}, nl = {404}, s = {"L$0", "I$0"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NtvsProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.common.NtvsProvider$load$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.NtvsProvider", f = "AuthorizedSportsProviders.kt", i = {0, 1, 1}, l = {305, 305}, m = "load", n = {"url", "url", "row"}, nl = {404, -1}, s = {"L$0", "L$0", "L$1"}, v = 2)
    static final class C00221 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00221(Continuation<? super C00221> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NtvsProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.common.NtvsProvider$loadLinks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.NtvsProvider", f = "AuthorizedSportsProviders.kt", i = {0, 0, 0, 0}, l = {307}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting"}, nl = {-1}, s = {"L$0", "L$1", "L$2", "Z$0"}, v = 2)
    static final class C00231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00231(Continuation<? super C00231> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NtvsProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.common.NtvsProvider$refresh$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.NtvsProvider", f = "AuthorizedSportsProviders.kt", i = {0}, l = {262}, m = "refresh", n = {"terms"}, nl = {277}, s = {"L$0"}, v = 2)
    static final class C00241 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00241(Continuation<? super C00241> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NtvsProvider.this.refresh((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.common.NtvsProvider$rows$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.NtvsProvider", f = "AuthorizedSportsProviders.kt", i = {}, l = {298}, m = "rows", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00251 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00251(Continuation<? super C00251> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NtvsProvider.this.rows((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.common.NtvsProvider$search$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.NtvsProvider", f = "AuthorizedSportsProviders.kt", i = {0}, l = {304}, m = "search", n = {"query"}, nl = {404}, s = {"L$0"}, v = 2)
    static final class C00261 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00261(Continuation<? super C00261> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NtvsProvider.this.search(null, (Continuation) this);
        }
    }

    public NtvsProvider(@NotNull SharedPreferences preferences) {
        this.countryFilter = new CountryFilter(preferences, "ntvs_countries");
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    @NotNull
    public VPNStatus getVpnStatus() {
        return this.vpnStatus;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    public final long getCheckedAt() {
        return this.checkedAt;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object refresh(@NotNull Continuation<? super Integer> continuation) throws ErrorLoadingException {
        C00241 c00241;
        Object objSupervisorScope;
        if (continuation instanceof C00241) {
            c00241 = (C00241) continuation;
            if ((c00241.label & Integer.MIN_VALUE) != 0) {
                c00241.label -= Integer.MIN_VALUE;
            } else {
                c00241 = new C00241(continuation);
            }
        } else {
            c00241 = new C00241(continuation);
        }
        Object $result = c00241.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00241.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                List terms = CollectionsKt.listOf(new String[]{"sports", "bein", "espn", "eurosport", "football", "racing", "nba", "tennis"});
                NtvsProvider$refresh$rows$1 ntvsProvider$refresh$rows$1 = new NtvsProvider$refresh$rows$1(terms, this, null);
                c00241.L$0 = SpillingKt.nullOutSpilledVariable(terms);
                c00241.label = 1;
                objSupervisorScope = SupervisorKt.supervisorScope(ntvsProvider$refresh$rows$1, c00241);
                if (objSupervisorScope == obj) {
                    return obj;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objSupervisorScope = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable rows = (List) objSupervisorScope;
        Iterable $this$distinctBy$iv = rows;
        HashSet set$iv = new HashSet();
        ArrayList list$iv = new ArrayList();
        for (Object e$iv : $this$distinctBy$iv) {
            WebEvent it = (WebEvent) e$iv;
            if (set$iv.add(it.getUrl())) {
                list$iv.add(e$iv);
            }
        }
        this.cache = list$iv;
        if (this.cache.isEmpty()) {
            throw new ErrorLoadingException("NTVStream spor kataloğu alınamadı.");
        }
        this.checkedAt = System.currentTimeMillis();
        return Boxing.boxInt(this.cache.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String route(JSONObject row) {
        String str;
        String server = row.optString("server");
        String id = row.optString("channel_id");
        String name = row.optString("channel_name");
        String code = row.optString("channel_code");
        if (server != null) {
            switch (server.hashCode()) {
                case -1323467369:
                    if (server.equals("hesgoales")) {
                        String it = row.optString("channel_url");
                        str = StringsKt.startsWith$default(it, "https://", false, 2, (Object) null) ? it : null;
                        return str == null ? getMainUrl() + "/channel/falcon/" + slug(name) : str;
                    }
                    break;
                case -485164981:
                    if (server.equals("scorpion")) {
                        return getMainUrl() + "/channel/scorpion/" + URLEncoder.encode(name, "UTF-8");
                    }
                    break;
                case 3086212:
                    if (server.equals("dlhd")) {
                        String it2 = !StringsKt.isBlank(id) ? id : null;
                        if (it2 != null) {
                            return "https://dlive.sx/watch.php?id=" + it2;
                        }
                        return null;
                    }
                    break;
                case 636375705:
                    if (server.equals("cdnlive")) {
                        String it3 = row.optString("channel_url");
                        str = StringsKt.startsWith$default(it3, "https://", false, 2, (Object) null) ? it3 : null;
                        return str == null ? getMainUrl() + "/channel/titan/" + slug(name) + "?code=" + URLEncoder.encode(code, "UTF-8") : str;
                    }
                    break;
            }
        }
        String it4 = !StringsKt.isBlank(id) ? id : null;
        if (it4 != null) {
            return getMainUrl() + "/channel/phoenix/" + it4;
        }
        return null;
    }

    private final String slug(String value) {
        String lowerCase = value.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return StringsKt.trim(new Regex("[^a-z0-9]+").replace(lowerCase, "-"), new char[]{'-'});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object rows(Continuation<? super List<WebEvent>> continuation) {
        C00251 c00251;
        if (continuation instanceof C00251) {
            c00251 = (C00251) continuation;
            if ((c00251.label & Integer.MIN_VALUE) != 0) {
                c00251.label -= Integer.MIN_VALUE;
            } else {
                c00251 = new C00251(continuation);
            }
        } else {
            c00251 = new C00251(continuation);
        }
        Object $result = c00251.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00251.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.cache.isEmpty() || System.currentTimeMillis() - this.checkedAt > 180000) {
                    c00251.label = 1;
                    if (refresh(c00251) == obj) {
                        return obj;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return this.cache;
    }

    private final LiveSearchResponse result(final WebEvent row) {
        return MainAPIKt.newLiveSearchResponse(this, row.getTitle(), row.getUrl(), TvType.Live, false, new Function1() { // from class: turkspor.common.NtvsProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return NtvsProvider.result$lambda$0(row, (LiveSearchResponse) obj);
            }
        });
    }

    static final Unit result$lambda$0(WebEvent $row, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl($row.getPoster());
        return Unit.INSTANCE;
    }

    @NotNull
    public final List<String> countries() {
        Iterable $this$map$iv = this.cache;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            WebEvent it = (WebEvent) item$iv$iv;
            destination$iv$iv.add(it.getCategory());
        }
        return CollectionsKt.sorted(CollectionsKt.distinct((List) destination$iv$iv));
    }

    @NotNull
    public final Set<String> selectedCountries() {
        return this.countryFilter.selected();
    }

    public final void setCountries(@NotNull Set<String> values) {
        this.countryFilter.set(values);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        AnonymousClass1 anonymousClass1;
        CountryFilter countryFilter;
        Object objRows;
        Object answer$iv$iv$iv;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object $result = anonymousClass1.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                countryFilter = this.countryFilter;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(request);
                anonymousClass1.L$1 = countryFilter;
                anonymousClass1.I$0 = page;
                anonymousClass1.label = 1;
                objRows = rows(anonymousClass1);
                if (objRows == obj) {
                    return obj;
                }
                break;
                break;
            case 1:
                int r4 = anonymousClass1.I$0;
                countryFilter = (CountryFilter) anonymousClass1.L$1;
                ResultKt.throwOnFailure($result);
                objRows = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable $this$groupBy$iv = countryFilter.apply((List) objRows);
        Map $this$map$iv = new LinkedHashMap();
        for (Object element$iv$iv : $this$groupBy$iv) {
            WebEvent it = (WebEvent) element$iv$iv;
            String category = it.getCategory();
            Object value$iv$iv$iv = $this$map$iv.get(category);
            if (value$iv$iv$iv == null) {
                Object answer$iv$iv$iv2 = (List) new ArrayList();
                answer$iv$iv$iv = answer$iv$iv$iv2;
                $this$map$iv.put(category, answer$iv$iv$iv);
            } else {
                answer$iv$iv$iv = value$iv$iv$iv;
            }
            List list$iv$iv = (List) answer$iv$iv$iv;
            list$iv$iv.add(element$iv$iv);
        }
        int $i$f$map = 0;
        Collection destination$iv$iv = new ArrayList($this$map$iv.size());
        for (Map.Entry item$iv$iv : $this$map$iv.entrySet()) {
            String str = (String) item$iv$iv.getKey();
            Iterable $this$map$iv2 = (Iterable) item$iv$iv.getValue();
            int $i$f$map2 = $i$f$map;
            AnonymousClass1 anonymousClass2 = anonymousClass1;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            Iterable<WebEvent> $this$mapTo$iv$iv = $this$map$iv2;
            for (WebEvent p0 : $this$mapTo$iv$iv) {
                Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                destination$iv$iv2.add(result(p0));
                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
            }
            destination$iv$iv.add(new HomePageList(str, (List) destination$iv$iv2, true));
            $i$f$map = $i$f$map2;
            anonymousClass1 = anonymousClass2;
        }
        return MainAPIKt.newHomePageResponse((List) destination$iv$iv, Boxing.boxBoolean(false));
    }

    /* JADX INFO: renamed from: turkspor.common.NtvsProvider$load$2, reason: invalid class name */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/LiveStreamLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.NtvsProvider$load$2", f = "AuthorizedSportsProviders.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<LiveStreamLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ WebEvent $row;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(WebEvent webEvent, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$row = webEvent;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.$row, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        public final Object invoke(LiveStreamLoadResponse liveStreamLoadResponse, Continuation<? super Unit> continuation) {
            return create(liveStreamLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LiveStreamLoadResponse $this$newLiveStreamLoadResponse = (LiveStreamLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newLiveStreamLoadResponse.setPosterUrl(this.$row.getPoster());
                    $this$newLiveStreamLoadResponse.setPlot(ChannelGroups.NOTICE);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<LiveSearchResponse>> continuation) {
        C00261 c00261;
        Object objRows;
        String query2;
        if (continuation instanceof C00261) {
            c00261 = (C00261) continuation;
            if ((c00261.label & Integer.MIN_VALUE) != 0) {
                c00261.label -= Integer.MIN_VALUE;
            } else {
                c00261 = new C00261(continuation);
            }
        } else {
            c00261 = new C00261(continuation);
        }
        Object $result = c00261.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00261.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00261.L$0 = query;
                c00261.label = 1;
                objRows = rows(c00261);
                if (objRows == obj) {
                    return obj;
                }
                query2 = query;
                break;
                break;
            case 1:
                query2 = (String) c00261.L$0;
                ResultKt.throwOnFailure($result);
                objRows = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable $this$filter$iv = (Iterable) objRows;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            WebEvent it = (WebEvent) element$iv$iv;
            if (StringsKt.contains(it.getTitle(), query2, true)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            WebEvent p0 = (WebEvent) item$iv$iv;
            destination$iv$iv2.add(result(p0));
        }
        return (List) destination$iv$iv2;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0085  */
    /* JADX WARN: Code duplicated, block: B:28:0x0096  */
    /* JADX WARN: Code duplicated, block: B:31:0x00be A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00221 c00221;
        Object objRows;
        String url2;
        Object element$iv;
        WebEvent webEvent;
        Object objNewLiveStreamLoadResponse;
        WebEvent it;
        if (continuation instanceof C00221) {
            c00221 = (C00221) continuation;
            if ((c00221.label & Integer.MIN_VALUE) != 0) {
                c00221.label -= Integer.MIN_VALUE;
            } else {
                c00221 = new C00221(continuation);
            }
        } else {
            c00221 = new C00221(continuation);
        }
        C00221 c00222 = c00221;
        Object $result = c00222.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00222.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00222.L$0 = url;
                c00222.label = 1;
                objRows = rows(c00222);
                if (objRows == obj) {
                    return obj;
                }
                url2 = url;
                break;
            case 1:
                String url3 = (String) c00222.L$0;
                ResultKt.throwOnFailure($result);
                objRows = $result;
                url2 = url3;
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable $this$firstOrNull$iv = (Iterable) objRows;
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (it2.hasNext()) {
                element$iv = it2.next();
                it = (WebEvent) element$iv;
            } else {
                element$iv = null;
            }
            webEvent = (WebEvent) element$iv;
            if (webEvent == null) {
                webEvent = new WebEvent("Canlı yayın", url2, null, null, 12, null);
            }
            WebEvent row = webEvent;
            String title = row.getTitle();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(row, 0);
            c00222.L$0 = SpillingKt.nullOutSpilledVariable(url2);
            c00222.L$1 = SpillingKt.nullOutSpilledVariable(row);
            c00222.label = 2;
            objNewLiveStreamLoadResponse = MainAPIKt.newLiveStreamLoadResponse(this, title, url2, url2, anonymousClass2, c00222);
            if (objNewLiveStreamLoadResponse == obj) {
                return obj;
            }
            return objNewLiveStreamLoadResponse;
        } while (!Intrinsics.areEqual(it.getUrl(), url2));
        webEvent = (WebEvent) element$iv;
        if (webEvent == null) {
            webEvent = new WebEvent("Canlı yayın", url2, null, null, 12, null);
        }
        WebEvent row2 = webEvent;
        String title2 = row2.getTitle();
        AnonymousClass2 anonymousClass3 = new AnonymousClass2(row2, 0);
        c00222.L$0 = SpillingKt.nullOutSpilledVariable(url2);
        c00222.L$1 = SpillingKt.nullOutSpilledVariable(row2);
        c00222.label = 2;
        objNewLiveStreamLoadResponse = MainAPIKt.newLiveStreamLoadResponse(this, title2, url2, url2, anonymousClass3, c00222);
        if (objNewLiveStreamLoadResponse == obj) {
            return obj;
        }
        return objNewLiveStreamLoadResponse;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) throws ErrorLoadingException {
        C00231 c00231;
        Object objEmit;
        if (continuation instanceof C00231) {
            c00231 = (C00231) continuation;
            if ((c00231.label & Integer.MIN_VALUE) != 0) {
                c00231.label -= Integer.MIN_VALUE;
            } else {
                c00231 = new C00231(continuation);
            }
        } else {
            c00231 = new C00231(continuation);
        }
        C00231 c00232 = c00231;
        Object $result = c00232.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00232.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                EmbedResolver embedResolver = EmbedResolver.INSTANCE;
                String name = getName();
                String mainUrl = getMainUrl();
                c00232.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00232.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00232.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00232.Z$0 = isCasting;
                c00232.label = 1;
                objEmit = embedResolver.emit(name, data, mainUrl, function1, function2, c00232);
                if (objEmit == obj) {
                    return obj;
                }
                break;
            case 1:
                boolean isCasting2 = c00232.Z$0;
                ResultKt.throwOnFailure($result);
                objEmit = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean ok = ((Boolean) objEmit).booleanValue();
        if (ok) {
            return Boxing.boxBoolean(true);
        }
        throw new ErrorLoadingException("NTVStream oynatıcısı yanıt vermiyor.");
    }
}
