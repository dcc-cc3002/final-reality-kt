@file:Suppress("unused")

package cl.uchile.dcc.finalreality.model

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.property.Arb
import io.kotest.property.Exhaustive
import io.kotest.property.arbitrary.enum
import io.kotest.property.arbitrary.positiveInt
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll
import io.kotest.property.exhaustive.enum

class WeaponTest : AnnotationSpec() {
  // region : EQUALITY
  @Test
  suspend fun `weapons are only equal if their type is the same`() {
    // ``checkAll`` will run the tests for random permutations of values
    checkAll(
      Arb.string(),       // The name is an Arbitrary (Random) String including common edge cases
      Arb.positiveInt(),  // The damage is an Arbitrary (Random) Positive Int including common edge cases
      Arb.positiveInt(),  // The weight is an Arbitrary (Random) Positive Int including common edge cases
      Exhaustive.enum<WeaponType>(), // The type is an Exhaustive collection of all WeaponTypes
      Exhaustive.enum<WeaponType>()
    ) { name, damage, weight, type1, type2 ->
      val weapon1 = Weapon(name, damage, weight, type1)
      val weapon2 = Weapon(name, damage, weight, type2)
      if (type1 == type2) {
        weapon1 shouldBe weapon2
        weapon1 should haveSameHashCodeAs(weapon2)
      } else {
        weapon1 shouldNotBe weapon2
        weapon1 shouldNot haveSameHashCodeAs(weapon2)
      }
    }
  }

  @Test
  suspend fun `weapons are only equal if they have the same name`() {
    checkAll(
      Arb.string(), Arb.string(), Arb.positiveInt(), Arb.positiveInt(), Arb.enum<WeaponType>()
    ) { name1, name2, damage, weight, type ->
      val weapon1 = Weapon(name1, damage, weight, type)
      val weapon2 = Weapon(name2, damage, weight, type)
      if (name1 == name2) {
        weapon1 shouldBe weapon2
        weapon1 should haveSameHashCodeAs(weapon2)
      } else {
        weapon1 shouldNotBe weapon2
        weapon1 shouldNot haveSameHashCodeAs(weapon2)
      }
    }
  }

  @Test
  suspend fun `weapons are only equal if they have the same damage`() {
    checkAll(
      Arb.string(), Arb.positiveInt(), Arb.positiveInt(), Arb.positiveInt(), Arb.enum<WeaponType>()
    ) { name, damage1, damage2, weight, type ->
      val weapon1 = Weapon(name, damage1, weight, type)
      val weapon2 = Weapon(name, damage2, weight, type)
      if (damage1 == damage2) {
        weapon1 shouldBe weapon2
        weapon1 should haveSameHashCodeAs(weapon2)
      } else {
        weapon1 shouldNotBe weapon2
        weapon1 shouldNot haveSameHashCodeAs(weapon2)
      }
    }
  }

  @Test
  suspend fun `weapons are only equal if they have the same weight`() {
    checkAll(
      Arb.string(), Arb.positiveInt(), Arb.positiveInt(), Arb.positiveInt(), Arb.enum<WeaponType>()
    ) { name, damage, weight1, weight2, type ->
      val weapon1 = Weapon(name, damage, weight1, type)
      val weapon2 = Weapon(name, damage, weight2, type)
      if (weight1 == weight2) {
        weapon1 shouldBe weapon2
        weapon1 should haveSameHashCodeAs(weapon2)
      } else {
        weapon1 shouldNotBe weapon2
        weapon1 shouldNot haveSameHashCodeAs(weapon2)
      }
    }
  }

    @Test
    suspend fun `weapons are only equal if they have the same type`() {
//      checkAll(
//        Arb.string(),
//        Arb.positiveInt(),
//        Arb.positiveInt(),
//        Arb.positiveInt(),
//        Arb.enum<WeaponType>(),
//        Arb.enum<WeaponType>()
//      ) { name, damage, weight, type1, type2 ->
//
//      }
//    }
  }
  // endregion
}
