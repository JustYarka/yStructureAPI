package ru.yarka.structureapi.api

import cn.nukkit.math.Vector3
import cn.nukkit.nbt.tag.CompoundTag

class StructureNBT() {
    
    private val nbt: CompoundTag = CompoundTag()

    private var offset = Vector3(0.0, 0.0, 0.0)
    private var size = Vector3(5.0, 5.0, 5.0)
    private var coords = Vector3(0.0, 0.0, 0.0)
    private var name = ""

    init {
        nbt.putString("dataField", "")
        nbt.putByte("mirror", 0)
        nbt.putByte("ignoreEntities", 0)
        nbt.putInt("data", 5)
        nbt.putLong("seed", 0)
        nbt.putByte("removeBlocks", 0)
        nbt.putByte("includePlayers", 0)
        nbt.putByte("isPowered", 0)
        nbt.putFloat("integrity", 100.0F)
        nbt.putString("id", "StructureBlock")
        nbt.putInt("redstoneSaveMode", 0)
        nbt.putInt("rotation", 0)
        nbt.putByte("isMovable", 1)
        nbt.putByte("showBoundingBox", 1)
    }

    fun setPosition(coords: Vector3): StructureNBT {
        this.coords = coords

        return this
    }

    fun setOffset(offset: Vector3): StructureNBT {
        this.offset = offset

        return this
    }

    fun setSize(size: Vector3): StructureNBT {
        this.size = size

        return this
    }

    fun setName(name: String): StructureNBT {
        this.name = name

        return this
    }

    fun build(): CompoundTag {
        putCoords()
        putName()
        putOffset()
        putSize()

        return nbt
    }

    private fun putSize() {
        nbt.putInt("xStructureSize", size.floorX)
        nbt.putInt("yStructureSize", size.floorY)
        nbt.putInt("zStructureSize", size.floorZ)
    }

    private fun putOffset() {
        nbt.putInt("xStructureOffset", offset.floorX)
        nbt.putInt("yStructureOffset", offset.floorY)
        nbt.putInt("zStructureOffset", offset.floorZ)
    }

    private fun putCoords() {
        nbt.putInt("x", coords.floorX)
        nbt.putInt("y", coords.floorY)
        nbt.putInt("z", coords.floorZ)
    }

    private fun putName() {
        nbt.putString("structureName", name)
    }

    fun getSize(): Vector3 {
        return size
    }

    fun getOffset(): Vector3 {
        return offset
    }

    fun getPosition(): Vector3 {
        return coords
    }
}