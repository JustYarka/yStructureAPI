package ru.yarka.structureapi

import cn.nukkit.event.Listener
import cn.nukkit.plugin.PluginBase

class NotAPI: PluginBase(), Listener {

    companion object {
        private lateinit var instance: NotAPI

        fun getInstance(): NotAPI {
            return instance
        }
    }

    override fun onEnable() {
        instance = this
        server.pluginManager.registerEvents(this, this)
    }
}

