package net.ess3.provider;

import net.essentialsx.providers.NullableProvider;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Sets item names and lore from JSON text components, for formatting that legacy strings can't hold (such as fonts).
 */
@NullableProvider
public interface ItemComponentProvider extends Provider {
    void setDisplayName(ItemMeta meta, String json);

    void setLore(ItemMeta meta, List<String> json);
}
