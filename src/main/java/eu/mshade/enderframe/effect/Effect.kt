package eu.mshade.enderframe.effect

data class Effect(val type: EffectKey, var duration: Int, val amplifier: Int, val particle: Boolean, val ambient: Boolean = false){

    companion object {
        @JvmStatic
        fun builder(type: EffectKey): EffectBuilder {
            return EffectBuilder(type)
        }
    }

}

class EffectBuilder(val type: EffectKey) {

    private var duration: Int = 0
    private var amplifier: Int = 0
    private var particles: Boolean = false
    private var ambient: Boolean = false


    fun duration(duration: Int): EffectBuilder {
        this.duration = duration
        return this
    }

    fun amplifier(amplifier: Int): EffectBuilder {
        this.amplifier = amplifier
        return this
    }

    fun particles(particles: Boolean): EffectBuilder {
        this.particles = particles
        return this
    }

    fun ambient(ambient: Boolean): EffectBuilder {
        this.ambient = ambient
        return this
    }

    fun build(): Effect {
        return Effect(type, duration, amplifier, particles, ambient)
    }

}