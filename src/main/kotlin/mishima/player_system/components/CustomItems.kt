package mishima.player_system.components

import mishima.player_system.PlayerSystem
import mishima.player_system.components.tools.VenomousDagger
import mishima.player_system.utils.tools.CustomToolMaterial
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Formatting
import net.minecraft.util.Identifier

object CustomItems {
    val RASAKA_FANG: Item = register(Item(Item.Settings()), "rasaka_fang")

    val RASAKA_VENOM_FANG_DAGGER: Item = register(VenomousDagger(CustomToolMaterial.RASAKA,
        4,
        -1f,
        Item.Settings().maxCount(1),
        "A Dagger made out of Rasaka's Venomous Fang",
        Formatting.GOLD,
    ), "rasaka_venom_fang_dagger")


    fun register(item: Item, id: String): Item {
        val itemId = Identifier.of(PlayerSystem.MOD_ID, id)
        val registeredItem: Item = Registry.register(Registries.ITEM, itemId, item)

        return registeredItem
    }

    fun initialize() {

    }
}