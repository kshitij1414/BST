package com.bst.strategy;

import com.bst.Student;

import java.util.Comparator;

/**
 * Creates a comparator which compares students based on their last name. If the last name is same
 * for both students , the comparison will be done basis on their first name. The comparator will help insert nodes
 * in the tree in descending order
 *
 * @author Kshitij Poojary <kpoojary4401@sdsu.edu>
 */
public class DescendingOrderNameStrategy implements  OrderingStrategy{
    @Override
    public Comparator<Student> order() {
        return Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName).reversed();
    }
}
