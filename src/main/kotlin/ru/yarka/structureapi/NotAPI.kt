package ru.yarka.structureapi

import cn.nukkit.Player
import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerInteractEvent
import cn.nukkit.math.Vector3
import cn.nukkit.plugin.PluginBase
import ru.yarka.structureapi.api.API
import ru.yarka.structureapi.api.StructureNBT

class NotAPI: PluginBase(), Listener {

    companion object {
        private lateinit var instance: NotAPI

        fun getInstance(): NotAPI {
            return instance
        }
    }

    private val map = HashMap<Player, Pair<Int, Vector3>>()

    override fun onEnable() {
        instance = this
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun handleTap(event: PlayerInteractEvent) {
        val player = event.player

        if(map.containsKey(player)) {
            map[player]?.let { API.removeStructureAxes(player.level, it) }
            map.remove(player)
        } else {
            map[player] = API.sendStructureAxes(player, StructureNBT().setPosition(event.block).setSize(Vector3(10.0, 1.0, 5.0)))
        }
    }
}

