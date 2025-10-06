# 🎓 Course and Student Management System

**Assignment 7 — Object-Oriented Programming in Java**

This project models a simple **university system** that manages students and courses.  
It was designed to explore **object-oriented programming concepts** such as **classes**, **constructors**, **encapsulation**, and **arrays** using Java.

---

## Overview

The system consists of two main classes:

### `Student.java`
Represents an individual student with:
- Personal information (first name, last name, student ID)
- Academic performance (grades, credits, GPA)
- Class standing (First Year, Sophomore, Junior, Senior)
- Bear Bucks account for managing funds
- Eligibility checks for **Phi Beta Kappa** honor society
- Ability to create a **legacy student** from two parents

Key Methods:
- `submitGrade(double grade, int credits)` — Records a new grade.
- `calculateGradePointAverage()` — Computes the student’s GPA.
- `getClassStanding()` — Returns the student’s year level.
- `cashOutBearBucks()` — Returns remaining Bear Bucks after an admin fee.
- `createLegacy()` — Creates a new student from two parent objects.

---

###  `Course.java`
Represents a university course with:
- Course name, credit hours, and capacity
- A student roster (stored in an array)
- Methods for adding students and computing averages

Key Methods:
- `addStudent(Student s)` — Enrolls a student in the course.
- `getSeatsRemaining()` — Returns the number of available spots.
- `generateRoster()` — Returns the names of enrolled students.
- `calculateAverageGPA()` — Computes the average GPA of all enrolled students.

---

##  How It Works

1. Create `Student` objects to represent individual students.
2. Use methods to record grades, track GPA, and manage Bear Bucks.
3. Create `Course` objects and enroll students into them.
4. Retrieve class rosters or calculate course-wide GPA.

---

##  Example Usage

```java
// Create students
Student alice = new Student("Alice", "Chang", 101);
Student bob = new Student("Bob", "Lee", 102);

// Record grades
alice.submitGrade(3.8, 15);
bob.submitGrade(3.4, 15);

// Create a course and add students
Course cs101 = new Course("Intro to CS", 4, 30);
cs101.addStudent(alice);
cs101.addStudent(bob);

// Print course info
System.out.println(cs101.generateRoster());
System.out.println("Average GPA: " + cs101.calculateAverageGPA());
