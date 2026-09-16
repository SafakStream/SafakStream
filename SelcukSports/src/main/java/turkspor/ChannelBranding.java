package turkspor;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ChannelBranding.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lturkspor/ChannelBranding;", "", "<init>", "()V", "TR", "", "BEIN", "channels", "", "Lturkspor/ChannelBranding$Brand;", "forChannel", "channel", "Lturkspor/SportsChannel;", "Brand", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class ChannelBranding {

    @NotNull
    private static final String BEIN = "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/international/beinsports/old/horizontal/";

    @NotNull
    public static final ChannelBranding INSTANCE = new ChannelBranding();

    @NotNull
    private static final String TR = "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/";

    @NotNull
    private static final Map<String, Brand> channels;

    private ChannelBranding() {
    }

    /* JADX INFO: compiled from: ChannelBranding.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lturkspor/ChannelBranding$Brand;", "", "title", "", "logo", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getLogo", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Brand {

        @NotNull
        private final String logo;

        @NotNull
        private final String title;

        public static /* synthetic */ Brand copy$default(Brand brand, String str, String str2, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                str = brand.title;
            }
            if ((r3 & 2) != 0) {
                str2 = brand.logo;
            }
            return brand.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLogo() {
            return this.logo;
        }

        @NotNull
        public final Brand copy(@NotNull String title, @NotNull String logo) {
            return new Brand(title, logo);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Brand)) {
                return false;
            }
            Brand brand = (Brand) other;
            return Intrinsics.areEqual(this.title, brand.title) && Intrinsics.areEqual(this.logo, brand.logo);
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.logo.hashCode();
        }

        @NotNull
        public String toString() {
            return "Brand(title=" + this.title + ", logo=" + this.logo + ')';
        }

        public Brand(@NotNull String title, @NotNull String logo) {
            this.title = title;
            this.logo = logo;
        }

        @NotNull
        public final String getLogo() {
            return this.logo;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }
    }

    static {
        Map $this$channels_u24lambda_u240 = MapsKt.createMapBuilder();
        for (int i = 1; i < 6; i++) {
            $this$channels_u24lambda_u240.put("selcukbeinsports" + i, new Brand("beIN Sports " + i, "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/international/beinsports/old/horizontal/bein-sports-" + i + "-hz-int.png"));
        }
        for (int i2 = 1; i2 < 3; i2++) {
            $this$channels_u24lambda_u240.put("selcukbeinsportsmax" + i2, new Brand("beIN Sports Max " + i2, "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/international/beinsports/old/horizontal/bein-sports-" + i2 + "-max-hz-int.png"));
        }
        $this$channels_u24lambda_u240.put("selcukbeinsportshaber", new Brand("beIN Sports Haber", "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/bein-sports-haber-hz-tr.png"));
        $this$channels_u24lambda_u240.put("selcukssport", new Brand("S Sport", "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/s-sport-tr.png"));
        $this$channels_u24lambda_u240.put("selcukssport2", new Brand("S Sport 2", "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/s-sport-2-tr.png"));
        for (int i3 = 1; i3 < 4; i3++) {
            $this$channels_u24lambda_u240.put("selcukssportplus" + i3, new Brand("S Sport Plus " + i3, "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/s-sport-plus-tr.png"));
        }
        $this$channels_u24lambda_u240.put("selcuksmartspor", new Brand("Spor Smart", "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/spor-smart-hd-tr.png"));
        $this$channels_u24lambda_u240.put("selcuksmartspor2", new Brand("Spor Smart 2", "https://i.imgur.com/qyUKCUa.png"));
        List tivibu = CollectionsKt.listOf(new String[]{"qvrKQY3", "qvrKQY3", "fZMSjNE", "xLrgt2O", "LgGxe7z"});
        int i4 = 0;
        while (true) {
            String string = "";
            if (i4 >= 5) {
                break;
            }
            String suffix = i4 == 0 ? "" : String.valueOf(i4);
            String str = "selcuktivibuspor" + suffix;
            StringBuilder sbAppend = new StringBuilder().append("Tivibu Spor");
            if (i4 != 0) {
                string = new StringBuilder().append(' ').append(i4).toString();
            }
            $this$channels_u24lambda_u240.put(str, new Brand(sbAppend.append(string).toString(), "https://i.imgur.com/" + ((String) tivibu.get(i4)) + ".png"));
            i4++;
        }
        int i5 = 0;
        while (i5 < 8) {
            String suffix2 = i5 == 0 ? "" : String.valueOf(i5);
            $this$channels_u24lambda_u240.put("selcuktabiispor" + suffix2, new Brand("tabii Spor" + (i5 == 0 ? "" : new StringBuilder().append(' ').append(i5).toString()), "https://cdn.prod.website-files.com/658da28123ee3a39812a40fd/65b199f7f21447f8e9e76a47_tabii-wc.png"));
            i5++;
        }
        $this$channels_u24lambda_u240.put("selcukaspor", new Brand("A Spor", "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/a-spor-tr.png"));
        $this$channels_u24lambda_u240.put("selcuktrtspor", new Brand("TRT Spor", "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/trt-spor-tr.png"));
        $this$channels_u24lambda_u240.put("selcuktrtspor2", new Brand("TRT Spor Yıldız", "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/trt-spor-yildiz-tr.png"));
        $this$channels_u24lambda_u240.put("selcuktrtavaz", new Brand("TRT Avaz", "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/trt-avaz-tr.png"));
        $this$channels_u24lambda_u240.put("selcuktrt1", new Brand("TRT 1", "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/trt-1-tr.png"));
        channels = MapsKt.build($this$channels_u24lambda_u240);
    }

    @NotNull
    public final Brand forChannel(@NotNull SportsChannel channel) {
        Brand brand = channels.get(channel.getId());
        return brand == null ? new Brand(channel.getTitle(), "") : brand;
    }
}
