package cl.uchile.dcc.finalreality.exceptions

object Require {
    class Stat(private val stat: Int, private val name: String) {
        infix fun atLeast(i: Int) = if (stat >= i) {
            stat
        } else {
            throw InvalidStatValueException("'$name'($stat must be at least $i")
        }

        infix fun inRange(range: IntRange) = if (stat in range) {
            stat
        } else {
            throw InvalidStatValueException(
              "'$name'($stat must be in range $range")
        }
    }
}
