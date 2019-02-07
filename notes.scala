/* notes.scala creates the Map of notes to values
 *
 * For CS 214, at Calvin College.
 * Completed by: Sarah Griffioen
 * Date: 05/14/18
 **********************************************************/

package notes

class Notes(aList: List[String]) {

	// create Map (dictionary) mapping note names to numbers
 	val noteMap = Map("Cb" -> 5.5, "C" -> 0, "C#" -> 0.5, "Db" -> 0.5, "D" -> 1,
 		"D#" -> 1.5, "Eb" -> 1.5, "E" -> 2, "E#" -> 2.5, "Fb" -> 2, "F" -> 2.5,
 		"F#" -> 3, "Gb" -> 3, "G" -> 3.5, "G#" -> 4, "Ab" -> 4, "A" -> 4.5,
 		"A#" -> 5, "Bb" -> 5, "B" -> 5.5, "B#" -> 0)


 	// if input is not valid (A-G), quit program
 	def is_valid: String = {
		aList.foreach {
			value =>
			val new_val: String = value.toString
 			if (noteMap.contains(new_val).toString == "false") return "invalid"
 		}
 		"valid"
 	}
}
