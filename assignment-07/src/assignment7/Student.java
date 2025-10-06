package assignment7;

public class Student {
	
	//instance variables
	String firstName;
	private String lastName;
	private int studentNumber;
	private int attemptedCredits;
	private int passingCredits;
	private double totalGradeQualityPoints;
	private double bearBucksBalance;
	double passingGrade = 1.7;

	//constructor 
	public Student (String initFirstName, String initLastName, int initStudentNumber) {
		firstName = initFirstName;
		lastName = initLastName;
		studentNumber = initStudentNumber;
		}
	
	public String getFullName() {
		return (firstName + " " + lastName);
	}
	
	public int getId() {
		return studentNumber;
	}
	
	public int getTotalAttemptedCredits() {
		return attemptedCredits;
	}
	
	public int getTotalPassingCredits() {
		return passingCredits;
	}
	
	//method
	public double calculateGradePointAverage () {
		return totalGradeQualityPoints/attemptedCredits;
	}	
	
	public void submitGrade (double grade, int credits) {
		if (grade >= 0) {
			attemptedCredits += credits;
			if (grade>= passingGrade) {
				passingCredits += credits;
			}
			totalGradeQualityPoints += credits*grade;
		}
	}
	
	//check determines what year depending on the Student's amount of passing credits
	public String getClassStanding () {
		int firstYearMax = 30;
		int sophomoreMax = 60;
		int juniorMax = 90;
		if (passingCredits < firstYearMax) {
			return "First Year";
		}
		if (passingCredits >= firstYearMax && passingCredits < sophomoreMax) {
			return "Sophomore";
		}
		if (passingCredits >= sophomoreMax && passingCredits < juniorMax) {
			return "Junior";
		} else {
			return "Senior";
		}
	}
	
	//check two ways of getting PhiBetaKappa
	public boolean isEligibleForPhiBetaKappa () {
		int firstMinPassingCredit = 98;
		double firstMinGPA = 3.60;
		int secondMinPassingCredit = 75;
		double secondMinGPA = 3.80;
		if (passingCredits >= firstMinPassingCredit && calculateGradePointAverage() >= firstMinGPA) {
			return true;
		}
		if (passingCredits >= secondMinPassingCredit && calculateGradePointAverage() >= secondMinGPA) {
			return true;
		}
		return false;
	}
	//increase bear bucks
	public void depositBearBucks (double amount) {
		bearBucksBalance += amount;
	}
	//decrease bear bucks
	public void deductBearBucks (double amount) {
		bearBucksBalance -= amount;
	}
	//get bear bucks value
	public double getBearBucksBalance() {
		return bearBucksBalance;
	}
	//take out all bear bucks and charge administration fee
	public double cashOutBearBucks() {
		double adminFee = 10;
		double minAmount = 10;
		if (bearBucksBalance <= minAmount) {
			bearBucksBalance = 0;
			return 0;
		} else {
			double amountReturned = bearBucksBalance - adminFee;
			bearBucksBalance = 0;
			return amountReturned;
		}
	}
	
	//create new students and deposit remaining bear bucks
	public Student createLegacy(String firstName, Student otherParent, boolean isHypenated, int id) {
		String lastName = "";
		if (isHypenated) {
			lastName = this.lastName + "-" + otherParent.lastName;
		} else {
			lastName = this.lastName;
		}
		Student legacy = new Student (firstName, lastName, id);
		legacy.depositBearBucks(this.cashOutBearBucks() + otherParent.cashOutBearBucks()); 
		return legacy;
	}

	// string first name, last name, and student id
	public String toString () {
		return (this.firstName + " " + this.lastName + " " + this.studentNumber);
	}
}
	
