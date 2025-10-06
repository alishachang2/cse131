package assignment7;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import assignment7.tests.course.CourseAddStudentComprehensiveTest;
import assignment7.tests.course.CourseAddStudentPreliminaryTest;
import assignment7.tests.course.CourseAddUniqueStudentsSeatsRemainingTest;
import assignment7.tests.course.CourseAverageGradePointAverageComprehensiveTest;
import assignment7.tests.course.CourseAverageGradePointAverageEdgeCaseTest;
import assignment7.tests.course.CourseAverageGradePointAveragePreliminaryTest;
import assignment7.tests.course.CourseConstructorNameCreditsCapacityTest;
import assignment7.tests.course.CourseRosterComprehensiveTest;
import assignment7.tests.course.CourseRosterPreliminaryTest;
import assignment7.tests.course.CourseStudentAtPreliminaryTest;
import assignment7.tests.course.CourseToStringIsOverriddenTest;
import assignment7.tests.course.CourseToStringTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ CourseConstructorNameCreditsCapacityTest.class, CourseAddUniqueStudentsSeatsRemainingTest.class,
		CourseAddStudentPreliminaryTest.class, CourseAddStudentComprehensiveTest.class,
		CourseStudentAtPreliminaryTest.class, CourseRosterPreliminaryTest.class, CourseRosterComprehensiveTest.class,
		CourseAverageGradePointAveragePreliminaryTest.class, CourseAverageGradePointAverageComprehensiveTest.class,
		CourseAverageGradePointAverageEdgeCaseTest.class, CourseToStringIsOverriddenTest.class,
		CourseToStringTest.class })
public class CourseTestSuite {
}
