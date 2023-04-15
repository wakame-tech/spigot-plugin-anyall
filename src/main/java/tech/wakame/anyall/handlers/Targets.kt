package tech.wakame.anyall.handlers

import org.bukkit.Material

val Minings = arrayOf(
    // ores
    Material.COAL_ORE,
    Material.DEEPSLATE_COAL_ORE,
    Material.IRON_ORE,
    Material.DEEPSLATE_IRON_ORE,
    Material.DIAMOND_ORE,
    Material.DEEPSLATE_DIAMOND_ORE,
    Material.EMERALD_ORE,
    Material.DEEPSLATE_EMERALD_ORE,
    Material.GOLD_ORE,
    Material.DEEPSLATE_GOLD_ORE,
    Material.LAPIS_ORE,
    Material.DEEPSLATE_LAPIS_ORE,
    Material.COPPER_ORE,
    Material.DEEPSLATE_COPPER_ORE,
    Material.REDSTONE_ORE,
    Material.DEEPSLATE_REDSTONE_ORE,
    Material.NETHER_GOLD_ORE,
    Material.NETHER_QUARTZ_ORE,
    // other
    Material.GLOWSTONE,
    Material.OBSIDIAN,
    Material.IRON_BLOCK,
    Material.GOLD_BLOCK,
    Material.EMERALD_BLOCK
)

val Cuttings = arrayOf(
    // logs
    Material.OAK_LOG,
    Material.SPRUCE_LOG,
    Material.ACACIA_LOG,
    Material.BIRCH_LOG,
    Material.DARK_OAK_LOG,
    Material.JUNGLE_LOG,
    Material.PUMPKIN,
    Material.MELON
)

val Diggings = arrayOf(
    Material.GRAVEL,
    Material.SOUL_SAND,
    Material.CLAY
)

val Harvests = mapOf(
    Material.WHEAT to Material.WHEAT_SEEDS,
    Material.POTATOES to Material.POTATOES,
    Material.CARROTS to Material.CARROTS
)