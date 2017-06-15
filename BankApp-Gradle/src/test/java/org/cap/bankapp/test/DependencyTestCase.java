package org.cap.bankapp.test;

import static org.junit.Assert.*;

import org.cap.dao.AccountDao;
import org.cap.dto.Account;
import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.exception.InsufficientBalanceException;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class DependencyTestCase {

	
	@Mock
	private AccountDao accountDao;
	private AcccountService acccountService;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		acccountService=new AccountServiceImpl(accountDao);
	}
	
	
	
	@Test
	public void test_findAccountById(){
		
		//Declaration
		Customer customer=new Customer();
		customer.setCustName("Tom");
		customer.setCustAddress(new Address());
		
		Account account=new Account();
		account.setAccountNo(1001);
		account.setCustomer(customer);
		account.setAmount(5000);
		
		Mockito.when(accountDao.findAccountById(1001)).thenReturn(account);
		
		//Actual Logic
		Account findAccount=acccountService.findAccountById(1001);
		
		//Verfication
		Mockito.verify(accountDao).findAccountById(1001);
		Assert.assertEquals(5000, findAccount.getAmount(),0.0);
		Assert.assertNotNull(findAccount.getCustomer());
		
	}
	
	@Test
	public void test_addAccount_withMock() throws InvalidInitialAmountException{
		Customer customer=new Customer();
		customer.setCustName("Tom");
		customer.setCustAddress(new Address());
		
		Account account=new Account();
		account.setCustomer(customer);
		account.setAmount(1000);
		
		//Declaration
		Mockito.when(accountDao.createAccount(account)).thenReturn(true);
		
		//Actual Logic
		Account newAccount=acccountService.addAccount(customer, 1000);
		
		//Verification
		Mockito.verify(accountDao).createAccount(account);
		assertEquals(newAccount.getAmount(), account.getAmount(),0.0);
	}
	
	@Test
	public void test_deposit_withMock(){
		//Declaration
		Customer customer=new Customer();
		customer.setCustName("Tom");
		customer.setCustAddress(new Address());
		
		Account account=new Account();
		account.setAccountNo(1001);
		account.setCustomer(customer);
		account.setAmount(5000);
		
		Mockito.when(accountDao.findAccountById(1001)).thenReturn(account);
		
		//actual
		Account depoAccount=acccountService.deposit(1001, 300);
		
		//Verification
		Mockito.verify(accountDao).findAccountById(1001);
		assertEquals(5300, depoAccount.getAmount(),0.0);
		
		
	}
	
	
	@Test
	public void test_withdraw_withMock() throws InsufficientBalanceException{
		//Declaration
		Customer customer=new Customer();
		customer.setCustName("Tom");
		customer.setCustAddress(new Address());
		
		Account account=new Account();
		account.setAccountNo(1001);
		account.setCustomer(customer);
		account.setAmount(5000);
		
		Mockito.when(accountDao.findAccountById(1001)).thenReturn(account);
		
		//actual
		Account depoAccount=acccountService.withdraw(1001, 300);
		
		//Verification
		Mockito.verify(accountDao).findAccountById(1001);
		assertEquals(4700, depoAccount.getAmount(),0.0);
		
		
	}

}
