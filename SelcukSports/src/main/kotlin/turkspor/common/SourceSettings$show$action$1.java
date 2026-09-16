package turkspor.common;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SourceSettings.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "turkspor.common.SourceSettings$show$action$1", f = "SourceSettings.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, nl = {97}, s = {}, v = 2)
final class SourceSettings$show$action$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $before;
    final /* synthetic */ Function0<String> $current;
    final /* synthetic */ boolean $previouslyChecked;
    final /* synthetic */ ProgressBar $progress;
    final /* synthetic */ MaterialButton $refresh;
    final /* synthetic */ TextView $status;
    final /* synthetic */ Function2<String, Continuation<? super Integer>, Object> $update;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SourceSettings$show$action$1(boolean z, Function0<String> function0, String str, MaterialButton materialButton, ProgressBar progressBar, Function2<? super String, ? super Continuation<? super Integer>, ? extends Object> function2, TextView textView, Continuation<? super SourceSettings$show$action$1> continuation) {
        super(2, continuation);
        this.$previouslyChecked = z;
        this.$current = function0;
        this.$before = str;
        this.$refresh = materialButton;
        this.$progress = progressBar;
        this.$update = function2;
        this.$status = textView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SourceSettings$show$action$1(this.$previouslyChecked, this.$current, this.$before, this.$refresh, this.$progress, this.$update, this.$status, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: turkspor.common.SourceSettings$show$action$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: SourceSettings.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.SourceSettings$show$action$1$1", f = "SourceSettings.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ Function2<String, Continuation<? super Integer>, Object> $update;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function2<? super String, ? super Continuation<? super Integer>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$update = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$update, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Function2<String, Continuation<? super Integer>, Object> function2 = this.$update;
                    this.label = 1;
                    Object objInvoke = function2.invoke((Object) null, this);
                    return objInvoke == obj ? obj : objInvoke;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(this.$update, null), (Continuation) this) == obj) {
                            return obj;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                TextView textView = this.$status;
                if (this.$previouslyChecked) {
                    str = !Intrinsics.areEqual(this.$current.invoke(), this.$before) ? "✓ Değişti" : "✓ Değişmedi";
                } else {
                    str = "✓ Güncellendi";
                }
                SourceSettings.show$render(textView, str);
            } catch (CancellationException e) {
                throw e;
            } catch (Exception e2) {
                SourceSettings.show$render(this.$status, "Güncellenemedi");
            }
            this.$refresh.setEnabled(true);
            this.$progress.setVisibility(8);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            this.$refresh.setEnabled(true);
            this.$progress.setVisibility(8);
            throw th;
        }
    }
}
