/*
 * Autor: Chris
 */
package aufgabenblatt2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.*;
import java.util.List;

public class Streams {

	private String[] stringArr = { "Eingabe ", "Äußeres ", null,
			"Strassen-Feger", " ein Haus" };
	/*
	 * Lambda für Umlaut-Austausch.
	 */
	private Function<String, String> umlautRep = (String s) -> s
			.replace("Ä", "AE").replace("Ö", "OE").replace("Ü", "UE")
			.replace("ß", "SS");

	public Streams() {

	}

	public String stringStreamsVerarbeitung(String[] arr) {

		Stream<String> stringStream = Arrays.stream(arr);
		List<String> verarbStringStream = (ArrayList<String>) stringStream
				.filter(p -> p != null)
				// filtert null
				.map(String::toUpperCase)
				// alle Strings zu Großbuchstaben
				.map(String::trim)
				// Schneidet Leerzeichen ab
				.map(umlautRep)
				// ersetzt alle Umlaute, verwendet Function Interface
				.map((String s) -> s.length() <= 8 ? s : s.substring(0, 8))//
				// kürzt alle String
				.collect(Collectors.toList());
				//Terminiert den Stream und sammelt alle Stringelemente in einer List

		return verarbStringStream.toString();

	}
	
	/*
	 * Getter für JUnit Test Case.
	 */
	public String[] getArray() {
		return stringArr;
	}
}
