package turkspor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SportsParser.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lturkspor/SportsChannel;", "", "id", "", "title", "category", "player", "time", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "getCategory", "getPlayer", "getTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SportsChannel {

    @NotNull
    private final String category;

    @NotNull
    private final String id;

    @NotNull
    private final String player;

    @NotNull
    private final String time;

    @NotNull
    private final String title;

    public static /* synthetic */ SportsChannel copy$default(SportsChannel sportsChannel, String str, String str2, String str3, String str4, String str5, int r6, Object obj) {
        if ((r6 & 1) != 0) {
            str = sportsChannel.id;
        }
        if ((r6 & 2) != 0) {
            str2 = sportsChannel.title;
        }
        if ((r6 & 4) != 0) {
            str3 = sportsChannel.category;
        }
        if ((r6 & 8) != 0) {
            str4 = sportsChannel.player;
        }
        if ((r6 & 16) != 0) {
            str5 = sportsChannel.time;
        }
        String str6 = str5;
        String str7 = str3;
        return sportsChannel.copy(str, str2, str7, str4, str6);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPlayer() {
        return this.player;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    @NotNull
    public final SportsChannel copy(@NotNull String id, @NotNull String title, @NotNull String category, @NotNull String player, @NotNull String time) {
        return new SportsChannel(id, title, category, player, time);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SportsChannel)) {
            return false;
        }
        SportsChannel sportsChannel = (SportsChannel) other;
        return Intrinsics.areEqual(this.id, sportsChannel.id) && Intrinsics.areEqual(this.title, sportsChannel.title) && Intrinsics.areEqual(this.category, sportsChannel.category) && Intrinsics.areEqual(this.player, sportsChannel.player) && Intrinsics.areEqual(this.time, sportsChannel.time);
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.category.hashCode()) * 31) + this.player.hashCode()) * 31) + this.time.hashCode();
    }

    @NotNull
    public String toString() {
        return "SportsChannel(id=" + this.id + ", title=" + this.title + ", category=" + this.category + ", player=" + this.player + ", time=" + this.time + ')';
    }

    public SportsChannel(@NotNull String id, @NotNull String title, @NotNull String category, @NotNull String player, @NotNull String time) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.player = player;
        this.time = time;
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getPlayer() {
        return this.player;
    }

    @NotNull
    public final String getTime() {
        return this.time;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
