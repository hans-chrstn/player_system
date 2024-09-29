package mishima.player_system.utils

import mishima.player_system.components.CustomItems
import mishima.player_system.PlayerSystem
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryKey
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object Utils {
    val MOD_ITEM_GROUP_KEY: RegistryKey<ItemGroup> = RegistryKey.of(
        Registries.ITEM_GROUP.getKey(), Identifier.of(
        PlayerSystem.MOD_ID, "item_group"))
    val MOD_ITEM_GROUP: ItemGroup = FabricItemGroup.builder()
        .icon { ItemStack(CustomItems.KASAKA_FANG) }
        .displayName(Text.translatable("itemGroup.${PlayerSystem.MOD_ID}"))
        .build()
}