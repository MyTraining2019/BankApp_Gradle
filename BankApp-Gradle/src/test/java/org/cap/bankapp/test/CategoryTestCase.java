package org.cap.bankapp.test;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({ BankAppTestCase.class, ParameterizedTestCase.class, ParameterTestCase.class, SampleTest.class })
//@ExcludeCategory({ReportCategory.class})
public class CategoryTestCase {

}
