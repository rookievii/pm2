/*
 * Autor: Chris
 */

package aufgabenblatt2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.*;



public class Rechner {

	public enum Operation {
		ADDITION, SUBTRAKTION, MULTIPLIKATION, DIVISION
	}

	private Map<Operation, BinaryOperator<Double>> map;
	
	/*
	 * Lambda Addition
	 */
	private BinaryOperator<Double> addition = (x, y) -> {
		return x + y;
	};
	
	/*
	 * Lambda Subtraktion
	 */
	private BinaryOperator<Double> subtraktion = (x, y) -> {
		return x - y;
	};
	
	/*
	 * Lambda Mulitplikation
	 */
	private BinaryOperator<Double> multiplikation = (x, y) -> {
		return x * y;
	};
	
	/*
	 * Lambda Division
	 */
	private BinaryOperator<Double> division = (x, y) -> {
		return x / y;
	};

	/*
	 * Lambda Nullstelle, Functional Interface DoubleDoubleZuDouble
	 */
	DoubleDoubleZuDouble<Double> nullstelle = (a, b) -> {
		return (b * -1) / a;
	};

	/*
	 * Lambda Multiplikation, Functional Interface DoubleDoubleZuDouble
	 */
	private DoubleDoubleZuDouble<Double> multi = (x, y) -> {
		return x * y;
	};

	
	 
	
	public Rechner() {
		map = new HashMap<Rechner.Operation, BinaryOperator<Double>>();
		map.put(Operation.ADDITION, addition);
		map.put(Operation.SUBTRAKTION, subtraktion);
		map.put(Operation.MULTIPLIKATION, multiplikation);
		map.put(Operation.DIVISION, division);
	}
	
	
	/*
	 * Berechnecht die gewünschten Werte mit der Gewünschten Operation.
	 */
	public double berechne(Operation sign, double x, double y) {

		return map.get(sign).apply(x, y);
	}
	
	/*
	 * Berechnete die gewünschten Werte mit der Functionalen Interface DoubleDoubleZuDouble
	 */
	
	public double auswerten(DoubleDoubleZuDouble<Double> berechnung, double x,
			double y) {
		return berechnung.werteAus(x, y);
	}
	/*
	 * Getter für JUnit Testcase.
	 */
	public DoubleDoubleZuDouble<Double> getMulti() {
		return multi;
	}

	public DoubleDoubleZuDouble<Double> getNullstelle() {
		return nullstelle;
	}

}
