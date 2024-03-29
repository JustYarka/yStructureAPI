package ru.yarka.structureapi.api

import cn.nukkit.Player
import cn.nukkit.level.Level
import cn.nukkit.math.Vector3
import cn.nukkit.nbt.NBTIO
import cn.nukkit.network.protocol.BlockEntityDataPacket
import cn.nukkit.scheduler.NukkitRunnable
import ru.yarka.structureapi.NotAPI
import java.nio.ByteOrder

class API {
    companion object {

        fun sendStructureAxes(player: Player, structureNBT: StructureNBT): Pair<Int, Vector3> {
            val id = player.level.getBlockIdAt(structureNBT.getPosition().floorX, structureNBT.getPosition().floorY, structureNBT.getPosition().floorZ)

            player.level.setBlockIdAt(structureNBT.getPosition().floorX, structureNBT.getPosition().floorY, structureNBT.getPosition().floorZ, 252)

            val packet = BlockEntityDataPacket()
            packet.x = structureNBT.getPosition().floorX
            packet.y = structureNBT.getPosition().floorY
            packet.z = structureNBT.getPosition().floorZ
            packet.namedTag = NBTIO.write(structureNBT.build(), ByteOrder.LITTLE_ENDIAN, true)

            object: NukkitRunnable() {
                override fun run() {
                    player.dataPacket(packet)
                }
            }.runTaskLater(NotAPI.instance, 3) //почему 3 тика? потому что если меньше то майну пофиг на то что ты ему кидаешь почему то

            return Pair(id, structureNBT.getPosition())
        }

        fun removeStructureAxes(level: Level, data: Pair<Int, Vector3>) {
            level.setBlockIdAt(data.second.floorX, data.second.floorY, data.second.floorZ, data.first)
        }
    }
}
