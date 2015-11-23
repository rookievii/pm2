package aufgabenblatt2;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Rennauto extends Thread {

	long startTime = System.currentTimeMillis();
	String name;
	long avSpeed;
	boolean rennenAbgebrochen;

	public Rennauto(String name) {
		super(name);
		this.name = name;
		
	}
	/*	Run-Methode verwendet intern ein While-Schleife, die entweder bis zum
	 * 	Ende der des Tracks läuft oder durch die RennenAbbrechen-Methode abgebrochen wird.
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		int track = 10;
		int meter = 0;

		while ((meter < track) && !isInterrupted()) {

			try {
				TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current()
						.nextInt(800, 1201));
			} catch (InterruptedException e) {
				
				interrupt();
				
			}
				avSpeed = avSpeed + (System.currentTimeMillis() - startTime);
				
				meter++;
				System.err.println(name + ": " + meter + "\\" + track);
			}
			

	}
}
