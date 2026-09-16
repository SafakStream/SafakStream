package turkspor;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DomainResolver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "turkspor.DomainResolver", f = "DomainResolver.kt", i = {0, 0, 0}, l = {36}, m = "resolve$lambda$0$verify", n = {"errors", "this$0", "url"}, nl = {37}, s = {"L$0", "L$1", "L$2"}, v = 2)
final class DomainResolver$resolve$2$verify$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    DomainResolver$resolve$2$verify$1(Continuation<? super DomainResolver$resolve$2$verify$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DomainResolver.resolve$lambda$0$verify(null, null, null, (Continuation) this);
    }
}
