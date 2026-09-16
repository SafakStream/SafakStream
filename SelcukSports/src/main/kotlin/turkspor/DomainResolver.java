package turkspor;

import android.content.SharedPreferences;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DomainResolver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lturkspor/DomainResolver;", "", "preferences", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "cached", "Lturkspor/SiteSnapshot;", "currentUrl", "", "getCurrentUrl", "()Ljava/lang/String;", "checkedAt", "", "getCheckedAt", "()J", "resolve", "force", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setManual", "value", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDomainResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DomainResolver.kt\nturkspor/DomainResolver\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,91:1\n116#2,8:92\n125#2,2:103\n1#3:100\n2068#4,2:101\n*S KotlinDebug\n*F\n+ 1 DomainResolver.kt\nturkspor/DomainResolver\n*L\n25#1:92,8\n25#1:103,2\n49#1:101,2\n*E\n"})
public final class DomainResolver {

    @NotNull
    public static final String BOOTSTRAP = "https://www.selcuksportshdbd813bd00f.xyz/";

    @NotNull
    public static final String GATEWAY = "https://www.selcuksportshd.is/";

    @NotNull
    public static final String MANIFEST = "https://raw.githubusercontent.com/Wiojelt/TurkSpor/main/domains.json";

    @NotNull
    public static final String UA = "Mozilla/5.0 (Linux; Android 13) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Mobile Safari/537.36";

    @Nullable
    private volatile SiteSnapshot cached;

    @NotNull
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @NotNull
    private final SharedPreferences preferences;

