package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.model.Weapon

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @property name
 *    The name of the character.
 * @property maxHp
 *    The maximum health points of the character.
 * @property defense
 *    The defense of the character.
 * @property currentHp
 *    The current health points of the character.
 * @property equippedWeapon
 *    The weapon equipped by the character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
interface GameCharacter {
  val name: String
  val maxHp: Int
  var currentHp: Int
  val defense: Int

  /**
   * Sets a scheduled executor to make this character (thread) wait for `speed / 10`
   * seconds before adding the character to the queue.
   */
  fun waitTurn()
}


/**
 * Enumeration of the classes a player character may have.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
enum class CharacterClass {
  KNIGHT, ENGINEER, THIEF, BLACK_MAGE, WHITE_MAGE, ENEMY
}
