package turkspor.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ChannelRules.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lturkspor/common/ChannelRules;", "", "<init>", "()V", "URL", "", "lock", "Lkotlinx/coroutines/sync/Mutex;", "checked", "", "hidden", "", "extras", "", "refresh", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "visible", "", "title", "extra", "raw", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChannelRules.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelRules.kt\nturkspor/common/ChannelRules\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,29:1\n116#2,8:30\n125#2,2:47\n1739#3:38\n1814#3,3:39\n835#4:42\n919#4,4:43\n1#5:49\n*S KotlinDebug\n*F\n+ 1 ChannelRules.kt\nturkspor/common/ChannelRules\n*L\n14#1:30,8\n14#1:47,2\n20#1:38\n20#1:39,3\n21#1:42\n21#1:43,4\n*E\n"})
public final class ChannelRules {

    @NotNull
    public static final String URL = "https://raw.githubusercontent.com/Wiojelt/TurkSpor/main/channel-rules.json";
    private static long checked;

    @NotNull
    public static final ChannelRules INSTANCE = new ChannelRules();

    @NotNull
    private static final Mutex lock = MutexKt.Mutex$default(false, 1, (Object) null);

    @NotNull
    private static volatile Set<String> hidden = SetsKt.emptySet();

    @NotNull
    private static volatile Map<String, String> extras = MapsKt.emptyMap();

