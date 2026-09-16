package turkspor.common;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SourceSettings.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J]\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000b2$\u0010\u000e\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f¢\u0006\u0002\u0010\u0012J¥\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000b2$\u0010\u000e\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\u0014\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0014\u0018\u00010\u000b2\u0014\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0016\u0018\u00010\u000b2\u001a\u0010\u0017\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Lturkspor/common/SourceSettings;", "", "<init>", "()V", "show", "", "context", "Landroid/content/Context;", "title", "", "current", "Lkotlin/Function0;", "checked", "", "update", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "countryOptions", "", "selectedCountries", "", "setCountries", "Lkotlin/Function1;", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSourceSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SourceSettings.kt\nturkspor/common/SourceSettings\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,107:1\n1#2:108\n37#3,2:109\n*S KotlinDebug\n*F\n+ 1 SourceSettings.kt\nturkspor/common/SourceSettings\n*L\n67#1:109,2\n*E\n"})
public final class SourceSettings {

    @NotNull
    public static final SourceSettings INSTANCE = new SourceSettings();

    private SourceSettings() {
    }

    public final void show(@NotNull Context context, @NotNull String title, @NotNull Function0<String> current, @NotNull Function0<Long> checked, @NotNull Function2<? super String, ? super Continuation<? super Integer>, ? extends Object> update) {
        show(context, title, current, checked, update, null, null, null);
    }

    private static final int show$dp(Context $context, int n) {
        return (int) (n * $context.getResources().getDisplayMetrics().density);
    }

