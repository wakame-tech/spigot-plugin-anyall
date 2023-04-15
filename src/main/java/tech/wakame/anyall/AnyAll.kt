package tech.wakame.anyall

import org.bukkit.plugin.java.JavaPlugin
import tech.wakame.anyall.handlers.BlockBreakHandler
import tech.wakame.anyall.handlers.BlockPlaceHandler
import tech.wakame.anyall.handlers.WarnDurabilityLowToolsHandler

class Anyall : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(BlockBreakHandler(), this)
        server.pluginManager.registerEvents(BlockPlaceHandler(), this)
        server.pluginManager.registerEvents(WarnDurabilityLowToolsHandler(), this)
    }

    override fun onDisable() {}
}