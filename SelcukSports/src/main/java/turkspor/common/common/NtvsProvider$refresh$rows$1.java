package turkspor.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lturkspor/common/WebEvent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "turkspor.common.NtvsProvider$refresh$rows$1", f = "AuthorizedSportsProviders.kt", i = {0}, l = {275}, m = "invokeSuspend", n = {"$this$supervisorScope"}, nl = {-1}, s = {"L$0"}, v = 2)
@SourceDebugExtension({"SMAP\nAuthorizedSportsProviders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AuthorizedSportsProviders.kt\nturkspor/common/NtvsProvider$refresh$rows$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,403:1\n1739#2:404\n1814#2,3:405\n*S KotlinDebug\n*F\n+ 1 AuthorizedSportsProviders.kt\nturkspor/common/NtvsProvider$refresh$rows$1\n*L\n263#1:404\n263#1:405,3\n*E\n"})
final class NtvsProvider$refresh$rows$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends WebEvent>>, Object> {
    final /* synthetic */ List<String> $terms;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NtvsProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NtvsProvider$refresh$rows$1(List<String> list, NtvsProvider ntvsProvider, Continuation<? super NtvsProvider$refresh$rows$1> continuation) {
        super(2, continuation);
        this.$terms = list;
        this.this$0 = ntvsProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> ntvsProvider$refresh$rows$1 = new NtvsProvider$refresh$rows$1(this.$terms, this.this$0, continuation);
        ntvsProvider$refresh$rows$1.L$0 = obj;
        return ntvsProvider$refresh$rows$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<WebEvent>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objAwaitAll;
        CoroutineScope $this$supervisorScope = (CoroutineScope) this.L$0;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$map$iv = this.$terms;
                NtvsProvider ntvsProvider = this.this$0;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    String term = (String) item$iv$iv;
                    destination$iv$iv.add(BuildersKt.async$default($this$supervisorScope, (CoroutineContext) null, (CoroutineStart) null, new NtvsProvider$refresh$rows$1$1$1(ntvsProvider, term, null), 3, (Object) null));
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$supervisorScope);
                this.label = 1;
                objAwaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                if (objAwaitAll == obj) {
                    return obj;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objAwaitAll = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return CollectionsKt.flatten((Iterable) objAwaitAll);
    }
}
