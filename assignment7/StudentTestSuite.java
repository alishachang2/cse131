package assignment7;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import assignment7.tests.student.StudentBearBucksTest;
import assignment7.tests.student.StudentCashOutBearBucksTest;
import assignment7.tests.student.StudentFullNameTest;
import assignment7.tests.student.StudentGradePointAverageEdgeCaseTest;
import assignment7.tests.student.StudentGradePointAverageTest;
import assignment7.tests.student.StudentIdTest;
import assignment7.tests.student.StudentLegacyBearBucksTest;
import assignment7.tests.student.StudentLegacyNameTest;
import assignment7.tests.student.StudentPhiBetaKappaTest;
import assignment7.tests.student.StudentStandingTest;
import assignment7.tests.student.StudentToStringIsOverriddenTest;
import assignment7.tests.student.StudentToStringTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ StudentFullNameTest.class, StudentIdTest.class,
		StudentGradePointAverageTest.class,
		StudentGradePointAverageEdgeCaseTest.class, StudentStandingTest.class, StudentPhiBetaKappaTest.class,
		StudentBearBucksTest.class, StudentCashOutBearBucksTest.class, StudentLegacyNameTest.class,
		StudentLegacyBearBucksTest.class, StudentToStringIsOverriddenTest.class, StudentToStringTest.class })
public class StudentTestSuite {
}
