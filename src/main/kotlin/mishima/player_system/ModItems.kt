package mishima.player_system

import mishima.player_system.utils.ModToolMaterial
import mishima.player_system.utils.Utils
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.PickaxeItem
import net.minecraft.item.SwordItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModItems {
    val RASAKA_FANG: Item = register(Item(Item.Settings()), "rasaka_fang")

    val RASAKA_VENOM_FANG_DAGGER: Item = register(SwordItem(ModToolMaterial.RASAKA_FANG, 5, 5f, Item.Settings()
        .maxCount(1)
        ), "rasaka_venom_fang_dagger")


    fun register(item: Item, id: String): Item {
        val itemId = Identifier.of(Player_system.MOD_ID, id)
        val registeredItem: Item = Registry.register(Registries.ITEM, itemId, item)

        return registeredItem
    }

    fun initialize() {

    }
}