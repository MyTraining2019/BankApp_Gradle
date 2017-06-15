package org.cap.bankapp.test;

import java.util.Arrays;
import java.util.List;

import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTestCase {
	
	private int input1;
	private int input2;
	private int output;
	
	private AcccountService acccountService;
	
	/*public ParameterizedTestCase(int input, int output) {
		super();
		this.input = input;
		this.output = output;
	}*/
	
	
	
	@Parameters
	public static List<Object[]> myParameters(){
		return Arrays.asList(new Object[][]{
			{1,2,3},
			{2,4,6},
			{0,3,3},
			{-1,-2,-3},
			{-4,-8,-12}
		});
	}
	
	public ParameterizedTestCase(int input1, int input2, int output) {
		super();
		this.input1 = input1;
		this.input2 = input2;
		this.output = output;
	}

	@Test
	public void test_addNumbers(){
		acccountService=new AccountServiceImpl();
		Assert.assertEquals(output,acccountService.addNumbers(input1, input2));
	}
	
	

}
