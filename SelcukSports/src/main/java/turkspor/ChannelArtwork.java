package turkspor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.net.Uri;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ChannelArtwork.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0086@¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lturkspor/ChannelArtwork;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "directory", "Ljava/io/File;", "semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "file", "channel", "Lturkspor/SportsChannel;", "poster", "", "prepare", "", "", "channels", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "render", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChannelArtwork.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelArtwork.kt\nturkspor/ChannelArtwork\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,69:1\n1#2:70\n*E\n"})
public final class ChannelArtwork {

    @NotNull
    private final File directory;

    @NotNull
    private final Semaphore semaphore;

    public ChannelArtwork(@NotNull Context context) {
        File $this$directory_u24lambda_u240 = new File(context.getCacheDir(), "turkspor_channel_cards_v1");
        $this$directory_u24lambda_u240.mkdirs();
        this.directory = $this$directory_u24lambda_u240;
        this.semaphore = SemaphoreKt.Semaphore$default(4, 0, 2, (Object) null);
    }

    private final File file(SportsChannel channel) {
        return new File(this.directory, channel.getId() + ".png");
    }

    @NotNull
    public final String poster(@NotNull SportsChannel channel) {
        return Uri.fromFile(file(channel)).toString();
    }

    /* JADX INFO: renamed from: turkspor.ChannelArtwork$prepare$2, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelArtwork.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "turkspor.ChannelArtwork$prepare$2", f = "ChannelArtwork.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, nl = {23}, s = {}, v = 2)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
        final /* synthetic */ List<SportsChannel> $channels;
        int label;
        final /* synthetic */ ChannelArtwork this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<SportsChannel> list, ChannelArtwork channelArtwork, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$channels = list;
            this.this$0 = channelArtwork;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$channels, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<Unit>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: turkspor.ChannelArtwork$prepare$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ChannelArtwork.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "turkspor.ChannelArtwork$prepare$2$1", f = "ChannelArtwork.kt", i = {0}, l = {22}, m = "invokeSuspend", n = {"$this$coroutineScope"}, nl = {-1}, s = {"L$0"}, v = 2)
        @SourceDebugExtension({"SMAP\nChannelArtwork.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelArtwork.kt\nturkspor/ChannelArtwork$prepare$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,69:1\n1849#2,8:70\n1739#2:78\n1814#2,3:79\n*S KotlinDebug\n*F\n+ 1 ChannelArtwork.kt\nturkspor/ChannelArtwork$prepare$2$1\n*L\n22#1:70,8\n22#1:78\n22#1:79,3\n*E\n"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
            final /* synthetic */ List<SportsChannel> $channels;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ChannelArtwork this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(List<SportsChannel> list, ChannelArtwork channelArtwork, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$channels = list;
                this.this$0 = channelArtwork;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$channels, this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<Unit>> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Iterable $this$distinctBy$iv = this.$channels;
                        HashSet set$iv = new HashSet();
                        ArrayList list$iv = new ArrayList();
                        for (Object e$iv : $this$distinctBy$iv) {
                            SportsChannel it = (SportsChannel) e$iv;
                            if (set$iv.add(it.getId())) {
                                list$iv.add(e$iv);
                            }
                        }
                        ArrayList $this$distinctBy$iv2 = list$iv;
                        ArrayList $this$map$iv = $this$distinctBy$iv2;
                        ChannelArtwork channelArtwork = this.this$0;
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            SportsChannel channel = (SportsChannel) item$iv$iv;
                            destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ChannelArtwork$prepare$2$1$2$1(channelArtwork, channel, null), 3, (Object) null));
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                        this.label = 1;
                        Object objAwaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                        return objAwaitAll == obj ? obj : objAwaitAll;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        public final Object invokeSuspend(Object $result) {
            Object obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(this.$channels, this.this$0, null), (Continuation) this);
                    if (objCoroutineScope == obj) {
                        return obj;
                    }
                    return objCoroutineScope;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Nullable
    public final Object prepare(@NotNull List<SportsChannel> list, @NotNull Continuation<? super List<Unit>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(list, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void render(SportsChannel channel) {
        Object obj;
        float f;
        float f2;
        File output = file(channel);
        if (!output.isFile() || System.currentTimeMillis() - output.lastModified() >= 86400000) {
            ChannelBranding.Brand brand = ChannelBranding.INSTANCE.forChannel(channel);
            try {
                Result.Companion companion = Result.Companion;
                ChannelArtwork channelArtwork = this;
                URLConnection uRLConnectionOpenConnection = new URL(brand.getLogo()).openConnection();
                Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                HttpURLConnection connection = (HttpURLConnection) uRLConnectionOpenConnection;
                connection.setConnectTimeout(4000);
                connection.setReadTimeout(4000);
                try {
                    InputStream inputStream = connection.getInputStream();
                    try {
                        InputStream it = inputStream;
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(it);
                        CloseableKt.closeFinally(inputStream, (Throwable) null);
                        connection.disconnect();
                        obj = Result.constructor-impl(bitmapDecodeStream);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(inputStream, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    connection.disconnect();
                    throw th3;
                }
            } catch (Throwable th4) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th4));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            Bitmap logo = (Bitmap) obj;
            Bitmap bitmap = Bitmap.createBitmap(640, 360, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawColor(Color.rgb(16, 22, 32));
            Paint paint = new Paint(3);
            paint.setColor(Color.rgb(248, 250, 252));
            canvas.drawRoundRect(new RectF(56.0f, 56.0f, 584.0f, 248.0f), 22.0f, 22.0f, paint);
            if (logo != null) {
                float scale = Math.min(464.0f / logo.getWidth(), 144.0f / logo.getHeight());
                float width = logo.getWidth() * scale;
                f = 1.0f;
                float height = logo.getHeight() * scale;
                f2 = 18.0f;
                canvas.drawBitmap(logo, (Rect) null, new RectF(320.0f - (width / 2.0f), 152.0f - (height / 2.0f), (width / 2.0f) + 320.0f, (height / 2.0f) + 152.0f), paint);
                logo.recycle();
            } else {
                f = 1.0f;
                f2 = 18.0f;
                paint.setColor(Color.rgb(30, 40, 60));
                paint.setTypeface(Typeface.create("sans-serif", 1));
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(38.0f);
                while (paint.measureText(brand.getTitle()) > 464.0f && paint.getTextSize() > 18.0f) {
                    paint.setTextSize(paint.getTextSize() - 1.0f);
                }
                canvas.drawText(brand.getTitle(), 320.0f, 166.0f, paint);
            }
            paint.setColor(-1);
            paint.setTypeface(Typeface.create("sans-serif", 1));
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(32.0f);
            while (paint.measureText(brand.getTitle()) > 520.0f && paint.getTextSize() > f2) {
                paint.setTextSize(paint.getTextSize() - f);
            }
            canvas.drawText(brand.getTitle(), 320.0f, 310.0f, paint);
            File temp = new File(this.directory, channel.getId() + '.' + Thread.currentThread().getId() + ".tmp");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(temp);
                try {
                    FileOutputStream it2 = fileOutputStream;
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, it2);
                    CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                    if (!temp.renameTo(output)) {
                        FilesKt.copyTo$default(temp, output, true, 0, 4, (Object) null);
                    }
                    temp.delete();
                    bitmap.recycle();
                } catch (Throwable th5) {
                    try {
                        throw th5;
                    } catch (Throwable th6) {
                        CloseableKt.closeFinally(fileOutputStream, th5);
                        throw th6;
                    }
                }
            } catch (Throwable th7) {
                temp.delete();
                bitmap.recycle();
                throw th7;
            }
        }
    }
}
