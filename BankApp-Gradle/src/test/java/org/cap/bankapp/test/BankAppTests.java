package org.cap.bankapp.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BankAppTestCase.class, ParameterizedTestCase.class, ParameterTestCase.class, SampleTest.class })
public class BankAppTests {

}
