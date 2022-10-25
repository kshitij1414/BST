package com.bst.strategy;

import com.bst.Student;

import java.util.Comparator;

/**
 * Creates a comparator which compares students based on their GPA. If the rounded gpa is same
 * for both students , the comparison will be done basis on their red id. The comparator will help insert nodes
 * in the tree in ascending order
 *
 * @author Kshitij Poojary <kpoojary4401@sdsu.edu>
 */
public class AscendingOrderGPAStrategy implements OrderingStrategy{
    @Override
    public Comparator<Student> order() {
        Comparator<Student> comparator = (Student s1, Student s2) -> {
            Integer s1RoundedGPA = (int)Math.round(s1.getGpa());
            Integer s2RoundedGPA = (int)Math.round(s2.getGpa());
            Integer cmp = s1RoundedGPA == s2RoundedGPA ? s1.getRedId().compareTo(s2.getRedId()) :
                    Integer.compare(s1RoundedGPA,s2RoundedGPA);
            return cmp;
        };
        return comparator;
    }
}
