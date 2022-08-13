package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.model.Weapon

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @property name The name of the character.
 * @property equippedWeapon The weapon equipped by the character.
 * @property characterClass The class of the character.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
interface GameCharacter {
    val name: String
    var equippedWeapon: Weapon
    val characterClass: CharacterClass

    /**
     * Sets a scheduled executor to make this character (thread) wait for `speed / 10`
     * seconds before adding the character to the queue.
     */
    fun waitTurn()

    /**
     * Equips a weapon to the character.
     */
    fun equip(weapon: Weapon)
}


/**
 * Enumeration of the classes a player character may have.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
enum class CharacterClass {
    KNIGHT, ENGINEER, THIEF, BLACK_MAGE, WHITE_MAGE, ENEMY
}
