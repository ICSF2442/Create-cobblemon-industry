package net.BLS.createcobblemonindustry.registry;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.BLS.createcobblemonindustry.registry.creative.CreateCobblemonIndustryCreativeModTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;

public class CreateCobblemonIndustryRegistrate extends AbstractRegistrate<CreateCobblemonIndustryRegistrate> {
    private static final Map<RegistryEntry<?, ?>, DeferredHolder<CreativeModeTab, CreativeModeTab>> TAB_LOOKUP = Collections.synchronizedMap(new IdentityHashMap<>());


    @Nullable
    private DeferredHolder<CreativeModeTab, CreativeModeTab> currentTab;

    protected CreateCobblemonIndustryRegistrate(String modid) {
        super(modid);
    }

    public static CreateCobblemonIndustryRegistrate create(String modid) {
        return new CreateCobblemonIndustryRegistrate(modid);
    }

    public CreateCobblemonIndustryRegistrate setCreativeTab(DeferredHolder<CreativeModeTab, CreativeModeTab> tab) {
        this.currentTab = tab;
        return this;
    }

    public boolean isInCreativeTab(RegistryEntry<?, ?> entry) {
        return entry != null && currentTab != null
                && currentTab == TAB_LOOKUP.get(entry);
    }

    public ItemBuilder<Item, CreateCobblemonIndustryRegistrate> item(String name) {
        return item(name, Item::new)
                .properties(p -> currentTab != null ? p : p); // Extend here later
    }
}
