package net.BLS.createcobblemonindustry.item;

import net.BLS.createcobblemonindustry.CreateCobblemonIndustry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreateCobblemonIndustryCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateCobblemonIndustry.MODID);

    public static final Supplier<CreativeModeTab> CREATE_COBBLEMON_INDUSTRY_ITEMS_TAB = CREATIVE_MODE_TAB.register("create_cobblemon_industry_items_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack (CreateCobblemonIndustryModItems.ITEM_MAP.get(BallType.INCOMPLETE_POKE_BALL).get()))
                .title(Component.translatable("creativetab.createcobblemonindustry.create_cobblemon_industry_items"))
                .displayItems((itemDisplayParameters, output) -> {

                    for (BallType type : BallType.values()) {
                        output.accept(CreateCobblemonIndustryModItems.ITEM_MAP.get(type).get());
                    }

                }).build());

    public static final Supplier<CreativeModeTab> CREATE_COBBLEMON_INDUSTRY_LIQUIDS_TAB = CREATIVE_MODE_TAB.register("create_cobblemon_industry_liquids_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack (CreateCobblemonIndustryModItems.ITEM_MAP.get(BallType.INCOMPLETE_POKE_BALL).get()))
                .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CreateCobblemonIndustry.MODID, "create_cobblemon_industry_items_tab"))
                .title(Component.translatable("creativetab.createcobblemonindustry.create_cobblemon_industry_liquids"))
                .displayItems((itemDisplayParameters, output) -> {



                }).build());

    public static void register(IEventBus bus){
        CREATIVE_MODE_TAB.register(bus);
    }
}
