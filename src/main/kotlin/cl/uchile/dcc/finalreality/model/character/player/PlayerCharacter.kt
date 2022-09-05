/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.Weapon
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import java.util.concurrent.BlockingQueue

/**
 * A character controlled by the user.
 *
 * @property equippedWeapon
 *    the weapon that the character is currently using
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
interface PlayerCharacter {
  val equippedWeapon: Weapon

  /**
   * Equips a weapon to the character.
   */
  fun equip(weapon: Weapon)
}

/**
 * A class that holds all the information of a player-controlled character in the game.
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param defense     the character's defense
 * @param turnsQueue  the queue with the characters waiting for their turn
 * @constructor Creates a new playable character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
abstract class AbstractPlayerCharacter(
  name: String,
  maxHp: Int,
  defense: Int,
  turnsQueue: BlockingQueue<GameCharacter>
) : AbstractCharacter(name, maxHp, defense, turnsQueue), PlayerCharacter {

  private lateinit var _equippedWeapon: Weapon
  override val equippedWeapon: Weapon
    get() = _equippedWeapon

  override fun equip(weapon: Weapon) {
    _equippedWeapon = weapon
  }
}