package CMSC203_Assignment6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTestStudent {
	Order orderOne, orderTwo, orderThree;

	@BeforeEach
	public void setUp() throws Exception {
		orderOne = new Order(9, Day.MONDAY, new Customer("Alex", 19));
		orderTwo = new Order(14, Day.THURSDAY, new Customer("Sarah", 17));
		orderThree = new Order(20, Day.SUNDAY, new Customer("Stephen", 25));
	}

	@AfterEach
	public void tearDown() throws Exception {
		orderOne = orderTwo = orderThree = null;
	}

	@Test
	public void testGetBeverage() {
		Coffee cf = new Coffee("Latte", Size.SMALL, false, true);
		Alcohol al = new Alcohol("Mimosa", Size.MEDIUM, false);
		Smoothie sm1 = new Smoothie("Mango", Size.MEDIUM, 1, true);
		Smoothie sm2 = new Smoothie("Blueberry", Size.LARGE, 1, false);

		orderOne.addNewBeverage("Latte", Size.SMALL, false, true);
		orderOne.addNewBeverage("Mimosa", Size.MEDIUM);
		orderOne.addNewBeverage("Mango", Size.MEDIUM, 1, true);
		assertTrue(orderOne.getBeverage(0).equals(cf));
		assertTrue(orderOne.getBeverage(1).equals(al));
		assertTrue(orderOne.getBeverage(2).equals(sm1));
		assertFalse(orderOne.getBeverage(2).equals(sm2));
	}

	@Test
	public void testCalcOrderTotal() {
		Coffee cf = new Coffee("Latte", Size.SMALL, false, true); //2.5
		Alcohol al = new Alcohol("Mimosa", Size.MEDIUM, false); //2.5
		Smoothie sm1 = new Smoothie("Mango", Size.MEDIUM, 1, true); // 4.5

		orderTwo.addNewBeverage("Latte", Size.SMALL, false, true);
		orderTwo.addNewBeverage("Mimosa", Size.MEDIUM);
		orderTwo.addNewBeverage("Mango", Size.MEDIUM, 1, true);

		double sum = cf.calcPrice() + al.calcPrice() + sm1.calcPrice();

		assertEquals(sum, orderTwo.calcOrderTotal(), .01);
		assertEquals(9.5, orderTwo.calcOrderTotal(), .01);

		orderThree.addNewBeverage("Mimosa", Size.MEDIUM); // 3.1 on weekends

		assertEquals(3.1, orderThree.calcOrderTotal(), .01);

	}

}
