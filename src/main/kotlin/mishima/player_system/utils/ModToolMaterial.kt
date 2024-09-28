package mishima.player_system.utils

import mishima.player_system.ModItems
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient

enum class ModToolMaterial(
    private val itemDurability: Int,
    private val miningLevel: Int,
    private val miningSpeed: Float,
    private val attackDamage: Float,
    private val enchantability: Int,
    private val repairIngredientProvider: () -> Ingredient
) : ToolMaterial {

    RASAKA_FANG(650, 5, 4.5f, 3.5f, 26, {
        Ingredient.ofItems(ModItems.RASAKA_FANG)
    });

    override fun getDurability(): Int {
      return itemDurability
    }

    override fun getMiningSpeedMultiplier(): Float {
        return miningSpeed
    }

    override fun getAttackDamage(): Float {
        return attackDamage
    }

    override fun getMiningLevel(): Int {
      return miningLevel
    }

    override fun getEnchantability(): Int {
        return enchantability
    }

    override fun getRepairIngredient(): Ingredient = repairIngredientProvider()
}
