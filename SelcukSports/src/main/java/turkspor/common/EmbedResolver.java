package turkspor.common;

import android.util.Base64;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002JN\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u000fH\u0086@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002J,\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lturkspor/common/EmbedResolver;", "", "<init>", "()V", "UA", "", "absolute", "base", "value", "emit", "", "label", "start", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "origin", "url", "scriptStreams", "", "body", "decodeUrlBase64", "daddyLink", "Lkotlin/Pair;", "pageUrl", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAuthorizedSportsProviders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AuthorizedSportsProviders.kt\nturkspor/common/EmbedResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,403:1\n1#2:404\n1#2:420\n1#2:439\n1#2:461\n1#2:477\n2068#3,2:405\n2068#3,2:407\n1795#3,10:409\n2068#3:419\n2069#3:421\n1805#3:422\n777#3:423\n873#3,2:424\n2068#3,2:426\n1795#3,10:428\n2068#3:438\n2069#3:440\n1805#3:441\n832#3:442\n862#3:443\n1960#3,3:444\n863#3:447\n2068#3,2:448\n1795#3,10:450\n2068#3:460\n2069#3:462\n1805#3:463\n2068#3,2:464\n1795#3,10:466\n2068#3:476\n2069#3:478\n1805#3:479\n2068#3,2:480\n1960#3,3:493\n1505#4,2:482\n1505#4,2:484\n835#4:486\n919#4,4:487\n1505#4,2:491\n*S KotlinDebug\n*F\n+ 1 AuthorizedSportsProviders.kt\nturkspor/common/EmbedResolver\n*L\n71#1:420\n81#1:439\n88#1:461\n90#1:477\n40#1:405,2\n54#1:407,2\n71#1:409,10\n71#1:419\n71#1:421\n71#1:422\n72#1:423\n72#1:424,2\n73#1:426,2\n81#1:428,10\n81#1:438\n81#1:440\n81#1:441\n82#1:442\n82#1:443\n84#1:444,3\n82#1:447\n86#1:448,2\n88#1:450,10\n88#1:460\n88#1:462\n88#1:463\n89#1:464,2\n90#1:466,10\n90#1:476\n90#1:478\n90#1:479\n91#1:480,2\n135#1:493,3\n102#1:482,2\n105#1:484,2\n107#1:486\n107#1:487,4\n109#1:491,2\n*E\n"})
public final class EmbedResolver {

    @NotNull
    public static final EmbedResolver INSTANCE = new EmbedResolver();

    @NotNull
    private static final String UA = "Mozilla/5.0 (Linux; Android 15) AppleWebKit/537.36 Chrome/139 Mobile Safari/537.36";

