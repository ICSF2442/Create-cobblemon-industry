package net.BLS.createcobblemonindustry.registry.creative;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllCreativeModeTabs;
import net.BLS.createcobblemonindustry.CreateCobblemonIndustry;
import net.createmod.catnip.platform.CatnipServices;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.apache.commons.lang3.mutable.MutableObject;
import org.jetbrains.annotations.ApiStatus;

import java.util.function.Predicate;

public class CreateCobblemonIndustryCreativeModTabs {
    private static final DeferredRegister<CreativeModeTab> REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateCobblemonIndustry.MODID);

    @ApiStatus.Internal
    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }

    private static class RegistrateDisplayItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {
        private static final Predicate<Item> IS_ITEM_3D_PREDICATE;

        static {
            MutableObject<Predicate<Item>> isItem3d = new MutableObject<>(item -> false);
            if (CatnipServices.PLATFORM.getEnv().isClient())
                isItem3d.setValue(item -> {
                    ItemRenderer itemRenderer = Minecraft.getInstance()
                            .getItemRenderer();
                    BakedModel model = itemRenderer.getModel(new ItemStack(item), null, null, 0);
                    return model.isGui3d();
                });
            IS_ITEM_3D_PREDICATE = isItem3d.getValue();
        }

        private final boolean addItems;
        private final DeferredHolder<CreativeModeTab, CreativeModeTab> tabFilter;

        public RegistrateDisplayItemsGenerator(boolean addItems, DeferredHolder<CreativeModeTab, CreativeModeTab> tabFilter) {
            this.addItems = addItems;
            this.tabFilter = tabFilter;
        }



        public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BASE_CREATIVE_TAB = REGISTER.register("base",
                () -> CreativeModeTab.builder()
                        .title(Component.translatable("itemGroup.create.base"))
                        .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                        .icon(() -> AllBlocks.COGWHEEL.asStack())
                        .displayItems(new CreateCobblemonIndustryCreativeModTabs.RegistrateDisplayItemsGenerator(true, AllCreativeModeTabs.BASE_CREATIVE_TAB))
                        .build());



        public static void register(IEventBus bus){
        REGISTER.register(bus);
    }
}
