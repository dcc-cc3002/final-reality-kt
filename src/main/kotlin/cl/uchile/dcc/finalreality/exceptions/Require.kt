/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.exceptions

/**
 * Object containing a series of methods to check if a condition is met.
 * If the condition is not met, an exception is thrown.
 *
 * @author <a href="https://github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
object Require {

    /**
     * Helper class to represent a _stat_ constraint.
     * When a _stat_ constraint is not met, an [InvalidStatValueException] is thrown.
     *
     * @property stat   the value of the stat to check
     * @property name   the name of the stat to check
     *
     * @constructor Creates a new _stat_ constraint.
     */
    class Stat(private val stat: Int, private val name: String) {

        /**
         * Checks if the stat is greater than or equal to the given value.
         * If the condition is met, the stat value is returned.
         */
        infix fun atLeast(i: Int) = if (stat >= i) {
            stat
        } else {
            throw InvalidStatValueException("'$name' ($stat must be at least $i)")
        }

        /**
         * Checks if the stat is in the given range.
         * If the condition is met, the stat value is returned.
         */
        infix fun inRange(range: IntRange) = if (stat in range) {
            stat
        } else {
            throw InvalidStatValueException("'$name' ($stat must be in range $range)")
        }
    }
}
