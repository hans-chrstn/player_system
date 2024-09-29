package mishima.player_system.gui

import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.math.MathHelper

class StatScreen(private val player: PlayerEntity) : Screen(Text.translatable("Player System")) {


    override fun init() {
        super.init()

        addDrawableChild(ButtonWidget.builder(Text.translatable("x"), ::onButtonClick)
            .position(width / 2 - 50, height - 30)
            .size(100, 20)
            .build())

        addDrawableChild(ButtonWidget.builder(Text.translatable("+"), ::addHealth)
            .position(width / 2 - 100, 110)
            .size(20, 20)
            .build())
    }


    private fun onButtonClick(button: ButtonWidget) {
        this.client?.setScreen(null)
    }

    private data class PlayerStat(val label: String, val value: String)

    private val stats: List<PlayerStat> by lazy {
        listOf(
            PlayerStat("Name", player.name.string),
            PlayerStat("Level", player.experienceLevel.toString()),
            PlayerStat("Job", "None"),
            PlayerStat("Fatigue", "0"),
            PlayerStat("Title", "None"),
            PlayerStat("HP", MathHelper.ceil(player.health).toString())
        )
    }

    override fun shouldPause(): Boolean {
       return false
    }

    override fun render(context: DrawContext, mouseX: Int, mouseY: Int, delta: Float) {
       context.fill(0, 0, width, height, 0x00FFFF)

        val titleWidth = this.textRenderer.getWidth(title)
        context.drawText(this.textRenderer, title, (width - titleWidth) / 2, 15, 0xFF0000, false)

        drawStats(context)

        super.render(context, mouseX, mouseY, delta)
    }

    private fun drawStats(context: DrawContext) {
        var startY = 40
        val lineSpacing = 20
        val leftX = width / 2 - 100
        val rightX = width / 2 + 10

        val bodyTextColor = 0x00FFFF

        val statPair = listOf(
            Pair(stats[0], stats[1]),
            Pair(stats[2], stats[3]),
            Pair(stats[4], null),
            Pair(stats[5], null),
        )

        for (pair in statPair) {
            context.drawText(this.textRenderer, "${pair.first.label}: ${pair.first.value}", leftX, startY, bodyTextColor, true)
            pair.second?.let {
                context.drawText(this.textRenderer, "${it.label}: ${it.value}", rightX, startY, bodyTextColor, true)
            }
            startY += lineSpacing
        }
    }

    private fun addHealth(button: ButtonWidget) {
        player.health = MathHelper.clamp(player.health + 1, 0.0f, 1024.0f)
    }

    override fun close() {
        this.client?.setScreen(null)
    }
}