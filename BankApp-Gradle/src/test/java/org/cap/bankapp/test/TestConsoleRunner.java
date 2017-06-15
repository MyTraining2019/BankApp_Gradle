package org.cap.bankapp.test;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class TestConsoleRunner {

	public static void main(String[] args) {
		JUnitCore unitCore=new JUnitCore();
		unitCore.addListener(new TextListener(System.out));
		unitCore.run(BankAppTestCase.class);
	}

}
