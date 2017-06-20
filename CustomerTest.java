import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.*;

public class CustomerTest {

	// Asserts that creating a new customer instance does not return null
	@Test
	public void testCustomerExists() {

		Customer customer = new Customer();
		assertNotNull(customer);

	}

	// Assert that creating a new Customer instance using the full constructor does not return null
	@Test
	public void testCustomerExistsFullConstructor() {

		Customer customer = new Customer(1, "John Smith");
		assertNotNull(customer);

	}

	// Asserts that changing the Customer name works as compared to an expected value
	@Test
	public void testCustomerNameChange() {

		Customer customer = new Customer(1, "John Smith");
		customer.setName("Joe Doe");
		assertEquals(customer.getName(), "Joe Doe");

	}


	// Asserts that changing the Customer ID works as compared to an expected value
	@Test
	public void testCustomerIdChange() {

		Customer customer = new Customer(1, "John Smith");
		int newId = 2;
		customer.setId(newId);
		assertEquals(newId, customer.getId());

	}

	// Assert that printing the Customer returns an expected value.
	@Test
	public void testCustomerIsPrintable() {

		Customer customer = new Customer(1, "John Smith");
		String expectedToString = "Customer Id 1. John Smith";
		assertEquals(expectedToString, customer.toString());

	}

}
