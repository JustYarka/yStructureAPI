# yStructureAPI
Простое API для работы с осями структурного блока
##Пример
```kotlin
open class Test: PluginBase(), Listener {

    private val map = HashMap<Player, Pair<Int, Vector3>>()

    override fun onEnable() {
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
```
Суть осознавайте сами, когда попробуете