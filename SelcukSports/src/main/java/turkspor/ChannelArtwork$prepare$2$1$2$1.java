package turkspor;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Semaphore;

/* JADX INFO: compiled from: ChannelArtwork.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "turkspor.ChannelArtwork$prepare$2$1$2$1", f = "ChannelArtwork.kt", i = {0}, l = {70}, m = "invokeSuspend", n = {"$this$withPermit$iv"}, nl = {71}, s = {"L$0"}, v = 2)
@SourceDebugExtension({"SMAP\nChannelArtwork.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelArtwork.kt\nturkspor/ChannelArtwork$prepare$2$1$2$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n*L\n1#1,69:1\n81#2,6:70\n*S KotlinDebug\n*F\n+ 1 ChannelArtwork.kt\nturkspor/ChannelArtwork$prepare$2$1$2$1\n*L\n22#1:70,6\n*E\n"})
final class ChannelArtwork$prepare$2$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SportsChannel $channel;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ChannelArtwork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelArtwork$prepare$2$1$2$1(ChannelArtwork channelArtwork, SportsChannel sportsChannel, Continuation<? super ChannelArtwork$prepare$2$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = channelArtwork;
        this.$channel = sportsChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChannelArtwork$prepare$2$1$2$1(this.this$0, this.$channel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Semaphore $this$withPermit$iv;
        ChannelArtwork channelArtwork;
        SportsChannel sportsChannel;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$withPermit$iv = this.this$0.semaphore;
                channelArtwork = this.this$0;
                sportsChannel = this.$channel;
                this.L$0 = $this$withPermit$iv;
                this.L$1 = channelArtwork;
                this.L$2 = sportsChannel;
                this.label = 1;
                if ($this$withPermit$iv.acquire((Continuation) this) == obj) {
                    return obj;
                }
                break;
            case 1:
                sportsChannel = (SportsChannel) this.L$2;
                channelArtwork = (ChannelArtwork) this.L$1;
                $this$withPermit$iv = (Semaphore) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            channelArtwork.render(sportsChannel);
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            $this$withPermit$iv.release();
        }
    }
}
