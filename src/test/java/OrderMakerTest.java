import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderMakerTest {
	private OrderMaker testOrder;
	private final double tolerance = 0.000001;
	@BeforeEach
	void start() {
		testOrder = new OrderMaker();
	}
	//Check if by default we get a 3.99 coffee when nothing is added
	@Test
	void noAddOnsTest() {
		assertTrue(Math.abs(3.99-testOrder.getTotal()) < tolerance, "Hm, total for plain coffee order wasn't 3.99...");
	}
	//Check if resetting our coffee starts us back at a 3.99 coffee
	@Test
	void defaultResetTest() {
		double originalTotal = testOrder.getTotal();
		testOrder.clear();
		double resetTotal = testOrder.getTotal();
		assertTrue(Math.abs(resetTotal-originalTotal) < tolerance);
	}
	//Check if resetting after using an addon still removes the addon's price
	@Test
	void properResetTest() {
		testOrder.addCream();
		testOrder.clear();
		double resetTotal = testOrder.getTotal();
		//We're using doubles so direct comparison is not a good idea
		assertTrue(Math.abs(3.99-resetTotal) < tolerance);
	}
	@Test
	void extraShotTest() {
		testOrder.addExtraShot();
		double expectation = 3.99 + 1.20;
		assertTrue(Math.abs(expectation - testOrder.getTotal()) < tolerance);
	}
	@Test
	void creamTest() {
		testOrder.addCream();
		double expectation = 3.99 + .50;
		assertTrue(Math.abs(expectation - testOrder.getTotal()) < tolerance);
	}
	@Test
	void sugarTest() {
		testOrder.addSugar();
		double expectation = 3.99 + .50;
		assertTrue(Math.abs(expectation - testOrder.getTotal()) < tolerance);
	}
	@Test
	void lemonJuiceTest() {
		testOrder.addLemonJuice();
		double expectation = 3.99 + .75;
		assertTrue(Math.abs(expectation - testOrder.getTotal()) < tolerance);
	}
	@Test
	void caramelTest() {
		testOrder.addCaramel();
		double expectation = 3.99 + .99;
		assertTrue(Math.abs(expectation - testOrder.getTotal()) < tolerance);
	}
	@Test
	void nuclearWasteTest() {
		testOrder.addNuclearWase();
		double expectation = 3.99 + 49999.99;
		assertTrue(Math.abs(expectation - testOrder.getTotal()) < tolerance);
	}
	@Test
	void combinationTest() {
		testOrder.addSugar();
		testOrder.addCream();
		testOrder.addCaramel();
		testOrder.addExtraShot();
		testOrder.addLemonJuice();
		testOrder.addNuclearWase();
		assertTrue(Math.abs(50007.92-testOrder.getTotal()) < tolerance);
	}

}
