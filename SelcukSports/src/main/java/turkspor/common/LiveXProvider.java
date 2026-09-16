package turkspor.common;

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
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.VPNStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
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
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0002J\u000e\u00102\u001a\u000203H\u0086@¢\u0006\u0002\u00104J\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020&0 H\u0082@¢\u0006\u0002\u00104J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u00020&H\u0002J\u001e\u0010\"\u001a\u0002092\u0006\u0010:\u001a\u0002032\u0006\u0010,\u001a\u00020;H\u0096@¢\u0006\u0002\u0010<J\u001c\u0010=\u001a\b\u0012\u0004\u0012\u0002070 2\u0006\u0010>\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010.J\u0016\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010.JF\u0010B\u001a\u00020\u00162\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u00162\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020H0F2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020H0FH\u0096@¢\u0006\u0002\u0010KR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020(@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006L"}, d2 = {"Lturkspor/common/LiveXProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "hasMainPage", "", "getHasMainPage", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "vpnStatus", "Lcom/lagradost/cloudstream3/VPNStatus;", "getVpnStatus", "()Lcom/lagradost/cloudstream3/VPNStatus;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "apis", "cache", "Lorg/json/JSONObject;", "value", "", "checkedAt", "getCheckedAt", "()J", "request", "path", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "array", "Lorg/json/JSONArray;", "text", "refresh", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rows", "result", "Lcom/lagradost/cloudstream3/LiveSearchResponse;", "row", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "query", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAuthorizedSportsProviders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AuthorizedSportsProviders.kt\nturkspor/common/LiveXProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,403:1\n1795#2,10:404\n2068#2:414\n2069#2:416\n1805#2:417\n777#2:418\n873#2,2:419\n1665#2:421\n1691#2,3:422\n1694#2,3:432\n1739#2:438\n1814#2,3:439\n777#2:443\n873#2,2:444\n1739#2:446\n1814#2,3:447\n296#2,2:450\n296#2,2:452\n1#3:415\n1#3:454\n460#4,7:425\n129#5:435\n158#5,2:436\n160#5:442\n*S KotlinDebug\n*F\n+ 1 AuthorizedSportsProviders.kt\nturkspor/common/LiveXProvider\n*L\n388#1:404,10\n388#1:414\n388#1:416\n388#1:417\n388#1:418\n388#1:419,2\n391#1:421\n391#1:422,3\n391#1:432,3\n391#1:438\n391#1:439,3\n392#1:443\n392#1:444,2\n392#1:446\n392#1:447,3\n393#1:450,2\n395#1:452,2\n388#1:415\n391#1:425,7\n391#1:435\n391#1:436,2\n391#1:442\n*E\n"})
public final class LiveXProvider extends MainAPI {
    private long checkedAt;
    private final boolean hasDownloadSupport;

    @NotNull
    private String mainUrl = "https://livextv.pro";

    @NotNull
    private String name = "LiveXTV • TurkSpor";

