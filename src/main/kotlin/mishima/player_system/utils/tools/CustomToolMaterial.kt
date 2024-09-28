package mishima.player_system.utils.tools

import mishima.player_system.components.CustomItems
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient

enum class CustomToolMaterial(
    private val durability: Int,
    private val miningLevel: Int,
    private val miningSpeed: Float,
    private val attackDamage: Float,
    private val enchantability: Int,
    private val repairIngredientProvider: Ingredient = Ingredient.empty()
) : ToolMaterial {

    RASAKA(265, 2, 6.5f, 2.5f, 16, Ingredient.ofItems(CustomItems.RASAKA_FANG));



    override fun getDurability(): Int = durability

    override fun getMiningSpeedMultiplier(): Float = miningSpeed

    override fun getAttackDamage(): Float = attackDamage

    override fun getMiningLevel(): Int = miningLevel

    override fun getEnchantability(): Int = enchantability

    override fun getRepairIngredient(): Ingredient = repairIngredientProvider
}