    private static final int show$color(Context $context, String name, int fallback) {
        Object obj;
        int id = $context.getResources().getIdentifier(name, "attr", $context.getPackageName());
        TypedValue value = new TypedValue();
        if (id != 0 && $context.getTheme().resolveAttribute(id, value, true)) {
            if (value.resourceId == 0) {
                return value.data;
            }
            SourceSettings sourceSettings = INSTANCE;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(Integer.valueOf($context.getColor(value.resourceId)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Integer numValueOf = Integer.valueOf(fallback);
            if (Result.isFailure-impl(obj)) {
                obj = numValueOf;
            }
            return ((Number) obj).intValue();
        }
        return fallback;
    }

    public final void show(@NotNull final Context context, @NotNull String title, @NotNull final Function0<String> current, @NotNull final Function0<Long> checked, @NotNull final Function2<? super String, ? super Continuation<? super Integer>, ? extends Object> update, @Nullable final Function0<? extends List<String>> countryOptions, @Nullable final Function0<? extends Set<String>> selectedCountries, @Nullable final Function1<? super Set<String>, Unit> setCountries) {
        Context context2 = context;
        int surface = show$color(context2, "colorSurface", Color.rgb(24, 24, 28));
        int foreground = show$color(context2, "colorOnSurface", -1);
        int muted = show$color(context2, "colorOnSurfaceVariant", -3355444);
        int accent = show$color(context2, "colorPrimary", Color.rgb(165, 192, 255));
        final BottomSheetDialog dialog = new BottomSheetDialog(context2);
        final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        ScrollView scroll = new ScrollView(context2);
        LinearLayout root = new LinearLayout(context2);
        root.setOrientation(1);
        root.setPadding(show$dp(context2, 24), show$dp(context2, 16), show$dp(context2, 24), show$dp(context2, 24));
        GradientDrawable $this$show_u24lambda_u241_u240 = new GradientDrawable();
        $this$show_u24lambda_u241_u240.setColor(surface);
        $this$show_u24lambda_u241_u240.setCornerRadii(new float[]{show$dp(context2, 28), show$dp(context2, 28), show$dp(context2, 28), show$dp(context2, 28), 0.0f, 0.0f, 0.0f, 0.0f});
        root.setBackground($this$show_u24lambda_u241_u240);
        View $this$show_u24lambda_u243 = new View(context2);
        GradientDrawable $this$show_u24lambda_u243_u240 = new GradientDrawable();
        $this$show_u24lambda_u243_u240.setColor(muted);
        $this$show_u24lambda_u243_u240.setCornerRadius(show$dp(context2, 3));
        $this$show_u24lambda_u243.setBackground($this$show_u24lambda_u243_u240);
        LinearLayout.LayoutParams $this$show_u24lambda_u244 = new LinearLayout.LayoutParams(show$dp(context2, 36), show$dp(context2, 4));
        $this$show_u24lambda_u244.gravity = 1;
        $this$show_u24lambda_u244.bottomMargin = show$dp(context2, 12);
        Unit unit = Unit.INSTANCE;
        root.addView($this$show_u24lambda_u243, $this$show_u24lambda_u244);
        show$text(context2, foreground, muted, root, title, 22.0f, true);
        show$text$default(context2, foreground, muted, root, "Güncelleme", 13.0f, false, 64, null);
        final TextView status = show$text$default(context2, foreground, muted, root, "", 0.0f, false, 96, null);
        final ProgressBar $this$show_u24lambda_u245 = new ProgressBar(context2, null, R.attr.progressBarStyleHorizontal);
        $this$show_u24lambda_u245.setIndeterminate(true);
        $this$show_u24lambda_u245.setVisibility(8);
        $this$show_u24lambda_u245.setIndeterminateTintList(ColorStateList.valueOf(accent));
        root.addView($this$show_u24lambda_u245, new LinearLayout.LayoutParams(-1, show$dp(context2, 3)));
        SourceCredit credit = SourceCredits.INSTANCE.forTitle(title);
        if (credit != null) {
            show$text(context2, foreground, muted, root, "Kaynak: " + credit.getName(), 15.0f, true);
            context2 = context;
            show$text$default(context2, foreground, muted, root, credit.getThanks(), 13.0f, false, 64, null);
        }
        final MaterialButton refresh = show$button(context2, 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0199: INVOKE (r18v1 'refresh' com.google.android.material.button.MaterialButton) = (r0v1 'context2' android.content.Context), (r3v3 android.view.View A[D('foreground' int)]), ("Gￃﾼncellemeyi kontrol et") STATIC call: turkspor.common.SourceSettings.show$button(android.content.Context, android.widget.LinearLayout, java.lang.String):com.google.android.material.button.MaterialButton A[DECLARE_VAR, MD:(android.content.Context, android.widget.LinearLayout, java.lang.String):com.google.android.material.button.MaterialButton (m)] (LINE:57) in method: turkspor.common.SourceSettings.show(android.content.Context, java.lang.String, kotlin.jvm.functions.Function0<java.lang.String>, kotlin.jvm.functions.Function0<java.lang.Long>, kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.coroutines.Continuation<? super java.lang.Integer>, ? extends java.lang.Object>, kotlin.jvm.functions.Function0<? extends java.util.List<java.lang.String>>, kotlin.jvm.functions.Function0<? extends java.util.Set<java.lang.String>>, kotlin.jvm.functions.Function1<? super java.util.Set<java.lang.String>, kotlin.Unit>):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v3 android.view.View
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            */
        /*
            Method dump skipped, instruction units count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: turkspor.common.SourceSettings.show(android.content.Context, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1):void");
    }

    private static final TextView show$text(Context $context, int foreground, int muted, LinearLayout root, String value, float size, boolean bold) {
        TextView $this$show_u24text_u24lambda_u242 = new TextView($context);
        $this$show_u24text_u24lambda_u242.setText(value);
        $this$show_u24text_u24lambda_u242.setTextSize(size);
        $this$show_u24text_u24lambda_u242.setTextColor(bold ? foreground : muted);
        if (bold) {
            $this$show_u24text_u24lambda_u242.setTypeface(Typeface.DEFAULT_BOLD);
        }
        $this$show_u24text_u24lambda_u242.setPadding(0, show$dp($context, 8), 0, show$dp($context, 8));
        root.addView($this$show_u24text_u24lambda_u242);
        return $this$show_u24text_u24lambda_u242;
    }

    static /* synthetic */ TextView show$text$default(Context context, int r8, int r9, LinearLayout linearLayout, String str, float f, boolean z, int r14, Object obj) {
        if ((r14 & 32) != 0) {
            f = 14.0f;
        }
        float f2 = f;
        if ((r14 & 64) != 0) {
            z = false;
        }
        return show$text(context, r8, r9, linearLayout, str, f2, z);
    }

    private static final MaterialButton show$button(Context $context, LinearLayout root, String label) {
        MaterialButton $this$show_u24button_u24lambda_u246 = new MaterialButton($context);
        $this$show_u24button_u24lambda_u246.setText(label);
        $this$show_u24button_u24lambda_u246.setAllCaps(false);
        $this$show_u24button_u24lambda_u246.setCornerRadius(show$dp($context, 20));
        $this$show_u24button_u24lambda_u246.setMinHeight(show$dp($context, 52));
        LinearLayout.LayoutParams $this$show_u24button_u24lambda_u246_u240 = new LinearLayout.LayoutParams(-1, show$dp($context, 56));
        $this$show_u24button_u24lambda_u246_u240.topMargin = show$dp($context, 10);
        Unit unit = Unit.INSTANCE;
        root.addView((View) $this$show_u24button_u24lambda_u246, $this$show_u24button_u24lambda_u246_u240);
        return $this$show_u24button_u24lambda_u246;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$render(TextView status, String message) {
        status.setText(message);
    }

    static /* synthetic */ void show$render$default(TextView textView, String str, int r2, Object obj) {
        if ((r2 & 2) != 0) {
            str = "";
        }
        show$render(textView, str);
    }

    static final void show$lambda$8(Function0 $countryOptions, Function0 $selectedCountries, Context $context, final TextView $status, final Function1 $setCountries, View it) {
        final List options = CollectionsKt.sorted(CollectionsKt.distinct((Iterable) $countryOptions.invoke()));
        if (options.isEmpty()) {
            show$render($status, "Önce kanal listesini güncelleyin");
            return;
        }
        final Set selected = CollectionsKt.toMutableSet((Iterable) $selectedCountries.invoke());
        if (selected.isEmpty()) {
            selected.addAll(options);
        }
        int size = options.size();
        boolean[] checkedItems = new boolean[size];
        for (int r5 = 0; r5 < size; r5++) {
            checkedItems[r5] = selected.isEmpty() || selected.contains(options.get(r5));
        }
        List $this$toTypedArray$iv = options;
        new AlertDialog.Builder($context).setTitle("Gösterilecek ülkeler").setMultiChoiceItems((CharSequence[]) $this$toTypedArray$iv.toArray(new String[0]), checkedItems, new DialogInterface.OnMultiChoiceClickListener() { // from class: turkspor.common.SourceSettings$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int r4, boolean z) {
                SourceSettings.show$lambda$8$0(selected, options, dialogInterface, r4, z);
            }
        }).setNeutralButton("Tümü", new DialogInterface.OnClickListener() { // from class: turkspor.common.SourceSettings$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int r4) {
                SourceSettings.show$lambda$8$1($setCountries, $status, dialogInterface, r4);
            }
        }).setPositiveButton("Uygula", new DialogInterface.OnClickListener() { // from class: turkspor.common.SourceSettings$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int r8) {
                SourceSettings.show$lambda$8$2($setCountries, selected, options, $status, dialogInterface, r8);
            }
        }).setNegativeButton("Vazgeç", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$8$0(Set $selected, List $options, DialogInterface dialogInterface, int which, boolean isChecked) {
        Object obj = $options.get(which);
        if (isChecked) {
            $selected.add(obj);
        } else {
            $selected.remove(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$8$1(Function1 $setCountries, TextView $status, DialogInterface dialogInterface, int r3) {
        $setCountries.invoke(SetsKt.emptySet());
        show$render($status, "✓ Tüm ülkeler");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$8$2(Function1 $setCountries, Set $selected, List $options, TextView $status, DialogInterface dialogInterface, int r5) {
        $setCountries.invoke($selected.size() == $options.size() ? SetsKt.emptySet() : $selected);
        show$render($status, "✓ Ülke filtresi kaydedildi");
    }

    static final void show$lambda$9(Context $context, View it) {
        Intent launch = $context.getPackageManager().getLaunchIntentForPackage("com.cloudflare.onedotonedotonedotone");
        if (launch == null) {
            launch = new Intent("android.intent.action.VIEW", Uri.parse("https://one.one.one.one/"));
        }
        SourceSettings sourceSettings = INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            $context.startActivity(launch.addFlags(268435456));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$action(Function0<String> function0, Function0<Long> function1, MaterialButton refresh, ProgressBar progress, CoroutineScope scope, TextView status, Function2<? super String, ? super Continuation<? super Integer>, ? extends Object> function2) {
        String before = (String) function0.invoke();
        boolean previouslyChecked = ((Number) function1.invoke()).longValue() > 0;
        refresh.setEnabled(false);
        progress.setVisibility(0);
        show$render(status, "Kontrol ediliyor…");
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new SourceSettings$show$action$1(previouslyChecked, function0, before, refresh, progress, function2, status, null), 3, (Object) null);
    }
}
