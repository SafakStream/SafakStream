package turkspor.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lturkspor/common/WebEvent;", "", "title", "", "url", "category", "poster", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getUrl", "getCategory", "getPoster", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class WebEvent {

    @NotNull
    private final String category;

    @Nullable
    private final String poster;

    @NotNull
    private final String title;

    @NotNull
    private final String url;

    public static /* synthetic */ WebEvent copy$default(WebEvent webEvent, String str, String str2, String str3, String str4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = webEvent.title;
        }
        if ((r5 & 2) != 0) {
            str2 = webEvent.url;
        }
        if ((r5 & 4) != 0) {
            str3 = webEvent.category;
        }
        if ((r5 & 8) != 0) {
            str4 = webEvent.poster;
        }
        return webEvent.copy(str, str2, str3, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPoster() {
        return this.poster;
    }

    @NotNull
    public final WebEvent copy(@NotNull String title, @NotNull String url, @NotNull String category, @Nullable String poster) {
        return new WebEvent(title, url, category, poster);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebEvent)) {
            return false;
        }
        WebEvent webEvent = (WebEvent) other;
        return Intrinsics.areEqual(this.title, webEvent.title) && Intrinsics.areEqual(this.url, webEvent.url) && Intrinsics.areEqual(this.category, webEvent.category) && Intrinsics.areEqual(this.poster, webEvent.poster);
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.url.hashCode()) * 31) + this.category.hashCode()) * 31) + (this.poster == null ? 0 : this.poster.hashCode());
    }

    @NotNull
    public String toString() {
        return "WebEvent(title=" + this.title + ", url=" + this.url + ", category=" + this.category + ", poster=" + this.poster + ')';
    }

    public WebEvent(@NotNull String title, @NotNull String url, @NotNull String category, @Nullable String poster) {
        this.title = title;
        this.url = url;
        this.category = category;
        this.poster = poster;
    }

    public /* synthetic */ WebEvent(String str, String str2, String str3, String str4, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (r5 & 4) != 0 ? "Canlı" : str3, (r5 & 8) != 0 ? null : str4);
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final String getPoster() {
        return this.poster;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }
}
