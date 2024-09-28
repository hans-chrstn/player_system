package mishima.player_system.components

import mishima.player_system.PlayerSystem
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object CustomBlocks {
    fun register(block: Block, name: String, shouldRegisterItem: Boolean): Block {
        val id = Identifier.of(PlayerSystem.MOD_ID, name)

        if (shouldRegisterItem) {
            val bItem = BlockItem(block, Item.Settings())
            Registry.register(Registries.ITEM, id, bItem)
        }

        return Registry.register(Registries.BLOCK, id, block)
    }

    fun initialize() {

    }
}