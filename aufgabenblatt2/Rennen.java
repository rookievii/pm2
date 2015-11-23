/*
 * Autor: Chris
 */
package aufgabenblatt2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rennen {

	ArrayList<Rennauto> wagenList;
	int anzWagen;
	DecimalFormat formatter = new DecimalFormat("#0.00");

	public Rennen() {
		wagenList = new ArrayList<Rennauto>();
	}

	/*
	 * Erstellt Rennauto-Objekte und fügt diese in eine Liste ein.
	 */
	public void startFeld(int anzWagen) {

		for (int index = 0; index < anzWagen; index++) {
			wagenList.add(new Rennauto("Wagen" + (index + 1)));
		}

	}

	/*
	 * Startet die Rennauto-Threads
	 */
	private void rennenStart() {

		for (Rennauto wagen : wagenList) {
			wagen.start();
		}

	}

	/*
	 * Wartet auf die Zeitergebnisse und "sammelt" sie mit join()-Methode. Setzt
	 * interrupt-flag in Rennauto-Thread im falle einer InterruptedException.
	 */
	private void rennenEnde() {

		for (Rennauto wagen : wagenList) {
			try {
				wagen.join();
			} catch (InterruptedException e) {
				wagen.interrupt();
				e.printStackTrace();
			}
		}

		System.out.println("Rennen Ende!");
	}
	
	/*
	 * Getter für Abbruch-Thread.
	 */
	public ArrayList<Rennauto> getWagen() {
		return wagenList;
	}
	
	/*
	 * Erstellt einen Abbruch-Thread und übergibt an Rennen-Objekt an diesen.
	 * Startet Abbruch-Thread.
	 */
	public void rennenAbbrechen(Rennen rennen) {
		Abbruch abbruch = new Abbruch(rennen);
		abbruch.run();
	}
	
	
	private void anzeigeTafel() {

		Stream<Rennauto> wagenStream = wagenList.stream();
		wagenStream.sorted((x, y) -> Long.compare(x.avSpeed, y.avSpeed))
				.forEach(
						x -> System.out.println(x.name + ": "
								+ formatter.format((x.avSpeed / 1000.0) / 10.0)
								+ " sek."));

	}

	public static void main(String[] args) throws InterruptedException {

		Rennen x = new Rennen();
		x.startFeld(3);
		x.rennenStart();
		x.rennenAbbrechen(x);
		x.rennenEnde();
		x.anzeigeTafel();

	}

}
