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
import org.w3c.dom.stylesheets.LinkStyle;

@RunWith(Parameterized.class)
public class ParameterTestCase {

	private int[] intput;
	private int output;
	
	private AcccountService acccountService;
	
	public ParameterTestCase(int[] intput, int output) {
		super();
		this.intput = intput;
		this.output = output;
	}
	
	@Parameters
	public static List<Object[]> myParams(){
		return Arrays.asList(new Object[][]{
			{new int[]{1,2,3},6},
			{new int[]{1,1,1},3}
		});
	}
	
	@Test
	public void test_addNumbers(){
		acccountService=new AccountServiceImpl();
		Assert.assertEquals(output,acccountService.sumOfArray(intput));
	}
	
	
	
}
