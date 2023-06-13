package tech.wakame.anyall.handlers

import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.BlockFace
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import tech.wakame.anyall.Anyall
import java.util.*

class BlockPlaceHandler(private val plugin: Anyall) : Listener {
    private val limit: Int by lazy {
        plugin.config.getInt("place_limit", 500)
    }

    @EventHandler
    fun onBlockPlace(event: BlockPlaceEvent) {
        if (event.block.type !in Harvests.keys) {
            return
        }

        val blockType = event.block.type
        var cnt = 0
        val queue = LinkedList<Block>()
        queue.add(event.block)

        while (queue.isNotEmpty()) {
            if (limit < cnt)
                return

            val target = queue.removeFirst()
            target.type = blockType
            cnt++

            arrayOf(BlockFace.SOUTH, BlockFace.NORTH, BlockFace.EAST, BlockFace.WEST).forEach {
                val next = target.getRelative(it)
                val isOnFarmland = next.getRelative(BlockFace.DOWN).type == Material.FARMLAND
                if (next.type.isAir && isOnFarmland) {
                    queue.push(next)
                }
            }
        }
    }
}