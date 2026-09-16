package turkspor.common;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lturkspor/common/WebEvent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "turkspor.common.NtvsProvider$refresh$rows$1$1$1", f = "AuthorizedSportsProviders.kt", i = {0, 0, 0}, l = {266}, m = "invokeSuspend", n = {"$this$async", "url", "$this$invokeSuspend_u24lambda_u240"}, nl = {266}, s = {"L$0", "L$1", "L$2"}, v = 2)
@SourceDebugExtension({"SMAP\nAuthorizedSportsProviders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AuthorizedSportsProviders.kt\nturkspor/common/NtvsProvider$refresh$rows$1$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,403:1\n1#2:404\n1#2:416\n1795#3,10:405\n2068#3:415\n2069#3:417\n1805#3:418\n*S KotlinDebug\n*F\n+ 1 AuthorizedSportsProviders.kt\nturkspor/common/NtvsProvider$refresh$rows$1$1$1\n*L\n268#1:416\n268#1:405,10\n268#1:415\n268#1:417\n268#1:418\n*E\n"})
final class NtvsProvider$refresh$rows$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends WebEvent>>, Object> {
    final /* synthetic */ String $term;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ NtvsProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NtvsProvider$refresh$rows$1$1$1(NtvsProvider ntvsProvider, String str, Continuation<? super NtvsProvider$refresh$rows$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = ntvsProvider;
        this.$term = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> ntvsProvider$refresh$rows$1$1$1 = new NtvsProvider$refresh$rows$1$1$1(this.this$0, this.$term, continuation);
        ntvsProvider$refresh$rows$1$1$1.L$0 = obj;
        return ntvsProvider$refresh$rows$1$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<WebEvent>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:33:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:35:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:45:0x0100  */
    /* JADX WARN: Code duplicated, block: B:47:0x0105  */
    /* JADX WARN: Code duplicated, block: B:50:0x0128  */
    /* JADX WARN: Code duplicated, block: B:52:0x013f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0147  */
    /* JADX WARN: Code duplicated, block: B:55:0x0165 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:56:0x0169  */
    /* JADX WARN: Code duplicated, block: B:62:0x0198  */
    /* JADX WARN: Code duplicated, block: B:65:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:81:0x01a8 A[SYNTHETIC] */
    public final Object invokeSuspend(Object $result) {
        String url;
        NtvsProvider$refresh$rows$1$1$1 ntvsProvider$refresh$rows$1$1$1;
        CoroutineScope $this$async;
        Object obj;
        String url2;
        Object obj2;
        NiceResponse niceResponse;
        NiceResponse response;
        Object obj3;
        JSONArray channels;
        NtvsProvider ntvsProvider;
        Collection destination$iv$iv;
        IntIterator it;
        JSONObject row;
        JSONArray channels2;
        CoroutineScope $this$async2;
        String title;
        String player;
        String p0;
        WebEvent webEvent;
        CoroutineScope $this$async3 = (CoroutineScope) this.L$0;
        Object obj4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                url = this.this$0.getMainUrl() + "/api/get-channels?limit=100&offset=0&search=" + URLEncoder.encode(this.$term, "UTF-8");
                try {
                    Result.Companion companion = Result.Companion;
                    Requests app = MainActivityKt.getApp();
                    this.L$0 = $this$async3;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    this.L$2 = SpillingKt.nullOutSpilledVariable($this$async3);
                    this.label = 1;
                    $this$async = $this$async3;
                    try {
                        obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 15L, (Interceptor) null, false, (ResponseParser) null, this, 3838, (Object) null);
                        ntvsProvider$refresh$rows$1$1$1 = this;
                        if (obj == obj4) {
                            return obj4;
                        }
                        url2 = url;
                        try {
                            obj2 = Result.constructor-impl((NiceResponse) obj);
                            break;
                        } catch (Throwable th) {
                            th = th;
                            url = url2;
                            Result.Companion companion2 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = null;
                        }
                        niceResponse = (NiceResponse) obj2;
                        if (niceResponse == null) {
                            return CollectionsKt.emptyList();
                        }
                        response = niceResponse;
                        try {
                            Result.Companion companion3 = Result.Companion;
                            obj3 = Result.constructor-impl(new JSONObject(response.getText()).optJSONArray("channels"));
                            break;
                        } catch (Throwable th2) {
                            Result.Companion companion4 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th2));
                        }
                        if (Result.isFailure-impl(obj3)) {
                            obj3 = null;
                        }
                        channels = (JSONArray) obj3;
                        if (channels == null) {
                            return CollectionsKt.emptyList();
                        }
                        Iterable $this$mapNotNull$iv = RangesKt.until(0, channels.length());
                        ntvsProvider = ntvsProvider$refresh$rows$1$1$1.this$0;
                        destination$iv$iv = new ArrayList();
                        it = $this$mapNotNull$iv.iterator();
                        while (it.hasNext()) {
                            int element$iv$iv$iv = it.nextInt();
                            row = channels.optJSONObject(element$iv$iv$iv);
                            if (row == null) {
                                channels2 = channels;
                                $this$async2 = $this$async;
                                webEvent = null;
                            } else {
                                channels2 = channels;
                                $this$async2 = $this$async;
                                title = StringsKt.trim(row.optString("channel_name")).toString();
                                player = ntvsProvider.route(row);
                                if (player == null && !StringsKt.isBlank(title)) {
                                    String strCountry = CountryCatalog.INSTANCE.country(title);
                                    p0 = row.optString("channel_image");
                                    if (StringsKt.isBlank(p0)) {
                                        p0 = null;
                                    }
                                    webEvent = new WebEvent(title, player, strCountry, p0);
                                } else {
                                    webEvent = null;
                                }
                            }
                            if (webEvent != null) {
                                destination$iv$iv.add(webEvent);
                            }
                            channels = channels2;
                            response = response;
                            $this$async = $this$async2;
                        }
                        return (List) destination$iv$iv;
                    } catch (Throwable th3) {
                        th = th3;
                        ntvsProvider$refresh$rows$1$1$1 = this;
                        Result.Companion companion5 = Result.Companion;
                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = null;
                        }
                        niceResponse = (NiceResponse) obj2;
                        if (niceResponse == null) {
                            return CollectionsKt.emptyList();
                        }
                        response = niceResponse;
                        Result.Companion companion6 = Result.Companion;
                        obj3 = Result.constructor-impl(new JSONObject(response.getText()).optJSONArray("channels"));
                        if (Result.isFailure-impl(obj3)) {
                            obj3 = null;
                        }
                        channels = (JSONArray) obj3;
                        if (channels == null) {
                            return CollectionsKt.emptyList();
                        }
                        Iterable $this$mapNotNull$iv2 = RangesKt.until(0, channels.length());
                        ntvsProvider = ntvsProvider$refresh$rows$1$1$1.this$0;
                        destination$iv$iv = new ArrayList();
                        it = $this$mapNotNull$iv2.iterator();
                        while (it.hasNext()) {
                            int element$iv$iv$iv2 = it.nextInt();
                            row = channels.optJSONObject(element$iv$iv$iv2);
                            if (row == null) {
                                channels2 = channels;
                                $this$async2 = $this$async;
                                webEvent = null;
                            } else {
                                channels2 = channels;
                                $this$async2 = $this$async;
                                title = StringsKt.trim(row.optString("channel_name")).toString();
                                player = ntvsProvider.route(row);
                                if (player == null) {
                                    webEvent = null;
                                } else {
                                    String strCountry2 = CountryCatalog.INSTANCE.country(title);
                                    p0 = row.optString("channel_image");
                                    if (StringsKt.isBlank(p0)) {
                                        p0 = null;
                                    }
                                    webEvent = new WebEvent(title, player, strCountry2, p0);
                                }
                            }
                            if (webEvent != null) {
                                destination$iv$iv.add(webEvent);
                            }
                            channels = channels2;
                            response = response;
                            $this$async = $this$async2;
                        }
                        return (List) destination$iv$iv;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    ntvsProvider$refresh$rows$1$1$1 = this;
                    $this$async = $this$async3;
                }
                break;
            case 1:
                String url3 = (String) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    url2 = url3;
                    ntvsProvider$refresh$rows$1$1$1 = this;
                    $this$async = $this$async3;
                    obj = $result;
                    obj2 = Result.constructor-impl((NiceResponse) obj);
                    break;
                } catch (Throwable th5) {
                    th = th5;
                    url = url3;
                    ntvsProvider$refresh$rows$1$1$1 = this;
                    $this$async = $this$async3;
                    Result.Companion companion7 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                    if (Result.isFailure-impl(obj2)) {
                        obj2 = null;
                    }
                    niceResponse = (NiceResponse) obj2;
                    if (niceResponse == null) {
                        return CollectionsKt.emptyList();
                    }
                    response = niceResponse;
                    Result.Companion companion8 = Result.Companion;
                    obj3 = Result.constructor-impl(new JSONObject(response.getText()).optJSONArray("channels"));
                    if (Result.isFailure-impl(obj3)) {
                        obj3 = null;
                    }
                    channels = (JSONArray) obj3;
                    if (channels == null) {
                        return CollectionsKt.emptyList();
                    }
                    Iterable $this$mapNotNull$iv3 = RangesKt.until(0, channels.length());
                    ntvsProvider = ntvsProvider$refresh$rows$1$1$1.this$0;
                    destination$iv$iv = new ArrayList();
                    it = $this$mapNotNull$iv3.iterator();
                    while (it.hasNext()) {
                        int element$iv$iv$iv3 = it.nextInt();
                        row = channels.optJSONObject(element$iv$iv$iv3);
                        if (row == null) {
                            channels2 = channels;
                            $this$async2 = $this$async;
                            webEvent = null;
                        } else {
                            channels2 = channels;
                            $this$async2 = $this$async;
                            title = StringsKt.trim(row.optString("channel_name")).toString();
                            player = ntvsProvider.route(row);
                            if (player == null) {
                                webEvent = null;
                            } else {
                                String strCountry3 = CountryCatalog.INSTANCE.country(title);
                                p0 = row.optString("channel_image");
                                if (StringsKt.isBlank(p0)) {
                                    p0 = null;
                                }
                                webEvent = new WebEvent(title, player, strCountry3, p0);
                            }
                        }
                        if (webEvent != null) {
                            destination$iv$iv.add(webEvent);
                        }
                        channels = channels2;
                        response = response;
                        $this$async = $this$async2;
                    }
                    return (List) destination$iv$iv;
                }
                if (Result.isFailure-impl(obj2)) {
                    obj2 = null;
                }
                niceResponse = (NiceResponse) obj2;
                if (niceResponse == null) {
                    return CollectionsKt.emptyList();
                }
                response = niceResponse;
                Result.Companion companion9 = Result.Companion;
                obj3 = Result.constructor-impl(new JSONObject(response.getText()).optJSONArray("channels"));
                if (Result.isFailure-impl(obj3)) {
                    obj3 = null;
                }
                channels = (JSONArray) obj3;
                if (channels == null) {
                    return CollectionsKt.emptyList();
                }
                Iterable $this$mapNotNull$iv4 = RangesKt.until(0, channels.length());
                ntvsProvider = ntvsProvider$refresh$rows$1$1$1.this$0;
                destination$iv$iv = new ArrayList();
                it = $this$mapNotNull$iv4.iterator();
                while (it.hasNext()) {
                    int element$iv$iv$iv4 = it.nextInt();
                    row = channels.optJSONObject(element$iv$iv$iv4);
                    if (row == null) {
                        channels2 = channels;
                        $this$async2 = $this$async;
                        webEvent = null;
                    } else {
                        channels2 = channels;
                        $this$async2 = $this$async;
                        title = StringsKt.trim(row.optString("channel_name")).toString();
                        player = ntvsProvider.route(row);
                        if (player == null) {
                            webEvent = null;
                        } else {
                            String strCountry4 = CountryCatalog.INSTANCE.country(title);
                            p0 = row.optString("channel_image");
                            if (StringsKt.isBlank(p0)) {
                                p0 = null;
                            }
                            webEvent = new WebEvent(title, player, strCountry4, p0);
                        }
                    }
                    if (webEvent != null) {
                        destination$iv$iv.add(webEvent);
                    }
                    channels = channels2;
                    response = response;
                    $this$async = $this$async2;
                }
                return (List) destination$iv$iv;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
