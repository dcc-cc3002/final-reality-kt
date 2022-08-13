package cl.uchile.dcc.finalreality.model.character

import java.util.*
import java.util.concurrent.BlockingQueue

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @property weight The weight of this enemy.
 * @property name The name of this enemy.
 * @property turnsQueue The queue with the characters waiting for their turn.
 *
 * @constructor Creates a new enemy with a name, a weight and the queue with the characters ready to
 * play.
 *
 * @author Ignacio Slater Muñoz
 * @author `Your name`
 */
class Enemy(
  name: String,
  val weight: Int,
  turnsQueue: BlockingQueue<GameCharacter>
) : AbstractCharacter(turnsQueue, name, CharacterClass.ENEMY) {

  override fun equals(other: Any?) = when {
    this === other -> true
    other !is Enemy -> false
    else -> name == other.name && weight == other.weight
  }

  override fun hashCode() = Objects.hash(Enemy::class, name, weight)
}