import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.*;

public class CatTest {

	// Assert that creating a new Cat instance does not return null
	@Test
	public void testCatExists() {

		Cat cat = new Cat();
		assertNotNull(cat);

	}

	// Assert that creating a new Cat instance using the full constructor does not return null
	@Test
	public void testCatExistsFullConstructor() {

		Cat cat = new Cat(1, "bob", 75.00);
		assertNotNull(cat);

	}

	// Asserts that changing the Cat name works as compared to an expected value
	@Test
	public void testCatNameChange() {

		Cat cat = new Cat(1, "bob", 75.00);
		String newName = "bobby";
		cat.setName(newName);
		assertEquals(newName, cat.getName());

	}

	// Asserts that changing the Cat ID works as compared to an expected value
	@Test
	public void testCatIdChange() {

		Cat cat = new Cat(1, "bob", 75.00);
		int newId = 2;
		cat.setId(newId);
		assertEquals(newId, cat.getId());

	}

	// Asserts that changing the Cat rental cost works as compared to an expected value
	@Test
	public void testCatCostChange() {

		Cat cat = new Cat(1, "bob", 75.00);
		double newCost = 200.00;
		cat.setCost(newCost);
		assertEquals(newCost, cat.getCost(), 1.00);

	}

	// Asserts that renting a Cat works and returns true
	@Test
	public void testCatIsRentable() {

		Cat cat = new Cat(1, "bob", 75.00);
		int rentorId = 3;
		boolean isRented = cat.rentCat(rentorId);
		assertEquals(isRented, true);

	}

	// Asserts that returning a Cat works and returns true
	@Test
	public void testCatIsReturnable() {

		Cat cat = new Cat(1, "bob", 75.00);
		int rentorId = 3;
		boolean isRented = cat.rentCat(rentorId);
		boolean isReturned = cat.returnCat();
		assertEquals(isReturned, true);

	}

	// Assert that printing the Cat returns an expected value.
	@Test
	public void testCatIsPrintable() {

		Cat cat = new Cat(1, "bob", 75.00);
		String expectedToString = "ID " + 1 + ". bob: " + 75.00 ;
		assertEquals(expectedToString, cat.toString());

	}

	// Asserts that attempting to rent an already rented out Cat does not work and returns false
	@Test
	public void testCatNoMultipleRents() {

		Cat cat = new Cat(1, "bob", 75.00);
		int rentorId = 3;
		boolean isRented = cat.rentCat(rentorId);
		boolean tryAgain = cat.rentCat(rentorId);
		assertEquals(tryAgain, false);

	}

	// Asserts that attempting to return a Cat that is not rented out does not work and returns false
	@Test
	public void testCatNoMultipleReturns() {

		Cat cat = new Cat(1, "bob", 75.00);
		int rentorId = 3;
		boolean isRented = cat.rentCat(rentorId);
		boolean isReturned = cat.returnCat();
		boolean returnAgain = cat.returnCat();
		assertEquals(returnAgain, false);

	}

}
