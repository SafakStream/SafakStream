package turkspor.common;

import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LiveSearchResponse;
import com.lagradost.cloudstream3.LiveStreamLoadResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.VPNStatus;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
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
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010-\u001a\u00020.H\u0086@¢\u0006\u0002\u0010/J\u001a\u00100\u001a\u0004\u0018\u00010\u00032\u0006\u00101\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0002J\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020'0\"H\u0082@¢\u0006\u0002\u0010/J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020'H\u0002J\u001e\u0010$\u001a\u0002062\u0006\u00107\u001a\u00020.2\u0006\u00108\u001a\u000209H\u0096@¢\u0006\u0002\u0010:J\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\"2\u0006\u0010=\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010>J\u0016\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010>JF\u0010B\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\u00182\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020H0F2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020H0FH\u0096@¢\u0006\u0002\u0010KR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0018X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020)@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006L"}, d2 = {"Lturkspor/common/EventSiteProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "name", "", "mainUrl", "kind", "Lturkspor/common/EventSiteKind;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lturkspor/common/EventSiteKind;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getMainUrl", "setMainUrl", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "hasMainPage", "", "getHasMainPage", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "vpnStatus", "Lcom/lagradost/cloudstream3/VPNStatus;", "getVpnStatus", "()Lcom/lagradost/cloudstream3/VPNStatus;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "cache", "Lturkspor/common/WebEvent;", "value", "", "checkedAt", "getCheckedAt", "()J", "refresh", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "absolute", "base", "rows", "result", "Lcom/lagradost/cloudstream3/LiveSearchResponse;", "row", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAuthorizedSportsProviders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AuthorizedSportsProviders.kt\nturkspor/common/EventSiteProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,403:1\n1544#2:404\n1633#2,2:405\n1795#2,10:408\n2068#2:418\n2069#2:420\n1805#2:421\n1635#2,3:422\n1849#2,8:425\n1665#2:433\n1691#2,3:434\n1694#2,3:444\n1739#2:450\n1814#2,3:451\n777#2:455\n873#2,2:456\n1739#2:458\n1814#2,3:459\n296#2,2:462\n1#3:407\n1#3:419\n460#4,7:437\n129#5:447\n158#5,2:448\n160#5:454\n*S KotlinDebug\n*F\n+ 1 AuthorizedSportsProviders.kt\nturkspor/common/EventSiteProvider\n*L\n169#1:404\n169#1:405,2\n171#1:408,10\n171#1:418\n171#1:420\n171#1:421\n169#1:422,3\n190#1:425,8\n201#1:433\n201#1:434,3\n201#1:444,3\n201#1:450\n201#1:451,3\n202#1:455\n202#1:456,2\n202#1:458\n202#1:459,3\n204#1:462,2\n171#1:419\n201#1:437,7\n201#1:447\n201#1:448,2\n201#1:454\n*E\n"})
public final class EventSiteProvider extends MainAPI {
    private long checkedAt;
    private final boolean hasDownloadSupport;

    @NotNull
    private final EventSiteKind kind;

    @NotNull
    private String mainUrl;

    @NotNull
    private String name;

    @NotNull
    private String lang = "tr";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Live);
    private final boolean hasMainPage = true;

    @NotNull
    private final VPNStatus vpnStatus = VPNStatus.MightBeNeeded;

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("all", "Canlı ve Yaklaşan")});

    @NotNull
    private List<WebEvent> cache = CollectionsKt.emptyList();

    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[EventSiteKind.values().length];
            try {
                r0[EventSiteKind.STREAMEAST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                r0[EventSiteKind.HESGOAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: turkspor.common.EventSiteProvider$getMainPage$1, reason: invalid class name */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.EventSiteProvider", f = "AuthorizedSportsProviders.kt", i = {0, 0}, l = {201}, m = "getMainPage", n = {"request", "page"}, nl = {404}, s = {"L$0", "I$0"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EventSiteProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.common.EventSiteProvider$load$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.EventSiteProvider", f = "AuthorizedSportsProviders.kt", i = {0, 1, 1}, l = {204, 205}, m = "load", n = {"url", "url", "row"}, nl = {404, -1}, s = {"L$0", "L$0", "L$1"}, v = 2)
    static final class C00111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00111(Continuation<? super C00111> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EventSiteProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.common.EventSiteProvider$loadLinks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.EventSiteProvider", f = "AuthorizedSportsProviders.kt", i = {0, 0, 0, 0}, l = {208}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting"}, nl = {209}, s = {"L$0", "L$1", "L$2", "Z$0"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EventSiteProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.common.EventSiteProvider$refresh$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.EventSiteProvider", f = "AuthorizedSportsProviders.kt", i = {}, l = {165}, m = "refresh", n = {}, nl = {166}, s = {}, v = 2)
    static final class C00131 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00131(Continuation<? super C00131> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EventSiteProvider.this.refresh((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.common.EventSiteProvider$rows$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.EventSiteProvider", f = "AuthorizedSportsProviders.kt", i = {}, l = {198}, m = "rows", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00141 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00141(Continuation<? super C00141> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EventSiteProvider.this.rows((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.common.EventSiteProvider$search$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.EventSiteProvider", f = "AuthorizedSportsProviders.kt", i = {0}, l = {202}, m = "search", n = {"query"}, nl = {404}, s = {"L$0"}, v = 2)
    static final class C00151 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00151(Continuation<? super C00151> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EventSiteProvider.this.search(null, (Continuation) this);
        }
    }

    public EventSiteProvider(@NotNull String name, @NotNull String mainUrl, @NotNull EventSiteKind kind) {
        this.name = name;
        this.mainUrl = mainUrl;
        this.kind = kind;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
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
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:70:0x0210  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:96:0x0214 A[SYNTHETIC] */
    @Nullable
    public final Object refresh(@NotNull Continuation<? super Integer> continuation) throws NoWhenBranchMatchedException, ErrorLoadingException {
        C00131 c00131;
        Iterable list;
        Element anchor;
        int $i$f$flatMap;
        WebEvent webEvent;
        String strText;
        if (continuation instanceof C00131) {
            c00131 = (C00131) continuation;
            if ((c00131.label & Integer.MIN_VALUE) != 0) {
                c00131.label -= Integer.MIN_VALUE;
            } else {
                c00131 = new C00131(continuation);
            }
        } else {
            c00131 = new C00131(continuation);
        }
        Object $result = c00131.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00131.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String mainUrl = getMainUrl();
                c00131.label = 1;
                $result = Requests.get$default(app, mainUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 22L, (Interceptor) null, false, (ResponseParser) null, c00131, 3838, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse response = (NiceResponse) $result;
        if (response.getCode() != 200) {
            throw new ErrorLoadingException("Kaynak yanıt vermiyor (" + response.getCode() + ").");
        }
        switch (WhenMappings.$EnumSwitchMapping$0[this.kind.ordinal()]) {
            case 1:
                Iterable $this$flatMap$iv = response.getDocument().select("section[data-m-sport]");
                int $i$f$flatMap2 = 0;
                Collection destination$iv$iv = new ArrayList();
                Iterable $this$flatMapTo$iv$iv = $this$flatMap$iv;
                int $i$f$flatMapTo = 0;
                for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                    Element section = (Element) element$iv$iv;
                    String strAttr = section.attr("data-m-sport-name");
                    if (StringsKt.isBlank(strAttr)) {
                        Element elementSelectFirst = section.selectFirst(".m-section__title");
                        if (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null) {
                            strText = "Canlı";
                        }
                        strAttr = strText;
                    }
                    String category = strAttr;
                    Iterable $this$mapNotNull$iv = section.select(".m-card");
                    Collection destination$iv$iv2 = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        Element card = (Element) element$iv$iv$iv;
                        NiceResponse response2 = response;
                        Iterable $this$flatMap$iv2 = $this$flatMap$iv;
                        if (Intrinsics.areEqual(card.tagName(), "a")) {
                            anchor = card;
                        } else {
                            anchor = card.selectFirst("a.m-card__link");
                            if (anchor == null) {
                                $i$f$flatMap = $i$f$flatMap2;
                                webEvent = null;
                            }
                            if (webEvent != null) {
                                destination$iv$iv2.add(webEvent);
                            }
                            response = response2;
                            $this$flatMap$iv = $this$flatMap$iv2;
                            $i$f$flatMap2 = $i$f$flatMap;
                            $this$flatMapTo$iv$iv = $this$flatMapTo$iv$iv;
                            $i$f$flatMapTo = $i$f$flatMapTo;
                        }
                        $i$f$flatMap = $i$f$flatMap2;
                        String url = absolute(response2.getUrl(), anchor.attr("href"));
                        if (url == null) {
                            webEvent = null;
                        } else {
                            String strAttr2 = anchor.attr("aria-label");
                            if (StringsKt.isBlank(strAttr2)) {
                                Element elementSelectFirst2 = card.selectFirst(".m-card__title");
                                String strText2 = elementSelectFirst2 != null ? elementSelectFirst2.text() : null;
                                if (strText2 == null) {
                                    strText2 = "";
                                }
                                String strJoinToString$default = strText2;
                                if (StringsKt.isBlank(strJoinToString$default)) {
                                    strJoinToString$default = CollectionsKt.joinToString$default(card.select(".m-card__name"), " vs ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: turkspor.common.EventSiteProvider$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj2) {
                                            return EventSiteProvider.refresh$lambda$0$1$0$0$0((Element) obj2);
                                        }
                                    }, 30, (Object) null);
                                }
                                strAttr2 = strJoinToString$default;
                            }
                            String title = strAttr2;
                            if (StringsKt.isBlank(title)) {
                                webEvent = null;
                            } else {
                                String url2 = response2.getUrl();
                                Element elementSelectFirst3 = card.selectFirst("img");
                                String strAttr3 = elementSelectFirst3 != null ? elementSelectFirst3.attr("src") : null;
                                if (strAttr3 == null) {
                                    strAttr3 = "";
                                }
                                webEvent = new WebEvent(title, url, category, absolute(url2, strAttr3));
                            }
                        }
                        if (webEvent != null) {
                            destination$iv$iv2.add(webEvent);
                        }
                        response = response2;
                        $this$flatMap$iv = $this$flatMap$iv2;
                        $i$f$flatMap2 = $i$f$flatMap;
                        $this$flatMapTo$iv$iv = $this$flatMapTo$iv$iv;
                        $i$f$flatMapTo = $i$f$flatMapTo;
                    }
                    Iterable list$iv$iv = (List) destination$iv$iv2;
                    CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
                }
                list = (List) destination$iv$iv;
                break;
            case 2:
                list = SequencesKt.toList(SequencesKt.mapNotNull(Regex.findAll$default(new Regex("country:\\s*(?:'([^']+)'|null)[\\s\\S]*?teams:\\s*'([^']+)'[\\s\\S]*?streams:\\s*\\[([\\s\\S]*?)]"), response.getText(), 0, 2, (Object) null), new Function1() { // from class: turkspor.common.EventSiteProvider$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj2) {
                        return EventSiteProvider.refresh$lambda$1((MatchResult) obj2);
                    }
                }));
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Iterable $this$distinctBy$iv = list;
        HashSet set$iv = new HashSet();
        ArrayList list$iv = new ArrayList();
        for (Object e$iv : $this$distinctBy$iv) {
            WebEvent it = (WebEvent) e$iv;
            if (set$iv.add(it.getUrl())) {
                list$iv.add(e$iv);
            }
        }
        ArrayList rows = list$iv;
        if (rows.isEmpty()) {
            throw new ErrorLoadingException("Güncel etkinlik listesi boş.");
        }
        this.cache = rows;
        this.checkedAt = System.currentTimeMillis();
        return Boxing.boxInt(rows.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence refresh$lambda$0$1$0$0$0(Element it) {
        return it.text();
    }

    static final WebEvent refresh$lambda$1(MatchResult match) {
        List groupValues;
        String stream;
        String it = null;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("url:\\s*'([^']+)'"), (CharSequence) match.getGroupValues().get(3), 0, 2, (Object) null);
        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (stream = (String) groupValues.get(1)) == null) {
            return null;
        }
        String fixed = new Regex("https://fawa-news\\.(?:com|sbs)/").replace(stream, "https://fawa-news.sbs/");
        String flag = StringsKt.substringBefore$default((String) match.getGroupValues().get(1), '-', (String) null, 2, (Object) null);
        if (!new Regex("[a-z]{2}").matches(flag)) {
            flag = null;
        }
        String str = (String) match.getGroupValues().get(2);
        if (flag != null) {
            String it2 = flag;
            it = "https://flagcdn.com/w640/" + it2 + ".png";
        }
        return new WebEvent(str, fixed, "Maçlar", it);
    }

    private final String absolute(String base, String value) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            EventSiteProvider eventSiteProvider = this;
            obj = Result.constructor-impl(new URI(base).resolve(value).toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String it = (String) obj;
        if (it == null || !StringsKt.startsWith$default(it, "https://", false, 2, (Object) null)) {
            return null;
        }
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object rows(Continuation<? super List<WebEvent>> continuation) {
        C00141 c00141;
        if (continuation instanceof C00141) {
            c00141 = (C00141) continuation;
            if ((c00141.label & Integer.MIN_VALUE) != 0) {
                c00141.label -= Integer.MIN_VALUE;
            } else {
                c00141 = new C00141(continuation);
            }
        } else {
            c00141 = new C00141(continuation);
        }
        Object $result = c00141.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00141.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.cache.isEmpty() || System.currentTimeMillis() - this.checkedAt > 120000) {
                    c00141.label = 1;
                    if (refresh(c00141) == obj) {
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
        return MainAPIKt.newLiveSearchResponse(this, row.getTitle(), row.getUrl(), TvType.Live, false, new Function1() { // from class: turkspor.common.EventSiteProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return EventSiteProvider.result$lambda$0(row, (LiveSearchResponse) obj);
            }
        });
    }

    static final Unit result$lambda$0(WebEvent $row, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl($row.getPoster());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        AnonymousClass1 anonymousClass1;
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
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(request);
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
                ResultKt.throwOnFailure($result);
                objRows = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable $this$groupBy$iv = (Iterable) objRows;
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

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00151 c00151;
        Object objRows;
        String query2;
        if (continuation instanceof C00151) {
            c00151 = (C00151) continuation;
            if ((c00151.label & Integer.MIN_VALUE) != 0) {
                c00151.label -= Integer.MIN_VALUE;
            } else {
                c00151 = new C00151(continuation);
            }
        } else {
            c00151 = new C00151(continuation);
        }
        Object $result = c00151.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00151.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00151.L$0 = query;
                c00151.label = 1;
                objRows = rows(c00151);
                if (objRows == obj) {
                    return obj;
                }
                query2 = query;
                break;
                break;
            case 1:
                query2 = (String) c00151.L$0;
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
        C00111 c00111;
        Object objRows;
        String url2;
        Object element$iv;
        WebEvent webEvent;
        Object objNewLiveStreamLoadResponse;
        WebEvent it;
        if (continuation instanceof C00111) {
            c00111 = (C00111) continuation;
            if ((c00111.label & Integer.MIN_VALUE) != 0) {
                c00111.label -= Integer.MIN_VALUE;
            } else {
                c00111 = new C00111(continuation);
            }
        } else {
            c00111 = new C00111(continuation);
        }
        C00111 c00112 = c00111;
        Object $result = c00112.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00112.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00112.L$0 = url;
                c00112.label = 1;
                objRows = rows(c00112);
                if (objRows == obj) {
                    return obj;
                }
                url2 = url;
                break;
            case 1:
                String url3 = (String) c00112.L$0;
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
            c00112.L$0 = SpillingKt.nullOutSpilledVariable(url2);
            c00112.L$1 = SpillingKt.nullOutSpilledVariable(row);
            c00112.label = 2;
            objNewLiveStreamLoadResponse = MainAPIKt.newLiveStreamLoadResponse(this, title, url2, url2, anonymousClass2, c00112);
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
        c00112.L$0 = SpillingKt.nullOutSpilledVariable(url2);
        c00112.L$1 = SpillingKt.nullOutSpilledVariable(row2);
        c00112.label = 2;
        objNewLiveStreamLoadResponse = MainAPIKt.newLiveStreamLoadResponse(this, title2, url2, url2, anonymousClass3, c00112);
        if (objNewLiveStreamLoadResponse == obj) {
            return obj;
        }
        return objNewLiveStreamLoadResponse;
    }

    /* JADX INFO: renamed from: turkspor.common.EventSiteProvider$load$2, reason: invalid class name */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/LiveStreamLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.EventSiteProvider$load$2", f = "AuthorizedSportsProviders.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) throws ErrorLoadingException {
        C00121 c00121;
        Object objEmit;
        if (continuation instanceof C00121) {
            c00121 = (C00121) continuation;
            if ((c00121.label & Integer.MIN_VALUE) != 0) {
                c00121.label -= Integer.MIN_VALUE;
            } else {
                c00121 = new C00121(continuation);
            }
        } else {
            c00121 = new C00121(continuation);
        }
        C00121 c00122 = c00121;
        Object $result = c00122.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00122.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                EmbedResolver embedResolver = EmbedResolver.INSTANCE;
                String name = getName();
                String mainUrl = getMainUrl();
                c00122.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00122.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00122.Z$0 = isCasting;
                c00122.label = 1;
                objEmit = embedResolver.emit(name, data, mainUrl, function1, function2, c00122);
                if (objEmit == obj) {
                    return obj;
                }
                break;
            case 1:
                boolean isCasting2 = c00122.Z$0;
                ResultKt.throwOnFailure($result);
                objEmit = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean ok = ((Boolean) objEmit).booleanValue();
        if (!ok) {
            throw new ErrorLoadingException("Yayın henüz başlamadı veya oynatıcı yanıt vermiyor.");
        }
        return Boxing.boxBoolean(true);
    }
}
