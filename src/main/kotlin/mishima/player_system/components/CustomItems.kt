package mishima.player_system.components

import mishima.player_system.PlayerSystem
import mishima.player_system.components.tools.VenomousDagger
import mishima.player_system.utils.tools.CustomToolMaterial
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Formatting
import net.minecraft.util.Identifier

object CustomItems {

    val RAIKAN_FANG: Item = register(Item(Item.Settings().maxCount(64)), "raikan_fang")
    val KASAKA_FANG: Item = register(Item(Item.Settings().maxCount(64)), "kasaka_fang")
    val KASAKA_VENOM: Item = register(Item(Item.Settings().maxCount(64).food(FoodComponent.Builder()
        .hunger(0)
        .saturationModifier(0.0f)
        .statusEffect(StatusEffectInstance(StatusEffects.WEAKNESS, 500), 100F)
        .statusEffect(StatusEffectInstance(StatusEffects.ABSORPTION, 500), 100F)
        .build()
        )), "kasaka_venom")

    val DUNGEON_KEY: Item = register(Item(Item.Settings()), "dungeon_key")
    val DEMON_CASTLE_KEY: Item = register(Item(Item.Settings()), "demon_castle_key")
    val CASTLE_DOOR_KEY: Item = register(Item(Item.Settings()), "castle_door_key")

    val KASAKA_VENOM_FANG_DAGGER: Item = register(VenomousDagger(CustomToolMaterial.KASAKA,
        3,
        1f,
        Item.Settings().maxCount(1),
        "A Dagger made out of Kasaka's Venomous Fang",
        Formatting.GOLD,
    ), "kasaka_venom_fang_dagger")


    fun register(item: Item, id: String): Item {
        val itemId = Identifier.of(PlayerSystem.MOD_ID, id)
        val registeredItem: Item = Registry.register(Registries.ITEM, itemId, item)

        return registeredItem
    }

    fun initialize() {

    }
}