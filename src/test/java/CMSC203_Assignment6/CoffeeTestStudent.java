package CMSC203_Assignment6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeTestStudent {

	Coffee coffee1;
	Coffee coffee2;

	@BeforeEach
	public void setUp() throws Exception {
		coffee1 = new Coffee("espresso", Size.MEDIUM, false, false);
		coffee2 = new Coffee("latte", Size.MEDIUM, true, true);
	}

	@AfterEach
	public void tearDown() throws Exception {
		coffee1 = coffee2 = null;
	}

	@Test
	public void testPrice() {
		assertEquals(2.5, coffee1.calcPrice(), .01);
		assertEquals(3.5, coffee2.calcPrice(), .01);
	}

	@Test
	public void testEquals() {
		assertEquals(coffee1, coffee1);
	}

}
