package com.bst.strategy;

import com.bst.Student;

import java.util.Comparator;

public interface OrderingStrategy {
    Comparator<Student> order();
}
