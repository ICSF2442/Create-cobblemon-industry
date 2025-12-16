package net.BLS.createcobblemonindustry.registry.creative;

import net.BLS.createcobblemonindustry.CreateCobblemonIndustry;
import net.BLS.createcobblemonindustry.registry.item.BallType;
import net.BLS.createcobblemonindustry.registry.item.CreateCobblemonIndustryModItems;
import net.BLS.createcobblemonindustry.registry.fluid.CreateCobblemonIndustryModFluids;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreateCobblemonIndustryCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateCobblemonIndustry.MODID);


     // ITEMS TAB
    public static final Supplier<CreativeModeTab> ITEMS_TAB =
            TABS.register("createcobblemonindustry_items",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable(
                                    "creativetab.createcobblemonindustry.items"))
                            .icon(() -> new ItemStack(
                                    CreateCobblemonIndustryModItems.ITEM_MAP
                                            .get(BallType.INCOMPLETE_POKE_BALL)
                                            .get()
                            ))
                            .displayItems((params, output) -> {
                                // Enum order = guaranteed order
                                for (BallType type : BallType.values()) {
                                    output.accept(
                                            CreateCobblemonIndustryModItems.ITEM_MAP
                                                    .get(type)
                                                    .get()
                                    );
                                }
                            })
                            .build()
            );


     //FLUIDS TAB
    public static final Supplier<CreativeModeTab> FLUIDS_TAB =
            TABS.register("createcobblemonindustry_fluids",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable(
                                    "creativetab.createcobblemonindustry.fluids"))
                            .withTabsBefore(
                                    ResourceLocation.fromNamespaceAndPath(
                                            CreateCobblemonIndustry.MODID,
                                            "createcobblemonindustry_items"
                                    )
                            )
                            .icon(() -> new ItemStack(
                                    CreateCobblemonIndustryModItems.ITEM_MAP
                                            .get(BallType.INCOMPLETE_POKE_BALL)
                                            .get()
                            ))
                            .displayItems((params, output) -> {
                                CreateCobblemonIndustryModFluids.FLUID_MAP
                                        .values()
                                        .forEach(fluid ->
                                                output.accept(fluid.get().getBucket())
                                        );
                            })
                            .build()
            );

    public static void register(IEventBus bus) {
        TABS.register(bus);
    }
}
