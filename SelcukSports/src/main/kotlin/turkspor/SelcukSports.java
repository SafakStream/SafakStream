package turkspor;

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
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import turkspor.common.ChannelGroups;
import turkspor.common.ChannelRules;
import turkspor.common.HlsQuality;

/* JADX INFO: compiled from: SelcukSports.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010$\u001a\u00020\t*\u00020%H\u0002J\f\u0010&\u001a\u00020'*\u00020%H\u0002J\u001e\u0010\"\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020'0 2\u0006\u0010/\u001a\u00020\tH\u0096@¢\u0006\u0002\u00100J\u0016\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\tH\u0082@¢\u0006\u0002\u00100J\u0016\u00103\u001a\u0002042\u0006\u00102\u001a\u00020\tH\u0096@¢\u0006\u0002\u00100JF\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\u001a2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;092\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020;09H\u0096@¢\u0006\u0002\u0010>R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001aX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006?"}, d2 = {"Lturkspor/SelcukSports;", "Lcom/lagradost/cloudstream3/MainAPI;", "domains", "Lturkspor/DomainResolver;", "artwork", "Lturkspor/ChannelArtwork;", "<init>", "(Lturkspor/DomainResolver;Lturkspor/ChannelArtwork;)V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "hasMainPage", "", "getHasMainPage", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "stableUrl", "Lturkspor/SportsChannel;", "result", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentChannel", "url", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSelcukSports.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelcukSports.kt\nturkspor/SelcukSports\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n1739#2:75\n1814#2,2:76\n1739#2:78\n1814#2,3:79\n1816#2:82\n777#2:83\n873#2,2:84\n1849#2,8:86\n1739#2:94\n1814#2,3:95\n777#2:98\n873#2,2:99\n296#2,2:101\n777#2:103\n873#2,2:104\n296#2,2:106\n2068#2,2:109\n1#3:108\n*S KotlinDebug\n*F\n+ 1 SelcukSports.kt\nturkspor/SelcukSports\n*L\n30#1:75\n30#1:76,2\n31#1:78\n31#1:79,3\n30#1:82\n37#1:83\n37#1:84,2\n39#1:86,8\n41#1:94\n41#1:95,3\n47#1:98\n47#1:99,2\n47#1:101,2\n48#1:103\n48#1:104,2\n48#1:106,2\n70#1:109,2\n*E\n"})
public final class SelcukSports extends MainAPI {

    @NotNull
    private final ChannelArtwork artwork;

    @NotNull
    private final DomainResolver domains;
    private final boolean hasDownloadSupport;

    @NotNull
    private String mainUrl = DomainResolver.GATEWAY;

    @NotNull
    private String name = "SelçukSports • SafakStream";

    @NotNull
    private String lang = "tr";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Live);
    private final boolean hasMainPage = true;

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("all", "Canlı Spor")});

    /* JADX INFO: renamed from: turkspor.SelcukSports$currentChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: SelcukSports.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.SelcukSports", f = "SelcukSports.kt", i = {0, 0, 0}, l = {46}, m = "currentChannel", n = {"url", "id", "title"}, nl = {47}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelcukSports.this.currentChannel(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.SelcukSports$getMainPage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SelcukSports.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.SelcukSports", f = "SelcukSports.kt", i = {0, 0, 1, 1, 2, 2, 2}, l = {27, 28, 29}, m = "getMainPage", n = {"request", "page", "request", "page", "request", "site", "page"}, nl = {28, 29, 30}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "L$1", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelcukSports.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.SelcukSports$load$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SelcukSports.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.SelcukSports", f = "SelcukSports.kt", i = {0, 1, 1, 1, 2, 2, 2}, l = {52, 54, 55}, m = "load", n = {"url", "url", "channel", "brand", "url", "channel", "brand"}, nl = {53, 55, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelcukSports.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.SelcukSports$loadLinks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SelcukSports.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.SelcukSports", f = "SelcukSports.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {61, 62, 67, 70}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "channel", "isCasting", "data", "subtitleCallback", "callback", "channel", "page", "stream", "playerOrigin", "isCasting", "data", "subtitleCallback", "callback", "channel", "page", "stream", "playerOrigin", "playlist", "isCasting"}, nl = {62, 63, 68, 76}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelcukSports.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.SelcukSports$search$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SelcukSports.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.SelcukSports", f = "SelcukSports.kt", i = {0, 1, 1, 2, 2, 2}, l = {35, 37, 40}, m = "search", n = {"query", "query", "term", "query", "term", "items"}, nl = {36, 75, 41}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelcukSports.this.search(null, (Continuation) this);
        }
    }

    public SelcukSports(@NotNull DomainResolver domains, @NotNull ChannelArtwork artwork) {
        this.domains = domains;
        this.artwork = artwork;
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
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    private final String stableUrl(SportsChannel $this$stableUrl) {
        return "https://www.selcuksportshd.is/turkspor?id=" + URLEncoder.encode($this$stableUrl.getId(), "UTF-8") + "&title=" + URLEncoder.encode($this$stableUrl.getTitle(), "UTF-8");
    }

    private final SearchResponse result(final SportsChannel $this$result) {
        return MainAPIKt.newLiveSearchResponse(this, ChannelBranding.INSTANCE.forChannel($this$result).getTitle(), stableUrl($this$result), TvType.Live, false, new Function1() { // from class: turkspor.SelcukSports$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return SelcukSports.result$lambda$0(this.f$0, $this$result, (LiveSearchResponse) obj);
            }
        });
    }

    static final Unit result$lambda$0(SelcukSports this$0, SportsChannel $this_result, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl(this$0.artwork.poster($this_result));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0086 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x00a2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:29:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:32:0x010a A[LOOP:1: B:30:0x0104->B:32:0x010a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00011 c00011;
        int page2;
        MainPageRequest request2;
        Object objResolve$default;
        SiteSnapshot site;
        ChannelArtwork channelArtwork;
        List<SportsChannel> channels;
        SiteSnapshot site2;
        int r12;
        Collection destination$iv$iv;
        Collection destination$iv$iv2;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = new C00011(continuation);
            }
        } else {
            c00011 = new C00011(continuation);
        }
        Object $result = c00011.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = false;
        switch (c00011.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ChannelRules channelRules = ChannelRules.INSTANCE;
                c00011.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00011.I$0 = page;
                c00011.label = 1;
                if (channelRules.refresh(c00011) == obj) {
                    return obj;
                }
                page2 = page;
                request2 = request;
                DomainResolver domainResolver = this.domains;
                c00011.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00011.I$0 = page2;
                c00011.label = 2;
                objResolve$default = DomainResolver.resolve$default(domainResolver, false, c00011, 1, null);
                if (objResolve$default == obj) {
                    return obj;
                }
                site = (SiteSnapshot) objResolve$default;
                channelArtwork = this.artwork;
                channels = site.getChannels();
                c00011.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00011.L$1 = site;
                c00011.I$0 = page2;
                c00011.label = 3;
                if (channelArtwork.prepare(channels, c00011) == obj) {
                    return obj;
                }
                site2 = site;
                Iterable $this$map$iv = ChannelGroups.INSTANCE.sections(site2.getChannels(), new Function1() { // from class: turkspor.SelcukSports$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        return ((SportsChannel) obj2).getTitle();
                    }
                });
                r12 = 10;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Pair pair = (Pair) item$iv$iv;
                    boolean z2 = z;
                    String category = (String) pair.component1();
                    Iterable items = (List) pair.component2();
                    Iterable $this$map$iv2 = items;
                    C00011 c00012 = c00011;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, r12));
                    for (Object item$iv$iv2 : $this$map$iv2) {
                        SportsChannel it = (SportsChannel) item$iv$iv2;
                        destination$iv$iv2.add(result(it));
                    }
                    destination$iv$iv.add(new HomePageList(category, (List) destination$iv$iv2, true));
                    z = z2;
                    c00011 = c00012;
                    r12 = 10;
                }
                return MainAPIKt.newHomePageResponse((List) destination$iv$iv, Boxing.boxBoolean(z));
            case 1:
                page2 = c00011.I$0;
                request2 = (MainPageRequest) c00011.L$0;
                ResultKt.throwOnFailure($result);
                DomainResolver domainResolver2 = this.domains;
                c00011.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00011.I$0 = page2;
                c00011.label = 2;
                objResolve$default = DomainResolver.resolve$default(domainResolver2, false, c00011, 1, null);
                if (objResolve$default == obj) {
                    return obj;
                }
                site = (SiteSnapshot) objResolve$default;
                channelArtwork = this.artwork;
                channels = site.getChannels();
                c00011.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00011.L$1 = site;
                c00011.I$0 = page2;
                c00011.label = 3;
                if (channelArtwork.prepare(channels, c00011) == obj) {
                    return obj;
                }
                site2 = site;
                Iterable $this$map$iv3 = ChannelGroups.INSTANCE.sections(site2.getChannels(), new Function1() { // from class: turkspor.SelcukSports$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        return ((SportsChannel) obj2).getTitle();
                    }
                });
                r12 = 10;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r15.hasNext()) {
                    Pair pair2 = (Pair) item$iv$iv;
                    boolean z3 = z;
                    String category2 = (String) pair2.component1();
                    Iterable items2 = (List) pair2.component2();
                    Iterable $this$map$iv4 = items2;
                    C00011 c00013 = c00011;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, r12));
                    while (r24.hasNext()) {
                        SportsChannel it2 = (SportsChannel) item$iv$iv2;
                        destination$iv$iv2.add(result(it2));
                    }
                    destination$iv$iv.add(new HomePageList(category2, (List) destination$iv$iv2, true));
                    z = z3;
                    c00011 = c00013;
                    r12 = 10;
                }
                return MainAPIKt.newHomePageResponse((List) destination$iv$iv, Boxing.boxBoolean(z));
            case 2:
                page2 = c00011.I$0;
                request2 = (MainPageRequest) c00011.L$0;
                ResultKt.throwOnFailure($result);
                objResolve$default = $result;
                site = (SiteSnapshot) objResolve$default;
                channelArtwork = this.artwork;
                channels = site.getChannels();
                c00011.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00011.L$1 = site;
                c00011.I$0 = page2;
                c00011.label = 3;
                if (channelArtwork.prepare(channels, c00011) == obj) {
                    return obj;
                }
                site2 = site;
                Iterable $this$map$iv5 = ChannelGroups.INSTANCE.sections(site2.getChannels(), new Function1() { // from class: turkspor.SelcukSports$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        return ((SportsChannel) obj2).getTitle();
                    }
                });
                r12 = 10;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                while (r15.hasNext()) {
                    Pair pair3 = (Pair) item$iv$iv;
                    boolean z4 = z;
                    String category3 = (String) pair3.component1();
                    Iterable items3 = (List) pair3.component2();
                    Iterable $this$map$iv6 = items3;
                    C00011 c00014 = c00011;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, r12));
                    while (r24.hasNext()) {
                        SportsChannel it3 = (SportsChannel) item$iv$iv2;
                        destination$iv$iv2.add(result(it3));
                    }
                    destination$iv$iv.add(new HomePageList(category3, (List) destination$iv$iv2, true));
                    z = z4;
                    c00011 = c00014;
                    r12 = 10;
                }
                return MainAPIKt.newHomePageResponse((List) destination$iv$iv, Boxing.boxBoolean(z));
            case 3:
                int r4 = c00011.I$0;
                site2 = (SiteSnapshot) c00011.L$1;
                ResultKt.throwOnFailure($result);
                Iterable $this$map$iv7 = ChannelGroups.INSTANCE.sections(site2.getChannels(), new Function1() { // from class: turkspor.SelcukSports$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        return ((SportsChannel) obj2).getTitle();
                    }
                });
                r12 = 10;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv7, 10));
                while (r15.hasNext()) {
                    Pair pair4 = (Pair) item$iv$iv;
                    boolean z5 = z;
                    String category4 = (String) pair4.component1();
                    Iterable items4 = (List) pair4.component2();
                    Iterable $this$map$iv8 = items4;
                    C00011 c00015 = c00011;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv8, r12));
                    while (r24.hasNext()) {
                        SportsChannel it4 = (SportsChannel) item$iv$iv2;
                        destination$iv$iv2.add(result(it4));
                    }
                    destination$iv$iv.add(new HomePageList(category4, (List) destination$iv$iv2, true));
                    z = z5;
                    c00011 = c00015;
                    r12 = 10;
                }
                return MainAPIKt.newHomePageResponse((List) destination$iv$iv, Boxing.boxBoolean(z));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0090 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0091  */
    /* JADX WARN: Code duplicated, block: B:26:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:28:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:35:0x013f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0171  */
    /* JADX WARN: Code duplicated, block: B:45:0x01a6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:50:0x01c8 A[LOOP:0: B:48:0x01c2->B:50:0x01c8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x00cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x016b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00041 c00041;
        String query2;
        String term;
        Object objResolve$default;
        String query3;
        String query4;
        Object obj;
        Collection destination$iv$iv;
        Iterable $this$filter$iv;
        int $i$f$filter;
        Collection destination$iv$iv2;
        HashSet set$iv;
        ArrayList list$iv;
        ArrayList items;
        ChannelArtwork channelArtwork;
        List items2;
        String term2;
        String lowerCase;
        Collection destination$iv$iv3;
        if (continuation instanceof C00041) {
            c00041 = (C00041) continuation;
            if ((c00041.label & Integer.MIN_VALUE) != 0) {
                c00041.label -= Integer.MIN_VALUE;
            } else {
                c00041 = new C00041(continuation);
            }
        } else {
            c00041 = new C00041(continuation);
        }
        Object $result = c00041.result;
        Object obj2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00041.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ChannelRules channelRules = ChannelRules.INSTANCE;
                c00041.L$0 = query;
                c00041.label = 1;
                if (channelRules.refresh(c00041) == obj2) {
                    return obj2;
                }
                query2 = query;
                term = query2.toLowerCase(Locale.forLanguageTag("tr"));
                Intrinsics.checkNotNullExpressionValue(term, "toLowerCase(...)");
                DomainResolver domainResolver = this.domains;
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00041.L$1 = term;
                c00041.label = 2;
                objResolve$default = DomainResolver.resolve$default(domainResolver, false, c00041, 1, null);
                if (objResolve$default == obj2) {
                    return obj2;
                }
                query3 = query2;
                query4 = term;
                obj = objResolve$default;
                Iterable $this$filter$iv2 = ((SiteSnapshot) obj).getChannels();
                destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv2) {
                    if (ChannelRules.INSTANCE.visible(((SportsChannel) element$iv$iv).getTitle())) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                $this$filter$iv = (List) destination$iv$iv;
                $i$f$filter = 0;
                destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv2 : $this$filter$iv) {
                    SportsChannel it = (SportsChannel) element$iv$iv2;
                    Object $result2 = $result;
                    term2 = query4;
                    lowerCase = (it.getTitle() + ' ' + ChannelBranding.INSTANCE.forChannel(it).getTitle()).toLowerCase(Locale.forLanguageTag("tr"));
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    Iterable $this$filter$iv3 = $this$filter$iv;
                    int $i$f$filter2 = $i$f$filter;
                    if (StringsKt.contains$default(lowerCase, term2, false, 2, (Object) null)) {
                        destination$iv$iv2.add(element$iv$iv2);
                    }
                    query4 = term2;
                    $result = $result2;
                    $this$filter$iv = $this$filter$iv3;
                    $i$f$filter = $i$f$filter2;
                }
                String term3 = query4;
                Iterable $this$distinctBy$iv = (List) destination$iv$iv2;
                set$iv = new HashSet();
                list$iv = new ArrayList();
                for (Object e$iv : $this$distinctBy$iv) {
                    if (set$iv.add(((SportsChannel) e$iv).getId())) {
                        list$iv.add(e$iv);
                    }
                }
                items = list$iv;
                channelArtwork = this.artwork;
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(query3);
                c00041.L$1 = SpillingKt.nullOutSpilledVariable(term3);
                c00041.L$2 = items;
                c00041.label = 3;
                if (channelArtwork.prepare(items, c00041) == obj2) {
                    return obj2;
                }
                items2 = items;
                List $this$map$iv = items2;
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    destination$iv$iv3.add(result((SportsChannel) item$iv$iv));
                }
                return (List) destination$iv$iv3;
            case 1:
                query2 = (String) c00041.L$0;
                ResultKt.throwOnFailure($result);
                term = query2.toLowerCase(Locale.forLanguageTag("tr"));
                Intrinsics.checkNotNullExpressionValue(term, "toLowerCase(...)");
                DomainResolver domainResolver2 = this.domains;
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00041.L$1 = term;
                c00041.label = 2;
                objResolve$default = DomainResolver.resolve$default(domainResolver2, false, c00041, 1, null);
                if (objResolve$default == obj2) {
                    return obj2;
                }
                query3 = query2;
                query4 = term;
                obj = objResolve$default;
                Iterable $this$filter$iv4 = ((SiteSnapshot) obj).getChannels();
                destination$iv$iv = new ArrayList();
                while (r17.hasNext()) {
                    if (ChannelRules.INSTANCE.visible(((SportsChannel) element$iv$iv).getTitle())) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                $this$filter$iv = (List) destination$iv$iv;
                $i$f$filter = 0;
                destination$iv$iv2 = new ArrayList();
                while (r14.hasNext()) {
                    SportsChannel it2 = (SportsChannel) element$iv$iv2;
                    Object $result3 = $result;
                    term2 = query4;
                    lowerCase = (it2.getTitle() + ' ' + ChannelBranding.INSTANCE.forChannel(it2).getTitle()).toLowerCase(Locale.forLanguageTag("tr"));
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    Iterable $this$filter$iv5 = $this$filter$iv;
                    int $i$f$filter3 = $i$f$filter;
                    if (StringsKt.contains$default(lowerCase, term2, false, 2, (Object) null)) {
                        destination$iv$iv2.add(element$iv$iv2);
                    }
                    query4 = term2;
                    $result = $result3;
                    $this$filter$iv = $this$filter$iv5;
                    $i$f$filter = $i$f$filter3;
                }
                String term4 = query4;
                Iterable $this$distinctBy$iv2 = (List) destination$iv$iv2;
                set$iv = new HashSet();
                list$iv = new ArrayList();
                while (r7.hasNext()) {
                    if (set$iv.add(((SportsChannel) e$iv).getId())) {
                        list$iv.add(e$iv);
                    }
                }
                items = list$iv;
                channelArtwork = this.artwork;
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(query3);
                c00041.L$1 = SpillingKt.nullOutSpilledVariable(term4);
                c00041.L$2 = items;
                c00041.label = 3;
                if (channelArtwork.prepare(items, c00041) == obj2) {
                    return obj2;
                }
                items2 = items;
                List $this$map$iv2 = items2;
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r10.hasNext()) {
                    destination$iv$iv3.add(result((SportsChannel) item$iv$iv));
                }
                return (List) destination$iv$iv3;
            case 2:
                query4 = (String) c00041.L$1;
                query3 = (String) c00041.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                Iterable $this$filter$iv6 = ((SiteSnapshot) obj).getChannels();
                destination$iv$iv = new ArrayList();
                while (r17.hasNext()) {
                    if (ChannelRules.INSTANCE.visible(((SportsChannel) element$iv$iv).getTitle())) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                $this$filter$iv = (List) destination$iv$iv;
                $i$f$filter = 0;
                destination$iv$iv2 = new ArrayList();
                while (r14.hasNext()) {
                    SportsChannel it3 = (SportsChannel) element$iv$iv2;
                    Object $result4 = $result;
                    term2 = query4;
                    lowerCase = (it3.getTitle() + ' ' + ChannelBranding.INSTANCE.forChannel(it3).getTitle()).toLowerCase(Locale.forLanguageTag("tr"));
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    Iterable $this$filter$iv7 = $this$filter$iv;
                    int $i$f$filter4 = $i$f$filter;
                    if (StringsKt.contains$default(lowerCase, term2, false, 2, (Object) null)) {
                        destination$iv$iv2.add(element$iv$iv2);
                    }
                    query4 = term2;
                    $result = $result4;
                    $this$filter$iv = $this$filter$iv7;
                    $i$f$filter = $i$f$filter4;
                }
                String term5 = query4;
                Iterable $this$distinctBy$iv3 = (List) destination$iv$iv2;
                set$iv = new HashSet();
                list$iv = new ArrayList();
                while (r7.hasNext()) {
                    if (set$iv.add(((SportsChannel) e$iv).getId())) {
                        list$iv.add(e$iv);
                    }
                }
                items = list$iv;
                channelArtwork = this.artwork;
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(query3);
                c00041.L$1 = SpillingKt.nullOutSpilledVariable(term5);
                c00041.L$2 = items;
                c00041.label = 3;
                if (channelArtwork.prepare(items, c00041) == obj2) {
                    return obj2;
                }
                items2 = items;
                List $this$map$iv3 = items2;
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r10.hasNext()) {
                    destination$iv$iv3.add(result((SportsChannel) item$iv$iv));
                }
                return (List) destination$iv$iv3;
            case 3:
                items2 = (List) c00041.L$2;
                ResultKt.throwOnFailure($result);
                List $this$map$iv4 = items2;
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                while (r10.hasNext()) {
                    destination$iv$iv3.add(result((SportsChannel) item$iv$iv));
                }
                return (List) destination$iv$iv3;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:40:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:45:0x0116  */
    /* JADX WARN: Code duplicated, block: B:50:0x0131  */
    /* JADX WARN: Code duplicated, block: B:57:0x014b  */
    /* JADX WARN: Code duplicated, block: B:59:0x0153  */
    /* JADX WARN: Code duplicated, block: B:73:0x0119 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x0144 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object currentChannel(String url, Continuation<? super SportsChannel> continuation) throws ErrorLoadingException {
        AnonymousClass1 anonymousClass1;
        String id;
        Object objResolve$default;
        String title;
        Object element$iv;
        SportsChannel sportsChannel;
        Collection destination$iv$iv;
        Iterator it;
        Object element$iv2;
        SportsChannel it2;
        ChannelRules channelRules;
        String url2;
        SportsChannel it3;
        String url3 = url;
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
                id = SportsParser.INSTANCE.queryParam(url3, "id");
                if (id == null) {
                    throw new ErrorLoadingException("Kanal kimliği eksik");
                }
                String title2 = SportsParser.INSTANCE.queryParam(url3, "title");
                DomainResolver domainResolver = this.domains;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                anonymousClass1.L$1 = id;
                anonymousClass1.L$2 = title2;
                anonymousClass1.label = 1;
                objResolve$default = DomainResolver.resolve$default(domainResolver, false, anonymousClass1, 1, null);
                if (objResolve$default == obj) {
                    return obj;
                }
                title = title2;
                break;
                break;
            case 1:
                title = (String) anonymousClass1.L$2;
                id = (String) anonymousClass1.L$1;
                url3 = (String) anonymousClass1.L$0;
                ResultKt.throwOnFailure($result);
                objResolve$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SiteSnapshot site = (SiteSnapshot) objResolve$default;
        Iterable $this$filter$iv = site.getChannels();
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            SportsChannel it4 = (SportsChannel) element$iv$iv;
            if (ChannelRules.INSTANCE.visible(it4.getTitle())) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        Iterable $this$firstOrNull$iv = (List) destination$iv$iv2;
        Iterator it5 = $this$firstOrNull$iv.iterator();
        do {
            if (it5.hasNext()) {
                element$iv = it5.next();
                it3 = (SportsChannel) element$iv;
            } else {
                element$iv = null;
            }
            sportsChannel = (SportsChannel) element$iv;
            if (sportsChannel == null) {
                Iterable $this$filter$iv2 = site.getChannels();
                destination$iv$iv = new ArrayList();
                for (Object element$iv$iv2 : $this$filter$iv2) {
                    SportsChannel it6 = (SportsChannel) element$iv$iv2;
                    channelRules = ChannelRules.INSTANCE;
                    String url4 = url3;
                    url2 = it6.getTitle();
                    if (channelRules.visible(url2)) {
                        destination$iv$iv.add(element$iv$iv2);
                    }
                    url3 = url4;
                }
                Iterable $this$firstOrNull$iv2 = (List) destination$iv$iv;
                it = $this$firstOrNull$iv2.iterator();
                do {
                    if (it.hasNext()) {
                        element$iv2 = it.next();
                        it2 = (SportsChannel) element$iv2;
                    } else {
                        element$iv2 = null;
                    }
                    sportsChannel = (SportsChannel) element$iv2;
                    if (sportsChannel == null) {
                        throw new ErrorLoadingException("Bu yayın güncel listede yok; ana sayfayı yenileyin.");
                    }
                } while (!Intrinsics.areEqual(it2.getId(), id));
                sportsChannel = (SportsChannel) element$iv2;
                if (sportsChannel == null) {
                    throw new ErrorLoadingException("Bu yayın güncel listede yok; ana sayfayı yenileyin.");
                }
            }
            return sportsChannel;
        } while (!(Intrinsics.areEqual(it3.getId(), id) && Intrinsics.areEqual(it3.getTitle(), title)));
        sportsChannel = (SportsChannel) element$iv;
        if (sportsChannel == null) {
            Iterable $this$filter$iv3 = site.getChannels();
            destination$iv$iv = new ArrayList();
            while (r13.hasNext()) {
                SportsChannel it7 = (SportsChannel) element$iv$iv2;
                channelRules = ChannelRules.INSTANCE;
                String url5 = url3;
                url2 = it7.getTitle();
                if (channelRules.visible(url2)) {
                    destination$iv$iv.add(element$iv$iv2);
                }
                url3 = url5;
            }
            Iterable $this$firstOrNull$iv3 = (List) destination$iv$iv;
            it = $this$firstOrNull$iv3.iterator();
            do {
                if (it.hasNext()) {
                    element$iv2 = it.next();
                    it2 = (SportsChannel) element$iv2;
                } else {
                    element$iv2 = null;
                }
                sportsChannel = (SportsChannel) element$iv2;
                if (sportsChannel == null) {
                    throw new ErrorLoadingException("Bu yayın güncel listede yok; ana sayfayı yenileyin.");
                }
            } while (!Intrinsics.areEqual(it2.getId(), id));
            sportsChannel = (SportsChannel) element$iv2;
            if (sportsChannel == null) {
                throw new ErrorLoadingException("Bu yayın güncel listede yok; ana sayfayı yenileyin.");
            }
        }
        return sportsChannel;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:20:0x008b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x008c  */
    /* JADX WARN: Code duplicated, block: B:24:0x00bd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x00be  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws ErrorLoadingException {
        C00021 c00021;
        Object objCurrentChannel;
        SportsChannel channel;
        ChannelBranding.Brand brand;
        ChannelArtwork channelArtwork;
        List<SportsChannel> listListOf;
        String url2;
        SportsChannel channel2;
        ChannelBranding.Brand brand2;
        Object objNewLiveStreamLoadResponse;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
            } else {
                c00021 = new C00021(continuation);
            }
        } else {
            c00021 = new C00021(continuation);
        }
        C00021 c00022 = c00021;
        Object $result = c00022.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00022.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00022.L$0 = url;
                c00022.label = 1;
                objCurrentChannel = currentChannel(url, c00022);
                if (objCurrentChannel == obj) {
                    return obj;
                }
                channel = (SportsChannel) objCurrentChannel;
                brand = ChannelBranding.INSTANCE.forChannel(channel);
                channelArtwork = this.artwork;
                listListOf = CollectionsKt.listOf(channel);
                c00022.L$0 = url;
                c00022.L$1 = channel;
                c00022.L$2 = brand;
                c00022.label = 2;
                if (channelArtwork.prepare(listListOf, c00022) == obj) {
                    return obj;
                }
                url2 = url;
                channel2 = channel;
                brand2 = brand;
                String title = brand2.getTitle();
                String strStableUrl = stableUrl(channel2);
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(channel2, null);
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(channel2);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(brand2);
                c00022.label = 3;
                objNewLiveStreamLoadResponse = MainAPIKt.newLiveStreamLoadResponse(this, title, url2, strStableUrl, anonymousClass2, c00022);
                if (objNewLiveStreamLoadResponse == obj) {
                    return obj;
                }
                return objNewLiveStreamLoadResponse;
            case 1:
                url = (String) c00022.L$0;
                ResultKt.throwOnFailure($result);
                objCurrentChannel = $result;
                channel = (SportsChannel) objCurrentChannel;
                brand = ChannelBranding.INSTANCE.forChannel(channel);
                channelArtwork = this.artwork;
                listListOf = CollectionsKt.listOf(channel);
                c00022.L$0 = url;
                c00022.L$1 = channel;
                c00022.L$2 = brand;
                c00022.label = 2;
                if (channelArtwork.prepare(listListOf, c00022) == obj) {
                    return obj;
                }
                url2 = url;
                channel2 = channel;
                brand2 = brand;
                String title2 = brand2.getTitle();
                String strStableUrl2 = stableUrl(channel2);
                AnonymousClass2 anonymousClass3 = new AnonymousClass2(channel2, null);
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(channel2);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(brand2);
                c00022.label = 3;
                objNewLiveStreamLoadResponse = MainAPIKt.newLiveStreamLoadResponse(this, title2, url2, strStableUrl2, anonymousClass3, c00022);
                if (objNewLiveStreamLoadResponse == obj) {
                    return obj;
                }
                return objNewLiveStreamLoadResponse;
            case 2:
                ChannelBranding.Brand brand3 = (ChannelBranding.Brand) c00022.L$2;
                SportsChannel channel3 = (SportsChannel) c00022.L$1;
                String url3 = (String) c00022.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url3;
                brand2 = brand3;
                channel2 = channel3;
                String title3 = brand2.getTitle();
                String strStableUrl3 = stableUrl(channel2);
                AnonymousClass2 anonymousClass4 = new AnonymousClass2(channel2, null);
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(channel2);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(brand2);
                c00022.label = 3;
                objNewLiveStreamLoadResponse = MainAPIKt.newLiveStreamLoadResponse(this, title3, url2, strStableUrl3, anonymousClass4, c00022);
                if (objNewLiveStreamLoadResponse == obj) {
                    return obj;
                }
                return objNewLiveStreamLoadResponse;
            case 3:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: turkspor.SelcukSports$load$2, reason: invalid class name */
    /* JADX INFO: compiled from: SelcukSports.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/LiveStreamLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.SelcukSports$load$2", f = "SelcukSports.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<LiveStreamLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ SportsChannel $channel;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SportsChannel sportsChannel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$channel = sportsChannel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = SelcukSports.this.new AnonymousClass2(this.$channel, continuation);
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
                    $this$newLiveStreamLoadResponse.setPosterUrl(SelcukSports.this.artwork.poster(this.$channel));
                    $this$newLiveStreamLoadResponse.setPlot(ChannelGroups.NOTICE);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:22:0x0164 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0165  */
    /* JADX WARN: Code duplicated, block: B:26:0x0175  */
    /* JADX WARN: Code duplicated, block: B:28:0x0185  */
    /* JADX WARN: Code duplicated, block: B:30:0x0210 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x0211  */
    /* JADX WARN: Code duplicated, block: B:34:0x0225  */
    /* JADX WARN: Code duplicated, block: B:43:0x02d8 A[LOOP:0: B:41:0x02d2->B:43:0x02d8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:48:0x030b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0313  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) throws ErrorLoadingException {
        C00031 c00031;
        Object objCurrentChannel;
        Function1<? super ExtractorLink, Unit> function3;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function4;
        String data2;
        SportsChannel channel;
        boolean isCasting3;
        Function1<? super ExtractorLink, Unit> function5;
        Object obj;
        int r1;
        Object obj2;
        Object obj3;
        Object obj4;
        SportsChannel channel2;
        boolean isCasting4;
        Function1<? super ExtractorLink, Unit> function6;
        NiceResponse page;
        String stream;
        String playerOrigin;
        Function1<? super ExtractorLink, Unit> function7;
        boolean isCasting5;
        SportsChannel channel3;
        Object obj5;
        Object obj6;
        Object obj7;
        String stream2;
        String playerOrigin2;
        NiceResponse page2;
        SportsChannel channel4;
        boolean isCasting6;
        Function1<? super ExtractorLink, Unit> function8;
        NiceResponse playlist;
        boolean z;
        Object objLinks;
        Function1<? super ExtractorLink, Unit> function9;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = new C00031(continuation);
            }
        } else {
            c00031 = new C00031(continuation);
        }
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object obj8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00032.L$2 = function2;
                c00032.Z$0 = isCasting;
                c00032.label = 1;
                objCurrentChannel = currentChannel(data, c00032);
                if (objCurrentChannel == obj8) {
                    return obj8;
                }
                function3 = function2;
                isCasting2 = isCasting;
                function4 = function1;
                data2 = data;
                channel = (SportsChannel) objCurrentChannel;
                Requests app = MainActivityKt.getApp();
                String player = channel.getPlayer();
                String currentUrl = this.domains.getCurrentUrl();
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("User-Agent", DomainResolver.UA));
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$2 = function3;
                c00032.L$3 = channel;
                c00032.Z$0 = isCasting2;
                c00032.label = 2;
                isCasting3 = isCasting2;
                function5 = function3;
                obj = "User-Agent";
                r1 = 200;
                obj2 = obj8;
                obj3 = DomainResolver.UA;
                obj4 = Requests.get$default(app, player, mapMapOf, currentUrl, (Map) null, (Map) null, false, 0, (TimeUnit) null, 15L, (Interceptor) null, false, (ResponseParser) null, c00032, 3832, (Object) null);
                c00032 = c00032;
                if (obj4 == obj2) {
                    return obj2;
                }
                channel2 = channel;
                isCasting4 = isCasting3;
                function6 = function5;
                page = (NiceResponse) obj4;
                if (page.getCode() != r1) {
                    throw new ErrorLoadingException("Oynatıcı yanıt vermedi (" + page.getCode() + ").");
                }
                stream = SportsParser.INSTANCE.streamUrl(page.getText(), page.getUrl());
                if (stream == null) {
                    throw new ErrorLoadingException("Oynatıcı yapısı değişmiş; eklenti güncellemesi gerekiyor.");
                }
                URI it = new URI(page.getUrl());
                playerOrigin = it.getScheme() + "://" + it.getAuthority() + '/';
                Requests app2 = MainActivityKt.getApp();
                Object obj9 = obj3;
                Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to(obj, obj9));
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$2 = function6;
                c00032.L$3 = channel2;
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(page);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(stream);
                c00032.L$6 = playerOrigin;
                c00032.Z$0 = isCasting4;
                c00032.label = 3;
                function7 = function6;
                isCasting5 = isCasting4;
                C00031 c00033 = c00032;
                channel3 = channel2;
                obj5 = obj9;
                obj6 = obj;
                obj7 = Requests.get$default(app2, stream, mapMapOf2, playerOrigin, (Map) null, (Map) null, false, 0, (TimeUnit) null, 15L, (Interceptor) null, false, (ResponseParser) null, c00033, 3832, (Object) null);
                c00032 = c00033;
                if (obj7 == obj2) {
                    return obj2;
                }
                stream2 = stream;
                playerOrigin2 = playerOrigin;
                page2 = page;
                channel4 = channel3;
                isCasting6 = isCasting5;
                function8 = function7;
                playlist = (NiceResponse) obj7;
                if (playlist.getCode() == r1 || !StringsKt.startsWith$default(StringsKt.trimStart(playlist.getText()).toString(), "#EXTM3U", false, 2, (Object) null)) {
                    throw new ErrorLoadingException("Yayın şu anda çevrimdışı veya erişilemiyor (" + playlist.getCode() + "). Maç saatinde veya WARP ile tekrar deneyin.");
                }
                HlsQuality hlsQuality = HlsQuality.INSTANCE;
                String name = getName();
                String title = ChannelBranding.INSTANCE.forChannel(channel4).getTitle();
                String url = playlist.getUrl();
                String text = playlist.getText();
                z = true;
                Map<String, String> mapMapOf3 = MapsKt.mapOf(new Pair[]{TuplesKt.to(obj6, obj5), TuplesKt.to("Origin", StringsKt.trimEnd(playerOrigin2, new char[]{'/'}))});
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$2 = function8;
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(channel4);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(page2);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(stream2);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(playerOrigin2);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(playlist);
                c00032.Z$0 = isCasting6;
                c00032.label = 4;
                objLinks = hlsQuality.links(name, title, url, text, playerOrigin2, mapMapOf3, c00032);
                if (objLinks == obj2) {
                    return obj2;
                }
                function9 = function8;
                Iterable $this$forEach$iv = (Iterable) objLinks;
                for (Object element$iv : $this$forEach$iv) {
                    function9.invoke(element$iv);
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00032.Z$0;
                function3 = (Function1) c00032.L$2;
                Function1<? super SubtitleFile, Unit> function10 = (Function1) c00032.L$1;
                String data3 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                function4 = function10;
                data2 = data3;
                objCurrentChannel = $result;
                channel = (SportsChannel) objCurrentChannel;
                Requests app3 = MainActivityKt.getApp();
                String player2 = channel.getPlayer();
                String currentUrl2 = this.domains.getCurrentUrl();
                Map mapMapOf4 = MapsKt.mapOf(TuplesKt.to("User-Agent", DomainResolver.UA));
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$2 = function3;
                c00032.L$3 = channel;
                c00032.Z$0 = isCasting2;
                c00032.label = 2;
                isCasting3 = isCasting2;
                function5 = function3;
                obj = "User-Agent";
                r1 = 200;
                obj2 = obj8;
                obj3 = DomainResolver.UA;
                obj4 = Requests.get$default(app3, player2, mapMapOf4, currentUrl2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 15L, (Interceptor) null, false, (ResponseParser) null, c00032, 3832, (Object) null);
                c00032 = c00032;
                if (obj4 == obj2) {
                    return obj2;
                }
                channel2 = channel;
                isCasting4 = isCasting3;
                function6 = function5;
                page = (NiceResponse) obj4;
                if (page.getCode() != r1) {
                    throw new ErrorLoadingException("Oynatıcı yanıt vermedi (" + page.getCode() + ").");
                }
                stream = SportsParser.INSTANCE.streamUrl(page.getText(), page.getUrl());
                if (stream == null) {
                    throw new ErrorLoadingException("Oynatıcı yapısı değişmiş; eklenti güncellemesi gerekiyor.");
                }
                URI it2 = new URI(page.getUrl());
                playerOrigin = it2.getScheme() + "://" + it2.getAuthority() + '/';
                Requests app4 = MainActivityKt.getApp();
                Object obj10 = obj3;
                Map mapMapOf5 = MapsKt.mapOf(TuplesKt.to(obj, obj10));
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$2 = function6;
                c00032.L$3 = channel2;
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(page);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(stream);
                c00032.L$6 = playerOrigin;
                c00032.Z$0 = isCasting4;
                c00032.label = 3;
                function7 = function6;
                isCasting5 = isCasting4;
                C00031 c00034 = c00032;
                channel3 = channel2;
                obj5 = obj10;
                obj6 = obj;
                obj7 = Requests.get$default(app4, stream, mapMapOf5, playerOrigin, (Map) null, (Map) null, false, 0, (TimeUnit) null, 15L, (Interceptor) null, false, (ResponseParser) null, c00034, 3832, (Object) null);
                c00032 = c00034;
                if (obj7 == obj2) {
                    return obj2;
                }
                stream2 = stream;
                playerOrigin2 = playerOrigin;
                page2 = page;
                channel4 = channel3;
                isCasting6 = isCasting5;
                function8 = function7;
                playlist = (NiceResponse) obj7;
                if (playlist.getCode() == r1) {
                    break;
                }
                throw new ErrorLoadingException("Yayın şu anda çevrimdışı veya erişilemiyor (" + playlist.getCode() + "). Maç saatinde veya WARP ile tekrar deneyin.");
            case 2:
                isCasting4 = c00032.Z$0;
                channel2 = (SportsChannel) c00032.L$3;
                function6 = (Function1) c00032.L$2;
                Function1<? super SubtitleFile, Unit> function11 = (Function1) c00032.L$1;
                String data4 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                obj2 = obj8;
                function4 = function11;
                obj3 = DomainResolver.UA;
                obj = "User-Agent";
                data2 = data4;
                r1 = 200;
                obj4 = $result;
                page = (NiceResponse) obj4;
                if (page.getCode() != r1) {
                    throw new ErrorLoadingException("Oynatıcı yanıt vermedi (" + page.getCode() + ").");
                }
                stream = SportsParser.INSTANCE.streamUrl(page.getText(), page.getUrl());
                if (stream == null) {
                    throw new ErrorLoadingException("Oynatıcı yapısı değişmiş; eklenti güncellemesi gerekiyor.");
                }
                URI it3 = new URI(page.getUrl());
                playerOrigin = it3.getScheme() + "://" + it3.getAuthority() + '/';
                Requests app5 = MainActivityKt.getApp();
                Object obj11 = obj3;
                Map mapMapOf6 = MapsKt.mapOf(TuplesKt.to(obj, obj11));
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$2 = function6;
                c00032.L$3 = channel2;
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(page);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(stream);
                c00032.L$6 = playerOrigin;
                c00032.Z$0 = isCasting4;
                c00032.label = 3;
                function7 = function6;
                isCasting5 = isCasting4;
                C00031 c00035 = c00032;
                channel3 = channel2;
                obj5 = obj11;
                obj6 = obj;
                obj7 = Requests.get$default(app5, stream, mapMapOf6, playerOrigin, (Map) null, (Map) null, false, 0, (TimeUnit) null, 15L, (Interceptor) null, false, (ResponseParser) null, c00035, 3832, (Object) null);
                c00032 = c00035;
                if (obj7 == obj2) {
                    return obj2;
                }
                stream2 = stream;
                playerOrigin2 = playerOrigin;
                page2 = page;
                channel4 = channel3;
                isCasting6 = isCasting5;
                function8 = function7;
                playlist = (NiceResponse) obj7;
                if (playlist.getCode() == r1) {
                    break;
                }
                throw new ErrorLoadingException("Yayın şu anda çevrimdışı veya erişilemiyor (" + playlist.getCode() + "). Maç saatinde veya WARP ile tekrar deneyin.");
            case 3:
                boolean isCasting7 = c00032.Z$0;
                String playerOrigin3 = (String) c00032.L$6;
                stream2 = (String) c00032.L$5;
                page2 = (NiceResponse) c00032.L$4;
                channel4 = (SportsChannel) c00032.L$3;
                Function1<? super ExtractorLink, Unit> function12 = (Function1) c00032.L$2;
                Function1<? super SubtitleFile, Unit> function13 = (Function1) c00032.L$1;
                String data5 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                obj2 = obj8;
                isCasting6 = isCasting7;
                function4 = function13;
                data2 = data5;
                obj5 = DomainResolver.UA;
                obj6 = "User-Agent";
                playerOrigin2 = playerOrigin3;
                r1 = 200;
                obj7 = $result;
                function8 = function12;
                playlist = (NiceResponse) obj7;
                if (playlist.getCode() == r1) {
                    break;
                }
                throw new ErrorLoadingException("Yayın şu anda çevrimdışı veya erişilemiyor (" + playlist.getCode() + "). Maç saatinde veya WARP ile tekrar deneyin.");
            case 4:
                boolean z2 = c00032.Z$0;
                function9 = (Function1) c00032.L$2;
                ResultKt.throwOnFailure($result);
                objLinks = $result;
                z = true;
                Iterable $this$forEach$iv2 = (Iterable) objLinks;
                while (r10.hasNext()) {
                    function9.invoke(element$iv);
                }
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
