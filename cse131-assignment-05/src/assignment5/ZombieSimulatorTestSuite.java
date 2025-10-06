package assignment5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import assignment5.tests.NonzombieCountMethodDeclarationTest;
import assignment5.tests.NonzombieCountTest;
import assignment5.tests.ReadEntitiesTest;
import assignment5.tests.TouchingZombieTest;
import assignment5.tests.UpdateEntitiesTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ReadEntitiesTest.class, TouchingZombieTest.class, UpdateEntitiesTest.class,
		NonzombieCountMethodDeclarationTest.class, NonzombieCountTest.class })
public class ZombieSimulatorTestSuite {
}
