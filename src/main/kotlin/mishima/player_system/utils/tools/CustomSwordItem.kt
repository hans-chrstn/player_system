package mishima.player_system.utils.tools

import net.minecraft.client.item.TooltipContext
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterial
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.world.World

data class TooltipEntry(val key: String, val formatting: Formatting)

open class CustomSwordItem(
    material: ToolMaterial,
    attackDamage: Int,
    attackSpeed: Float,
    settings: Settings,
    private val tooltipEntries: List<TooltipEntry>
    ): SwordItem(material, attackDamage, attackSpeed, settings) {

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {
        tooltipEntries.forEach { entry ->
            tooltip?.add(Text.translatable(entry.key).formatted(entry.formatting))
        }
    }
}