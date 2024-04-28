package CMSC203_Assignment6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlcoholTestStudent {

	Alcohol alcohol1;
	Alcohol alcohol2;

	@BeforeEach
	public void setUp() throws Exception {
		alcohol1 = new Alcohol("mimosa", Size.MEDIUM, false);
		alcohol2 = new Alcohol("mimosa", Size.LARGE, true);
	}

	@AfterEach
	public void tearDown() throws Exception {
		alcohol1 = alcohol2 = null;
	}

	@Test
	public void testPrice() {
		assertEquals(2.5, alcohol1.calcPrice(), .01);
		assertEquals(3.6, alcohol2.calcPrice(), .01);
	}

	@Test
	public void testEquals() {
		assertEquals(alcohol1, alcohol1);
	}

}
