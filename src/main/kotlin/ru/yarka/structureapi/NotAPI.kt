package ru.yarka.structureapi

import cn.nukkit.event.Listener
import cn.nukkit.plugin.PluginBase

class NotAPI: PluginBase(), Listener {

    companion object {
        lateinit var instance: NotAPI
        private set;
    }

    override fun onEnable() {
        instance = this
        server.pluginManager.registerEvents(this, this)
    }
}

