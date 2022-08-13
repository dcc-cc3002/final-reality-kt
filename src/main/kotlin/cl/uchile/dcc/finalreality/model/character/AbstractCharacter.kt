package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.model.Weapon
import java.util.concurrent.BlockingQueue
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @property turnsQueue The queue with the characters waiting for their turn.
 * @property name The name of the character.
 * @property characterClass The class of the character.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
abstract class AbstractCharacter protected constructor(
  private val turnsQueue: BlockingQueue<GameCharacter>,
  override val name: String,
  override val characterClass: CharacterClass
) : GameCharacter {

  private lateinit var scheduledExecutor: ScheduledExecutorService
  override lateinit var equippedWeapon: Weapon

  override fun waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor()
    when (this) {
      is PlayerCharacter -> {
        scheduledExecutor.schedule(
          /* command = */ ::addToQueue,
          /* delay = */ (equippedWeapon.weight / 10).toLong(),
          /* unit = */ TimeUnit.SECONDS
        )
      }

      is Enemy -> {
        scheduledExecutor.schedule(
          /* command = */ ::addToQueue,
          /* delay = */ (this.weight / 10).toLong(),
          /* unit = */ TimeUnit.SECONDS)
      }
    }
  }

  /**
   * Adds this character to the turns queue.
   */
  private fun addToQueue() {
    turnsQueue.put(this)
    scheduledExecutor.shutdown()
  }

  override fun equip(weapon: Weapon) {
    if (this is PlayerCharacter) {
      equippedWeapon = weapon
    }
  }
}