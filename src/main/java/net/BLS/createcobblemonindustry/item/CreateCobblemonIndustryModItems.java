package net.BLS.createcobblemonindustry.item;

import net.BLS.createcobblemonindustry.CreateCobblemonIndustry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CreateCobblemonIndustryModItems {
	public static final DeferredRegister.Items ITEMS =
			DeferredRegister.createItems(CreateCobblemonIndustry.MODID);

	public static final Map<BallType, DeferredItem<Item>> ITEM_MAP = new HashMap<>();

	static {
		for (BallType type : BallType.values()) {
			ITEM_MAP.put(type, ITEMS.register(type.getId(), () -> new Item(new Item.Properties())));
		}
	}

	public static void register(IEventBus bus) {
		ITEMS.register(bus);
	}
}

