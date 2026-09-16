package turkspor.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HlsQuality.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lturkspor/common/HlsVariant;", "", "url", "", "height", "", "bandwidth", "", "<init>", "(Ljava/lang/String;IJ)V", "getUrl", "()Ljava/lang/String;", "getHeight", "()I", "getBandwidth", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class HlsVariant {
    private final long bandwidth;
    private final int height;

    @NotNull
    private final String url;

    public static /* synthetic */ HlsVariant copy$default(HlsVariant hlsVariant, String str, int r2, long j, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = hlsVariant.url;
        }
        if ((r5 & 2) != 0) {
            r2 = hlsVariant.height;
        }
        if ((r5 & 4) != 0) {
            j = hlsVariant.bandwidth;
        }
        return hlsVariant.copy(str, r2, j);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getBandwidth() {
        return this.bandwidth;
    }

    @NotNull
    public final HlsVariant copy(@NotNull String url, int height, long bandwidth) {
        return new HlsVariant(url, height, bandwidth);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HlsVariant)) {
            return false;
        }
        HlsVariant hlsVariant = (HlsVariant) other;
        return Intrinsics.areEqual(this.url, hlsVariant.url) && this.height == hlsVariant.height && this.bandwidth == hlsVariant.bandwidth;
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + this.height) * 31) + HlsVariant$$ExternalSyntheticBackport0.m(this.bandwidth);
    }

    @NotNull
    public String toString() {
        return "HlsVariant(url=" + this.url + ", height=" + this.height + ", bandwidth=" + this.bandwidth + ')';
    }

    public HlsVariant(@NotNull String url, int height, long bandwidth) {
        this.url = url;
        this.height = height;
        this.bandwidth = bandwidth;
    }

    public /* synthetic */ HlsVariant(String str, int r2, long j, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, r2, (r5 & 4) != 0 ? 0L : j);
    }

    public final long getBandwidth() {
        return this.bandwidth;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }
}
