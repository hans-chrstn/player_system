package mishima.player_system.gui

import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.math.MathHelper

class StatScreen(private val player: PlayerEntity) : Screen(Text.translatable("gui.stats.title")) {
    override fun render(context: DrawContext, mouseX: Int, mouseY: Int, delta: Float) {
       context.fill(0, 0, width, height, 0x00FFFF)

        val titleWidth = this.textRenderer.getWidth(title)
        context.drawText(this.textRenderer, title, (width - titleWidth) / 2, 15, 0xFF0000, false)

        val health = MathHelper.ceil(player.health)
        val level = player.experienceLevel
        val experience = player.experienceProgress
        context.drawText(this.textRenderer, "Health: $health", width / 2 - 50, 40, 0x00FFFF, false)
        context.drawText(this.textRenderer, "Level: $level", width / 2 - 50, 60, 0x00FFFF, false)
        context.drawText(this.textRenderer, "Experience: ${(experience * 100).toInt()})%", width / 2 - 50, 80, 0x00FFFF, false)

        super.render(context, mouseX, mouseY, delta)
    }

    override fun close() {
        this.client?.setScreen(null)
    }
}