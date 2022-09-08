/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.exceptions

/**
 * This error is used to represent an invalid stat value.
 *
 * @constructor Creates a new `InvalidStatValueException` with a `description` of the
 * error.
 *
 * @author <a href="https://github.com/r8vnhill">R8V</a>
 */
class InvalidStatValueException(description: String) :
    Exception("The required condition is not met. $description")
