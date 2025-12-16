package net.BLS.createcobblemonindustry.registry.item;

import net.BLS.createcobblemonindustry.CreateCobblemonIndustry;
import net.BLS.createcobblemonindustry.registry.CreateCobblemonIndustryRegistrate;

import net.minecraft.world.item.Item;

import com.tterrag.registrate.util.entry.ItemEntry;

import java.util.EnumMap;
import java.util.Map;

public class CreateCobblemonIndustryModItems {

	private static final CreateCobblemonIndustryRegistrate REGISTRATE =
			CreateCobblemonIndustry.registrate();

	public static final Map<BallType, ItemEntry<Item>> ITEM_MAP =
			new EnumMap<>(BallType.class);

	static {
		for (BallType type : BallType.values()) {
			ITEM_MAP.put(type,
					REGISTRATE
							.item(type.getId(), Item::new)
							.register()
			);
		}
	}

	// Force class loading
	public static void register() {}
}
