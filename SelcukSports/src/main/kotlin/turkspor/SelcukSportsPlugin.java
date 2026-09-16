package turkspor;

import android.content.Context;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import turkspor.common.SourceSettings;
import turkspor.common.SupportNotice;

/* JADX INFO: compiled from: SelcukSportsPlugin.kt */
/* JADX INFO: loaded from: classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002Ê\u0001\u0002\b\f¨\u0006\u000b"}, d2 = {"Lturkspor/SelcukSportsPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "load", "", "context", "Landroid/content/Context;", "showSettings", "resolver", "Lturkspor/DomainResolver;", "SelcukSports", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class SelcukSportsPlugin extends Plugin {
    public void load(@NotNull Context context) {
        SupportNotice.INSTANCE.showIfDue(context);
        final DomainResolver resolver = new DomainResolver(context.getSharedPreferences("turkspor_selcuk", 0));
        registerMainAPI(new SelcukSports(resolver, new ChannelArtwork(context)));
        setOpenSettings(new Function1() { // from class: turkspor.SelcukSportsPlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return SelcukSportsPlugin.load$lambda$0(this.f$0, resolver, (Context) obj);
            }
        });
    }

    static final Unit load$lambda$0(SelcukSportsPlugin this$0, DomainResolver $resolver, Context uiContext) {
        this$0.showSettings(uiContext, $resolver);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: turkspor.SelcukSportsPlugin$showSettings$3, reason: invalid class name */
    /* JADX INFO: compiled from: SelcukSportsPlugin.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "manual", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.SelcukSportsPlugin$showSettings$3", f = "SelcukSportsPlugin.kt", i = {0, 1}, l = {17, 17}, m = "invokeSuspend", n = {"manual", "manual"}, nl = {17, -1}, s = {"L$0", "L$0"}, v = 2)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<String, Continuation<? super Integer>, Object> {
        final /* synthetic */ DomainResolver $resolver;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(DomainResolver domainResolver, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$resolver = domainResolver;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass3 = new AnonymousClass3(this.$resolver, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        public final Object invoke(String str, Continuation<? super Integer> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) throws Exception {
            Object manual;
            String manual2 = (String) this.L$0;
            Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    DomainResolver domainResolver = this.$resolver;
                    Continuation<? super SiteSnapshot> continuation = (Continuation) this;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(manual2);
                    if (manual2 == null) {
                        this.label = 1;
                        manual = domainResolver.resolve(true, continuation);
                        if (manual == obj) {
                            return obj;
                        }
                    } else {
                        this.label = 2;
                        manual = domainResolver.setManual(manual2, continuation);
                        if (manual == obj) {
                            return obj;
                        }
                    }
                case 1:
                case 2:
                    ResultKt.throwOnFailure($result);
                    manual = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Boxing.boxInt(((SiteSnapshot) manual).getChannels().size());
        }
    }

    private final void showSettings(Context context, final DomainResolver resolver) {
        SourceSettings.INSTANCE.show(context, "SelcukSports", new Function0() { // from class: turkspor.SelcukSportsPlugin$$ExternalSyntheticLambda1
            public final Object invoke() {
                return resolver.getCurrentUrl();
            }
        }, new Function0() { // from class: turkspor.SelcukSportsPlugin$$ExternalSyntheticLambda2
            public final Object invoke() {
                return Long.valueOf(resolver.getCheckedAt());
            }
        }, new AnonymousClass3(resolver, null));
    }
}
