/* operations.scala defines all the operations on the notes
 *
 * For CS 214, at Calvin College.
 * Completed by: Sarah Griffioen
 * Date: 05/14/18
 **********************************************************/

 package operations

 import notes.Notes

 class Operations(aList: List[String]) {

 	// create an instance of the notes class to be able to reference the Map
 	val note_class = new Notes(aList)

 	// define and initialize first, second and third notes
 	val first: String = aList(0)
 	val second: String = aList(1)
 	val third: String = aList(2)

 	// store first interval
 	val first_int: String = interval_quality(first, second)

 	// store second interval
 	val second_int: String = interval_quality(second, third)

 	// calculate distance between two notes
 	def difference(a: Double, b: Double): Double = {
 		if ((b - a) < 0) {
 			(b + 6) - a
 		} else {
 			b - a
 		}
 	}

 	// returns the quality of the chord (first interval)
 	def interval_quality(n1: String, n2: String): String = {
 		val note1: Double = note_class.noteMap(n1).asInstanceOf[Number].doubleValue
 		val note2: Double = note_class.noteMap(n2).asInstanceOf[Number].doubleValue
 		if (difference(note1, note2) == 0.5) "half" // half step
 		else if (difference(note1, note2) == 1) "whole" // whole step
 		else if (difference(note1, note2) == 1.5) "minor third"
 		else if (difference(note1, note2) == 2) "major third"
 		else if (difference(note1, note2) == 2.5) "fourth"
 		else if (difference(note1, note2) == 3) "tritone"
 		else if (difference(note1, note2) == 4) "diminished fourth"
 		else "none"
 	}

 	// prints out name of scales
 	def create_scale: String = {

 		// store the rest of the intervals after the first two
 		val fourth: String = aList(3)
 		val fifth: String = aList(4)
 		val sixth: String = aList(5)
 		val seventh: String = aList(6)
 		val eigth: String = aList(7)
 		val third_int: String = interval_quality(third, fourth)
 		val fourth_int: String = interval_quality(fourth, fifth)
 		val fifth_int: String = interval_quality(fifth, sixth)
 		val sixth_int: String = interval_quality(sixth, seventh)
 		val seventh_int: String = interval_quality(seventh, eigth)

 		if (first_int == "whole" && second_int == "whole" && third_int == "half" &&
 			fourth_int == "whole" && fifth_int == "whole" && sixth_int == "whole" && seventh_int == "half") {
 			(s"Answer: $first major scale")
 		} else if (first_int == "whole" && second_int == "half" && third_int == "whole" &&
 			fourth_int == "whole" && fifth_int == "half" && sixth_int == "whole" && seventh_int == "whole") {
 			(s"Answer: $first natural minor scale")
 		} else if (first_int == "whole" && second_int == "half" && third_int == "whole" &&
 			fourth_int == "whole" && fifth_int == "half" && sixth_int == "minor third" && seventh_int == "half") {
 			(s"Answer: $first harmonic minor scale")
 		} else if (first_int == "whole" && second_int == "half" && third_int == "whole" &&
 			fourth_int == "whole" && fifth_int == "whole" && sixth_int == "whole" && seventh_int == "half") {
 			(s"Answer: $first melodic minor scale")
 		} else if (first_int == "whole" && second_int == "half" && third_int == "whole" &&
 			fourth_int == "whole" && fifth_int == "whole" && sixth_int == "half" && seventh_int == "whole") {
 			(s"Answer: $first dorian scale")
 		} else if (first_int == "half" && second_int == "whole" && third_int == "whole" &&
 			fourth_int == "whole" && fifth_int == "half" && sixth_int == "whole" && seventh_int == "whole") {
 			(s"Answer: $first phrygian scale")
 		} else if (first_int == "whole" && second_int == "whole" && third_int == "whole" &&
 			fourth_int == "half" && fifth_int == "whole" && sixth_int == "whole" && seventh_int == "half") {
 			(s"Answer: $first lydian scale")
 		} else if (first_int == "whole" && second_int == "whole" && third_int == "half" &&
 			fourth_int == "whole" && fifth_int == "whole" && sixth_int == "half" && seventh_int == "whole") {
 			(s"Answer: $first mixolydian scale")
 		} else if (first_int == "half" && second_int == "whole" && third_int == "whole" &&
 			fourth_int == "half" && fifth_int == "whole" && sixth_int == "whole" && seventh_int == "whole") {
 			(s"Answer: $first locrian scale")
 		} else {
 			("ERROR: Not a traditional scale.")
 		}
 	}

 	// prints out name of triad
 	def create_triad: String = {
 		// diminished
 		if (first_int == "minor third" && second_int == "minor third") {
 			(s"Answer: $first diminished triad")
 		} else if (first_int == "minor third" && second_int == "tritone") {
 			(s"Answer: $third diminished triad in first inversion")
 		} else if (first_int == "tritone" && second_int == "minor third") {
 			(s"Answer: $second diminished triad in second inversion")
 		}

 		// minor
 		else if (first_int == "minor third" && second_int == "major third") {
 			(s"Answer: $first minor triad")
 		} else if (first_int == "major third" && second_int == "fourth") {
 			(s"Answer: $third minor triad in first inversion")
 		} else if (first_int == "fourth" && second_int == "minor third") {
 			(s"Answer: $second minor triad in second inversion")
 		}

 		// major
 		else if (first_int == "major third" && second_int == "minor third") {
 			(s"Answer: $first major triad")
 		} else if (first_int == "minor third" && second_int == "fourth") {
 			(s"Answer: $third major triad in first inversion")
 		} else if (first_int == "fourth" && second_int == "major third") {
 			(s"Answer: $second major triad in second inversion")
 		}

 		// augmented
 		else if (first_int == "major third" && second_int == "major third") {
 			(s"Answer: $first augmented triad")
 		} else if (first_int == "major third" && second_int == "diminished fourth") {
 			(s"Answer: $third augmented triad in first inversion")
 		} else if (first_int == "diminished fourth" && second_int == "major third") {
 			(s"Answer: $second augmented triad in second inversion")
 		} else {
 			(s"ERROR: Answer: $first $second $third does not form a traditional triad.")
 		}
 	}

 	// prints out name of seventh chord
 	def create_seventh_chord: String =  {

 		// store third interval of chord
 		val fourth: String = aList(3)
 		val third_int: String = interval_quality(third, fourth)

 		// fully diminished (no inversions because it is symmetrical)
 		if (first_int == "minor third" && second_int == "minor third" && third_int == "minor third") {
 			(s"Answer: $first fully diminished seventh chord")
 		}
 		
 		// half diminished
 		else if (first_int == "minor third" && second_int == "minor third" && third_int == "major third") {
 			(s"Answer: $first half diminished seventh chord")
 		} else if (first_int == "minor third" && second_int == "major third" && third_int == "whole") {
 			(s"Answer: $fourth half diminished seventh chord in first inversion")
 		} else if (first_int == "major third" && second_int == "whole" && third_int == "minor third") {
 			(s"Answer: $third half diminished seventh chord in second inversion")
 		} else if (first_int == "whole" && second_int == "minor third" && third_int == "minor third") {
 			(s"Answer: $second half diminished seventh chord in third inversion")
 		}

 		// minor
 		else if (first_int == "minor third" && second_int == "major third" && third_int == "minor third") {
 			(s"Answer: $first minor seventh chord")
 		} else if (first_int == "major third" && second_int == "minor third" && third_int == "whole") {
 			(s"Answer: $fourth minor seventh chord in first inversion")
 		} else if (first_int == "minor third" && second_int == "whole" && third_int == "minor third") {
 			(s"Answer: $third minor seventh chord in second inversion")
 		} else if (first_int == "whole" && second_int == "minor third" && third_int == "major third") {
 			(s"Answer: $second minor seventh chord in third inversion")
 		}

 		// dominant
 		else if (first_int == "major third" && second_int == "minor third" && third_int == "minor third") {
 			(s"Answer: $first dominant seventh chord")
 		} else if (first_int == "minor third" && second_int == "minor third" && third_int == "whole") {
 			(s"Answer: $fourth dominant seventh chord in first inversion")
 		} else if (first_int == "minor third" && second_int == "whole" && third_int == "major third") {
 			(s"Answer: $third dominant seventh chord in second inversion")
 		} else if (first_int == "whole" && second_int == "major third" && third_int == "minor third") {
 			(s"Answer: $second dominant seventh chord in third inversion")
 		}

 		// major
 		else if (first_int == "major third" && second_int == "minor third" && third_int == "major third") {
 			(s"Answer: $first major seventh chord")
 		} else if (first_int == "minor third" && second_int == "major third" && third_int == "half") {
 			(s"Answer: $fourth major seventh chord in first inversion")
 		} else if (first_int == "major third" && second_int == "half" && third_int == "major third") {
 			(s"Answer: $third major seventh chord in second inversion")
 		} else if (first_int == "half" && second_int == "major third" && third_int == "minor third") {
 			(s"Answer: $second major seventh chord in third inversion")
 		} else {
 			(s"ERROR: Answer: $first $second $third $fourth does not form a traditional seventh chord.")
 		}
 	}

 }









