package CMSC203_Assignment6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmoothieTestStudent {

	Smoothie smoothie1;
	Smoothie smoothie2;

	@BeforeEach
	public void setUp() throws Exception {
		smoothie1 = new Smoothie("strawberry", Size.SMALL, 1, true);
		smoothie2 = new Smoothie("mango", Size.LARGE, 3, false);
	}

	@AfterEach
	public void tearDown() throws Exception {
		smoothie1 = smoothie2 = null;
	}

	@Test
	public void testPrice() {
		assertEquals(4.0, smoothie1.calcPrice(), .01);
		assertEquals(4.5, smoothie2.calcPrice(), .01);
	}

	@Test
	public void testEquals() {
		assertEquals(smoothie1, smoothie1);
	}

}
