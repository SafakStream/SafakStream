package turkspor;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DomainResolver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lturkspor/SiteSnapshot;", "", "url", "", "channels", "", "Lturkspor/SportsChannel;", "checkedAt", "", "<init>", "(Ljava/lang/String;Ljava/util/List;J)V", "getUrl", "()Ljava/lang/String;", "getChannels", "()Ljava/util/List;", "getCheckedAt", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SiteSnapshot {

    @NotNull
    private final List<SportsChannel> channels;
    private final long checkedAt;

    @NotNull
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SiteSnapshot copy$default(SiteSnapshot siteSnapshot, String str, List list, long j, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = siteSnapshot.url;
        }
        if ((r5 & 2) != 0) {
            list = siteSnapshot.channels;
        }
        if ((r5 & 4) != 0) {
            j = siteSnapshot.checkedAt;
        }
        return siteSnapshot.copy(str, list, j);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final List<SportsChannel> component2() {
        return this.channels;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getCheckedAt() {
        return this.checkedAt;
    }

    @NotNull
    public final SiteSnapshot copy(@NotNull String url, @NotNull List<SportsChannel> channels, long checkedAt) {
        return new SiteSnapshot(url, channels, checkedAt);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SiteSnapshot)) {
            return false;
        }
        SiteSnapshot siteSnapshot = (SiteSnapshot) other;
        return Intrinsics.areEqual(this.url, siteSnapshot.url) && Intrinsics.areEqual(this.channels, siteSnapshot.channels) && this.checkedAt == siteSnapshot.checkedAt;
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + this.channels.hashCode()) * 31) + SiteSnapshot$$ExternalSyntheticBackport0.m(this.checkedAt);
    }

    @NotNull
    public String toString() {
        return "SiteSnapshot(url=" + this.url + ", channels=" + this.channels + ", checkedAt=" + this.checkedAt + ')';
    }

    public SiteSnapshot(@NotNull String url, @NotNull List<SportsChannel> list, long checkedAt) {
        this.url = url;
        this.channels = list;
        this.checkedAt = checkedAt;
    }

    @NotNull
    public final List<SportsChannel> getChannels() {
        return this.channels;
    }

    public final long getCheckedAt() {
        return this.checkedAt;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }
}
