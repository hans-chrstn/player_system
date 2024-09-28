package mishima.player_system.utils

import net.minecraft.block.BlockSetType
import net.minecraft.block.DoorBlock
import net.minecraft.sound.BlockSoundGroup

class CustomDoorBlock(settings: Settings, type: BlockSetType): DoorBlock(settings, type) {
    companion object {
        fun createSettings(strength: Float, soundGroup: BlockSoundGroup): Settings {
            return Settings.create()
                .strength(strength)
                .sounds(soundGroup)
        }
    }
}