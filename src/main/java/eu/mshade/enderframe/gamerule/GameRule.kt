package eu.mshade.enderframe.gamerule

import org.slf4j.LoggerFactory

object GameRule {

    private val gameRuleByName = HashMap<String, GameRuleKey>()
    private val logger = LoggerFactory.getLogger(GameRule::class.java)

    val DO_DAYLIGHT_CYCLE = GameRuleKey.of("DO_DAYLIGHT_CYCLE", true)


    init {
        val javaClass = GameRule.javaClass
        val fields = javaClass.declaredFields
        for (field in fields) {
            if (field.type == GameRuleKey::class.java) {
                val gameRuleKey = field.get(javaClass) as GameRuleKey
                gameRuleByName[gameRuleKey.getName()] = gameRuleKey
                logger.debug("Loaded gameRules ${gameRuleKey.getName()}")
            }
        }
    }

    fun getGameRule(name: String): GameRuleKey? {
        return gameRuleByName[name]
    }

    fun getGameRules(): Collection<GameRuleKey> {
        return gameRuleByName.values
    }

    fun registerGameRule(gameRuleKey: GameRuleKey) {
        gameRuleByName[gameRuleKey.getName()] = gameRuleKey
    }

}