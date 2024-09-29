package mishima.player_system

import mishima.player_system.components.CustomBlocks
import mishima.player_system.components.CustomEffects
import mishima.player_system.components.CustomItems
import mishima.player_system.utils.Utils
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.slf4j.LoggerFactory

object PlayerSystem : ModInitializer {
	const val MOD_ID: String = "player_system"
    private val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("Initializing $MOD_ID")
		Registry.register(Registries.ITEM_GROUP, Utils.MOD_ITEM_GROUP_KEY, Utils.MOD_ITEM_GROUP)

		CustomItems.initialize()
		CustomBlocks.initialize()
		CustomEffects.initialize()

		val items = listOf(
			CustomItems.RAIKAN_FANG,
			CustomItems.KASAKA_FANG,
			CustomItems.KASAKA_VENOM,
			CustomItems.KASAKA_VENOM_FANG_DAGGER,
			CustomItems.DUNGEON_KEY,
			CustomItems.DEMON_CASTLE_KEY,
			CustomItems.CASTLE_DOOR_KEY,
		)

		ItemGroupEvents.modifyEntriesEvent(Utils.MOD_ITEM_GROUP_KEY).register { itemGroup ->
			items.forEach { itemGroup.add(it)}
		}
	}
}