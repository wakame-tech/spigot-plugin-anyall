package tech.wakame.anyall.handlers

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.meta.Damageable

class WarnDurabilityLowToolsHandler : Listener {
    companion object {
        const val THRESHOLD = 10
    }

    @EventHandler
    fun warnToolDurabilityLow(event: BlockBreakEvent) {
        val tool = event.player.inventory.itemInMainHand
        if (tool.itemMeta !is Damageable || !Tools.contains(tool.type)) {
            return
        }
        val durability = tool.type.maxDurability - (tool.itemMeta as Damageable).damage
        if (durability < THRESHOLD) {
            event.player.sendMessage("[WARN] this tool will break soon. durability: $durability")
        }
    }
}