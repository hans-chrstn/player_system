package mishima.player_system.components.tools

import mishima.player_system.components.CustomEffects
import mishima.player_system.utils.tools.CustomSwordItem
import mishima.player_system.utils.tools.TooltipEntry
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.item.ItemStack
import net.minecraft.item.ToolMaterial
import net.minecraft.util.Formatting
import kotlin.random.Random

class VenomousDagger(
    material: ToolMaterial,
    attackDamage: Int,
    attackSpeed: Float,
    settings: Settings,
    tooltipEntries: List<TooltipEntry>
): CustomSwordItem(material, attackDamage, attackSpeed, settings, tooltipEntries) {
    override fun postHit(stack: ItemStack, target: LivingEntity, attacker: LivingEntity): Boolean {
        stack.damage(1, attacker) { e: LivingEntity ->
            e.sendEquipmentBreakStatus(
                EquipmentSlot.MAINHAND
            )
        }
        applyCustomEffects(target, attacker)
        return true
    }

    private val paralysisChance = 0.3
    private fun applyCustomEffects(target: LivingEntity, attacker: LivingEntity) {
        if (!attacker.world.isClient) {
            if (Random.nextDouble() < paralysisChance) {
                target.addStatusEffect(StatusEffectInstance(CustomEffects.PARALYSIS, 100))
            }
        }
    }
}