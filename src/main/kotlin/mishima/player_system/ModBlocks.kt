package mishima.player_system

import mishima.player_system.utils.CustomDoorBlock
import net.minecraft.block.Block
import net.minecraft.block.BlockSetType
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier

object ModBlocks {
    val CUSTOM_DOOR: Block =
        register(CustomDoorBlock(CustomDoorBlock.Companion.createSettings(3.0f, BlockSoundGroup.WOOD), BlockSetType.OAK), "custom_door", true)

    fun register(block: Block, name: String, shouldRegisterItem: Boolean): Block {
        val id = Identifier.of(Player_system.MOD_ID, name)

        if (shouldRegisterItem) {
            val bItem = BlockItem(block, Item.Settings())
            Registry.register(Registries.ITEM, id, bItem)
        }

        return Registry.register(Registries.BLOCK, id, block)
    }

    fun initialize() {

    }
}