    /* JADX INFO: renamed from: turkspor.DomainResolver$resolve$1, reason: invalid class name */
    /* JADX INFO: compiled from: DomainResolver.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.DomainResolver", f = "DomainResolver.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4}, l = {97, 49, 52, 63, 68}, m = "resolve", n = {"$this$withLock_u24default$iv", "force", "$this$withLock_u24default$iv", "candidates", "errors", "$this$forEach$iv", "manual", "element$iv", "it", "force", "now", "$this$withLock_u24default$iv", "candidates", "errors", "manual", "force", "now", "$this$withLock_u24default$iv", "candidates", "errors", "manual", "force", "now", "$this$withLock_u24default$iv", "candidates", "errors", "candidate", "manual", "force", "now"}, nl = {98, 100, 53, 64, 100}, s = {"L$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "Z$0", "J$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "J$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "J$0", "L$0", "L$1", "L$2", "L$4", "L$5", "Z$0", "J$0"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
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

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DomainResolver.this.resolve(false, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.DomainResolver$setManual$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DomainResolver.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.DomainResolver", f = "DomainResolver.kt", i = {0, 1, 1, 1}, l = {76, 82}, m = "setManual", n = {"value", "value", "url", "old"}, nl = {78, 83}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DomainResolver.this.setManual(null, (Continuation) this);
        }
    }

    public DomainResolver(@NotNull SharedPreferences preferences) {
        this.preferences = preferences;
    }

    @NotNull
    public final String getCurrentUrl() {
        String url;
        SiteSnapshot siteSnapshot = this.cached;
        if (siteSnapshot != null && (url = siteSnapshot.getUrl()) != null) {
            return url;
        }
        String string = this.preferences.getString("lastGood", BOOTSTRAP);
        return string == null ? BOOTSTRAP : string;
    }

    public final long getCheckedAt() {
        SiteSnapshot siteSnapshot = this.cached;
        return siteSnapshot != null ? siteSnapshot.getCheckedAt() : this.preferences.getLong("checkedAt", 0L);
    }

    public static /* synthetic */ Object resolve$default(DomainResolver domainResolver, boolean z, Continuation continuation, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            z = false;
        }
        return domainResolver.resolve(z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:59:0x019f  */
    /* JADX WARN: Code duplicated, block: B:61:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:79:0x0210 A[Catch: all -> 0x02b3, TRY_LEAVE, TryCatch #9 {all -> 0x02b3, blocks: (B:77:0x020a, B:79:0x0210), top: B:278:0x020a }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x024f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x0250  */
    /* JADX WARN: Code duplicated, block: B:85:0x026f  */
    /* JADX WARN: Code duplicated, block: B:86:0x027a  */
    /* JADX WARN: Path cross not found for [B:296:0x0183, B:56:0x019b], limit reached: 331 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:242:0x06e6 -> B:300:0x06fa). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x0250 -> B:294:0x026b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object resolve(boolean r37, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super turkspor.SiteSnapshot> r38) {
        /*
            Method dump skipped, instruction units count: 1968
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: turkspor.DomainResolver.resolve(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x00ca A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x00cb A[Catch: Exception -> 0x00f9, CancellationException -> 0x00fb, TRY_LEAVE, TryCatch #5 {CancellationException -> 0x00fb, Exception -> 0x00f9, blocks: (B:26:0x00a2, B:29:0x00b1, B:32:0x00ba, B:35:0x00cb), top: B:58:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object resolve$lambda$0$verify(List<String> list, DomainResolver this$0, String url, Continuation<? super SiteSnapshot> continuation) {
        DomainResolver$resolve$2$verify$1 domainResolver$resolve$2$verify$1;
        List<String> list2;
        DomainResolver this$1;
        NiceResponse response;
        String finalUrl;
        List<SportsChannel> listChannels;
        if (continuation instanceof DomainResolver$resolve$2$verify$1) {
            domainResolver$resolve$2$verify$1 = (DomainResolver$resolve$2$verify$1) continuation;
            if ((domainResolver$resolve$2$verify$1.label & Integer.MIN_VALUE) != 0) {
                domainResolver$resolve$2$verify$1.label -= Integer.MIN_VALUE;
            } else {
                domainResolver$resolve$2$verify$1 = new DomainResolver$resolve$2$verify$1(continuation);
            }
        } else {
            domainResolver$resolve$2$verify$1 = new DomainResolver$resolve$2$verify$1(continuation);
        }
        DomainResolver$resolve$2$verify$1 domainResolver$resolve$2$verify$2 = domainResolver$resolve$2$verify$1;
        Object $result = domainResolver$resolve$2$verify$2.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (domainResolver$resolve$2$verify$2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    Requests app = MainActivityKt.getApp();
                    Map mapMapOf = MapsKt.mapOf(TuplesKt.to("User-Agent", UA));
                    domainResolver$resolve$2$verify$2.L$0 = list;
                    domainResolver$resolve$2$verify$2.L$1 = this$0;
                    domainResolver$resolve$2$verify$2.L$2 = SpillingKt.nullOutSpilledVariable(url);
                    domainResolver$resolve$2$verify$2.label = 1;
                    try {
                        Object obj2 = Requests.get$default(app, url, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 12L, (Interceptor) null, false, (ResponseParser) null, domainResolver$resolve$2$verify$2, 3836, (Object) null);
                        if (obj2 == obj) {
                            return obj;
                        }
                        list2 = list;
                        this$1 = this$0;
                        $result = obj2;
                        try {
                            response = (NiceResponse) $result;
                            finalUrl = SportsParser.INSTANCE.siteUrl(response.getUrl());
                            if (finalUrl != null || response.getCode() != 200) {
                                return null;
                            }
                            listChannels = SportsParser.INSTANCE.channels(response.getText(), finalUrl);
                            if (listChannels.isEmpty()) {
                                return null;
                            }
                            SiteSnapshot it = new SiteSnapshot(finalUrl, listChannels, System.currentTimeMillis());
                            this$1.cached = it;
                            this$1.preferences.edit().putString("lastGood", it.getUrl()).putLong("checkedAt", it.getCheckedAt()).apply();
                            return it;
                        } catch (CancellationException e) {
                            throw e;
                        } catch (Exception e2) {
                            e = e2;
                            list2.add(e.getClass().getSimpleName());
                            return null;
                        }
                    } catch (CancellationException e3) {
                        throw e3;
                    } catch (Exception e4) {
                        e = e4;
                        list2 = list;
                        list2.add(e.getClass().getSimpleName());
                        return null;
                    }
                } catch (CancellationException e5) {
                    throw e5;
                } catch (Exception e6) {
                    e = e6;
                    list2 = list;
                }
                break;
            case 1:
                this$1 = (DomainResolver) domainResolver$resolve$2$verify$2.L$1;
                list2 = (List) domainResolver$resolve$2$verify$2.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    response = (NiceResponse) $result;
                    finalUrl = SportsParser.INSTANCE.siteUrl(response.getUrl());
                    if (finalUrl != null) {
                        return null;
                    }
                    listChannels = SportsParser.INSTANCE.channels(response.getText(), finalUrl);
                    if (listChannels.isEmpty()) {
                        return null;
                    }
                    SiteSnapshot it2 = new SiteSnapshot(finalUrl, listChannels, System.currentTimeMillis());
                    this$1.cached = it2;
                    this$1.preferences.edit().putString("lastGood", it2.getUrl()).putLong("checkedAt", it2.getCheckedAt()).apply();
                    return it2;
                } catch (CancellationException e7) {
                    throw e7;
                } catch (Exception e8) {
                    e = e8;
                    list2.add(e.getClass().getSimpleName());
                    return null;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:37:0x00bb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x00bc A[Catch: Exception -> 0x0041, TryCatch #1 {Exception -> 0x0041, blocks: (B:13:0x003b, B:35:0x00af, B:38:0x00bc, B:39:0x00c3), top: B:48:0x003b }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object setManual(@NotNull String value, @NotNull Continuation<? super SiteSnapshot> continuation) throws Exception {
        C00001 c00001;
        String url;
        String old;
        Object objResolve;
        SiteSnapshot result;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = new C00001(continuation);
            }
        } else {
            c00001 = new C00001(continuation);
        }
        Object $result = c00001.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (StringsKt.isBlank(value)) {
                    this.preferences.edit().remove("manual").apply();
                    c00001.L$0 = SpillingKt.nullOutSpilledVariable(value);
                    c00001.label = 1;
                    Object objResolve2 = resolve(true, c00001);
                    return objResolve2 == obj ? obj : objResolve2;
                }
                url = SportsParser.INSTANCE.siteUrl(value);
                if (url == null) {
                    throw new ErrorLoadingException("Geçerli bir HTTPS SelçukSports adresi girin.");
                }
                String string = this.preferences.getString("manual", "");
                String old2 = string != null ? string : "";
                this.preferences.edit().putString("manual", url).apply();
                try {
                    c00001.L$0 = SpillingKt.nullOutSpilledVariable(value);
                    c00001.L$1 = url;
                    c00001.L$2 = old2;
                    c00001.label = 2;
                    objResolve = resolve(true, c00001);
                    if (objResolve == obj) {
                        return obj;
                    }
                    old = old2;
                    result = (SiteSnapshot) objResolve;
                    if (Intrinsics.areEqual(result.getUrl(), url)) {
                        return result;
                    }
                    throw new ErrorLoadingException("Girilen adres doğrulanamadı; çalışan adres korundu.");
                } catch (Exception e) {
                    e = e;
                    old = old2;
                    this.preferences.edit().putString("manual", old).apply();
                    throw e;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            case 2:
                old = (String) c00001.L$2;
                url = (String) c00001.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    objResolve = $result;
                    result = (SiteSnapshot) objResolve;
                    if (Intrinsics.areEqual(result.getUrl(), url)) {
                        return result;
                    }
                    throw new ErrorLoadingException("Girilen adres doğrulanamadı; çalışan adres korundu.");
                } catch (Exception e2) {
                    e = e2;
                    this.preferences.edit().putString("manual", old).apply();
                    throw e;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
