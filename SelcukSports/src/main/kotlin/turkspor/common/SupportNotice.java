package turkspor.common;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SupportNotice.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lturkspor/common/SupportNotice;", "", "<init>", "()V", "PREFS", "", "LAST_DAY", "showIfDue", "", "context", "Landroid/content/Context;", "open", "url", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSupportNotice.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SupportNotice.kt\nturkspor/common/SupportNotice\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,42:1\n1#2:43\n*E\n"})
public final class SupportNotice {

    @NotNull
    public static final SupportNotice INSTANCE = new SupportNotice();

    @NotNull
    private static final String LAST_DAY = "last_day";

    @NotNull
    private static final String PREFS = "turkspor_support_notice";

    private SupportNotice() {
    }

    public final void showIfDue(@NotNull Context context) {
        final Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return;
        }
        SharedPreferences prefs = ((Activity) context).getSharedPreferences(PREFS, 0);
        Calendar $this$showIfDue_u24lambda_u240 = Calendar.getInstance();
        String today = new StringBuilder().append($this$showIfDue_u24lambda_u240.get(1)).append('-').append($this$showIfDue_u24lambda_u240.get(6)).toString();
        if (Intrinsics.areEqual(prefs.getString(LAST_DAY, ""), today)) {
            return;
        }
        prefs.edit().putString(LAST_DAY, today).apply();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: turkspor.common.SupportNotice$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SupportNotice.showIfDue$lambda$1(activity);
            }
        });
    }

    static final void showIfDue$lambda$1(final Activity $activity) {
        if ($activity.isFinishing() || $activity.isDestroyed()) {
            return;
        }
        final SupportNotice $this$showIfDue_u24lambda_u241_u240 = INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            Result.constructor-impl(new MaterialAlertDialogBuilder($activity).setTitle("TurkSpor'a destek ol ☕").setMessage("Eklentiler ücretsiz kalacak. İstersen projeye bir kahveyle destek olabilirsin.\n\nBu hatırlatma günde en fazla bir kez gösterilir.").setPositiveButton("Destek ol", new DialogInterface.OnClickListener() { // from class: turkspor.common.SupportNotice$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int r4) {
                    SupportNotice.showIfDue$lambda$1$0$0(this.f$0, $activity, dialogInterface, r4);
                }
            }).setNeutralButton("Telegram", new DialogInterface.OnClickListener() { // from class: turkspor.common.SupportNotice$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int r4) {
                    SupportNotice.showIfDue$lambda$1$0$1(this.f$0, $activity, dialogInterface, r4);
                }
            }).setNegativeButton("Bugün kapat", (DialogInterface.OnClickListener) null).show());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showIfDue$lambda$1$0$0(SupportNotice $this_runCatching, Activity $activity, DialogInterface dialogInterface, int r3) {
        $this_runCatching.open($activity, "https://buymeacoffee.com/wiojelt");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showIfDue$lambda$1$0$1(SupportNotice $this_runCatching, Activity $activity, DialogInterface dialogInterface, int r3) {
        $this_runCatching.open($activity, "https://t.me/wioj3lt");
    }

    private final void open(Context context, String url) {
        try {
            Result.Companion companion = Result.Companion;
            SupportNotice supportNotice = this;
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)).addFlags(268435456));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }
}
