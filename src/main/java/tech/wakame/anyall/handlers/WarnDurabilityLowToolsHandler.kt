package tech.wakame.anyall.handlers

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.meta.Damageable
import tech.wakame.anyall.Anyall

class WarnDurabilityLowToolsHandler(private val plugin: Anyall) : Listener {
    private val threshold: Int by lazy {
        plugin.config.getInt("alert_threshold", 10)
    }

    @EventHandler
    fun warnToolDurabilityLow(event: BlockBreakEvent) {
        val tool = event.player.inventory.itemInMainHand
        if (tool.itemMeta !is Damageable || !Tools.contains(tool.type)) {
            return
        }
        val durability = tool.type.maxDurability - (tool.itemMeta as Damageable).damage
        if (durability < threshold) {
            event.player.sendMessage("[WARN] this tool will break soon. durability: $durability")
        }
    }
}