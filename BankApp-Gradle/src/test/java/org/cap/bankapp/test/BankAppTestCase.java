package org.cap.bankapp.test;

import static org.junit.Assert.*;

import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BankAppTestCase {
	
	private AcccountService acccountService;
	
	@BeforeClass
	public static void beforeClass(){
		//System.out.println("@BeforeClass -  method");
	}
	
	@AfterClass
	public static void afterClass(){
		//System.out.println("@@AfterClass -  method");
	}
	
	@Before
	public void setUp(){
		//System.out.println("@Before - setUp method");
		acccountService=new AccountServiceImpl();
	}

	@After
	public void tearDown(){
		//System.out.println("@After - setUp method");
		acccountService=new AccountServiceImpl();
	}
	
	
	@Category(ReportCategory.class)
	@Test
	public void test_addNumbers_Method(){
		assertEquals(33, acccountService.addNumbers(10, 23));
	}
	
	@Category(ReportCategory.class)
	@Test(expected=IllegalArgumentException.class)
	public void test_addAccount_with_nullCustomer() throws InvalidInitialAmountException{
		//acccountService=new AccountServiceImpl();
		Customer customer=null;
		//System.out.println("test_addAccount_with_nullCustomer");
		acccountService.addAccount(customer, 1000);
		
	}
	
	@Category(LoginCategory.class)
	@Test(expected=InvalidInitialAmountException.class)
	public void test_addAccount_with_invalid_initialAmount() throws InvalidInitialAmountException{
		Customer customer=new Customer();
		customer.setCustName("Tom");
		customer.setCustAddress(new Address());
		
		acccountService.addAccount(customer, 100);
	}
	
	@Category(ReportCategory.class)
	@Ignore
	@Test(timeout=10)
	public void test_printLoop_timeout(){
		acccountService.printLoop();
	}
}
