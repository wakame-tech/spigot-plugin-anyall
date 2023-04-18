package tech.wakame.anyall

import org.bukkit.plugin.java.JavaPlugin
import tech.wakame.anyall.handlers.BlockBreakHandler
import tech.wakame.anyall.handlers.BlockPlaceHandler
import tech.wakame.anyall.handlers.WarnDurabilityLowToolsHandler

class Anyall : JavaPlugin() {
    private val handlers = arrayOf(
        BlockBreakHandler(),
        BlockPlaceHandler(),
        WarnDurabilityLowToolsHandler(),
    )

    override fun onEnable() {
        handlers.forEach {
            server.pluginManager.registerEvents(it, this)
        }
    }

    override fun onDisable() {}
}