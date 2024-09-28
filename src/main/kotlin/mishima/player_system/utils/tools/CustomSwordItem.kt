package mishima.player_system.utils.tools

import net.minecraft.client.item.TooltipContext
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterial
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.world.World

open class CustomSwordItem(
    material: ToolMaterial,
    attackDamage: Int,
    attackSpeed: Float,
    settings: Settings,
    private val tooltipKey: String,
    private val formatting: Formatting,
    ): SwordItem(material, attackDamage, attackSpeed, settings) {

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {
        tooltip?.add(Text.translatable(tooltipKey).formatted(formatting))
    }
}