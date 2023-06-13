package tech.wakame.anyall.handlers

import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import tech.wakame.anyall.Anyall

val diffs = arrayOf(
    Triple(-1, -1, -1),
    Triple(-1, -1, 0),
    Triple(-1, -1, 1),
    Triple(-1, 0, -1),
    Triple(-1, 0, 0),
    Triple(-1, 0, 1),
    Triple(-1, 1, -1),
    Triple(-1, 1, 0),
    Triple(-1, 1, 1),

    Triple(0, -1, -1),
    Triple(0, -1, 0),
    Triple(0, -1, 1),
    Triple(0, 0, -1),
    Triple(0, 0, 1),
    Triple(0, 1, -1),
    Triple(0, 1, 0),
    Triple(0, 1, 1),

    Triple(1, -1, -1),
    Triple(1, -1, 0),
    Triple(1, -1, 1),
    Triple(1, 0, -1),
    Triple(1, 0, 0),
    Triple(1, 0, 1),
    Triple(1, 1, -1),
    Triple(1, 1, 0),
    Triple(1, 1, 1)
)

class BlockBreakHandler(private val plugin: Anyall) : Listener {
    private val limit: Int by lazy {
        plugin.config.getInt("break_limit", 500)
    }
    
    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        val tool = event.player.inventory.itemInMainHand
        val block = event.block
        var cnt = 0

        if (
            !(tool.type in Pickaxes && block.type in Minings) &&
            !(tool.type in Axes && block.type in Cuttings) &&
            !(tool.type in Shovels && block.type in Diggings) &&
            block.type !in Harvests.keys
        ) return

        val type = block.type
        val dest = event.player.location

        fun blockBreak(target: Block) {
            if (limit < cnt || target.type.isAir)
                return
            target.getDrops(tool).forEach {
                target.world.dropItemNaturally(dest, it)
            }
            target.type = Material.AIR
            diffs.forEach {
                val nextTarget = target.getRelative(it.first, it.second, it.third)
                if (nextTarget.type == type) {
                    cnt++
                    blockBreak(nextTarget)
                }
            }
        }
        blockBreak(block)
    }

}