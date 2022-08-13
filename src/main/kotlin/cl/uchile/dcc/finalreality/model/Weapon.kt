package cl.uchile.dcc.finalreality.model

import java.util.*

/**
 * A class that holds all the information of a weapon.
 *
 * @property name String
 *     The name of the weapon.
 * @property damage Int
 *     The base damage done by the weapon.
 * @property weight Int
 *     The weight of the weapon.
 * @property type WeaponType
 *     The type of the weapon.
 *
 * @constructor Creates a weapon with a name, a base damage, speed, and it's type.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
class Weapon(
  private val name: String,
  private val damage: Int,
  val weight: Int,
  private val type: WeaponType
) {

  override fun equals(other: Any?) = when {
    this === other -> true
    other !is Weapon -> false
    else -> {
      name == other.name && damage == other.damage && weight == other.weight && type == other.type
    }
  }

  override fun hashCode() = Objects.hash(Weapon::class, name, damage, weight, type)
}

/**
 * Enumeration of all the weapon types.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
enum class WeaponType {
  SWORD, AXE, KNIFE, STAFF, BOW
}