package turkspor.common;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AuthorizedSportsProviders.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tJ\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\tJ\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lturkspor/common/CountryFilter;", "", "preferences", "Landroid/content/SharedPreferences;", "key", "", "<init>", "(Landroid/content/SharedPreferences;Ljava/lang/String;)V", "selected", "", "set", "", "values", "apply", "", "Lturkspor/common/WebEvent;", "rows", "SelcukSports"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAuthorizedSportsProviders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AuthorizedSportsProviders.kt\nturkspor/common/CountryFilter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,403:1\n1#2:404\n777#3:405\n873#3,2:406\n*S KotlinDebug\n*F\n+ 1 AuthorizedSportsProviders.kt\nturkspor/common/CountryFilter\n*L\n243#1:405\n243#1:406,2\n*E\n"})
final class CountryFilter {

    @NotNull
    private final String key;

    @NotNull
    private final SharedPreferences preferences;

    public CountryFilter(@NotNull SharedPreferences preferences, @NotNull String key) {
        this.preferences = preferences;
        this.key = key;
    }

    @NotNull
    public final Set<String> selected() {
        Set<String> stringSet = this.preferences.getStringSet(this.key, SetsKt.emptySet());
        Set<String> set = stringSet != null ? CollectionsKt.toSet(stringSet) : null;
        return set == null ? SetsKt.emptySet() : set;
    }

    public final void set(@NotNull Set<String> values) {
        this.preferences.edit().putStringSet(this.key, values).apply();
    }

    @NotNull
    public final List<WebEvent> apply(@NotNull List<WebEvent> rows) {
        Set<String> setSelected = selected();
        if (setSelected.isEmpty()) {
            setSelected = null;
        }
        if (setSelected == null) {
            return rows;
        }
        List<WebEvent> $this$filter$iv = rows;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            WebEvent it = (WebEvent) element$iv$iv;
            if (setSelected.contains(it.getCategory())) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }
}
