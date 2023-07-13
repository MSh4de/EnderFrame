package eu.mshade.enderframe.effect

data class PotionEffect(val type: PotionEffectKey, var duration: Int, val amplifier: Int, val particle: Boolean, val ambient: Boolean = false){

    companion object {
        @JvmStatic
        fun builder(type: PotionEffectKey): PotionEffectBuilder {
            return PotionEffectBuilder(type)
        }
    }

}

class PotionEffectBuilder(val type: PotionEffectKey) {

    private var duration: Int = 0
    private var amplifier: Int = 0
    private var particles: Boolean = false
    private var ambient: Boolean = false


    fun duration(duration: Int): PotionEffectBuilder {
        this.duration = duration
        return this
    }

    fun amplifier(amplifier: Int): PotionEffectBuilder {
        this.amplifier = amplifier
        return this
    }

    fun particles(particles: Boolean): PotionEffectBuilder {
        this.particles = particles
        return this
    }

    fun ambient(ambient: Boolean): PotionEffectBuilder {
        this.ambient = ambient
        return this
    }

    fun build(): PotionEffect {
        return PotionEffect(type, duration, amplifier, particles, ambient)
    }

}