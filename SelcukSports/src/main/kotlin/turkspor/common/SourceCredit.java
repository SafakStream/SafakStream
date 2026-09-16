package turkspor.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SourceCredits.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lturkspor/common/SourceCredit;", "", "name", "", "url", "linkLabel", "thanks", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getUrl", "getLinkLabel", "getThanks", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SourceCredit {

    @NotNull
    private final String linkLabel;

    @NotNull
    private final String name;

    @NotNull
    private final String thanks;

    @Nullable
    private final String url;

    public static /* synthetic */ SourceCredit copy$default(SourceCredit sourceCredit, String str, String str2, String str3, String str4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = sourceCredit.name;
        }
        if ((r5 & 2) != 0) {
            str2 = sourceCredit.url;
        }
        if ((r5 & 4) != 0) {
            str3 = sourceCredit.linkLabel;
        }
        if ((r5 & 8) != 0) {
            str4 = sourceCredit.thanks;
        }
        return sourceCredit.copy(str, str2, str3, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLinkLabel() {
        return this.linkLabel;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getThanks() {
        return this.thanks;
    }

    @NotNull
    public final SourceCredit copy(@NotNull String name, @Nullable String url, @NotNull String linkLabel, @NotNull String thanks) {
        return new SourceCredit(name, url, linkLabel, thanks);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SourceCredit)) {
            return false;
        }
        SourceCredit sourceCredit = (SourceCredit) other;
        return Intrinsics.areEqual(this.name, sourceCredit.name) && Intrinsics.areEqual(this.url, sourceCredit.url) && Intrinsics.areEqual(this.linkLabel, sourceCredit.linkLabel) && Intrinsics.areEqual(this.thanks, sourceCredit.thanks);
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + this.linkLabel.hashCode()) * 31) + this.thanks.hashCode();
    }

    @NotNull
    public String toString() {
        return "SourceCredit(name=" + this.name + ", url=" + this.url + ", linkLabel=" + this.linkLabel + ", thanks=" + this.thanks + ')';
    }

    public SourceCredit(@NotNull String name, @Nullable String url, @NotNull String linkLabel, @NotNull String thanks) {
        this.name = name;
        this.url = url;
        this.linkLabel = linkLabel;
        this.thanks = thanks;
    }

    public /* synthetic */ SourceCredit(String str, String str2, String str3, String str4, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (r5 & 4) != 0 ? "Kaynak sitesini aç ↗" : str3, (r5 & 8) != 0 ? str + " ekibine emekleri ve kaynak paylaşımı için teşekkür ederiz." : str4);
    }

    @NotNull
    public final String getLinkLabel() {
        return this.linkLabel;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getThanks() {
        return this.thanks;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }
}
