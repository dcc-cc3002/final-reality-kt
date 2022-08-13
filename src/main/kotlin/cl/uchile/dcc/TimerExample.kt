package cl.uchile.dcc

import cl.uchile.dcc.finalreality.model.character.CharacterClass
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.PlayerCharacter
import cl.uchile.dcc.finalreality.model.Weapon
import cl.uchile.dcc.finalreality.model.WeaponType
import java.util.concurrent.LinkedBlockingQueue
import kotlin.random.Random

fun main() {
  val queue = LinkedBlockingQueue<GameCharacter>()
  for (i in 0 until 10) {
    // Gives a random speed to each character to generate different waiting times
    val weapon = Weapon("", 0, Random.nextInt(50), WeaponType.KNIFE)
    val character = PlayerCharacter("$i", queue, CharacterClass.THIEF)
    character.equip(weapon)
    character.waitTurn()
  }
  // Waits for 6 seconds to ensure that all characters have finished waiting
  Thread.sleep(6000)
  while (!queue.isEmpty()) {
    // Pops and prints the names of the characters of the queue to illustrate the turns
    // order
    println(queue.poll().name)
  }
}