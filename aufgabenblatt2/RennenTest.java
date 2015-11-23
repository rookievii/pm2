package aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Test;

public class RennenTest {

	@Test
	public void testStartFeld() {
		Rennen x = new Rennen();
		x.startFeld(3);
		assertEquals(3, x.wagenList.size());
	}

}
