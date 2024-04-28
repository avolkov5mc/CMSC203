package CMSC203_Assignment6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BevShopTestStudent {

	BevShop shop;
	Order orderTwo;
	Order orderThree;

	@BeforeEach
	public void setUp() throws Exception {
		shop = new BevShop();

		Order orderOne = new Order(9, Day.MONDAY, new Customer("Alex", 24));
		orderOne.addNewBeverage("Latte", Size.SMALL, false, true);
		orderOne.addNewBeverage("Mimosa", Size.MEDIUM);
		orderOne.addNewBeverage("Mango", Size.MEDIUM, 1, true);

		shop.startNewOrder(9, Day.MONDAY,"Alex", 24);
		shop.processCoffeeOrder("Latte", Size.SMALL, false, true); // 2.5
		shop.processAlcoholOrder("Mimosa", Size.MEDIUM); // 2.5
		shop.processSmoothieOrder("Mango", Size.MEDIUM, 1, true); // 4.5

		orderTwo = new Order(14, Day.THURSDAY, new Customer("Sarah", 31));
		orderTwo.addNewBeverage("Latte", Size.LARGE, false, false);
		orderTwo.addNewBeverage("Mimosa", Size.LARGE);

		shop.startNewOrder(14, Day.THURSDAY,"Sarah", 31);
		shop.processCoffeeOrder("Latte", Size.LARGE, false, false); // 3.0
		shop.processAlcoholOrder("Mimosa", Size.LARGE); // 3.0

		orderThree = new Order(20, Day.SUNDAY, new Customer("Stephen", 25));
		orderThree.addNewBeverage("Mimosa", Size.MEDIUM);

		shop.startNewOrder(20, Day.SUNDAY,"Stephen", 25);
		shop.processAlcoholOrder("Mimosa", Size.MEDIUM);// 3.1 on weekends
	}

	@AfterEach
	public void tearDown() throws Exception {
		shop = null;
		orderTwo = orderThree = null;
	}

	@Test
	public void testTotalMonthlySale() {
		assertEquals(18.6, shop.totalMonthlySale());
	}

	@Test
	public void testMonthlyOrders() {
		assertEquals(3, shop.totalNumOfMonthlyOrders());
	}

	@Test
	public void testFindOrders() {
		int lastOrder = shop.getCurrentOrder().getOrderNumber();
		assertEquals(2, shop.findOrder(lastOrder));
	}

}
