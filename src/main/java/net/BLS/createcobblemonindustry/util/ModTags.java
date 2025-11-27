package nl.giellio.create_cobblemon.util;

import net.BLS.createcobblemonindustry.CreateCobblemonIndustry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> TUMBLESTONE_BUDS = createTag("tumblestone_buds");
        public static final TagKey<Block> SKY_TUMBLESTONE_BUDS = createTag("sky_tumblestone_buds");
        public static final TagKey<Block> BLACK_TUMBLESTONE_BUDS = createTag("black_tumblestone_buds");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CreateCobblemonIndustry.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> POKEBALL_LIDS = createTag("poke_ball_lids");
        public static final TagKey<Item> ANCIENT_BALL_LIDS = createTag("ancient_ball_lids");
        public static final TagKey<Item> UPGRADES_SUPER_POTIONS = createTag("upgrades_super_potions");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CreateCobblemonIndustry.MODID, name));
        }
    }

}