    @NotNull
    private String lang = "tr";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Live);
    private final boolean hasMainPage = true;

    @NotNull
    private final VPNStatus vpnStatus = VPNStatus.MightBeNeeded;

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("all", "Canlı")});

    @NotNull
    private final List<String> apis = CollectionsKt.listOf(new String[]{"https://livextv-backend.onrender.com/api", "https://streamed.pk/api"});

    @NotNull
    private List<? extends JSONObject> cache = CollectionsKt.emptyList();

    /* JADX INFO: renamed from: turkspor.common.LiveXProvider$getMainPage$1, reason: invalid class name */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.LiveXProvider", f = "AuthorizedSportsProviders.kt", i = {0, 0}, l = {391}, m = "getMainPage", n = {"request", "page"}, nl = {404}, s = {"L$0", "I$0"}, v = 2)
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
            return LiveXProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.common.LiveXProvider$load$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.LiveXProvider", f = "AuthorizedSportsProviders.kt", i = {0, 0, 1, 1, 1}, l = {393, 393}, m = "load", n = {"url", "id", "url", "id", "row"}, nl = {404, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00161(Continuation<? super C00161> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveXProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.common.LiveXProvider$loadLinks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.LiveXProvider", f = "AuthorizedSportsProviders.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {395, 397, 398}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "id", "isCasting", "data", "subtitleCallback", "callback", "id", "row", "sources", "source", "type", "sid", "$this$loadLinks_u24lambda_u241", "isCasting", "found", "i", "data", "subtitleCallback", "callback", "id", "row", "sources", "source", "type", "sid", "streams", "embed", "isCasting", "found", "i", "j"}, nl = {404, 397, 396}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "I$0", "I$1", "I$3"}, v = 2)
    static final class C00171 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00171(Continuation<? super C00171> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveXProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.common.LiveXProvider$refresh$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.LiveXProvider", f = "AuthorizedSportsProviders.kt", i = {}, l = {388}, m = "refresh", n = {}, nl = {404}, s = {}, v = 2)
    static final class C00181 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00181(Continuation<? super C00181> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveXProvider.this.refresh((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.common.LiveXProvider$request$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.LiveXProvider", f = "AuthorizedSportsProviders.kt", i = {0, 0}, l = {384}, m = "request", n = {"path", "api"}, nl = {385}, s = {"L$0", "L$2"}, v = 2)
    static final class C00191 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00191(Continuation<? super C00191> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveXProvider.this.request(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.common.LiveXProvider$rows$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.LiveXProvider", f = "AuthorizedSportsProviders.kt", i = {}, l = {389}, m = "rows", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00201 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00201(Continuation<? super C00201> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveXProvider.this.rows((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.common.LiveXProvider$search$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.LiveXProvider", f = "AuthorizedSportsProviders.kt", i = {0}, l = {392}, m = "search", n = {"query"}, nl = {404}, s = {"L$0"}, v = 2)
    static final class C00211 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00211(Continuation<? super C00211> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveXProvider.this.search(null, (Continuation) this);
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:22:0x0079  */
    /* JADX WARN: Code duplicated, block: B:29:0x00da A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x00db  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ea A[Catch: Exception -> 0x00f6, CancellationException -> 0x00fc, TRY_LEAVE, TryCatch #8 {CancellationException -> 0x00fc, Exception -> 0x00f6, blocks: (B:31:0x00e0, B:33:0x00ea), top: B:60:0x00e0 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00db -> B:60:0x00e0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0102 -> B:50:0x012f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0110 -> B:50:0x012f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0126 -> B:50:0x012f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object request(java.lang.String r26, kotlin.coroutines.Continuation<? super java.lang.String> r27) throws com.lagradost.cloudstream3.ErrorLoadingException {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: turkspor.common.LiveXProvider.request(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final JSONArray array(String text) {
        String clean = StringsKt.trim(text).toString();
        if (StringsKt.startsWith$default(clean, "[", false, 2, (Object) null)) {
            return new JSONArray(clean);
        }
        JSONArray jSONArrayOptJSONArray = new JSONObject(clean).optJSONArray("data");
        return jSONArrayOptJSONArray == null ? new JSONArray() : jSONArrayOptJSONArray;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object refresh(@NotNull Continuation<? super Integer> continuation) throws ErrorLoadingException {
        C00181 c00181;
        Object objRequest;
        LiveXProvider liveXProvider;
        if (continuation instanceof C00181) {
            c00181 = (C00181) continuation;
            if ((c00181.label & Integer.MIN_VALUE) != 0) {
                c00181.label -= Integer.MIN_VALUE;
            } else {
                c00181 = new C00181(continuation);
            }
        } else {
            c00181 = new C00181(continuation);
        }
        Object $result = c00181.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00181.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00181.L$0 = this;
                c00181.label = 1;
                objRequest = request("/matches/live", c00181);
                if (objRequest == obj) {
                    return obj;
                }
                liveXProvider = this;
                break;
                break;
            case 1:
                liveXProvider = (LiveXProvider) c00181.L$0;
                ResultKt.throwOnFailure($result);
                objRequest = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        JSONArray a = liveXProvider.array((String) objRequest);
        Iterable $this$mapNotNull$iv = RangesKt.until(0, a.length());
        Collection destination$iv$iv = new ArrayList();
        IntIterator it = $this$mapNotNull$iv.iterator();
        while (it.hasNext()) {
            int element$iv$iv$iv = it.nextInt();
            JSONObject jSONObjectOptJSONObject = a.optJSONObject(element$iv$iv$iv);
            if (jSONObjectOptJSONObject != null) {
                destination$iv$iv.add(jSONObjectOptJSONObject);
            }
        }
        Iterable $this$filter$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            JSONObject it2 = (JSONObject) element$iv$iv;
            JSONArray jSONArrayOptJSONArray = it2.optJSONArray("sources");
            if ((jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.length() : 0) > 0) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        this.cache = (List) destination$iv$iv2;
        if (this.cache.isEmpty()) {
            throw new ErrorLoadingException("LiveXTV canlı listesi boş.");
        }
        this.checkedAt = System.currentTimeMillis();
        return Boxing.boxInt(this.cache.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object rows(Continuation<? super List<? extends JSONObject>> continuation) {
        C00201 c00201;
        if (continuation instanceof C00201) {
            c00201 = (C00201) continuation;
            if ((c00201.label & Integer.MIN_VALUE) != 0) {
                c00201.label -= Integer.MIN_VALUE;
            } else {
                c00201 = new C00201(continuation);
            }
        } else {
            c00201 = new C00201(continuation);
        }
        Object $result = c00201.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00201.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.cache.isEmpty() || System.currentTimeMillis() - this.checkedAt > 60000) {
                    c00201.label = 1;
                    if (refresh(c00201) == obj) {
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

    private final LiveSearchResponse result(JSONObject row) {
        String id = row.optString("id");
        final String poster = row.optString("poster");
        return MainAPIKt.newLiveSearchResponse(this, row.optString("title", "Canlı yayın"), getMainUrl() + "/watch/" + id, TvType.Live, false, new Function1() { // from class: turkspor.common.LiveXProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return LiveXProvider.result$lambda$0(poster, (LiveSearchResponse) obj);
            }
        });
    }

    static final Unit result$lambda$0(String $poster, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl(StringsKt.startsWith$default($poster, "/", false, 2, (Object) null) ? "https://streamed.pk" + $poster : $poster);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        AnonymousClass1 anonymousClass1;
        Object objRows;
        Object key$iv$iv;
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
            JSONObject it = (JSONObject) element$iv$iv;
            String strOptString = it.optString("category", "Diğer");
            Object value$iv$iv$iv = $this$map$iv.get(strOptString);
            if (value$iv$iv$iv == null) {
                Object answer$iv$iv$iv = (List) new ArrayList();
                key$iv$iv = answer$iv$iv$iv;
                $this$map$iv.put(strOptString, key$iv$iv);
            } else {
                key$iv$iv = value$iv$iv$iv;
            }
            List list$iv$iv = (List) key$iv$iv;
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
            Iterable<JSONObject> $this$mapTo$iv$iv = $this$map$iv2;
            for (JSONObject p0 : $this$mapTo$iv$iv) {
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

    /* JADX INFO: renamed from: turkspor.common.LiveXProvider$load$2, reason: invalid class name */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/LiveStreamLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.LiveXProvider$load$2", f = "AuthorizedSportsProviders.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<LiveStreamLoadResponse, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = new AnonymousClass2(continuation);
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
        C00211 c00211;
        Object objRows;
        String query2;
        if (continuation instanceof C00211) {
            c00211 = (C00211) continuation;
            if ((c00211.label & Integer.MIN_VALUE) != 0) {
                c00211.label -= Integer.MIN_VALUE;
            } else {
                c00211 = new C00211(continuation);
            }
        } else {
            c00211 = new C00211(continuation);
        }
        Object $result = c00211.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00211.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00211.L$0 = query;
                c00211.label = 1;
                objRows = rows(c00211);
                if (objRows == obj) {
                    return obj;
                }
                query2 = query;
                break;
                break;
            case 1:
                query2 = (String) c00211.L$0;
                ResultKt.throwOnFailure($result);
                objRows = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable $this$filter$iv = (Iterable) objRows;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            JSONObject it = (JSONObject) element$iv$iv;
            if (StringsKt.contains(it.optString("title"), query2, true)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            JSONObject p0 = (JSONObject) item$iv$iv;
            destination$iv$iv2.add(result(p0));
        }
        return (List) destination$iv$iv2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:26:0x0091  */
    /* JADX WARN: Code duplicated, block: B:28:0x00be A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:31:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws ErrorLoadingException {
        C00161 c00161;
        String id;
        Object objRows;
        Object element$iv;
        JSONObject row;
        Object objNewLiveStreamLoadResponse;
        JSONObject it;
        if (continuation instanceof C00161) {
            c00161 = (C00161) continuation;
            if ((c00161.label & Integer.MIN_VALUE) != 0) {
                c00161.label -= Integer.MIN_VALUE;
            } else {
                c00161 = new C00161(continuation);
            }
        } else {
            c00161 = new C00161(continuation);
        }
        C00161 c00162 = c00161;
        Object $result = c00162.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00162.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                id = StringsKt.substringAfterLast$default(url, '/', (String) null, 2, (Object) null);
                c00162.L$0 = url;
                c00162.L$1 = id;
                c00162.label = 1;
                objRows = rows(c00162);
                if (objRows == obj) {
                    return obj;
                }
                break;
            case 1:
                id = (String) c00162.L$1;
                url = (String) c00162.L$0;
                ResultKt.throwOnFailure($result);
                objRows = $result;
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String id2 = id;
        Iterable $this$firstOrNull$iv = (Iterable) objRows;
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (it2.hasNext()) {
                element$iv = it2.next();
                it = (JSONObject) element$iv;
            } else {
                element$iv = null;
            }
            row = (JSONObject) element$iv;
            if (row != null) {
                throw new ErrorLoadingException("Etkinlik bulunamadı.");
            }
            String strOptString = row.optString("title");
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(null);
            c00162.L$0 = SpillingKt.nullOutSpilledVariable(url);
            c00162.L$1 = SpillingKt.nullOutSpilledVariable(id2);
            c00162.L$2 = SpillingKt.nullOutSpilledVariable(row);
            c00162.label = 2;
            objNewLiveStreamLoadResponse = MainAPIKt.newLiveStreamLoadResponse(this, strOptString, url, url, anonymousClass2, c00162);
            if (objNewLiveStreamLoadResponse == obj) {
                return obj;
            }
            return objNewLiveStreamLoadResponse;
        } while (!Intrinsics.areEqual(it.optString("id"), id2));
        row = (JSONObject) element$iv;
        if (row != null) {
            throw new ErrorLoadingException("Etkinlik bulunamadı.");
        }
        String strOptString2 = row.optString("title");
        AnonymousClass2 anonymousClass3 = new AnonymousClass2(null);
        c00162.L$0 = SpillingKt.nullOutSpilledVariable(url);
        c00162.L$1 = SpillingKt.nullOutSpilledVariable(id2);
        c00162.L$2 = SpillingKt.nullOutSpilledVariable(row);
        c00162.label = 2;
        objNewLiveStreamLoadResponse = MainAPIKt.newLiveStreamLoadResponse(this, strOptString2, url, url, anonymousClass3, c00162);
        if (objNewLiveStreamLoadResponse == obj) {
            return obj;
        }
        return objNewLiveStreamLoadResponse;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x041d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0422  */
    /* JADX WARN: Code duplicated, block: B:41:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:43:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:44:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:46:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:77:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:79:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:82:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:85:0x0311  */
    /* JADX WARN: Code duplicated, block: B:87:0x036f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:88:0x0370  */
    /* JADX WARN: Code duplicated, block: B:91:0x038d  */
    /* JADX WARN: Code duplicated, block: B:92:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:93:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:95:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:96:0x03f6 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:99:0x0413  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x02c3 -> B:98:0x0408). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x02ce -> B:76:0x02e5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0370 -> B:89:0x0385). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x03b3 -> B:94:0x03c6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x0402 -> B:98:0x0408). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:95:0x03d3
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r30, boolean r31, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r32, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r33, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r34) {
        /*
            Method dump skipped, instruction units count: 1078
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: turkspor.common.LiveXProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
