package assignment6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import assignment6.tests.ArraySumTestSuite;
import assignment6.tests.DragonTestSuite;
import assignment6.tests.ExponentTestSuite;
import assignment6.tests.MaxPathLengthTestSuite;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ExponentTestSuite.class, ArraySumTestSuite.class, DragonTestSuite.class,
		MaxPathLengthTestSuite.class })
public class RecursiveMethodsTestSuite {

}
