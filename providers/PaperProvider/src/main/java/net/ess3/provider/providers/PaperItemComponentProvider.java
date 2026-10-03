package net.ess3.provider.providers;

import net.ess3.provider.ItemComponentProvider;
import net.essentialsx.providers.ProviderData;
import net.essentialsx.providers.ProviderTest;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

@ProviderData(description = "Paper Item Component Provider")
public class PaperItemComponentProvider implements ItemComponentProvider {

    @Override
    public void setDisplayName(ItemMeta meta, String json) {
        meta.displayName(GsonComponentSerializer.gson().deserialize(json));
    }

    @Override
    public void setLore(ItemMeta meta, List<String> json) {
        final List<Component> lore = new ArrayList<>(json.size());
        for (final String line : json) {
            lore.add(GsonComponentSerializer.gson().deserialize(line));
        }
        meta.lore(lore);
    }

    @ProviderTest
    public static boolean test() {
        try {
            ItemMeta.class.getDeclaredMethod("lore", List.class);
            return true;
        } catch (final NoSuchMethodException ignored) {
            return false;
        }
    }
}
