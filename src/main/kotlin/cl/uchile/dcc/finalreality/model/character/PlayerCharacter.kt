//package cl.uchile.dcc.finalreality.model.character
//
//import java.util.*
//import java.util.concurrent.BlockingQueue
//
///**
// * A class that holds all the information of a single character of the game.
// *
// * @property name The name of the character.
// * @property turnsQueue The queue with the characters waiting for their turn.
// * @property characterClass The class of the character.
// *
// * @constructor Creates a new character.
// *
// * @author <a href="https://www.github.com/r8vnhill">R8V</a>
// * @author ~Your name~
// */
//class PlayerCharacter(
//  name: String,
//  turnsQueue: BlockingQueue<GameCharacter>,
//  characterClass: CharacterClass
//) : AbstractCharacter(turnsQueue, name, characterClass) {
//
//  override fun hashCode() = Objects.hash(PlayerCharacter::class, name, characterClass)
//
//  override fun equals(other: Any?) = when {
//    this === other -> true
//    other !is PlayerCharacter -> false
//    else -> characterClass == other.characterClass && name == other.name
//  }
//}