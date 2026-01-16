package megafishing;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MegaFishing implements ModInitializer {
	public static final String MOD_ID = "mega-fishing";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	private static final Identifier FISHING_TREASURE_LOOT_TABLE_ID = Identifier.of("minecraft", "gameplay/fishing/treasure");
	private static final Identifier MEGA_STONE_LOOT_TABLE_ID = Identifier.tryParse("megafishing", "gameplay/fishing/mega_stones");
	private static final Identifier BLANK_MEGA_STONE_LOOT_TABLE_ID = Identifier.tryParse("megafishing", "gameplay/fishing/blank_mega_stone");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		registerLootTableModifier();
	}

	private void registerLootTableModifier() {
		LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
			// Let's only modify built-in loot tables and leave data pack loot tables untouched by checking the source.
			// We also check that the loot table ID is equal to the ID we want.
			if (source.isBuiltin() && FISHING_TREASURE_LOOT_TABLE_ID.equals(key.getValue())) {
				LOGGER.info("Injecting MegaFishing loot into fishing treasure table");


				RegistryKey<LootTable> MEGA_STONE_LOOT_TABLE = RegistryKey.of(RegistryKeys.LOOT_TABLE, MEGA_STONE_LOOT_TABLE_ID);
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create((1)))
						.conditionally(RandomChanceLootCondition.builder(0.0625f))
						.with(LootTableEntry.builder(MEGA_STONE_LOOT_TABLE));

				tableBuilder.pool(poolBuilder);

				RegistryKey<LootTable> BLANK_MEGA_STONE_LOOT_TABLE = RegistryKey.of(RegistryKeys.LOOT_TABLE, BLANK_MEGA_STONE_LOOT_TABLE_ID);
				poolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create((1)))
						.conditionally(RandomChanceLootCondition.builder(0.00625f))
						.with(LootTableEntry.builder(BLANK_MEGA_STONE_LOOT_TABLE));

				tableBuilder.pool(poolBuilder);
			}
		});
	}
}