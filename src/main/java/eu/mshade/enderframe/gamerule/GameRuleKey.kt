package eu.mshade.enderframe.gamerule

interface GameRuleKey {

    fun getName(): String

    fun getValue(): Any

    companion object {

        fun of(name: String, value: Any): GameRuleKey {
            return DefaultGameRuleKey(name, value)
        }
    }
}

class DefaultGameRuleKey(private val name: String, private val value: Any): GameRuleKey {

    override fun getName(): String {
        return name
    }

    override fun getValue(): Any {
        return value
    }
}