package eu.mshade.enderframe.tick

abstract class Tickable {

    var tick: Long = 0
        private set
    val tickId = TickBus.TICKABLE_ID.freeId

    private var tickBus: TickBus? = null
    var tickState = TickState.WAITING

    abstract fun tick()

    fun isPeriod(period: Int): Boolean {
        return tick % period == 0L
    }

    fun addTick() {
        tick++
    }

    fun resetTick() {
        tick = 0
    }

    fun joinTickBus(tickBus: TickBus) {
        if (this.tickBus != null) return
        this.tickBus = tickBus
        tickBus.addTickable(this)
    }

    fun leaveTickBus() {
        if (tickBus != null) {
            tickBus!!.removeTickable(this)
            tickBus = null
        }
    }
}
