package turkspor.common;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
final /* synthetic */ class EmbedResolver$scriptStreams$6$joined$2 extends FunctionReferenceImpl implements Function1<String, String> {
    EmbedResolver$scriptStreams$6$joined$2(Object obj) {
        super(1, obj, EmbedResolver.class, "decodeUrlBase64", "decodeUrlBase64(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    public final String invoke(String p0) {
        return ((EmbedResolver) this.receiver).decodeUrlBase64(p0);
    }
}