    /* JADX INFO: renamed from: turkspor.common.EmbedResolver$daddyLink$1, reason: invalid class name */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.EmbedResolver", f = "AuthorizedSportsProviders.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {136, 139}, m = "daddyLink", n = {"pageUrl", "body", "encoded", "bundle", "channel", "server", "params", "authHosts", "$this$any$iv", "element$iv", "host", "$this$daddyLink_u24lambda_u240_u240", "pageUrl", "body", "encoded", "bundle", "channel", "server", "params", "authHosts", "authorized"}, nl = {135, 140}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EmbedResolver.this.daddyLink(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: turkspor.common.EmbedResolver$emit$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.EmbedResolver", f = "AuthorizedSportsProviders.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {34, 35, 40, 47, 55, 62, 63, 74}, m = "emit", n = {"label", "start", "referer", "subtitleCallback", "callback", "queue", "seen", "found", "url", "ref", "label", "start", "referer", "subtitleCallback", "callback", "queue", "seen", "found", "url", "ref", "label", "start", "referer", "subtitleCallback", "callback", "queue", "seen", "found", "url", "ref", "response", "body", "headers", "label", "start", "referer", "subtitleCallback", "callback", "queue", "seen", "found", "url", "ref", "response", "body", "direct", "hls", "label", "start", "referer", "subtitleCallback", "callback", "queue", "seen", "found", "url", "ref", "response", "body", "direct", "$this$forEach$iv", "element$iv", "hls", "label", "start", "referer", "subtitleCallback", "callback", "queue", "seen", "found", "url", "ref", "response", "body", "direct", "label", "start", "referer", "subtitleCallback", "callback", "queue", "seen", "found", "url", "ref", "response", "body", "direct", "hls", "label", "start", "referer", "subtitleCallback", "callback", "queue", "seen", "found", "url", "ref", "response", "body", "direct", "doc", "$this$forEach$iv", "element$iv", "media"}, nl = {35, 36, 404, 52, 60, 63, 68, 79}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EmbedResolver.this.emit(null, null, null, null, null, (Continuation) this);
        }
    }

    private EmbedResolver() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String absolute(String base, String value) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            EmbedResolver embedResolver = this;
            String clean = StringsKt.trim(StringsKt.replace$default(StringsKt.replace$default(value, "\\/", "/", false, 4, (Object) null), "&amp;", "&", false, 4, (Object) null)).toString();
            try {
                obj = Result.constructor-impl(new URI(base).resolve(StringsKt.startsWith$default(clean, "//", false, 2, (Object) null) ? "https:" + clean : clean).toString());
            } catch (Throwable th) {
                th = th;
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String it = (String) obj;
        if (it == null || !StringsKt.startsWith$default(it, "https://", false, 2, (Object) null)) {
            return null;
        }
        return it;
    }

    /* JADX WARN: Code duplicated, block: B:467:0x16a5 A[LOOP:1: B:57:0x04e1->B:467:0x16a5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:555:0x0510 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:61:0x04f4  */
    /* JADX WARN: Code duplicated, block: B:67:0x054a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:68:0x054b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x03b2: MOVE (r13 I:??[OBJECT, ARRAY] A[D('seen' java.util.Set)]) = (r12 I:??[OBJECT, ARRAY] A[D('found' kotlin.jvm.internal.Ref$BooleanRef)]), block:B:43:0x03b1 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x03d3: MOVE (r7 I:??[OBJECT, ARRAY] A[D('ref' java.lang.String)]) = (r12 I:??[OBJECT, ARRAY] A[D('found' kotlin.jvm.internal.Ref$BooleanRef)]), block:B:45:0x03d1 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0487: MOVE (r22 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY] A[D('queue' kotlin.collections.ArrayDeque)]), block:B:53:0x0479 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x049d: MOVE (r22 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY] A[D('queue' kotlin.collections.ArrayDeque)]), block:B:55:0x049d */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0328: MOVE (r1 I:??[OBJECT, ARRAY] A[D('label' java.lang.String)]) = (r13 I:??[OBJECT, ARRAY] A[D('ref' java.lang.String)]), block:B:36:0x0319 */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x03b1: MOVE (r6 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY] A[D('seen' java.util.Set)]), block:B:43:0x03b1 */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x03d1: MOVE (r6 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY] A[D('seen' java.util.Set)]), block:B:45:0x03d1 */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0494: MOVE (r6 I:??[OBJECT, ARRAY] A[D('url' java.lang.String)]) = (r13 I:??[OBJECT, ARRAY] A[D('callback' kotlin.jvm.functions.Function1)]), block:B:53:0x0479 */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x04a6: MOVE (r6 I:??[OBJECT, ARRAY] A[D('url' java.lang.String)]) = (r13 I:??[OBJECT, ARRAY] A[D('callback' kotlin.jvm.functions.Function1)]), block:B:55:0x049d */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0331: MOVE (r22 I:??[OBJECT, ARRAY] A[D('queue' kotlin.collections.ArrayDeque)]) = (r14 I:??[OBJECT, ARRAY] A[D('url' java.lang.String)]), block:B:36:0x0319 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x034c: MOVE (r22 I:??[OBJECT, ARRAY] A[D('queue' kotlin.collections.ArrayDeque)]) = (r14 I:??[OBJECT, ARRAY] A[D('url' java.lang.String)]), block:B:38:0x033b */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x03c2: MOVE (r8 I:??[OBJECT, ARRAY] A[D('url' java.lang.String)]) = (r14 I:??[OBJECT, ARRAY] A[D('queue' kotlin.collections.ArrayDeque)]), block:B:43:0x03b1 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x03df: MOVE (r8 I:??[OBJECT, ARRAY] A[D('url' java.lang.String)]) = (r14 I:??[OBJECT, ARRAY] A[D('queue' kotlin.collections.ArrayDeque)]), block:B:45:0x03d1 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x047e: MOVE (r5 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY] A[D('subtitleCallback' kotlin.jvm.functions.Function1)]), block:B:53:0x0479 */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0329: MOVE (r13 I:??[OBJECT, ARRAY] A[D('ref' java.lang.String)]) = (r15 I:??[OBJECT, ARRAY] A[D('found' kotlin.jvm.internal.Ref$BooleanRef)]), block:B:36:0x0319 */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0345: MOVE (r7 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('found' kotlin.jvm.internal.Ref$BooleanRef)]), block:B:38:0x033b */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x03c3: MOVE (r6 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('callback' kotlin.jvm.functions.Function1)]), block:B:43:0x03b1 */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x03e0: MOVE (r6 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('callback' kotlin.jvm.functions.Function1)]), block:B:45:0x03d1 */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0482: MOVE (r22 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('referer' java.lang.String)]), block:B:53:0x0479 */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x04a7: MOVE (r27 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('referer' java.lang.String)]), block:B:55:0x049d */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0479: MOVE (r22 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY] A[D('start' java.lang.String)]), block:B:53:0x0479 */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x04ac: MOVE (r1 I:??[OBJECT, ARRAY] A[D('ref' java.lang.String)]) = (r16 I:??[OBJECT, ARRAY] A[D('start' java.lang.String)]), block:B:55:0x049d */
    /* JADX WARN: Not initialized variable reg: 21, insn: 0x032a: MOVE (r12 I:??[OBJECT, ARRAY]) = (r21 I:??[OBJECT, ARRAY] A[D('seen' java.util.Set)]), block:B:36:0x0319 */
    /* JADX WARN: Not initialized variable reg: 21, insn: 0x0346: MOVE (r12 I:??[OBJECT, ARRAY]) = (r21 I:??[OBJECT, ARRAY] A[D('seen' java.util.Set)]), block:B:38:0x033b */
    /* JADX WARN: Not initialized variable reg: 21, insn: 0x0495: MOVE (r35 I:??[OBJECT, ARRAY]) = (r21 I:??[OBJECT, ARRAY] A[D('label' java.lang.String)]), block:B:53:0x0479 */
    /* JADX WARN: Not initialized variable reg: 21, insn: 0x04a9: MOVE (r35 I:??[OBJECT, ARRAY]) = (r21 I:??[OBJECT, ARRAY] A[D('label' java.lang.String)]), block:B:55:0x049d */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x032c: MOVE (r8 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY] A[D('queue' kotlin.collections.ArrayDeque)]), block:B:36:0x0319 */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x0348: MOVE (r8 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY] A[D('queue' kotlin.collections.ArrayDeque)]), block:B:38:0x033b */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x048c: MOVE (r22 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY] A[D('url' java.lang.String)]), block:B:53:0x0479 */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x04a4: MOVE (r22 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY] A[D('url' java.lang.String)]), block:B:55:0x049d */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x03b9: MOVE (r1 I:??[OBJECT, ARRAY] A[D('label' java.lang.String)]) = (r7 I:??[OBJECT, ARRAY] A[D('ref' java.lang.String)]), block:B:43:0x03b1 */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x03d2: MOVE (r13 I:??[OBJECT, ARRAY] A[D('seen' java.util.Set)]) = (r7 I:??[OBJECT, ARRAY] A[D('ref' java.lang.String)]), block:B:45:0x03d1 */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0497: MOVE (r13 I:??[OBJECT, ARRAY] A[D('callback' kotlin.jvm.functions.Function1)]) = (r7 I:??[OBJECT, ARRAY] A[D('found' kotlin.jvm.internal.Ref$BooleanRef)]), block:B:53:0x0479 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x03ba: MOVE (r22 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY] A[D('url' java.lang.String)]), block:B:43:0x03b1 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x03dd: MOVE (r22 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY] A[D('url' java.lang.String)]), block:B:45:0x03d1 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0489: MOVE (r12 I:??[OBJECT, ARRAY] A[D('queue' kotlin.collections.ArrayDeque)]) = (r8 I:??[OBJECT, ARRAY] A[D('seen' java.util.Set)]), block:B:53:0x0479 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x049f: MOVE (r12 I:??[OBJECT, ARRAY] A[D('queue' kotlin.collections.ArrayDeque)]) = (r8 I:??[OBJECT, ARRAY] A[D('seen' java.util.Set)]), block:B:55:0x049d */
    /* JADX WARN: Type inference failed for: r18v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v117 */
    /* JADX WARN: Type inference failed for: r1v128 */
    /* JADX WARN: Type inference failed for: r1v129, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v145 */
    /* JADX WARN: Type inference failed for: r1v146 */
    /* JADX WARN: Type inference failed for: r1v147, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v155 */
    /* JADX WARN: Type inference failed for: r1v181 */
    /* JADX WARN: Type inference failed for: r1v218 */
    /* JADX WARN: Type inference failed for: r1v223 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v335 */
    /* JADX WARN: Type inference failed for: r1v336 */
    /* JADX WARN: Type inference failed for: r1v337 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v62 */
    /* JADX WARN: Type inference failed for: r1v68 */
    /* JADX WARN: Type inference failed for: r1v72 */
    /* JADX WARN: Type inference failed for: r21v20 */
    /* JADX WARN: Type inference failed for: r21v21 */
    /* JADX WARN: Type inference failed for: r21v22 */
    /* JADX WARN: Type inference failed for: r21v23 */
    /* JADX WARN: Type inference failed for: r21v24 */
    /* JADX WARN: Type inference failed for: r21v25 */
    /* JADX WARN: Type inference failed for: r25v46, types: [turkspor.common.HlsQuality] */
    /* JADX WARN: Type inference failed for: r26v0 */
    /* JADX WARN: Type inference failed for: r26v10 */
    /* JADX WARN: Type inference failed for: r26v11 */
    /* JADX WARN: Type inference failed for: r26v13 */
    /* JADX WARN: Type inference failed for: r26v14 */
    /* JADX WARN: Type inference failed for: r26v19 */
    /* JADX WARN: Type inference failed for: r26v20 */
    /* JADX WARN: Type inference failed for: r26v21 */
    /* JADX WARN: Type inference failed for: r26v22 */
    /* JADX WARN: Type inference failed for: r26v23 */
    /* JADX WARN: Type inference failed for: r26v24 */
    /* JADX WARN: Type inference failed for: r26v25 */
    /* JADX WARN: Type inference failed for: r26v26 */
    /* JADX WARN: Type inference failed for: r26v27 */
    /* JADX WARN: Type inference failed for: r26v28 */
    /* JADX WARN: Type inference failed for: r26v29 */
    /* JADX WARN: Type inference failed for: r26v30 */
    /* JADX WARN: Type inference failed for: r26v31 */
    /* JADX WARN: Type inference failed for: r26v32, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r26v33 */
    /* JADX WARN: Type inference failed for: r26v34 */
    /* JADX WARN: Type inference failed for: r26v45 */
    /* JADX WARN: Type inference failed for: r26v51 */
    /* JADX WARN: Type inference failed for: r26v8 */
    /* JADX WARN: Type inference failed for: r26v9 */
    /* JADX WARN: Type inference failed for: r27v26, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v104 */
    /* JADX WARN: Type inference failed for: r2v125 */
    /* JADX WARN: Type inference failed for: r2v126 */
    /* JADX WARN: Type inference failed for: r2v138 */
    /* JADX WARN: Type inference failed for: r2v51, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v80, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v98, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r35v0 */
    /* JADX WARN: Type inference failed for: r35v10 */
    /* JADX WARN: Type inference failed for: r35v100 */
    /* JADX WARN: Type inference failed for: r35v101 */
    /* JADX WARN: Type inference failed for: r35v102 */
    /* JADX WARN: Type inference failed for: r35v103 */
    /* JADX WARN: Type inference failed for: r35v104 */
    /* JADX WARN: Type inference failed for: r35v11 */
    /* JADX WARN: Type inference failed for: r35v12 */
    /* JADX WARN: Type inference failed for: r35v13 */
    /* JADX WARN: Type inference failed for: r35v15 */
    /* JADX WARN: Type inference failed for: r35v16 */
    /* JADX WARN: Type inference failed for: r35v17 */
    /* JADX WARN: Type inference failed for: r35v18 */
    /* JADX WARN: Type inference failed for: r35v19 */
    /* JADX WARN: Type inference failed for: r35v2 */
    /* JADX WARN: Type inference failed for: r35v21 */
    /* JADX WARN: Type inference failed for: r35v23 */
    /* JADX WARN: Type inference failed for: r35v26 */
    /* JADX WARN: Type inference failed for: r35v27 */
    /* JADX WARN: Type inference failed for: r35v28 */
    /* JADX WARN: Type inference failed for: r35v29 */
    /* JADX WARN: Type inference failed for: r35v30 */
    /* JADX WARN: Type inference failed for: r35v31 */
    /* JADX WARN: Type inference failed for: r35v32 */
    /* JADX WARN: Type inference failed for: r35v35 */
    /* JADX WARN: Type inference failed for: r35v38 */
    /* JADX WARN: Type inference failed for: r35v4 */
    /* JADX WARN: Type inference failed for: r35v40 */
    /* JADX WARN: Type inference failed for: r35v41 */
    /* JADX WARN: Type inference failed for: r35v42 */
    /* JADX WARN: Type inference failed for: r35v44 */
    /* JADX WARN: Type inference failed for: r35v46 */
    /* JADX WARN: Type inference failed for: r35v48 */
    /* JADX WARN: Type inference failed for: r35v50 */
    /* JADX WARN: Type inference failed for: r35v52 */
    /* JADX WARN: Type inference failed for: r35v54 */
    /* JADX WARN: Type inference failed for: r35v56 */
    /* JADX WARN: Type inference failed for: r35v58 */
    /* JADX WARN: Type inference failed for: r35v6 */
    /* JADX WARN: Type inference failed for: r35v60 */
    /* JADX WARN: Type inference failed for: r35v62 */
    /* JADX WARN: Type inference failed for: r35v64 */
    /* JADX WARN: Type inference failed for: r35v66 */
    /* JADX WARN: Type inference failed for: r35v69 */
    /* JADX WARN: Type inference failed for: r35v7 */
    /* JADX WARN: Type inference failed for: r35v71 */
    /* JADX WARN: Type inference failed for: r35v73 */
    /* JADX WARN: Type inference failed for: r35v75 */
    /* JADX WARN: Type inference failed for: r35v77 */
    /* JADX WARN: Type inference failed for: r35v78 */
    /* JADX WARN: Type inference failed for: r35v79 */
    /* JADX WARN: Type inference failed for: r35v8 */
    /* JADX WARN: Type inference failed for: r35v80 */
    /* JADX WARN: Type inference failed for: r35v81 */
    /* JADX WARN: Type inference failed for: r35v83 */
    /* JADX WARN: Type inference failed for: r35v85 */
    /* JADX WARN: Type inference failed for: r35v86 */
    /* JADX WARN: Type inference failed for: r35v87 */
    /* JADX WARN: Type inference failed for: r35v88 */
    /* JADX WARN: Type inference failed for: r35v89 */
    /* JADX WARN: Type inference failed for: r35v9 */
    /* JADX WARN: Type inference failed for: r35v90, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r35v91 */
    /* JADX WARN: Type inference failed for: r35v92 */
    /* JADX WARN: Type inference failed for: r35v93 */
    /* JADX WARN: Type inference failed for: r35v94 */
    /* JADX WARN: Type inference failed for: r35v96 */
    /* JADX WARN: Type inference failed for: r35v97 */
    /* JADX WARN: Type inference failed for: r35v98 */
    /* JADX WARN: Type inference failed for: r35v99 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v150 */
    /* JADX WARN: Type inference failed for: r3v152 */
    /* JADX WARN: Type inference failed for: r3v153 */
    /* JADX WARN: Type inference failed for: r3v154 */
    /* JADX WARN: Type inference failed for: r3v157 */
    /* JADX WARN: Type inference failed for: r3v158 */
    /* JADX WARN: Type inference failed for: r3v159 */
    /* JADX WARN: Type inference failed for: r3v160 */
    /* JADX WARN: Type inference failed for: r3v161 */
    /* JADX WARN: Type inference failed for: r3v162 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v52, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v66 */
    /* JADX WARN: Type inference failed for: r3v69 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v84 */
    /* JADX WARN: Type inference failed for: r43v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r43v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r43v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r44v5 */
    /* JADX WARN: Type inference failed for: r44v6 */
    /* JADX WARN: Type inference failed for: r44v7 */
    /* JADX WARN: Type inference failed for: r44v8 */
    /* JADX WARN: Type inference failed for: r44v9 */
    /* JADX WARN: Type inference failed for: r8v63, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v23, types: [java.lang.String] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:110:0x06d5 -> B:57:0x04e1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:146:0x08b6 -> B:510:0x0829). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:182:0x0a4f -> B:478:0x09b1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:273:0x0dd9 -> B:532:0x0ded). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:282:0x0e79 -> B:543:0x0e98). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:436:0x14e1 -> B:57:0x04e1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:463:0x1687 -> B:57:0x04e1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object emit(@org.jetbrains.annotations.NotNull java.lang.String r43, @org.jetbrains.annotations.NotNull java.lang.String r44, @org.jetbrains.annotations.NotNull java.lang.String r45, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r46, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r47, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r48) {
        /*
            Method dump skipped, instruction units count: 5862
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: turkspor.common.EmbedResolver.emit(java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: turkspor.common.EmbedResolver$emit$2, reason: invalid class name */
    /* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.common.EmbedResolver$emit$2", f = "AuthorizedSportsProviders.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ NiceResponse $response;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(NiceResponse niceResponse, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$response = niceResponse;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.$response, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
            return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newExtractorLink.setReferer(this.$response.getUrl());
                    $this$newExtractorLink.setHeaders(MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", EmbedResolver.UA), TuplesKt.to("Origin", EmbedResolver.INSTANCE.origin(this.$response.getUrl()))}));
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String origin(String url) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            EmbedResolver embedResolver = this;
            URI it = new URI(url);
            obj = Result.constructor-impl(it.getScheme() + "://" + it.getAuthority());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = url;
        }
        return (String) obj;
    }

    private final List<String> scriptStreams(String body) {
        Set result = new LinkedHashSet();
        Sequence $this$forEach$iv = SequencesKt.map(Regex.findAll$default(new Regex("(?:streamUrl|file|source)\\s*:\\s*[\\\"'](https?:[^\\\"']+\\.m3u8[^\\\"']*)", RegexOption.IGNORE_CASE), body, 0, 2, (Object) null), new Function1() { // from class: turkspor.common.EmbedResolver$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return StringsKt.replace$default((String) ((MatchResult) obj).getGroupValues().get(1), "\\/", "/", false, 4, (Object) null);
            }
        });
        for (Object element$iv : $this$forEach$iv) {
            String p0 = (String) element$iv;
            result.add(p0);
        }
        Sequence $this$forEach$iv2 = SequencesKt.filter(SequencesKt.mapNotNull(Regex.findAll$default(new Regex("(?:source\\s*:\\s*)?window\\.atob\\([\\\"']([^\\\"']+)[\\\"']\\)", RegexOption.IGNORE_CASE), body, 0, 2, (Object) null), new Function1() { // from class: turkspor.common.EmbedResolver$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return EmbedResolver.scriptStreams$lambda$1((MatchResult) obj);
            }
        }), new Function1() { // from class: turkspor.common.EmbedResolver$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return Boolean.valueOf(EmbedResolver.scriptStreams$lambda$2((String) obj));
            }
        });
        for (Object element$iv2 : $this$forEach$iv2) {
            String p1 = (String) element$iv2;
            result.add(p1);
        }
        Sequence $this$associate$iv = Regex.findAll$default(new Regex("var\\s+([A-Za-z_$][\\w$]*)\\s*=\\s*[\\\"']([A-Za-z0-9_\\-+/=]{4,})[\\\"']"), body, 0, 2, (Object) null);
        final Map destination$iv$iv = new LinkedHashMap();
        for (Object element$iv$iv : $this$associate$iv) {
            MatchResult it = (MatchResult) element$iv$iv;
            Pair pair = TuplesKt.to(it.getGroupValues().get(1), it.getGroupValues().get(2));
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        Sequence $this$forEach$iv3 = Regex.findAll$default(new Regex("var\\s+[A-Za-z_$][\\w$]*\\s*=\\s*((?:[A-Za-z_$][\\w$]*\\([A-Za-z_$][\\w$]*\\)\\s*\\+?\\s*){2,})"), body, 0, 2, (Object) null);
        for (Object element$iv3 : $this$forEach$iv3) {
            MatchResult assignment = (MatchResult) element$iv3;
            String joined = SequencesKt.joinToString$default(SequencesKt.mapNotNull(SequencesKt.mapNotNull(Regex.findAll$default(new Regex("[A-Za-z_$][\\w$]*\\(([A-Za-z_$][\\w$]*)\\)"), (CharSequence) assignment.getGroupValues().get(1), 0, 2, (Object) null), new Function1() { // from class: turkspor.common.EmbedResolver$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    return EmbedResolver.scriptStreams$lambda$5$0(destination$iv$iv, (MatchResult) obj);
                }
            }), new EmbedResolver$scriptStreams$6$joined$2(INSTANCE)), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            if (StringsKt.startsWith$default(joined, "https://", false, 2, (Object) null) && StringsKt.contains$default(joined, ".m3u8", false, 2, (Object) null)) {
                result.add(joined);
            }
        }
        return CollectionsKt.toList(result);
    }

    static final String scriptStreams$lambda$1(MatchResult it) {
        Object obj;
        EmbedResolver embedResolver = INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(MainAPIKt.base64Decode((String) it.getGroupValues().get(1)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    static final boolean scriptStreams$lambda$2(String it) {
        return StringsKt.startsWith$default(it, "https://", false, 2, (Object) null) && StringsKt.contains$default(it, ".m3u8", false, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String scriptStreams$lambda$5$0(Map $vars, MatchResult it) {
        return (String) $vars.get(it.getGroupValues().get(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String decodeUrlBase64(String value) {
        Throwable th;
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            EmbedResolver embedResolver = this;
            try {
                String padded = StringsKt.padEnd(StringsKt.replace$default(StringsKt.replace$default(value, '-', '+', false, 4, (Object) null), '_', '/', false, 4, (Object) null), ((value.length() + 3) / 4) * 4, '=');
                obj = Result.constructor-impl(new String(Base64.decode(padded, 0), Charsets.UTF_8));
            } catch (Throwable th2) {
                th = th2;
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
        } catch (Throwable th3) {
            th = th3;
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:45:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:50:0x0283 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x0284  */
    /* JADX WARN: Code duplicated, block: B:54:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:55:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:67:0x0312  */
    /* JADX WARN: Code duplicated, block: B:70:0x031c  */
    /* JADX WARN: Code duplicated, block: B:71:0x0326  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0284 -> B:100:0x029d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x02f0 -> B:65:0x0306). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object daddyLink(java.lang.String r46, java.lang.String r47, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.String, java.lang.String>> r48) {
        /*
            Method dump skipped, instruction units count: 1166
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: turkspor.common.EmbedResolver.daddyLink(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
