package com.bst.strategy;

import com.bst.Student;

import java.util.Comparator;

/**
 * Creates a comparator which compares students based on their red id.
 * The comparator will help insert nodes in the tree in ascending order.
 *
 * @author Kshitij Poojary <kpoojary4401@sdsu.edu>
 */
public class AscendingOrderRedIdStrategy implements OrderingStrategy{
    @Override
    public Comparator<Student> order() {
        return Comparator.comparing(Student::getRedId);
    }
}
