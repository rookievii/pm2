/*
 * Autor: Chris
 */
package aufgabenblatt2;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Abbruch extends Thread {

	
	ArrayList<Rennauto> rennenList;
	boolean flag;

	

	public Abbruch(Rennen rennen) {
		
		rennenList = rennen.getWagen();
		
	}
	/*Sendet mit einer Wahrscheinlichkeit interrupt an die Rennauto-Threads.
	 * Beendet sich selbst, wenn interrupt gesendet wurde.
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while (!flag) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			if (ThreadLocalRandom.current().nextInt(0, 2) == 1) {
				for (Rennauto wagen : rennenList) {
					wagen.interrupt();

				}
				flag = true;
				System.out.println("Abbruch wegen Unfall!\n");

			}
		}
	}

}
