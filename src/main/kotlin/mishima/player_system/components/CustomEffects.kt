package mishima.player_system.components

import mishima.player_system.PlayerSystem
import net.minecraft.entity.attribute.EntityAttributeModifier
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object CustomEffects {
    val PARALYSIS: StatusEffect = register("paralysis", object : StatusEffect(StatusEffectCategory.HARMFUL, 0xfcf7bd) {
        init {
            addAttributeModifier(
                EntityAttributes.GENERIC_MOVEMENT_SPEED,
                "3e2f3a57-7b4c-4c25-8e70-3b5a0f93c0a2", -1.0, EntityAttributeModifier.Operation.MULTIPLY_TOTAL
            )
        }
    })

    fun register(id: String, effect: StatusEffect): StatusEffect {
        val statId = Identifier.of(PlayerSystem.MOD_ID, id)
        return Registry.register(Registries.STATUS_EFFECT, statId, effect)
    }

    fun initialize() {
    }
}