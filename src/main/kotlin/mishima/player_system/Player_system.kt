package mishima.player_system

import mishima.player_system.ModItems.RASAKA_FANG
import mishima.player_system.ModItems.RASAKA_VENOM_FANG_DAGGER
import mishima.player_system.utils.Utils
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.slf4j.LoggerFactory

object Player_system : ModInitializer {
	const val MOD_ID: String = "player_system"
    private val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("Initializing $MOD_ID")
		Registry.register(Registries.ITEM_GROUP, Utils.MOD_ITEM_GROUP_KEY, Utils.MOD_ITEM_GROUP)

		ModItems.initialize()
		ItemGroupEvents.modifyEntriesEvent(Utils.MOD_ITEM_GROUP_KEY).register { itemGroup ->
			itemGroup.add(ModItems.RASAKA_FANG)
			itemGroup.add(ModItems.RASAKA_VENOM_FANG_DAGGER)
		}
	}
}