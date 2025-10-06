package assignment7;

public class Course {
	private String name;
	private int credits;
	private Student[] Roster;
	private int capacity;

	//constructor
	
	public Course(String initName, int initCredit, int initCapacity) {
		name = initName;
		credits = initCredit;
		Roster = new Student[initCapacity];
		capacity = initCapacity;
	}

	public String getName() {
		return name;
	}

	public int getCredits() {
		return credits;
	}

	public int getCapacity() {
		return capacity;
	}
	
	public int getSeatsRemaining() {
		// go through entire array to find empty seats
		int seatsRemaining = 0;
		for (int i = 0; i < capacity; i++) {
			if (Roster[i] == null) {
				seatsRemaining ++;
			}
		}
		return seatsRemaining;
	}

	// methods
	public boolean addStudent(Student s) {
		// check if student is already on roster
		for (Student student : Roster) {
			if (s.equals(student)) {
				return false;
			}
		}
		// add student to roster
		for (int i = 0; i < Roster.length; i++) {
			if (Roster[i] == null) {
				Roster[i] = s;
				return true;
			}
		}
		// not in the roster and unable to add
		return false;
	}

	//get the student at a specific point of the roster
	public Student getStudentAt(int index) {
		return Roster[index];
	}
	
	//return roster string
	public String generateRoster() {
		String roster = "";
		for (int i = 0; i < (getCapacity() - getSeatsRemaining()); i++) {
			if (Roster[i] != null) {
				roster += Roster[i].getFullName();
			}
		}
		return roster;
	}
	
	//take every value of gpa and divide it by the number of students to get average
	public double calculateAverageGPA() {
		double totalGPA = 0.0;
		int enrollment = 0;
		for (int i = 0; i < Roster.length; i++) {
			if (Roster[i] != null) {
				totalGPA += Roster[i].calculateGradePointAverage();
				enrollment++;
			}
		}
		return totalGPA / enrollment;
	}
	
	//concatenate name and credits 
	public String toString() {
		return getName() + getCredits();
	}
}


