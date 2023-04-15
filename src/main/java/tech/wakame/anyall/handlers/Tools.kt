package tech.wakame.anyall.handlers

import org.bukkit.Material

val Pickaxes = arrayOf(
    Material.NETHERITE_PICKAXE,
    Material.DIAMOND_PICKAXE,
    Material.IRON_PICKAXE,
    Material.GOLDEN_PICKAXE,
    Material.STONE_PICKAXE,
    Material.WOODEN_PICKAXE
)

val Axes = arrayOf(
    Material.NETHERITE_AXE,
    Material.DIAMOND_AXE,
    Material.IRON_AXE,
    Material.GOLDEN_AXE,
    Material.STONE_AXE,
    Material.WOODEN_AXE
)

val Shovels = arrayOf(
    Material.NETHERITE_SHOVEL,
    Material.DIAMOND_SHOVEL,
    Material.IRON_SHOVEL,
    Material.GOLDEN_SHOVEL,
    Material.STONE_SHOVEL,
    Material.WOODEN_SHOVEL
)

val Tools = arrayOf(*Pickaxes, *Axes, *Shovels)