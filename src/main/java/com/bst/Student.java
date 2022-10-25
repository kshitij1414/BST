package com.bst;

import java.util.Objects;

/**
 * A Student has the following properties.
 * 1. Red ID
 * 2. GPA
 * 3. Full name & Last name
 *
 * @author Kshitij Poojary <kpoojary4401@sdsu.edu>
 */
public class Student implements Comparable<Student> {
    private Integer redId;
    private String firstName;
    private String lastName;

    private double gpa;

    public Student(Integer redId, String firstName,String lastName, double gpa) {
        this.redId = redId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    public Integer getRedId() {
        return redId;
    }

    public void setRedId(Integer redId) {
        this.redId = redId;
    }

    public String getName() {
        return firstName + ' ' + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.getRedId(),(o.getRedId()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.gpa, gpa) == 0 && redId.equals(student.redId)
                && firstName.equals(student.firstName) && lastName.equals(student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(redId, firstName, lastName, gpa);
    }

    @Override
    public String toString() {
        return "Student{" +
                "redId=" + redId +
                ", name='" + this.getName() + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
