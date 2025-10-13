package assignment8;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import assignment8.tests.EntityTestSuite;
import assignment8.tests.ZombieSimulatorTestSuite;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ EntityTestSuite.class, ZombieSimulatorTestSuite.class })
public class EntityAndZombieSimulatorTestSuite {
}
