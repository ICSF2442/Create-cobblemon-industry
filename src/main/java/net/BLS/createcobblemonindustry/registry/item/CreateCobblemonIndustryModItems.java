package net.BLS.createcobblemonindustry.registry.item;

import net.BLS.createcobblemonindustry.CreateCobblemonIndustry;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.BLS.createcobblemonindustry.registry.creative.CreateCobblemonIndustryCreativeModTabs;
import net.BLS.createcobblemonindustry.registry.CreateCobblemonIndustryRegistrate;
import net.minecraft.world.item.Item;

public class CreateCobblemonIndustryModItems {
	private static final CreateCobblemonIndustryRegistrate REGISTRATE = CreateCobblemonIndustry.registrate();

	static {
		REGISTRATE.setCreativeTab(CreateCobblemonIndustryCreativeModTabs.BASE_CREATIVE_TAB);
	}


	public static final ItemEntry<Item> POKE_BALL = REGISTRATE
			.item("poke_ball")
			.register();

	public static void register() {}
}