    /* JADX INFO: renamed from: turkspor.common.ChannelRules$refresh$1 */
    /* JADX INFO: compiled from: ChannelRules.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.ChannelRules", f = "ChannelRules.kt", i = {0, 1}, l = {35, 17}, m = "refresh", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, nl = {36, 18}, s = {"L$0", "L$0"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
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
            return ChannelRules.this.refresh((Continuation) this);
        }
    }

    private ChannelRules() {
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00ca A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:40:0x00dd A[Catch: Exception -> 0x01a2, CancellationException -> 0x01a5, all -> 0x021b, TryCatch #11 {all -> 0x021b, blocks: (B:38:0x00d3, B:40:0x00dd, B:42:0x00ea, B:43:0x0113, B:45:0x0119, B:46:0x0136, B:47:0x015f, B:49:0x0165, B:50:0x0199, B:70:0x0204, B:77:0x0229, B:73:0x021a), top: B:86:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0119 A[Catch: Exception -> 0x01a2, CancellationException -> 0x01a5, all -> 0x021b, LOOP:0: B:43:0x0113->B:45:0x0119, LOOP_END, TryCatch #11 {all -> 0x021b, blocks: (B:38:0x00d3, B:40:0x00dd, B:42:0x00ea, B:43:0x0113, B:45:0x0119, B:46:0x0136, B:47:0x015f, B:49:0x0165, B:50:0x0199, B:70:0x0204, B:77:0x0229, B:73:0x021a), top: B:86:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0165 A[Catch: Exception -> 0x01a2, CancellationException -> 0x01a5, all -> 0x021b, LOOP:1: B:47:0x015f->B:49:0x0165, LOOP_END, TryCatch #11 {all -> 0x021b, blocks: (B:38:0x00d3, B:40:0x00dd, B:42:0x00ea, B:43:0x0113, B:45:0x0119, B:46:0x0136, B:47:0x015f, B:49:0x0165, B:50:0x0199, B:70:0x0204, B:77:0x0229, B:73:0x021a), top: B:86:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x021d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:87:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    public final Object refresh(@NotNull Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        Mutex $this$withLock_u24default$iv2;
        int $i$f$withLock;
        Object owner$iv2;
        Mutex $this$withLock_u24default$iv3;
        NiceResponse response;
        JsonNode root;
        Collection destination$iv$iv;
        Sequence $this$associate$iv;
        Map destination$iv$iv2;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object $result = anonymousClass2.result;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (anonymousClass2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$withLock_u24default$iv2 = lock;
                    anonymousClass2.L$0 = $this$withLock_u24default$iv2;
                    anonymousClass2.label = 1;
                    if ($this$withLock_u24default$iv2.lock((Object) null, anonymousClass2) == obj) {
                        return obj;
                    }
                    $i$f$withLock = 0;
                    owner$iv2 = null;
                    try {
                        if (System.currentTimeMillis() - checked >= 300000) {
                            try {
                                Requests app = MainActivityKt.getApp();
                                try {
                                    anonymousClass2.L$0 = $this$withLock_u24default$iv2;
                                    anonymousClass2.label = 2;
                                    $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                                    try {
                                        $result = Requests.get$default(app, URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 5L, (Interceptor) null, false, (ResponseParser) null, anonymousClass2, 3838, (Object) null);
                                        if ($result == obj) {
                                            return obj;
                                        }
                                        owner$iv = owner$iv2;
                                        $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                                        try {
                                            response = (NiceResponse) $result;
                                            if (response.getCode() == 200 && response.getText().length() < 200000) {
                                                root = new ObjectMapper().readTree(response.getText());
                                                Iterable $this$map$iv = root.path("hiddenChannels");
                                                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                                for (Object item$iv$iv : $this$map$iv) {
                                                    JsonNode it = (JsonNode) item$iv$iv;
                                                    destination$iv$iv.add(StringsKt.trim(it.asText()).toString());
                                                }
                                                hidden = CollectionsKt.toSet((List) destination$iv$iv);
                                                $this$associate$iv = SequencesKt.asSequence(root.path("extraChannels").fields());
                                                destination$iv$iv2 = new LinkedHashMap();
                                                for (Object element$iv$iv : $this$associate$iv) {
                                                    Map.Entry entry = (Map.Entry) element$iv$iv;
                                                    String k = (String) entry.getKey();
                                                    JsonNode v = (JsonNode) entry.getValue();
                                                    JsonNode root2 = root;
                                                    Pair pair = TuplesKt.to(k, v.asText());
                                                    destination$iv$iv2.put(pair.getFirst(), pair.getSecond());
                                                    root = root2;
                                                    $this$associate$iv = $this$associate$iv;
                                                }
                                                extras = destination$iv$iv2;
                                            }
                                            break;
                                        } catch (CancellationException e) {
                                            throw e;
                                        } catch (Exception e2) {
                                        }
                                        checked = System.currentTimeMillis();
                                    } catch (CancellationException e3) {
                                        throw e3;
                                    } catch (Exception e4) {
                                        owner$iv = owner$iv2;
                                        $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                                    } catch (Throwable th) {
                                        e = th;
                                        owner$iv = owner$iv2;
                                        $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                                        $this$withLock_u24default$iv.unlock(owner$iv);
                                        throw e;
                                    }
                                } catch (CancellationException e5) {
                                    throw e5;
                                } catch (Exception e6) {
                                    owner$iv = owner$iv2;
                                    $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                                } catch (Throwable th2) {
                                    e = th2;
                                    owner$iv = owner$iv2;
                                    $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                                }
                            } catch (CancellationException e7) {
                                throw e7;
                            } catch (Exception e8) {
                                owner$iv = owner$iv2;
                                $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                            }
                        } else {
                            owner$iv = owner$iv2;
                            $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                        }
                        Unit unit = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        return unit;
                    } catch (Throwable th3) {
                        e = th3;
                        owner$iv = owner$iv2;
                        $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                    }
                    break;
                case 1:
                    Mutex $this$withLock_u24default$iv4 = (Mutex) anonymousClass2.L$0;
                    ResultKt.throwOnFailure($result);
                    $i$f$withLock = 0;
                    $this$withLock_u24default$iv2 = $this$withLock_u24default$iv4;
                    owner$iv2 = null;
                    if (System.currentTimeMillis() - checked >= 300000) {
                        Requests app2 = MainActivityKt.getApp();
                        anonymousClass2.L$0 = $this$withLock_u24default$iv2;
                        anonymousClass2.label = 2;
                        $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                        $result = Requests.get$default(app2, URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 5L, (Interceptor) null, false, (ResponseParser) null, anonymousClass2, 3838, (Object) null);
                        if ($result == obj) {
                            return obj;
                        }
                        owner$iv = owner$iv2;
                        $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                        response = (NiceResponse) $result;
                        if (response.getCode() == 200) {
                            root = new ObjectMapper().readTree(response.getText());
                            Iterable $this$map$iv2 = root.path("hiddenChannels");
                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                            while (r13.hasNext()) {
                                JsonNode it2 = (JsonNode) item$iv$iv;
                                destination$iv$iv.add(StringsKt.trim(it2.asText()).toString());
                            }
                            hidden = CollectionsKt.toSet((List) destination$iv$iv);
                            $this$associate$iv = SequencesKt.asSequence(root.path("extraChannels").fields());
                            destination$iv$iv2 = new LinkedHashMap();
                            while (r12.hasNext()) {
                                Map.Entry entry2 = (Map.Entry) element$iv$iv;
                                String k2 = (String) entry2.getKey();
                                JsonNode v2 = (JsonNode) entry2.getValue();
                                JsonNode root3 = root;
                                Pair pair2 = TuplesKt.to(k2, v2.asText());
                                destination$iv$iv2.put(pair2.getFirst(), pair2.getSecond());
                                root = root3;
                                $this$associate$iv = $this$associate$iv;
                            }
                            extras = destination$iv$iv2;
                        }
                        checked = System.currentTimeMillis();
                        break;
                    } else {
                        owner$iv = owner$iv2;
                        $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                    }
                    Unit unit2 = Unit.INSTANCE;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    return unit2;
                case 2:
                    owner$iv = null;
                    $this$withLock_u24default$iv = (Mutex) anonymousClass2.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        response = (NiceResponse) $result;
                        if (response.getCode() == 200) {
                            root = new ObjectMapper().readTree(response.getText());
                            Iterable $this$map$iv3 = root.path("hiddenChannels");
                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                            while (r13.hasNext()) {
                                JsonNode it3 = (JsonNode) item$iv$iv;
                                destination$iv$iv.add(StringsKt.trim(it3.asText()).toString());
                            }
                            hidden = CollectionsKt.toSet((List) destination$iv$iv);
                            $this$associate$iv = SequencesKt.asSequence(root.path("extraChannels").fields());
                            destination$iv$iv2 = new LinkedHashMap();
                            while (r12.hasNext()) {
                                Map.Entry entry3 = (Map.Entry) element$iv$iv;
                                String k3 = (String) entry3.getKey();
                                JsonNode v3 = (JsonNode) entry3.getValue();
                                JsonNode root4 = root;
                                Pair pair3 = TuplesKt.to(k3, v3.asText());
                                destination$iv$iv2.put(pair3.getFirst(), pair3.getSecond());
                                root = root4;
                                $this$associate$iv = $this$associate$iv;
                            }
                            extras = destination$iv$iv2;
                        }
                        break;
                    } catch (CancellationException e9) {
                        throw e9;
                    } catch (Exception e10) {
                    } catch (Throwable th4) {
                        e = th4;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        throw e;
                    }
                    checked = System.currentTimeMillis();
                    Unit unit3 = Unit.INSTANCE;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    return unit3;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th5) {
            e = th5;
        }
    }

    public final boolean visible(@NotNull String title) {
        return !hidden.contains(title);
    }

    @Nullable
    public final String extra(@NotNull String raw) {
        String it = extras.get(StringsKt.trim(raw).toString());
        if (it == null || StringsKt.isBlank(it)) {
            return null;
        }
        return it;
    }
}
